package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Time;

public interface DAOTimeSQL {
	
	public Time getTime(String nomeTime) throws SQLException;
	
	public Time addTime(Time time) throws SQLException; 
	
	public List<Time> getTimes()  throws SQLException;
	
}
