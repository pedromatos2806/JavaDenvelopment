package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produtos;

public abstract class DAOProdutos {
	
	
	public abstract List<Produtos> getProdutos() throws SQLException;
	
	public abstract Produtos getProduto(String nome) throws SQLException;
	
}
