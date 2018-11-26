package br.com.flf.view.account;

import java.util.Scanner;

import br.com.flf.view.ViewPrincipal;

public class ViewAccount {

	public static void operacoesConta() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Locar um filme");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Pesquisar");
		System.out.println("5 - Listar");
		System.out.println("6 - Deletar");
		System.out.println("7 - Voltar ao menu principal");
		System.out.print("> ");
		
		int opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			ViewCreateAccount.cadatraConta();
			break;
		case 2:
			ViewUpdateAccount.locarFilme();
			break;
		case 3:
			ViewUpdateAccount.atualizaConta();
			break;
		case 4:
			ViewFindByAccount.buscaConta();
			break;
		case 5:
			ViewListAccount.listaConta();
			break;
		case 6:
			ViewDeleteAccount.deletaConta();
			break;
		case 7:
			ViewPrincipal.principal();
			break;
		default:
			System.out.println("Opcao invalida!");
			break;
		}
		scanner.close();
	}
}