package entities;

import java.util.List;

import exception.NaoHaPesquisadoresException;

public class ProjetoPesquisa {
	
	private String nome;
	private Pesquisador coordenador;
	
	public ProjetoPesquisa() {
		this.nome = "";
		coordenador = new Coordenador("Mara Andrade");
	}
	
	public ProjetoPesquisa(String nome) {
		this.nome = nome;
		coordenador = new Coordenador("Mara Andrade");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pesquisador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Pesquisador coordenador) {
		this.coordenador = coordenador;
	}
	
	public void inserirPesquisador(String nomePai ,Pesquisador filho) {
		//ir no primeiro pesquisador do projeto de pesquisa 
		// pesquisar se há algum pai com esse nome 
		// se houver algum pai com esse nome ,se for, 
		//inserir o pesquisador na lista de pesquisadores do pai 
		// se não for, busque na lista de pesquisadores do filho alguém com esse nome.
		if(	nomePai.equals(	getCoordenador().getNome()	)	) {
			getCoordenador().getListPesquisadores().add(filho);
		}else {
			if(	getCoordenador().getPesquisador(nomePai) != null) {
				var obj = getCoordenador().getPesquisador(nomePai);
				obj.inserirPesquisador(filho);
			}
		}
		
	}

	public int getQtdPesquisadores() {
		int qtd = 1;
		 qtd += getCoordenador().getQtdPesquisadores();
		return qtd;
	}
	
//	public double getValorPago( String nome ) throws NaoHaPesquisadoresException{
//		double salario = -1;
//		for(Pesquisador pesquisador : pesquisadores) {
//			if(pesquisador.getNome().equals(nome)) {
//				salario = pesquisador.getValorPago();
//				return salario;
//			}else if(pesquisador instanceof Coordenador &&  pesquisador.getListPesquisadores() != null) {
//				//chamar o get valor pago para a lista de pesquisadores desse coordenador!
//				 pesquisador.getValorPagoPesquisadorList(nome);
//			}
//		}
//		if(salario == -1) {
//			 throw new NaoHaPesquisadoresException();
//		}
//		salario = 0;
//		return salario;
//	}
}
