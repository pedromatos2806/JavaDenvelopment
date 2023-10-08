package entities;

import java.util.ArrayList;
import java.util.List;

import exception.NaoHaPesquisadoresException;


public abstract class Pesquisador {
	
	private String nome;
	private List<Pesquisador> pesquisadores;
	private Pesquisador coordenador;
	private double salario;
	
	// Constructors 
	public Pesquisador () {
		pesquisadores = new ArrayList<Pesquisador>();
		this.salario = getValorPago();
		coordenador = null;
		this.nome = " ";
	}
	public Pesquisador (String nome) {
		this.nome = nome;
		this.coordenador = null;
		this.salario = getValorPago();
		pesquisadores = new ArrayList<Pesquisador>();
	}
	
	public Pesquisador (String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
		this.salario = getValorPago();
		pesquisadores = new ArrayList<Pesquisador>();
	}
	
	//Getters and Setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	//Methods
	public abstract double getValorPago();
	
	public void inserirPesquisador(Pesquisador pesquisador) {
			pesquisadores.add(pesquisador);
	}
	
	public boolean isProfessor(Pesquisador pesquisador) {
		if(pesquisador instanceof Professor) {
			return true;
		}
		return false;
	}
	
	public int getQtdPesquisadores() {
		int count = 0;
		for (Pesquisador pesquisador : pesquisadores) {
			if(pesquisador instanceof Professor) {
				count++;
			}else if(pesquisador instanceof Coordenador && getPesquisadores() == null){
				count ++;	
			} else {
				getQtdPesquisadores();
			}
		}
		return count;
	}
	
	public double getValorPagoPesquisadorList(String nome) throws NaoHaPesquisadoresException {
		double salario = -1;
		for(Pesquisador obj : pesquisadores) {
			if(obj.getNome().equals(nome)){
				salario =  getValorPago();
				return salario;
			}else if(obj instanceof Coordenador && getPesquisadores() != null) {
				obj.getValorPagoPesquisadorList(nome);
			}
		}

		if(salario == -1) {
			 throw new NaoHaPesquisadoresException();
		}
		salario = 0;
		return salario;
	}
}
