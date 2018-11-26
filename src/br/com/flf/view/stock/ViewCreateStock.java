package br.com.flf.view.stock;

import java.util.Scanner;

import br.com.flf.model.Movie;
import br.com.flf.model.Stock;
import service.MovieService;
import service.StockService;

public class ViewCreateStock {

	public static void cadatraCopia() {
		Scanner scanner = new Scanner(System.in);
		StockService stockService = new StockService();
		MovieService movieService = new MovieService();
		Stock copia = new Stock();

		System.out.println("######### CADASTRO DE COPIAS #########");
		System.out.println("");
		System.out.println("Lista de Filmes");
		for (Movie filme : movieService.getFilmes()) {
			System.out.println(filme.getCodigo() + " - " + filme.getTitulo());
		}
		
		System.out.println("Informe o codigo do filme: ");
		System.out.print("> ");
		Movie filme = movieService.localizar(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Informe o preco do filme: ");
		System.out.print("> ");
		double preco = Double.parseDouble(scanner.nextLine());	
		
		System.out.println("Informe a quantidade de copias: ");
		System.out.print("> ");
		
		for (int i = 1; i <= Integer.parseInt(scanner.nextLine()); i++) {
			copia.setFilme(filme);
			copia.setPrecoUnitario(preco);
			stockService.gravar();
			copia = new Stock();
		}
		
		scanner.close();
		ViewStock.operacoesCopia();
	}
}