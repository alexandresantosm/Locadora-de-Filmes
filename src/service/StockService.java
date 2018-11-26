package service;

import java.util.List;

import br.com.flf.dao.StockDao;
import br.com.flf.model.Stock;

public class StockService {
	
	private StockDao stockDao = new StockDao();
	private Stock copia = new Stock();
	
	public Stock getCopia() {
		return copia;
	}
	
	public void setCopia(Stock copia) {
		this.copia = copia;
	}

	public List<Stock> getCopias() {
		return stockDao.listAll();
	}

	public void excluir(Integer codigo) {
		stockDao.delete(codigo);
		copia = new Stock();
	}
	
	public void gravar() {
		stockDao.createOrUpdate(copia);
		copia = new Stock();
	}
	
	public void editar(Stock copia) {
		this.copia = copia; 
	}
	
	public Stock localizar(Integer codigo) {
		return stockDao.findByCodigo(codigo);
	}
}