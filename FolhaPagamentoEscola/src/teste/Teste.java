package teste;
import java.util.Scanner;

import entities.Administrativo;
import entities.Escola;
import entities.Funcionario;
import entities.Professor;
import exceptions.NewException;
public class Teste {

	public static void main(String[] args) {
		
		Escola escola = new Escola();
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i < 4 ; i++) {
			try {
				System.out.println("Digite o salário base:");
				double salario = scan.nextDouble();
				System.out.println("Digite a qtd de faltas:");
				int faltas = scan.nextInt();
				System.out.println("Digite a qtd horas extras:");
				double horasExtras = scan.nextDouble();
				
				System.out.println("Digite 1 para Professor e 2 para Administrativo:");
				int valueFuncionario = scan.nextInt();
				Funcionario funcionario = null;
				if(valueFuncionario == 1) {
					funcionario = new Professor(salario,faltas,horasExtras);
					escola.addFuncionario(funcionario,i);
				}else {
					 funcionario = new Administrativo(salario,faltas,horasExtras);
					escola.addFuncionario(funcionario,i);
				}
				escola.addFuncionario(funcionario, i);
			}catch(NewException e) {
				System.out.println("Erro na Entrada de dados!\n");
			}
		}
		

		System.out.println("FOLHA DE PAGAMENTOS:");
		escola.imprimirFolha();
	}

}
