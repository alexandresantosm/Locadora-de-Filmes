package br.com.flf.view.location;

import java.util.Date;
import java.util.Scanner;

import br.com.flf.model.Location;
import service.LocationService;

public class ViewUpdateLocation {

	public static Location atualizaLocacao() {

		Scanner scanner = new Scanner(System.in);
		LocationService locationService = new LocationService();
		Date data;
		
		System.out.println("######### ATUALIZACAO DE LOCACAO #########");
		System.out.println("");

		System.out.println("Informe o codigo: ");
		System.out.print("> ");

		Location locacao = locationService.localizar(Integer.parseInt(scanner.nextLine()));

		if (locacao != null) {
			System.out.println("Setando a data de hoje");
			System.out.print("> ");
			data = new Date();
			locacao.setDataLocacao(data);

		} else {
			System.out.println("Locacao nao encontrada!");
		}

		locationService.editar(locacao);
		scanner.close();
		ViewLocation.operacoesLocacao();
		return locacao;
	}
}