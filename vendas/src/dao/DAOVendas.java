package dao;


import model.Vendas;
import java.sql.SQLException;

public interface DAOVendas {

	
	public Vendas Vender(Vendas venda) throws SQLException; 
	
}
