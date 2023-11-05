package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.NatimortoNaoTemFilhoException;

public abstract class Pessoa {
	
	Pessoa pai;
	String nome;
	List<Pessoa> descendentes;
	
	
	public Pessoa(String nome, Pessoa pai) {
		descendentes = new ArrayList<Pessoa>();
		setNome(nome);
		setPai(pai);		
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getDescendentes() {
		return descendentes;
	}

	public void setDescendentes(List<Pessoa> descendentes) {
		this.descendentes = descendentes;
	}
	
	public Pessoa findPessoa (String nome) {
		if(nome.equalsIgnoreCase(getNome())) {
			return  this;
		}else if(getDescendentes() != null) {
			for (Pessoa p : descendentes) {
				if(p.getNome().equalsIgnoreCase(nome)) {
					return p;
				}else {
					Pessoa pessoaEncontrada = p.findPessoa(nome);
					if (pessoaEncontrada != null) {
						return pessoaEncontrada;
					}
				}
			}
		}
		return null;
	}
		
	public int countQtdFilhos(){
		int count =	0;
		if (getDescendentes() != null) {	
			for(  Pessoa p : descendentes) {
				if(p != null)
				count ++;	
			}
		}
		return count;	
	}
	
	public String listarAscendentes() {
		Pessoa paiAtual = this.getPai();
		String nomes="";
		while(paiAtual != null) {
			nomes += paiAtual.getNome()+ "\n";
			paiAtual = paiAtual.getPai();
		}
		return nomes;
	}
	
	public abstract Pessoa cadastrarFilho ( String nome , String sexo ) throws NatimortoNaoTemFilhoException;

	@Override
	public String toString() {
		return nome;
	}

}
