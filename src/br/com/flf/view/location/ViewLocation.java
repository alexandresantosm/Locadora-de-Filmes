package br.com.flf.view.location;

import java.util.Scanner;

import br.com.flf.view.ViewOperacion;
import br.com.flf.view.ViewPrincipal;

public class ViewLocation {

	public static void operacoesLocacao() {

		Scanner scanner = new Scanner(System.in);

		ViewOperacion.operacoes();
		
		int opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			System.out.println(ViewCreateLocation.cadatraLocacao().toString());
			break;
		case 2:
			System.out.println(ViewUpdateLocation.atualizaLocacao().toString());
			break;
		case 3:
			System.out.println(ViewFindByLocation.buscaLocacao().toString());
			break;
		case 4:
			ViewListLocation.listaLocacao();
			break;
		case 5:
			ViewDeleteLocation.deletaLocacao();
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