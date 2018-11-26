package br.com.flf.view.movie;

import java.util.Scanner;

import br.com.flf.model.Movie;
import service.MovieService;

public class ViewFindByMovie {

	public static void buscaFilme() {

		Scanner scanner = new Scanner(System.in);
		MovieService movieService = new MovieService();
		Movie filme = new Movie();

		System.out.println("######### PESQUISA FILME #########");
		System.out.println("");

		System.out.println("O deseja localizar o filme pelo 'codigo' ou pelo 'titulo'? ");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("codigo")) {
			System.out.println("Informe o codigo: ");
			System.out.print("> ");

			filme = movieService.localizar(Integer.parseInt(scanner.nextLine()));
		} else if (scanner.nextLine().toLowerCase().equals("titulo")) {
			System.out.println("Informe o titulo: ");
			System.out.print("> ");

			filme = movieService.localizar(scanner.nextLine());
		} else {
			System.out.println("Opcao ivalida! Filme nao localizado");
		}

		if (filme == null) {
			System.out.println("Filme nao cadastrado!");
		}

		System.out.println(filme.toString());
		scanner.close();
		ViewMovie.operacoesFilme();
	}
}