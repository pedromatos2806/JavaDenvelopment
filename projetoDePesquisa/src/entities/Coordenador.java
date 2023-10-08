package entities;


public class Coordenador extends Pesquisador{
	
	public Coordenador() {
		super();
	}
	
	public Coordenador(String nome) {
		super(nome);
	}
	
	public Coordenador(String nome, Pesquisador coordenador) {
		super(nome,coordenador);
	}
	
	@Override
	public double getValorPago()  {
		return 300 - (	(2.5/100) * getQtdPesquisadores()	);
	}
}
