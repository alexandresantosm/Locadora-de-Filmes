package br.com.flf.view.client;

import java.util.Scanner;

import br.com.flf.view.ViewOperacion;
import br.com.flf.view.ViewPrincipal;

public class ViewClient {

	public static void operacoesCliente() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		ViewOperacion.operacoes();
		
		int opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			if (ViewCreateClient.cadatraCliente() != null) {
				System.out.println("Cliente salvo com sucesso!");
			} else {
				System.out.println("Erro ao salvar o cliente!");
			}
			break;
		case 2:
			ViewUpdateClient.atualizaCliente();
			break;
		case 3:
			if (ViewFindByClient.buscaCliente() != null) {
				System.out.println("Cliente cadastrado com sucesso!");
			} else {
				System.out.println("Cliente nao cadastrado!");
			}
			break;
		case 4:
			ViewListClient.listaCliente();
			break;
		case 5:
			ViewDeleteClient.deletaCliente();
			break;
		case 6:
			ViewPrincipal.principal();
			break;
		default:
			System.out.println("Opcao invalida!");
			break;
		}
	}
}