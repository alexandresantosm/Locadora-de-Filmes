package br.com.flf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flf.connection.ConnectionFactory;
import br.com.flf.model.Account;
import br.com.flf.model.Client;

public class AccountDao {
	
private EntityManager em = new ConnectionFactory().getConnection();
	
	
	public void createOrUpdate(Account conta) {
		try {
			em.getTransaction().begin();
			if (conta.getCodigo() == null) {
				em.persist(conta); // Cria a conta
				System.out.println("Conta criada com sucesso!");
			} else {
				em.merge(conta); // Atualiza a conta
				System.out.println("Conta atualizada com sucesso!");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void delete(Integer codigo) {
		Account conta = findByCodigo(codigo);
		em.getTransaction().begin();
		em.remove(conta);
		em.getTransaction().commit();
		em.close();
	}

	public Account findByCodigo(Integer codigo) {
		em.getTransaction().begin();
		Account conta = em.find(Account.class, codigo);
		em.getTransaction().commit();
		em.close();
		return conta;
	}
	
	public Account findByCliente(Client cliente) {
		
		em.getTransaction().begin();
		Account conta = em.find(Account.class, cliente);
		em.getTransaction().commit();
		em.close();
		return conta;
	}

	@SuppressWarnings("unchecked")
	public List<Account> listAll() {
		
		List<Account> contas = null;
		
		try {
			em.getTransaction().begin();
			contas = em.createQuery("SELECT a FROM Account a ORDER BY a.codigo").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return contas;
	}
}