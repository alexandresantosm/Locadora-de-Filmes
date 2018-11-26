package br.com.flf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flf.connection.ConnectionFactory;
import br.com.flf.model.Client;

public class ClientDao{
	
	private EntityManager em = new ConnectionFactory().getConnection();
	
	public void createOrUpdate(Client cliente) {
		try {
			em.getTransaction().begin();
			if (cliente.getCodigo() == null) {
				em.persist(cliente); // Cria o cliente
				System.out.println("Cliente criado com sucesso!");
			} else {
				em.merge(cliente); // Atualiza o cliente
				System.out.println("Cliente atualizado com sucesso!");
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
		Client cliente = findByCodigo(codigo);
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}

	public Client findByCodigo(Integer codigo) {
		em.getTransaction().begin();
		Client cliente = em.find(Client.class, codigo);
		em.getTransaction().commit();
		em.close();
		return cliente;
	}

	public Client findByTelefone(String telefone) {
		em.getTransaction().begin();
		Client cliente = em.find(Client.class, telefone);
		em.getTransaction().commit();
		em.close();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	public List<Client> listAll() {
		
		List<Client> clientes = null;
		
		try {
			em.getTransaction().begin();
			clientes = em.createQuery("SELECT c FROM Client c ORDER BY c.nome").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return clientes;
	}
}