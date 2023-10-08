package entities;

import java.util.List;

import exception.NaoHaPesquisadoresException;

public class ProjetoPesquisa {
	
	private String nome;
	private List<Pesquisador> pesquisadores;
	private Pesquisador coordenador;
	
	public ProjetoPesquisa() {
		this.nome = "";
		pesquisadores = null;
		coordenador = new Coordenador("Mara Andrade");
	}
	
	public ProjetoPesquisa(String nome) {
		this.nome = nome;
		pesquisadores = null;
		coordenador = new Coordenador("Mara Andrade");
	}

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
	
	public void inserirPesquisador(Pesquisador pesquisador) {
		pesquisadores.add(pesquisador);
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
	
	public double getValorPago( String nome ) throws NaoHaPesquisadoresException{
		double salario = -1;
		for(Pesquisador pesquisador : pesquisadores) {
			if(pesquisador.getNome().equals(nome)) {
				salario = pesquisador.getValorPago();
				return salario;
			}else if(pesquisador instanceof Coordenador &&  pesquisador.getPesquisadores() != null) {
				//chamar o get valor pago para a lista de pesquisadores desse coordenador!
				 pesquisador.getValorPagoPesquisadorList(nome);
			}
		}
		if(salario == -1) {
			 throw new NaoHaPesquisadoresException();
		}
		salario = 0;
		return salario;
	}
}
