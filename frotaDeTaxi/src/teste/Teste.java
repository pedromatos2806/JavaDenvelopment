package teste;

import java.util.Scanner;

import entities.*;

public class Teste {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Frota frota = new Frota();
		Veiculo veiculo = null;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			System.out.println("Digite a quilometragem" + " de " + (i+1) + " :");
			double km = scan.nextDouble();
			System.out.println("Digite a manutenção"+ " de " + (i+1) + " :" );
			int manutencao = scan.nextInt();
			System.out.println("Digite a combustível"+ " de " + (i+1) + " :" );
			double combustivel = scan.nextDouble();
			System.out.println("Digite a placa" + " de " + (i+1) + " :");
			String placa = scan.next();
			
			int j=1;
			
			do {
				System.out.println("Digite 1 para combustão, 2 para eletrico , 3 para hibrido:");
				int typeVeiculo = scan.nextInt();
				
				j=1;
					switch(typeVeiculo) {
						case 1:{
							veiculo = new Combustao(km,manutencao,placa);
							break;
						}	
						case 2:{
							veiculo = new Eletricos(km,manutencao,placa);
							break;
						}
						case 3:{
							veiculo = new Hibridos(km,manutencao,placa);
							break;
						}
						default:
							System.out.println("valor digitado não percete ao esperado!");
							j=0;
					}
				}while(j==0);
			
			frota.addVeiculo(veiculo, i);
		}
		frota.ImprimirLista();

	}

}
