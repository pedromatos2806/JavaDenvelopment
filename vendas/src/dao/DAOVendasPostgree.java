package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
