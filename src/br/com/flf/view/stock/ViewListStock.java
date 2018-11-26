package br.com.flf.view.stock;

import br.com.flf.dao.ClientDao;
import br.com.flf.model.Client;

public class ViewListStock {

	public static void listaCopia() {

		ClientDao cs = new ClientDao();

		System.out.println("######### LISTAGEM DOS CLIENTES #########");
		System.out.println("");

		for (Client cliente : cs.listAll()) {
			System.out.println(cliente.toString());
		}

		if (cs.listAll().isEmpty()) {
			System.out.println("Nenhum cliente cadastrado!");
		}
	}
}