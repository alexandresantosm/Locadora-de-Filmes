package br.com.flf.view.location;

import java.util.Scanner;

import br.com.flf.model.Location;
import service.LocationService;

public class ViewFindByLocation {

	public static Location buscaLocacao() {

		Scanner scanner = new Scanner(System.in);
		LocationService locationService = new LocationService();

		System.out.println("######### PESQUISA LOCACAO #########");
		System.out.println("");

		System.out.println("Informe o codigo: ");
		System.out.print("> ");

		Location locacao = locationService.localizar(Integer.parseInt(scanner.nextLine()));

		scanner.close();
		ViewLocation.operacoesLocacao();
		return locacao;
	}
}