package entities;

import exception.NaoHaPesquisadoresException;

public class Professor extends Pesquisador{
	//Constructors
	public Professor() {
		super();
	}
	
	public Professor(String nome) {
		super(nome);
	}
	
	public Professor (String nome, Pesquisador cordenador) {
		super(nome,cordenador);
	}
	
	// Methods
	public  int getQtdPesquisadores() throws NaoHaPesquisadoresException {
		throw new NaoHaPesquisadoresException();
	}

	@Override
	public void inserirPesquisador(String pai, Pesquisador filho) throws NaoHaPesquisadoresException {
		throw new NaoHaPesquisadoresException();	
	}
	
	@Override
	public void inserirPesquisador(Pesquisador filho) throws NaoHaPesquisadoresException{
		throw new NaoHaPesquisadoresException();
	}
	
	@Override
	public double getValorPago() throws NaoHaPesquisadoresException {
		return 220 + ( (30/100) * this.getCoordenador().getValorPago() );
	}
}
