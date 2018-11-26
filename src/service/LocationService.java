package service;

import java.util.List;

import br.com.flf.dao.LocationDao;
import br.com.flf.model.Location;

public class LocationService {
	
	private LocationDao locationDao = new LocationDao();
	private Location locacao = new Location();
	
	public Location getLocacao() {
		return locacao;
	}
	
	public void setLocacao(Location locacao) {
		this.locacao = locacao;
	}

	public List<Location> getLocacoes() {
		return locationDao.listAll();
	}

	public void excluir(Integer codigo) {
		locationDao.delete(codigo);
		locacao = new Location();
	}
	
	public void gravar() {
		locationDao.createOrUpdate(locacao);
		locacao = new Location();
	}
	
	public void editar(Location locacao) {
		this.locacao = locacao; 
	}
	
	public Location localizar(Integer codigo) {
		return locationDao.findByCodigo(codigo);
	}
}