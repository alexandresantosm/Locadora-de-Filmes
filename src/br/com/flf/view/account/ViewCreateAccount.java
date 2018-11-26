package br.com.flf.view.account;

import java.util.Scanner;

import br.com.flf.model.Account;
import br.com.flf.view.client.ViewCreateClient;
import service.AccountService;

public class ViewCreateAccount {

	public static void cadatraConta() {
		Scanner scanner = new Scanner(System.in);
		Account conta = new Account();
		AccountService accountService = new AccountService();
		
		System.out.println("######### CADASTRO DE CONTA #########");
		System.out.println("");
		
		conta.setCliente(ViewCreateClient.cadatraCliente());

		System.out.println("Deseja salvar a conta? 'S' ou 'N'");
		System.out.print("> ");

		if (scanner.nextLine().toLowerCase().equals("s")) {
			accountService.gravar();
			System.out.println("Conta salva com sucesso!");
		}
		
		scanner.close();
		ViewAccount.operacoesConta();
	}
}