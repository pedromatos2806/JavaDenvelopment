package principal;

import java.util.Scanner;

import entities.Homem;
import entities.Mulher;

public class Teste {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o sexo da pessoa (homem/mulher): ");
		String gender = scan.nextLine();
		String sexo = gender.toLowerCase();

		if(sexo.equals("homem") ) {
			System.out.println("digite a altura do homem:");
			Double altura = scan.nextDouble();
			System.out.println("digite o peso do homem:");
			Double peso = scan.nextDouble();
			Homem homem = new Homem(altura, peso);
			System.out.println(homem);
		}else {
			System.out.println("digite a altura do mulher:");
			Double altura = scan.nextDouble();
			System.out.println("digite o peso do mulher:");
			Double peso = scan.nextDouble();
			Mulher mulher = new Mulher(altura,peso);
			System.out.println(mulher);
		}
		
		
	}

}
