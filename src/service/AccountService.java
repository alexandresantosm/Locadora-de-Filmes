package service;

import java.util.List;

import br.com.flf.dao.AccountDao;
import br.com.flf.model.Account;
import br.com.flf.model.Client;

public class AccountService {
	
	private AccountDao accountDao = new AccountDao();
	private Account conta = new Account();
	
	public Account getConta() {
		return conta;
	}
	
	public void setConta(Account conta) {
		this.conta = conta;
	}

	public List<Account> getContas() {
		return accountDao.listAll();
	}

	public void excluir(Integer codigo) {
		accountDao.delete(codigo);
		conta = new Account();
	}
	
	public void gravar() {
		accountDao.createOrUpdate(conta);
		conta = new Account();
	}
	
	public void editar(Account conta) {
		this.conta = conta; 
	}
	
	public Account localizar(Integer codigo) {
		return accountDao.findByCodigo(codigo);
	}
	
	public Account localizar(Client cliente) {
		return accountDao.findByCliente(cliente);
	}
}