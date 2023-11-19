package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreeSQL {
	
	private String URL="jdbc:postgresql://localhost:5433/POO";
	
	private String usuario = "postgres";
	
	private String senha = "alunoifba";
	
	public Connection getConn() throws SQLException{
		Connection conn = DriverManager.getConnection(URL, usuario , senha);
		return conn;
	}

	
}
