package br.com.flf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flf.connection.ConnectionFactory;
import br.com.flf.model.Movie;
import br.com.flf.model.Stock;

public class StockDao {
	
private EntityManager em = new ConnectionFactory().getConnection();
	
	
	public void createOrUpdate(Stock copia) {
		try {
			em.getTransaction().begin();
			if (copia.getCodigo() == null) {
				em.persist(copia); // Cria a copia
				System.out.println("Copia criado com sucesso!");
			} else {
				em.merge(copia); // Atualiza a copia
				System.out.println("Copia atualizado com sucesso!");
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
		Stock copia = findByCodigo(codigo);
		em.getTransaction().begin();
		em.remove(copia);
		System.out.println("A copia do filme " + copia.getFilme().getTitulo() + " foi deletado com sucesso!");
		em.getTransaction().commit();
		em.close();
	}

	public Stock findByCodigo(Integer codigo) {
		em.getTransaction().begin();
		Stock copia = em.find(Stock.class, codigo);
		em.getTransaction().commit();
		em.close();
		return copia;
	}

	public Stock findByFilme(Movie filme) {
		em.getTransaction().begin();
		Stock copia = em.find(Stock.class, filme);
		em.getTransaction().commit();
		em.close();
		return copia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> listAll() {
		
		List<Stock> copias = null;
		
		try {
			em.getTransaction().begin();
			copias = em.createQuery("SELECT s FROM Stock s ORDER BY s.codigo").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return copias;
	}
}