package br.com.flf.model;

public enum Formato {
	VHS("VHS"), DVD("DVD"), BLURAY("Blu-ray");
	
	private String formato;
	
	Formato(String formato) {
		this.formato = formato;
	}
	
	public String getFormato() {
		return this.formato;
	}
}