package br.com.flf.view.client;

import java.util.Scanner;

import br.com.flf.model.Client;
import service.ClientService;

public class ViewFindByClient {

	public static Client buscaCliente() {

		Scanner scanner = new Scanner(System.in);
		ClientService clientService = new ClientService();
		Client cliente = new Client();

		System.out.println("######### PESQUISA CLIENTE #########");
		System.out.println("");

		System.out.println("Localizar o cliente pelo 'codigo' ou pelo 'telefone'? ");
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

		System.out.println(cliente.toString());
		scanner.close();
		ViewClient.operacoesCliente();
		return cliente;
	}
}