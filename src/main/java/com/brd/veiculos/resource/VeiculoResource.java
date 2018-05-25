package com.brd.veiculos.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brd.veiculos.model.Veiculo;
import com.brd.veiculos.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public List<Veiculo> listar(){
		return veiculoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Veiculo buscarPeloCodigo(@PathVariable Long codigo){
		return veiculoRepository.findOne(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> criar(@Valid @RequestBody Veiculo veiculo, HttpServletResponse response){
		veiculoRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void remover(@PathVariable Long codigo) {
		veiculoRepository.delete(codigo);
	}
}
