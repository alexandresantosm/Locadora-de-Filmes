package service;

import java.util.List;

import br.com.flf.dao.ClientDao;
import br.com.flf.model.Client;

public class ClientService {

	private ClientDao clientDao = new ClientDao();
	private Client cliente = new Client();

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<Client> getClientes() {
		return clientDao.listAll();
	}

	public void excluir(Integer codigo) {
		clientDao.delete(codigo);
		cliente = new Client();
	}

	public void gravar() {
		clientDao.createOrUpdate(cliente);
		cliente = new Client();
	}

	public void editar(Client cliente) {
		this.cliente = cliente;
	}

	public Client localizar(Integer codigo) {
		return clientDao.findByCodigo(codigo);
	}

	public Client localizar(String telefone) {
		return clientDao.findByTelefone(telefone);
	}
}