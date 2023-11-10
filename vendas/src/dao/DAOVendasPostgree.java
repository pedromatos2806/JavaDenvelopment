package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produtos;
import model.Vendas;

public class DAOVendasPostgree implements DAOVendas{
	
	private ConexaoPostgreSQL conexao;
	
	private PreparedStatement pstm;
	
	
	public DAOVendasPostgree() {
		this.conexao = new ConexaoPostgreSQL();
	}

	@Override
	public Vendas Vender(Vendas venda) throws SQLException {
		this.pstm = this.conexao.getConn().prepareStatement("INSERT INTO vendas(quantidade,\"P_ID\") VALUES (?,?)");
		pstm.setInt(1, venda.getQuantidade());
		pstm.setInt(2, venda.getProduto().getId());
		pstm.executeUpdate();
		return venda;
	}
	
	public List<Vendas> getVendas() throws SQLException {
	
		pstm = conexao.getConn().prepareStatement("SELECT p.id as idProduto,p.nome,p.preco,v.id as idVendas, v.\"P_ID\" as vProdutoId,v.quantidade from vendas as v INNER JOIN produtos as p ON p.id = v.\"P_ID\";");
		
		ResultSet rs = pstm.executeQuery();
		List<Vendas> lista = new ArrayList<Vendas>();
		while(rs.next()) {
			
			int pId = rs.getInt("idProduto");
			String pNome = rs.getString("nome");
			double pPreco = rs.getDouble("preco");
			Produtos produto = new Produtos(pId,pNome,pPreco);
			int vId = rs.getInt("idVendas");
			int vProdutoId = rs.getInt("vProdutoId");
			int vQuantidade = rs.getInt("quantidade");
			Vendas venda = new Vendas(vId,vQuantidade,produto);
			lista.add(venda);
		}
		return lista;
	}

}
