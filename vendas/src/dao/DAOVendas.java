package dao;


import model.Vendas;
import java.sql.SQLException;
import java.util.List;

public abstract class DAOVendas {
	
	public abstract List<Vendas> getVendas() throws SQLException;
	
	public abstract Vendas getVenda(int ID) throws SQLException;
	
}
