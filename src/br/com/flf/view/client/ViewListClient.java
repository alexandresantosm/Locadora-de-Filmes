package br.com.flf.view.client;

import br.com.flf.model.Client;
import service.ClientService;

public class ViewListClient {

	public static void listaCliente() {

		ClientService clientService = new ClientService();
		
		System.out.println("######### LISTAGEM DOS CLIENTES #########");
		System.out.println("");

		for (Client cliente : clientService.getClientes()) {
			System.out.println(cliente.toString());
		}
		
		ViewClient.operacoesCliente();
	}
}