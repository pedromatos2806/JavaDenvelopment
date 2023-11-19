package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Time;

public interface DAOTimeSQL {
	
	public List<Time> getTimes()  throws SQLException;
	
	public Time getTime(String nomeTime) throws SQLException;
	
	public Time updateTime (Time time , String nome) throws SQLException;
	
	public void deleteTime(String nome) throws SQLException;
	
	public Time addTime(Time time) throws SQLException; 
}
