package br.com.flf.view.client;

import java.util.Date;
import java.util.Scanner;

import br.com.flf.model.Address;
import br.com.flf.model.Client;
import service.ClientService;

public class ViewCreateClient {

	public static Client cadatraCliente() {
		Scanner scanner = new Scanner(System.in);
		Client cliente = new Client();
		ClientService clientService = new ClientService();
		Address endereco = new Address();
		Date data = new Date();

		System.out.println("######### CADASTRO DE CLIENTE #########");
		System.out.println("");

		System.out.println("Informe o nome: ");
		System.out.print("> ");
		cliente.setNome(scanner.nextLine());

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

		System.out.println("Informe o telefone: ");
		System.out.print("> ");
		cliente.setTelefone(scanner.nextLine());

		System.out.println("Informe o RG: ");
		System.out.print("> ");
		cliente.setRg(scanner.nextLine());

		System.out.println("Informe o CPF: ");
		System.out.print("> ");
		cliente.setCpf(scanner.nextLine());

		cliente.setDataDeAdesao(data);

		System.out.println(cliente.toString());
		
		System.out.println("Deseja salvar o cliente? 'S' ou 'N'");
		System.out.print("> ");
		
		if(scanner.nextLine().toLowerCase().equals("s")) {
			clientService.gravar();
		}
		
		ViewClient.operacoesCliente();
		scanner.close();
		return cliente;
	}
}