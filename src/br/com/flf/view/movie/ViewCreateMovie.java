package br.com.flf.view.movie;

import java.util.Scanner;

import br.com.flf.model.Formato;
import br.com.flf.model.Movie;
import service.MovieService;

public class ViewCreateMovie {

	public static void cadatraFilme() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Movie filme = new Movie();
		MovieService movieService = new MovieService();

		System.out.println("######### CADASTRO DE FILME #########");
		System.out.println("");

		System.out.println("Informe o titulo do filme: ");
		System.out.print("> ");
		filme.setTitulo(scanner.nextLine());

		System.out.println("Informe a duracao do filme: ");
		System.out.print("> ");
		filme.setDuracao(Integer.parseInt(scanner.nextLine()));

		System.out.println("Informe o ano de lancamento do filme: ");
		System.out.print("> ");
		filme.setAnoDeLancamento(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Informe o formato do filme 'VHS', 'DVD' ou 'Blu-ray':");
		System.out.print("> ");
		String formato = scanner.nextLine().toLowerCase();
		
		if (formato.equals("vhs")) {
			filme.setFormato(Formato.VHS);
		} else if (formato.equals("dvd")) {
			filme.setFormato(Formato.DVD);
		} else if (formato.equals("Blu-ray")) {
			filme.setFormato(Formato.BLURAY);
		} else {
			System.out.println("Opcao invalida!");
		}

		System.out.println("Informe o elenco do filme: ");
		System.out.print("> ");
		filme.setElenco(scanner.nextLine());

		System.out.println(filme.toString());

		System.out.println("Deseja salvar o filme? 'S' ou 'N'");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("s")) {
			movieService.gravar();
			System.out.println("Filme salvo com sucesso!");
		}

		ViewMovie.operacoesFilme();
	}
}