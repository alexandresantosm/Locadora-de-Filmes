package br.com.flf.view.location;

import java.util.Scanner;

import br.com.flf.model.Location;
import service.LocationService;

public class ViewDeleteLocation {

	public static void deletaLocacao() {

		Scanner scanner = new Scanner(System.in);
		LocationService locationService = new LocationService();

		System.out.println("######### EXCLUIR LOCACAO #########");
		System.out.println("");

		System.out.println("Informe o codigo: ");
		System.out.print("> ");

		Location locacao = locationService.localizar(Integer.parseInt(scanner.nextLine()));

		if (locacao == null) {
			System.out.println("Locacao nao cadastrada!");
		} else {
			locationService.excluir(locacao.getCodigo());
		}
		scanner.close();
		ViewLocation.operacoesLocacao();
	}
}