package entities;

import exceptions.NatimortoNaoTemFilhoException;

public class Natimorto extends Pessoa{

	public Natimorto(String nome, Pessoa pai) {
		super("Natimorto " + nome, pai);
	}
	
	@Override
	public Pessoa cadastrarFilho(String nome, String sexo) throws NatimortoNaoTemFilhoException {
		throw new NatimortoNaoTemFilhoException("Natimorto Não tem filhos!");
	}
	
}
