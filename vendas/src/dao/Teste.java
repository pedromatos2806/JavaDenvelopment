package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost/POO";
		
		try {
			
			Connection conn = DriverManager.getConnection(url,"" ,""); //meu banco nao tem senha nem usuario
			
			System.out.println("Conectou");
			
			PreparedStatement psmp = conn.prepareStatement("select * from produtos where nome like ?");
			psmp.setString(1, "BOLA");
			ResultSet rs=psmp.executeQuery();
			
			while(rs.next()) {
				String nome=rs.getString("nome");
				int id=rs.getInt("id");
				double preco = rs.getDouble("preco");
				
				System.out.println(id +" - " + nome + " - "+ preco );
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
