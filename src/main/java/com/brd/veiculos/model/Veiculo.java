package com.brd.veiculos.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MarcaVeiculo marca;

	@Size(min = 3, max = 20)
	private String modelo;

	@NotNull
	@Size(min = 3, max = 20)
	private String placa;

	private LocalDate dataLocacao;

	private LocalDate dataDataEntrega;

	private boolean locado;

	
	public Veiculo() {
	}
	
	public Veiculo(MarcaVeiculo marca, String modelo, String placa, LocalDate dataLocacao, LocalDate dataDataEntrega,
			boolean locado) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.dataLocacao = dataLocacao;
		this.dataDataEntrega = dataDataEntrega;
		this.locado = locado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public MarcaVeiculo getMarca() {
		return marca;
	}

	public void setMarca(MarcaVeiculo marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDate getDataDataEntrega() {
		return dataDataEntrega;
	}

	public void setDataDataEntrega(LocalDate dataDataEntrega) {
		this.dataDataEntrega = dataDataEntrega;
	}

	public boolean isLocado() {
		return locado;
	}

	public void setLocado(boolean locado) {
		this.locado = locado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
