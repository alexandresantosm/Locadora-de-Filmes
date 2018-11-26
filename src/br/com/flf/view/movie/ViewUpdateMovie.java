package br.com.flf.view.movie;

import java.util.Scanner;

import br.com.flf.model.Formato;
import br.com.flf.model.Movie;
import service.MovieService;

public class ViewUpdateMovie {

	public static void atualizaFilme() {

		Scanner scanner = new Scanner(System.in);
		Movie filme = new Movie();
		MovieService movieService = new MovieService();

		System.out.println("######### ATUALIZACAO DE FILME #########");
		System.out.println("");

		System.out.println("Excluir o filme pelo 'codigo' ou pelo 'titulo'? ");
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
			System.out.println("Opcao invalida! Nenhum filme foi deletado!");
		}
		
		if (filme != null) {
			System.out.println("O que deseja atualizar?\ntitulo \nformato \nelenco ");
			System.out.print("> ");

			switch (scanner.nextLine().toLowerCase()) {
			case "titulo":
				System.out.println("Informe o novo titulo: ");
				System.out.print("> ");
				filme.setTitulo(scanner.nextLine());
				break;
			case "formato":
				System.out.println("Informe o formato: 'VHS, DVD ou Blu-ray'");
				System.out.print("> ");
				if (scanner.nextLine().toLowerCase().equals("vhs")) {
					filme.setFormato(Formato.VHS);
				} else if (scanner.nextLine().toLowerCase().equals("dvd")) {
					filme.setFormato(Formato.DVD);
				} else if (scanner.nextLine().toLowerCase().equals("dvd")) {
					filme.setFormato(Formato.BLURAY);
				} else {
					System.out.println("Opcao invalida!");
				}
				break;
			case "elenco":
				System.out.println("Informe o elenco: ");
				System.out.print("> ");
				filme.setElenco(scanner.nextLine());
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}

		} else {
			System.out.println("Cliente nao encontrado!");
		}

		movieService.editar(filme);
		System.out.println("Filme atualizado com sucesso!");
		scanner.close();
		ViewMovie.operacoesFilme();
	}
}