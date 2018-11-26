package br.com.flf.view.movie;

import java.util.Scanner;

import br.com.flf.view.ViewOperacion;
import br.com.flf.view.ViewPrincipal;

public class ViewMovie {

	public static void operacoesFilme() {

		Scanner scanner = new Scanner(System.in);

		ViewOperacion.operacoes();

		int opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			ViewCreateMovie.cadatraFilme();
			break;
		case 2:
			ViewUpdateMovie.atualizaFilme();
			break;
		case 3:
			ViewFindByMovie.buscaFilme();
			break;
		case 4:
			ViewListMovie.listaFilme();
			break;
		case 5:
			ViewDeleteMovie.deletaFilme();
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