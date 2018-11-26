package br.com.flf.view.account;

import java.util.Scanner;

import br.com.flf.model.Account;
import br.com.flf.view.client.ViewFindByClient;
import br.com.flf.view.location.ViewLocation;
import service.AccountService;

public class ViewFindByAccount {

	public static Account buscaConta() {

		Scanner scanner = new Scanner(System.in);
		AccountService accountService = new AccountService();
		Account conta = new Account();

		System.out.println("######### PESQUISA CONTA #########");
		System.out.println("");

		System.out.println("O que deseja localizar a conta pelo 'codigo' ou pelo 'cliente'? ");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("codigo")) {
			System.out.println("Informe o codigo: ");
			System.out.print("> ");

			conta = accountService.localizar(Integer.parseInt(scanner.nextLine()));
		} else if (scanner.nextLine().toLowerCase().equals("cliente")) {			
			conta = accountService.localizar(ViewFindByClient.buscaCliente());
		} else {
			System.out.println("Opcao invalida! Conta nao localizado!");
		}

		if (conta == null) {
			System.out.println("Conta nao cadastrado!");
		} 

		ViewLocation.operacoesLocacao();
		scanner.close();
		
		return conta;
	}
}