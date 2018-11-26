package br.com.flf.view.account;

import java.util.Scanner;

import br.com.flf.model.Account;
import br.com.flf.model.Client;
import br.com.flf.model.IsSocio;
import service.AccountService;
import service.ClientService;

public class ViewDeleteAccount {

	public static void deletaConta() {

		Scanner scanner = new Scanner(System.in);
		AccountService accountService = new AccountService();
		ClientService clientService = new ClientService();
		Client cliente = new Client();
		Account conta = new Account();

		System.out.println("######### EXCLUIR CONTA #########");
		System.out.println("");

		System.out.println("Excluir a conta pelo 'codigo do cliente' ou pelo 'telefone do cliente'? ");
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
			System.out.println("Conta nao cadastrado!");
		} else {
			if (conta.getStatus() == IsSocio.NAOASSOCIADO) {
				accountService.excluir(conta.getCodigo());
				System.out.println("Conta deletada com sucesso!");
			} else {
				System.out.println("O cliente ainda e associado da locadora!\nSomente contas de clientes nao associado pode ser deletados!");
			}
		}
		
		scanner.close();
		ViewAccount.operacoesConta();
	}
}