package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produtos;

public interface DAOProdutos {
	
	public  List<Produtos> getProdutos() throws SQLException;
	
	public  Produtos getProduto(String nome) throws SQLException;
	
	public Produtos getProduto(int ID) throws SQLException;
	
	public Produtos addProduto(String nomeString, double preco) throws SQLException;
	
}
