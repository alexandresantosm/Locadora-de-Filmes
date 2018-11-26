package br.com.flf.model;

public enum IsSocio {
	
	ASSOCIADO(0), NAOASSOCIADO(1), BLOQUEADO(2);
	
	private final int valor;
	
	IsSocio(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
}
