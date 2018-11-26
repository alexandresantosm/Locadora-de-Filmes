package br.com.flf.view;

import java.util.Scanner;

import br.com.flf.view.client.ViewClient;
import br.com.flf.view.location.ViewLocation;
import br.com.flf.view.movie.ViewMovie;
import br.com.flf.view.stock.ViewStock;

public class ViewPrincipal {

	public static void principal() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1 - Cliente");
		System.out.println("2 - Filme");
		System.out.println("3 - Estoque(Copias de filmes)");
		System.out.println("4 - Locacoes");
		System.out.println("5 - Sair");
		System.out.print("> ");
		
		switch (Integer.parseInt(scanner.nextLine())) {
		case 1:
			ViewClient.operacoesCliente();
			break;
		case 2:
			ViewMovie.operacoesFilme();
			break;
		case 3:
			ViewStock.operacoesCopia();
			break;
		case 4:
			ViewLocation.operacoesLocacao();
			break;
		case 5:
			System.out.println("Finalizando...");
			scanner.close();
			System.exit(0);
			break;

		default:
			System.out.println("Opcao invalida!");
			break;
		}
	}
}
