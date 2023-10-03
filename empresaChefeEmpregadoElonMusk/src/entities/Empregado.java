package entities;

import excpetions.NaoHaSubordinadosException;
import excpetions.UltrapassouLimiteSubordinadoException;

public class Empregado extends Pessoa{

	public Empregado(String nome, Pessoa chefe) {
		super(nome, chefe);
		// TODO Auto-generated constructor stub
	}
 	public Pessoa encontrarSubordinado(String nome) throws NaoHaSubordinadosException {
 			throw new NaoHaSubordinadosException();
 	}
	public void adicionarSubordinado (Pessoa pessoa) throws UltrapassouLimiteSubordinadoException {
			throw new UltrapassouLimiteSubordinadoException();
	}
}

