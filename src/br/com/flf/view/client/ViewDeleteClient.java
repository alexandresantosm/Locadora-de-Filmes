package br.com.flf.view.client;

import java.util.Scanner;

import br.com.flf.model.Client;
import service.ClientService;

public class ViewDeleteClient {

	public static void deletaCliente() {

		Scanner scanner = new Scanner(System.in);
		ClientService clientService = new ClientService();
		Client cliente = new Client();

		System.out.println("######### EXCLUIR CLIENTE #########");
		System.out.println("");

		System.out.println("Excluir o cliente pelo 'codigo' ou pelo 'telefone'? ");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("codigo")) {
			System.out.println("Informe o codigo: ");
			System.out.print("> ");

			cliente = clientService.localizar(Integer.parseInt(scanner.nextLine()));
		} else if (scanner.nextLine().toLowerCase().equals("telefone")) {
			System.out.println("Informe o telefone: ");
			System.out.print("> ");
			
			cliente = clientService.localizar(scanner.nextLine());
		} else {
			System.out.println("Opcao invalida! Cliente nao localizado!");
		}

		if (cliente == null) {
			System.out.println("Cliente nao cadastrado!");
		} else {
			clientService.excluir(cliente.getCodigo());
			System.out.println("Cliente deletado com sucesso!");
		}
		ViewClient.operacoesCliente();
		scanner.close();
	}
}