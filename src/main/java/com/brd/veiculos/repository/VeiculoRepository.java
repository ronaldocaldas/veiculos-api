package com.brd.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.veiculo.VeiculoRepositoryQuery;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, VeiculoRepositoryQuery{

}

