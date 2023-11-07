package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Vendas;

public class DAOVendasPostgree extends DAOVendas{
	
	private ConexaoPostgreSQL conexao;
	
	private PreparedStatement pstm;
	
	
	
	public DAOVendasPostgree() {
		this.conexao = new ConexaoPostgreSQL();
	}
	
	
	
	@Override
	public List<Vendas> getVendas() throws SQLException {
		List<Vendas> lista = new ArrayList<Vendas>();
		this.pstm=this.conexao.getConn().prepareStatement("SELECT * FROM AUTOR");
		ResultSet rs = this.pstm.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			int quantidade = rs.getInt("quantidade");
			int p_id = rs.getInt("P_ID");
			Vendas vendas = new Vendas(id,quantidade,p_id);
			lista.add(vendas);
		}
		
		return lista;
	}

	@Override
	public Vendas getVenda(int ID) throws SQLException {
		this.pstm = this.conexao.getConn().prepareCall("SELECT * FROM AUTOR WHERE ID=?");
		this.pstm.setInt(1, ID);
		ResultSet rs = this.pstm.executeQuery();
		
		Vendas vendas = null;
		if(rs.next()) {
			int id = rs.getInt("id");
			int quantidade = rs.getInt("quantidade");
			int p_id = rs.getInt("P_ID");
			 vendas = new Vendas(id,quantidade,p_id);
		}
		return vendas;
	}

}
