package br.com.flf.view.location;

import java.util.Scanner;

import br.com.flf.model.Account;
import br.com.flf.model.Location;
import service.AccountService;
import service.LocationService;

public class ViewCreateLocation {

	public static Location cadatraLocacao() {
		Scanner scanner = new Scanner(System.in);
		Location locacao = new Location();
		LocationService locationService = new LocationService();
		AccountService accountService = new AccountService();

		System.out.println("######### CADASTRO DE LOCACAO #########");
		System.out.println("");
		
		System.out.println("Escolha uma conta: ");
		for (Account conta : accountService.getContas()) {
			System.out.println(conta.getCodigo() + " - " + conta.getCliente().getNome());
		}
		
		System.out.println("Informe o codigo da conta: ");
		System.out.print("> ");
		
		locacao.setConta(accountService.localizar(Integer.parseInt(scanner.nextLine())));
		
		
		locationService.gravar();
		
		scanner.close();
		ViewLocation.operacoesLocacao();
		return locacao;
	}
}