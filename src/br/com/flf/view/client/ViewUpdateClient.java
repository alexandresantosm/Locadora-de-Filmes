package br.com.flf.view.client;

import java.util.Scanner;

import br.com.flf.model.Address;
import br.com.flf.model.Client;
import service.ClientService;

public class ViewUpdateClient {

	public static void atualizaCliente() {

		Scanner scanner = new Scanner(System.in);
		ClientService clientService = new ClientService();

		System.out.println("######### ATUALIZACAO DE CLIENTE #########");
		System.out.println("");

		System.out.println("Informe o telefone: ");
		System.out.print("> ");

		Client cliente = clientService.localizar(scanner.nextLine());

		if (cliente != null) {
			System.out.println("O que deseja atualizar?\nnome \nendereco \ntelefone ");
			System.out.print("> ");

			switch (scanner.nextLine().toLowerCase()) {
			case "nome":
				System.out.println("Informe o novo nome: ");
				System.out.print("> ");
				cliente.setNome(scanner.nextLine());
				break;
			case "endereco":
				Address endereco = new Address();
				System.out.println("Informe o endereco: ");
				System.out.print("> ");
				endereco.setLogradouro(scanner.nextLine());

				System.out.println("Informe a cidade: ");
				System.out.print("> ");
				endereco.setCidade(scanner.nextLine());

				System.out.println("Informe o estado: ");
				System.out.print("> ");
				endereco.setEstado(scanner.nextLine());
				cliente.setEndereco(endereco);
				break;
			case "telefone":
				System.out.println("Informe o novo telefone: ");
				System.out.print("> ");
				cliente.setTelefone(scanner.nextLine());
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
		} else {
			System.out.println("Cliente nao encontrado!");
		}

		clientService.editar(cliente);
		System.out.println("Cliente atualizado com sucesso!");
		ViewClient.operacoesCliente();
		scanner.close();
	}
}