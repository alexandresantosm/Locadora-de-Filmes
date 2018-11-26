package br.com.flf.view.location;

import br.com.flf.model.Location;
import service.LocationService;

public class ViewListLocation {

	public static void listaLocacao() {

		LocationService locationService = new LocationService();

		System.out.println("######### LISTAGEM DAS LOCACOES #########");
		System.out.println("");

		for (Location locacao : locationService.getLocacoes()) {
			System.out.println(locacao.toString());
		}

		ViewLocation.operacoesLocacao();
	}
}