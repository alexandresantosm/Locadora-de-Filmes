package br.com.flf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@ManyToOne
	private Movie filme;
	
	@Column(name = "preco_unitatiro")
	private double precoUnitario;
	
	@ManyToMany(mappedBy = "copias")
	private List<Location> locacoes;
	
	public Stock(Movie filme) {
		this.setFilme(filme);
	}
	
	public Stock() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Movie getFilme() {
		return filme;
	}

	public void setFilme(Movie filme) {
		this.filme = filme;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		if (precoUnitario > 0) {
			this.precoUnitario = precoUnitario;
		}
	}
	
	public List<Location> getLocacao() {
		return locacoes;
	}
	
	public void setLocacao(List<Location> locacoes) {
		this.locacoes = locacoes;
	}
	
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("============== ESTOQUE ==============\n");
		stringBuilder.append("Codigo: " + getCodigo() + "\n");
		stringBuilder.append("Filme: " + getFilme().getTitulo() + "\n");
		stringBuilder.append("Preco Unitario: " + getPrecoUnitario());
		stringBuilder.append("\n============== ESTOQUE ==============");

		return stringBuilder.toString();
	}
}