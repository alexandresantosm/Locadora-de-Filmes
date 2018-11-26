package br.com.flf.view.stock;

import java.util.Scanner;

import br.com.flf.view.ViewOperacion;
import br.com.flf.view.ViewPrincipal;

public class ViewStock {

	public static void operacoesCopia() {

		Scanner scanner = new Scanner(System.in);

		ViewOperacion.operacoes();
		
		int opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			ViewCreateStock.cadatraCopia();
			break;
		case 2:
			ViewUpdateStock.atualizaCopia();
			break;
		case 3:
			ViewFindByStock.buscaCopia().toString();
			break;
		case 4:
			ViewListStock.listaCopia();
			break;
		case 5:
			ViewDeleteStock.deletaCopia();
			break;
		case 6:
			ViewPrincipal.principal();
			break;
		default:
			System.out.println("Opcao invalida!");
			break;
		}
		scanner.close();
	}
}