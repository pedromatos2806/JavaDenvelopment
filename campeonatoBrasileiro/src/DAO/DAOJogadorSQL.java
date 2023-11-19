package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Jogador;

public interface DAOJogadorSQL {
	
	
	public Jogador addJogador(Jogador jogador) throws SQLException;
	
	public Jogador updateJogador(Jogador nomeJogador) throws SQLException;
	
	public List<Jogador> getJogadores() throws SQLException;
	
	public Jogador getJogador(String nomeJogador) throws SQLException;
	

}
