package entities;

import exceptions.NatimortoNaoTemFilhoException;

public class Filho extends Pessoa{

	public Filho (String nome, Pessoa pai) {
		super("Sr. " + nome , pai);
	}
	

	
	@Override
	public Pessoa cadastrarFilho(String nome, String sexo) throws NatimortoNaoTemFilhoException {
		if(countQtdFilhos() == 2 ) {
			Natimorto pessoa = new Natimorto(nome,this);
			getDescendentes().add(pessoa);
			return pessoa;
		}else if (sexo.equalsIgnoreCase("masculino")) {
			Filho pessoa = new Filho(nome,this);
			getDescendentes().add(pessoa);
			return pessoa;
		}else {
			Filha pessoa = new Filha(nome,this);
			getDescendentes().add(pessoa);
			return pessoa;
		}
	}

}
