package br.com.flf.view.account;

import java.util.Scanner;

import br.com.flf.model.Account;
import br.com.flf.model.IsSocio;
import service.AccountService;

public class ViewUpdateAccount {
	private static Scanner scanner;
	private static AccountService accountService;
	private static Account conta;

	public static void atualizaConta() {

		scanner = new Scanner(System.in);
		accountService = new AccountService(); 
		conta = new Account();

		System.out.println("######### ATUALIZACAO DE CONTA #########");
		System.out.println("");

		System.out.println("Deseja alterar o status da conta? \nSe 'SIM' digite: \n0 - ASSOCIADO \n1 - NAO ASSOCIADO \n2 -BLOQUEADO");
		System.out.print("> ");
		
		
		if (scanner.nextLine().toLowerCase().equals("0")) {
			System.out.println("Informe o codigo da conta: ");
			System.out.print("> ");

			conta = accountService.localizar(Integer.parseInt(scanner.nextLine()));
			conta.setStatus(IsSocio.ASSOCIADO);
		} else if (scanner.nextLine().toLowerCase().equals("1")) {
			System.out.println("Informe o codigo da conta: ");
			System.out.print("> ");
			
			conta = accountService.localizar(Integer.parseInt(scanner.nextLine()));
			conta.setStatus(IsSocio.NAOASSOCIADO);
		}else if (scanner.nextLine().toLowerCase().equals("2")) {
			System.out.println("Informe o codigo da conta: ");
			System.out.print("> ");
			
			conta = accountService.localizar(Integer.parseInt(scanner.nextLine()));
			conta.setStatus(IsSocio.BLOQUEADO);
		} else {
			System.out.println("Opcao invalida!");
		}
		scanner.close();
	}

	public static void locarFilme() {
		System.out.println("######### LOCACAO DE FILMES #########");
		System.out.println("");
		
		
		scanner.close();
	}
}