package br.com.flf.view.stock;

import java.util.Scanner;

import br.com.flf.dao.ClientDao;
import br.com.flf.model.Client;
import br.com.flf.view.ViewPrincipal;

public class ViewFindByStock {

	public static Client buscaCopia() {

		Scanner scanner = new Scanner(System.in);
		ClientDao cs = new ClientDao();
		Client cliente = new Client();

		System.out.println("######### PESQUISA CLIENTE #########");
		System.out.println("");

		System.out.println("O que deseja localizar o cliente pelo 'codigo' ou pelo 'telefone'? ");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("codigo")) {
			System.out.println("Informe o codigo: ");
			System.out.print("> ");

			cliente = cs.findByCodigo(Integer.parseInt(scanner.nextLine()));
		} else if (scanner.nextLine().toLowerCase().equals("telefone")) {
			System.out.println("Informe o telefone: ");
			System.out.print("> ");
			
			cliente = cs.findByTelefone(scanner.nextLine());
		} else {
			System.out.println("Opcao invalida! Cliente nao localizado!");
		}

		if (cliente == null) {
			System.out.println("Cliente nao cadastrado!");
		} 

		ViewPrincipal.principal();
		scanner.close();
		
		return cliente;
	}
}