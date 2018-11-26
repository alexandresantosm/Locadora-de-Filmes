package br.com.flf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "rua", nullable = false)
	private String logradouro;

	@Column(name = "cidade", nullable = true)
	private String cidade;

	@Column(name = "estado", nullable = true)
	private String estado;

	public Address() {
	}

	public Address(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}