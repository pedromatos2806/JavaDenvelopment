package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Time;

public class DaoTimeSQLPostgres implements DAOTimeSQL{
	
	private ConexaoPostgreeSQL conn;
	
	private PreparedStatement pstm;
	
	private ResultSet rs;
	
	
	public DaoTimeSQLPostgres() {
		conn = new ConexaoPostgreeSQL();
	}
	
	
	@Override
	public List<Time> getTimes() throws SQLException {
		pstm=conn.getConn().prepareStatement("SELECT * FROM TIMES;");
		rs=pstm.executeQuery();
		
		List<Time> lista = new ArrayList<Time>();
		Time t = null;
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			int pts = rs.getInt("pts");
			int vit = rs.getInt("vit");
			int der = rs.getInt("der");
			int emp = rs.getInt("emp");
			int qtdJog = rs.getInt("qtdjogador");
			t = new Time(id,nome,pts,vit,der,emp,qtdJog);
			lista.add(t);
		}
		return lista;
	}
	
	@Override
	public Time getTime(String nomeTime) throws SQLException {
		pstm=conn.getConn().prepareStatement("SELECT * FROM times WHERE nome like '?' ");
		pstm.setString(1,nomeTime);
		
		rs=pstm.executeQuery();
		Time t = null;
		if(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			int pts = rs.getInt("pts");
			int vit = rs.getInt("vit");
			int der = rs.getInt("der");
			int emp = rs.getInt("emp");
			int qtdJog = rs.getInt("qtdjogador");
			t = new Time(id,nome,pts,vit,der,emp,qtdJog);
		}
		return t;
	}

	@Override
	public Time updateTime(Time time , String nome) throws SQLException {
		Time t = getTime(nome);
		if( t == null) {
			return null;
		}
		
		pstm = conn.getConn().prepareStatement("UPDATE times SET nome = '?' , pts = ? , vit = ? , der = ? , emp = ? , qtdjogador = ? WHERE nome = '?' ");
		pstm.setString(1, time.getNome());
		pstm.setInt(2, time.getPontuacao());
		pstm.setInt(3, time.getVit());
		pstm.setInt(4, time.getDer());
		pstm.setInt(5, time.getEmp());
		pstm.setInt(6, time.getQtdJogadores());
		pstm.setString(7, nome);
		
		pstm.executeUpdate();
		
		return time;
	}
	
	@Override
	public void deleteTime(String nome) throws SQLException {
		pstm= conn.getConn().prepareStatement("DELETE FROM times WHERE nome = '?' ");
		pstm.setString(1,nome);
		
		pstm.executeUpdate();
	}
	
	@Override
	public Time addTime(Time time) throws SQLException {
		pstm=conn.getConn().prepareStatement("INSERT INTO times (nome,pts,vit,der,emp,qtdjgoador) VALUES('?',?,?,?,?,?); ");
		pstm.setString(1, time.getNome());
		pstm.setInt(2, time.getPontuacao());
		pstm.setInt(3, time.getVit());
		pstm.setInt(4, time.getDer());
		pstm.setInt(5, time.getEmp());
		pstm.setInt(6, time.getQtdJogadores());
		
		return time;
	}

}
