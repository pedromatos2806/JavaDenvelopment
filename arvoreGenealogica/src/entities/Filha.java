package entities;

import java.util.Random;

import exceptions.NatimortoNaoTemFilhoException;

public class Filha extends Pessoa{

	public Filha(String nome, Pessoa pai) {
		super("Sra. " + nome, pai);
	}
	
	
	@Override
	public Pessoa cadastrarFilho(String nome, String sexo) throws NatimortoNaoTemFilhoException {
		
		if (sexo.equalsIgnoreCase("masculino")){
			Random random = new Random();
			int numero = random.nextInt(2);
			if ( numero == 0) {
				Filho pessoa = new Filho (nome,this);
				getDescendentes().add(pessoa);
				return pessoa;
			}else {
				Natimorto pessoa = new Natimorto(nome, this);
				getDescendentes().add(pessoa);
				return pessoa;
			}
		}else {
			Filha pessoa = new Filha(nome,this);
			getDescendentes().add(pessoa);
			return pessoa;
		}
		
	}
	


}
