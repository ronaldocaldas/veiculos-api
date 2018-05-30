package com.brd.veiculos.repository.veiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.filter.VeiculoFilter;

public interface VeiculoRepositoryQuery {
	public Page<Veiculo> filtrar(VeiculoFilter veiculoFilter, Pageable pageable);

}
