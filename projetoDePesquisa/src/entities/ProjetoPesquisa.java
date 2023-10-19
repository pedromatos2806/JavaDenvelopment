package entities;

import exception.NaoHaPesquisadoresException;

public class ProjetoPesquisa {
	
	private String nome;
	private Pesquisador coordenador;
	
	// Constructors 
	public ProjetoPesquisa() {
		this.nome = "";
		coordenador = new Coordenador("Mara Andrade");
	}
	
	public ProjetoPesquisa(String nome) {
		this.nome = nome;
		coordenador = new Coordenador("Mara Andrade");
	}
	
	// Getters and Setters
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
	
	// Methods 
	public void inserirPesquisador(String nomePai ,Pesquisador filho) throws NaoHaPesquisadoresException {
//		ir no primeiro pesquisador do projeto de pesquisa 
//		 pesquisar se há algum pai com esse nome 
//		 se houver algum pai com esse nome ,se for, 
//		inserir o pesquisador na lista de pesquisadores do pai 
//		 se não for, busque na lista de pesquisadores do filho alguém com esse nome.
		if(	nomePai.equals(	getCoordenador().getNome()	)	) {
			getCoordenador().getListPesquisadores().add(filho);
		}else {
			if(	getCoordenador().getPesquisador(nomePai) != null) {
				Pesquisador obj = getCoordenador().getPesquisador(nomePai);
				obj.inserirPesquisador(filho);
			}else {
				System.out.println("Não há nenhum pai com esse nome!");
			}
		}
	}

	public int getQtdPesquisadores() throws NaoHaPesquisadoresException {
		int qtd = 1;
		 qtd += getCoordenador().getQtdPesquisadores();
		return qtd;
	}
	
	public double getValorPago( String nome ) throws NaoHaPesquisadoresException{
		   if(	getCoordenador().getNome().equals(nome)	) {
			   return getCoordenador().getValorPago();
		   }
		   else if ( getCoordenador().getPesquisador(nome) != null ) {
			   Pesquisador obj = getCoordenador().getPesquisador(nome);
			   return obj.getValorPago();
		   }else {
			   throw new NaoHaPesquisadoresException();
		   }
	 }
}
