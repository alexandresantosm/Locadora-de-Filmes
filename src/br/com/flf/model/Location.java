package br.com.flf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@ManyToOne
	private Account conta;
	
	
	@ManyToMany
	@JoinTable(name = "movie_location",
			joinColumns = @JoinColumn(name = "cod_location"),
			inverseJoinColumns = @JoinColumn(name = "cod_stock"))
	private List<Stock> copias = new ArrayList<>();
	
	@Column(name = "data_locacao")
	private Date dataLocacao = new Date();
	
	@Column(name = "data_devolucao")
	private Date dataDevolucao;

	public Location() {
	}

	public Location(Account conta) {
		this.conta = conta;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Account getConta() {
		return this.conta;
	}

	public void setConta(Account conta) {
		this.conta = conta;
	}

	public List<Stock> getCopias() {
		return this.copias;
	}

	public void setCopias(List<Stock> copias) {
		this.copias = copias;
	}

	public Date getDataLocacao() {
		return this.dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao() {
		Calendar dataExpiracao = Calendar.getInstance();
		dataExpiracao.setTime(dataLocacao);
		dataExpiracao.add(Calendar.DAY_OF_MONTH, 3);
		this.dataDevolucao = dataExpiracao.getTime();
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("============== LOCACAO ==============\n");
		stringBuilder.append("Codigo: " + getCodigo() + "\n");
		stringBuilder.append("Locador: " + getConta().getCliente().getNome() + "\n");
		stringBuilder.append("Filme: ");
		for (Stock stock : getCopias()) {
			stringBuilder.append(stock.getFilme().getTitulo() + "\n");
		}
		stringBuilder.append("Data da locacao: " + getDataLocacao() + "\n");
		stringBuilder.append("Data da devolucao: " + getDataDevolucao());
		stringBuilder.append("\n============== LOCACAO ==============");

		return stringBuilder.toString();
	}
}