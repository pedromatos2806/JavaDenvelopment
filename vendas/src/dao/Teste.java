package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5433/POO";
		String user = "postgres";
		String password = "alunoifba";
		String nomeProduto = "BOLA";
		try {
			
			

			//usei isso no banco
			// ALTER USER postgres PASSWORD 'alunoifba';
			//select USER;
			
			System.out.println("Conectou");
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement psmp = conn.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
			psmp.setString(1, "%" + nomeProduto + "%");
			ResultSet rs=psmp.executeQuery();
			
			if(rs.next()) {
				String nome=rs.getString("nome");
				int id=rs.getInt("id");
				double preco = rs.getDouble("preco");
				
				System.out.println(id +" - " + nome + " - " + preco );
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
