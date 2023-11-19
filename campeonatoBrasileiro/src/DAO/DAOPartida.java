package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Partida;

public interface DAOPartida {
	
	public Partida getPartida(int id) throws SQLException;
	
	public List<Partida> getPartidas() throws SQLException;
	
	public void addPartida(Partida partida) throws SQLException;
	
	public void addListaPartida(List<Partida> lista  ) throws SQLException;
	
	public void updatePartida(Partida partida) throws SQLException;
}
