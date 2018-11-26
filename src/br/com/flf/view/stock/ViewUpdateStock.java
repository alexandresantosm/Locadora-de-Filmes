package br.com.flf.view.stock;

import java.util.Scanner;

import br.com.flf.model.Movie;
import br.com.flf.model.Stock;
import service.MovieService;
import service.StockService;

public class ViewUpdateStock {

	public static void atualizaCopia() {

		Scanner scanner = new Scanner(System.in);
		StockService stockService = new StockService();
		MovieService movieService = new MovieService();

		System.out.println("######### ATUALIZACAO DA COPIA #########");
		System.out.println("");
		System.out.println("Filmes");
		for (Movie filme :movieService.getFilmes()) {
			System.out.println(filme.getCodigo() + " - " + filme.getTitulo());
		}

		System.out.println("Informe o codigo do filme: ");
		System.out.print("> ");

		Movie filme = movieService.localizar(Integer.parseInt(scanner.nextLine()));

		System.out.println("Informe o novo preco do filme: ");
		System.out.print("> ");
		double precoUnitario = Double.parseDouble(scanner.nextLine());

		for (Stock copia : stockService.getCopias()) {
			if (copia.getFilme().getCodigo() == filme.getCodigo()) {
				copia.setPrecoUnitario(precoUnitario);
				stockService.editar(copia);
			}
		}

		scanner.close();
		ViewStock.operacoesCopia();
	}
}