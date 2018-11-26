package br.com.flf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column
	private String titulo;
	
	@Column
	private int duracao;
	
	@Column(name = "ano_lancamento")
	private int anoDeLancamento;
	
	@Enumerated(EnumType.STRING)
	private Formato formato;
	
	@Column
	private String elenco;
	
	@OneToMany(mappedBy = "filme", cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Stock> copias = new ArrayList<>();
	
	public Movie() {
	}

	public Movie(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getAnoDeLancamento() {
		return this.anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public String getElenco() {
		return this.elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}
	
	public List<Stock> getCopias() {
		return copias;
	}

	public void setCopias(List<Stock> copias) {
		this.copias = copias;
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("============== FILME ==============\n");
		stringBuilder.append("Codigo: " + getCodigo() + "\n");
		stringBuilder.append("Titulo: " + getTitulo() + "\n");
		stringBuilder.append("Duracao: " + getDuracao() + "min\n");
		stringBuilder.append("Ano de lancamento: " + getAnoDeLancamento() + "\n");
		stringBuilder.append("Formato: " + getFormato() + "\n");
		stringBuilder.append("Elenco: " + getElenco() + "\n");
		stringBuilder.append("Quantidade de copias: " + getCopias().size());
		stringBuilder.append("\n============== FILME ==============");

		return stringBuilder.toString();
	}
}