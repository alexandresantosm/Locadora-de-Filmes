package br.com.flf.view.movie;

import br.com.flf.model.Movie;
import service.MovieService;

public class ViewListMovie {

	public static void listaFilme() {

		MovieService movieService = new MovieService();

		System.out.println("######### LISTAGEM DOS FILMES #########");
		System.out.println("");

		for (Movie filme : movieService.getFilmes()) {
			System.out.println(filme.toString());
		}

		ViewMovie.operacoesFilme();
	}
}