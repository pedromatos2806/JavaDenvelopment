package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;

public class DAOJogadorSQLPostgres implements DAOJogadorSQL{

	private ConexaoPostgreeSQL conn;
	
	private PreparedStatement pstm;
	
	@Override
	public Jogador addJogador(Jogador jogador) throws SQLException {
		return null;
	}

	@Override
	public Jogador updateJogador(Jogador nomeJogador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jogador> getJogadores() throws SQLException {
		
		pstm=conn.getConn().prepareStatement(" SELECT * FROM jogadores");
		
		ResultSet rs = this.pstm.executeQuery();
		List<Jogador> lista = new ArrayList<Jogador>();
		Jogador jogador =  null;
		while(rs.next()) {
			String nome = rs.getString("nome");
			int id = rs.getInt("id");
			String nomePosicao = rs.getString("nomeposicao");
			int golsVasados = rs.getInt("golvasados");
			int golsFeitos = rs.getInt("golsfeitos");
			
			jogador = new Jogador(id,nome,nomePosicao);
			lista.add(jogador);
		}
		return lista;
	}

	@Override
	public Jogador getJogador(String nomeJogador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
