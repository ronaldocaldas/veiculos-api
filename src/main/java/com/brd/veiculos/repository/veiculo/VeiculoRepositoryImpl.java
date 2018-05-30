package com.brd.veiculos.repository.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.filter.VeiculoFilter;

public class VeiculoRepositoryImpl implements VeiculoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Veiculo> filtrar(VeiculoFilter veiculoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteria = builder.createQuery(Veiculo.class);
		Root<Veiculo> root = criteria.from(Veiculo.class);

		Predicate[] predicates = criarRestricoes(veiculoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Veiculo> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(veiculoFilter));

	}

	private Predicate[] criarRestricoes(VeiculoFilter veiculoFilter, CriteriaBuilder builder, Root<Veiculo> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(veiculoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + veiculoFilter.getDescricao().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private Long total(VeiculoFilter veiculoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Veiculo> root = criteria.from(Veiculo.class);

		Predicate[] predicates = criarRestricoes(veiculoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));

		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);

	}

}
