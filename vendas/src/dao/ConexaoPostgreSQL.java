package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
	
    private static final String URL = "jdbc:postgresql://localhost:5433/POO";
    //private static final String USUARIO = "seu_usuario";
    //private static final String SENHA = "sua_senha";

    
    public Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(URL,"postgres","alunoifba");
        return conn;
    }

    public void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Lidar com o erro ao fechar a conexão, se necessário
            }
        }
    }
}