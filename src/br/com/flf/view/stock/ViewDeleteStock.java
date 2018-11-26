package br.com.flf.view.stock;

import java.util.Scanner;

import br.com.flf.model.Stock;
import service.StockService;

public class ViewDeleteStock {

	public static void deletaCopia() {

		Scanner scanner = new Scanner(System.in);
		StockService stockService = new StockService();

		System.out.println("######### EXCLUIR CLIENTE #########");
		System.out.println("");
		
		System.out.println("Informe o codigo: ");
		System.out.print("> ");

		Stock copia = stockService.localizar(Integer.parseInt(scanner.nextLine()));
		
		if (copia == null) {
			System.out.println("Copia nao cadastrada!");
		} else {
			stockService.excluir(copia.getCodigo());
			System.out.println("Copia deletada com sucesso!");
		}
		
		scanner.close();
		ViewStock.operacoesCopia();
	}
}