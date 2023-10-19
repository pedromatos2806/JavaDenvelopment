package entities;

import exception.NaoHaPesquisadoresException;

public class Coordenador extends Pesquisador{
	// Constructors
	public Coordenador() {
		super();
	}
	
	public Coordenador(String nome) {
		super(nome);
	}
	
	public Coordenador(String nome, Pesquisador coordenador) {
		super(nome,coordenador);
	}
	
	//Methods
	public int getQtdPesquisadores() throws NaoHaPesquisadoresException {
		
		int count = 0;
		
		for (Pesquisador pesquisador : this.getListPesquisadores()) {
			if(pesquisador instanceof Professor) {
				count++;
			}else if(pesquisador instanceof Coordenador && (this.getListPesquisadores().size() == 0 || this.getListPesquisadores() == null)){
				count ++;
			} else {
				pesquisador.getQtdPesquisadores();
			}
		}
		return count;
	}

	public void inserirPesquisador(String pai,Pesquisador filho) throws NaoHaPesquisadoresException{

		if( this.getNome().equals(pai) ) {
			this.getListPesquisadores().add(filho);
		}else {
			Pesquisador obj = getPesquisador(pai);
			obj.getListPesquisadores().add(filho);
		}
	}
	
	public void inserirPesquisador(Pesquisador filho) throws NaoHaPesquisadoresException{
		getListPesquisadores().add(filho);
	}
	
	@Override
	public double getValorPago() throws NaoHaPesquisadoresException {
		return 300 - (	(2.5/100) * getQtdPesquisadores()*300	);
	}
}
