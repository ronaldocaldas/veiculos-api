package com.brd.veiculos;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brd.veiculos.model.MarcaVeiculo;
import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.VeiculoRepository;

@SpringBootApplication
public class VeiculosApplication implements CommandLineRunner{

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VeiculosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		veiculoRepository.save(new Veiculo(MarcaVeiculo.FIAT, "Uno", "MDK-983", LocalDate.of(2018,05,22), null, true));
		veiculoRepository.save(new Veiculo(MarcaVeiculo.CHEVROLET, "Corsa", "IUY-987", LocalDate.of(2018,03,12), null, true));
		veiculoRepository.save(new Veiculo(MarcaVeiculo.FORD, "Fusion", "VBN-234", null, null, false));
		veiculoRepository.save(new Veiculo(MarcaVeiculo.VOLKSWAGEN, "Golf", "GAD-931", null, null, false));
	}
	
}
