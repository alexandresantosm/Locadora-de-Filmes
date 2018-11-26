package service;

import java.util.List;

import br.com.flf.dao.MovieDao;
import br.com.flf.model.Movie;

public class MovieService {
	
	private MovieDao movieDao = new MovieDao();
	private Movie filme = new Movie();
	
	public Movie getFilme() {
		return filme;
	}
	
	public void setFilme(Movie filme) {
		this.filme = filme;
	}

	public List<Movie> getFilmes() {
		return movieDao.listAll();
	}

	public void excluir(Integer codigo) {
		movieDao.delete(codigo);
		filme = new Movie();
	}
	
	public void gravar() {
		movieDao.createOrUpdate(filme);
		filme = new Movie();
	}
	
	public void editar(Movie filme) {
		this.filme = filme; 
	}
	
	public Movie localizar(Integer codigo) {
		return movieDao.findByCodigo(codigo);
	}

	public Movie localizar(String titulo) {
		return movieDao.findByTitulo(titulo);
	}
}