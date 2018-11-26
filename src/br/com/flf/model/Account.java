package br.com.flf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Client cliente = new Client();
	
	@Column
	private double saldo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "conta")
	@JoinColumn(name = "cod_location")
	private List<Location> locacoes = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private IsSocio status = IsSocio.ASSOCIADO;
	
	public Account() {
		
	}	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo() {
		for (Location locacao : locacoes) {
			for (Stock copia : locacao.getCopias()) {
				this.saldo += copia.getPrecoUnitario();
			}
		}
	}

	public List<Location> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Location> locacoes) {
		this.locacoes = locacoes;
	}
	
	public IsSocio getStatus() {
		return status;
	}

	public void setStatus(IsSocio status) {
		this.status = status;
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("============== CONTA ==============\n");
		stringBuilder.append("Codigo: " + getCodigo() + "\n");
		stringBuilder.append("Cliente: " + getCliente().getNome() + "\n");
		stringBuilder.append("Saldo Devedor: " + getSaldo() + "\n");
		stringBuilder.append("Historico de Locacoes\nFilmes:\n");
		for (Location locacoes : locacoes) {
			for (Stock copias : locacoes.getCopias()) {
				stringBuilder.append(copias.getFilme().getTitulo() + " \n");
			}
		}
		stringBuilder.append("============== CONTA ==============");

		return stringBuilder.toString();
	}
}