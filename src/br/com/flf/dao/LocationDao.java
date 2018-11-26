package br.com.flf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flf.connection.ConnectionFactory;
import br.com.flf.model.Location;

public class LocationDao {
	
private EntityManager em = new ConnectionFactory().getConnection();
	
	
	public void createOrUpdate(Location locacao) {
		try {
			em.getTransaction().begin();
			if (locacao.getCodigo() == null) {
				em.persist(locacao); // Cria a locacao
				System.out.println("Locacao criada com sucesso!");
			} else {
				em.merge(locacao); // Atualiza a locacao
				System.out.println("Locacao atualizada com sucesso!");
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
		Location locacao = findByCodigo(codigo);
		em.getTransaction().begin();
		em.remove(locacao);
		em.getTransaction().commit();
		em.close();
	}

	public Location findByCodigo(Integer codigo) {
		em.getTransaction().begin();
		Location locacao = em.find(Location.class, codigo);
		em.getTransaction().commit();
		em.close();
		return locacao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Location> listAll() {
		
		List<Location> locacoes = null;
		
		try {
			em.getTransaction().begin();
			locacoes = em.createQuery("SELECT l FROM Location l ORDER BY l.codigo").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return locacoes;
	}
}