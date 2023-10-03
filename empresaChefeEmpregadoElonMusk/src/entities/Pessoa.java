package entities;

import java.util.ArrayList;
import java.util.List;

import excpetions.NaoHaSubordinadosException;
import excpetions.UltrapassouLimiteSubordinadoException;

public class Pessoa {
	
	 private String nome;
	 private Pessoa chefe;
	 private List<Pessoa> subordinados;
	 
 	public Pessoa(String nome, Pessoa chefe){
 		this.nome = nome;
 		this.chefe = chefe;
 		this.subordinados = new ArrayList();
 	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getChefe() {
		return chefe;
	}

	public void setChefe(Pessoa chefe) {
		this.chefe = chefe;
	}

	public List<Pessoa> getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(List<Pessoa> subordinados) {
		this.subordinados = subordinados;
	}
 	

	public void adicionarSubordinado (Pessoa pessoa) throws UltrapassouLimiteSubordinadoException {
		if( subordinados.size() > 10 ) {
			throw new UltrapassouLimiteSubordinadoException();
		} else {
			subordinados.add(pessoa);
		}
	}
	

 	public void ListarEmpregadosSubordinados() {
		for(Pessoa obj : subordinados) {
			if(obj instanceof Empregado) {
				if(subordinados != null) {
					ListarEmpregadosSubordinados();
					System.out.println(obj);
				}
			}
		}
 	}
 	
 	public void listarSuperiores() {
 		if( this.chefe != null ) {
 			this.chefe.chefe.listarSuperiores();
 			System.out.println(this.chefe);
 		}
 	}
 	
 	public Pessoa encontrarSubordinado(String nome) throws NaoHaSubordinadosException {
 		//apenas os subordinados diretos
 		if(subordinados == null) {
 			throw new NaoHaSubordinadosException();
 		}else {
 			for (Pessoa pessoa : subordinados) {
				if(pessoa.equals(nome)) {
					return pessoa;
				}
			}
 			return null;
 		}
 	}
 	
	@Override
	public String toString() {
		return "Nome: " + this.nome
			+ "\nChefe: " + this.chefe;
	}
}
