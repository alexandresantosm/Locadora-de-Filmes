package br.com.flf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flf.connection.ConnectionFactory;
import br.com.flf.model.Movie;

public class MovieDao {

	private EntityManager em = new ConnectionFactory().getConnection();

	public void createOrUpdate(Movie filme) {
		try {
			em.getTransaction().begin();
			if (filme.getCodigo() == null) {
				em.persist(filme); // Cria o filme
			} else {
				em.merge(filme); // Atualiza o filme
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
		Movie filme = findByCodigo(codigo);
		em.getTransaction().begin();
		em.remove(filme);
		em.getTransaction().commit();
		em.close();
	}

	public Movie findByCodigo(Integer codigo) {
		em.getTransaction().begin();
		Movie filme = em.find(Movie.class, codigo);
		em.getTransaction().commit();
		em.close();
		return filme;
	}

	public Movie findByTitulo(String titulo) {
		em.getTransaction().begin();
		Movie filme = em.find(Movie.class, titulo);
		em.getTransaction().commit();
		em.close();
		return filme;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> listAll() {

		List<Movie> filmes = null;

		try {
			em.getTransaction().begin();
			filmes = em.createQuery("SELECT m FROM Movie m ORDER BY m.titulo").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return filmes;
	}
}