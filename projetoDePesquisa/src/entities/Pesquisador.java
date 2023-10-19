package entities;

import java.util.ArrayList;
import java.util.List;

import exception.NaoHaPesquisadoresException;


public abstract class Pesquisador {
	
	private String nome;
	private List<Pesquisador> pesquisadores;
	private Pesquisador coordenador;
	
	// Constructors 
	public Pesquisador () {

		pesquisadores = new ArrayList<Pesquisador>();
		coordenador = null;
		this.nome = " ";
	}
	
	public Pesquisador (String nome) {
		this.nome = nome;
		this.coordenador = null;
		pesquisadores = new ArrayList<Pesquisador>();
	}
	
	public Pesquisador (String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
		pesquisadores = new ArrayList<Pesquisador>();
	}
	
	//Getters and Setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pesquisador> getListPesquisadores() {
		if (pesquisadores.size()	>	0)
			return pesquisadores;
		else
			return null;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public Pesquisador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Pesquisador coordenador) {
		this.coordenador = coordenador;
	}


	//Methods
	
	public abstract int getQtdPesquisadores() throws NaoHaPesquisadoresException;
	
	public abstract void inserirPesquisador(String pai,Pesquisador filho) throws NaoHaPesquisadoresException;
	
	public abstract void inserirPesquisador(Pesquisador filho) throws NaoHaPesquisadoresException;
	
	public abstract double getValorPago() throws NaoHaPesquisadoresException;
	
	public Pesquisador getPesquisador(String nome) {
		
		for (Pesquisador obj : pesquisadores) {
			if(	obj.getNome().equals(nome)	) {
				return obj;
			}else if (obj instanceof Coordenador && obj.getListPesquisadores() != null) {
				obj.getPesquisador(nome);
			}
		}
		return null;
	}
	

}
