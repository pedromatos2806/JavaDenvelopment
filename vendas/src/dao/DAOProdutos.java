package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produtos;

public interface DAOProdutos {
	
	
	public  List<Produtos> getProdutos() throws SQLException;
	
	public  Produtos getProduto(String nome) throws SQLException;
	
	public void addProduto(Produtos produto) throws SQLException;
	
}
