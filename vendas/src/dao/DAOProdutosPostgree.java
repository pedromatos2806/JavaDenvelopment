package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produtos;

public class DAOProdutosPostgree implements DAOProdutos{

	private ConexaoPostgreSQL conexao;
	
	private PreparedStatement pstm;
	
	
	public DAOProdutosPostgree() {
		this.conexao = new ConexaoPostgreSQL();
	}
	
	@Override
	public List<Produtos> getProdutos() throws SQLException {
		
		
		
		this.pstm = this.conexao.getConn().prepareStatement("SELECT * FROM produtos");
		
		ResultSet rs = this.pstm.executeQuery();
		
		List<Produtos> lista = new ArrayList<Produtos>();
		while( rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			double preco = rs.getDouble("preco");
			Produtos produtos = new Produtos(id,nome,preco);
			lista.add(produtos);
		}
		
		return lista;
	}

	@Override
	public Produtos getProduto(String nome) throws SQLException {
		
		this.pstm = this.conexao.getConn().prepareStatement("select * from produtos where nome like ?;");
		// no parâmetro necessita colocar apostrofe já que no banco é uma string utiliza-se apostrofe?
		this.pstm.setString(1, nome);
		ResultSet rs = this.pstm.executeQuery();
		
		Produtos produtos = null;
		if(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("nome");
			double preco = rs.getDouble("preco");
			produtos = new Produtos(id,name,preco);
		}
		return produtos;
	}
	
	public Produtos getProduto(int ID) throws SQLException {
		
		this.pstm = this.conexao.getConn().prepareStatement("select * from produtos where id = ?;");
		this.pstm.setInt(1, ID);
		ResultSet rs = this.pstm.executeQuery();
		
		Produtos produtos = null;
		if(rs.next()) {
			int id_produto = rs.getInt("id");
			String name = rs.getString("nome");
			double preco = rs.getDouble("preco");
			produtos = new Produtos(id_produto,name,preco);
		}
		return produtos;
	}

	@Override
	public Produtos addProduto(String nomeString, double preco) throws SQLException {
		Produtos produto = null;
		if( !nomeString.isEmpty() || nomeString.length() > 0) {
			produto = new Produtos(nomeString,preco);
			this.pstm = this.conexao.getConn().prepareStatement("INSERT INTO produtos (nome,preco) VALUES (?,?) ");
			this.pstm.setString(1,produto.getNomeString());
			this.pstm.setDouble(2, produto.getPreco());
			this.pstm.executeUpdate();
		}

		return produto;
	}
	
}
