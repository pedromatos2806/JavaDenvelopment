package Teste;
import Entities.*;

public class Teste {

	public static void main(String[] args) {
		
		Animal camelo = new Animal( "Camelo" , 150 , 4 , "Amarelo" , "Terra", 2.0);
		Peixe tubarao = new Peixe( "Tubarao" , 300 , 1.5 ,"Barbatanas", "cauda");
		Mamifero urso = new Mamifero( "Urso-do-canada" , 180.0 , 4 , "Vermelho", 0.5, "Mel");
	
		System.out.println(camelo);
		System.out.println(tubarao);
		System.out.println(urso);
	
	}
}
