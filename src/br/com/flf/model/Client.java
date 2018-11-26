package br.com.flf.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column
	private String nome;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "logradouro", column = @Column(name = "logradouro")),
		@AttributeOverride(name = "cidade", column = @Column(name = "cidade")),
		@AttributeOverride(name = "estado", column = @Column(name = "estado"))
	})
	private Address endereco = new Address();
	
	@Column
	private String telefone;
	
	@Column
	private String rg;
	
	@Column
	private String cpf;
	
	@Column
	private Date dataDeAdesao;
	
	public Client() {
	}

	public Client(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Address getEndereco() {
		return endereco;
	}

	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeAdesao() {
		return dataDeAdesao;
	}

	public void setDataDeAdesao(Date dataDeAdesao) {
		this.dataDeAdesao = dataDeAdesao;
	}

	@Override
	public String toString() {
		// cria e manipula dados de Strings dinamicamente
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("============== SOCIO ==============\n");
		stringBuilder.append("Codigo: " + getCodigo() + "\n");
		stringBuilder.append("Nome: " + getNome() + "\n");
		String rua = getEndereco().getLogradouro();
		stringBuilder.append("Rua: " + rua + "\n");
		String cidade = getEndereco().getCidade();
		stringBuilder.append("Cidade: " + cidade + "\n");
		String estado = getEndereco().getEstado();
		stringBuilder.append("Estado: " + estado + "\n");
		stringBuilder.append("Telefone: " + getTelefone() + "\n");
		stringBuilder.append("RG: " + getRg() + "\n");
		stringBuilder.append("CPF: " + getCpf() + "\n");

		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		String result = out.format(getDataDeAdesao());
		stringBuilder.append("Data de adesao: " + result + "\n");

		stringBuilder.append("\n============== SOCIO ==============\n");

		return stringBuilder.toString();
	}
}