package com.brd.veiculos.sevice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.VeiculoRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo atualizar(Long codigo, Veiculo pessoa) {
		Veiculo veiculoSalvo = veiculoRepository.findOne(codigo);
		BeanUtils.copyProperties(pessoa, veiculoSalvo, "codigo");
		return veiculoRepository.save(veiculoSalvo);
	}

}
