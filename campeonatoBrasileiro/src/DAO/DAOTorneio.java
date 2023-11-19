package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Partida;
import model.Time;

public interface DAOTorneio {
	
	public Partida getPartida(int id)throws SQLException;
	
	public List<Partida> getPartidas () throws SQLException;
	
	public List<Time> getTimes() throws SQLException;
	
	public Time getTime(int id) throws SQLException;
	
}
