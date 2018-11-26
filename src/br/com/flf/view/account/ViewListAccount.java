package br.com.flf.view.account;

import br.com.flf.model.Account;
import service.AccountService;

public class ViewListAccount {

	public static void listaConta() {

		AccountService accountService = new AccountService();

		System.out.println("######### LISTAGEM DOS CLIENTES #########");
		System.out.println("");

		for (Account conta : accountService.getContas()) {
			System.out.println(conta.toString());
		}
		
		ViewAccount.operacoesConta();
	}
}