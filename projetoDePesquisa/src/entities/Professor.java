package entities;


public class Professor extends Pesquisador
{
	public Professor() {
		super();
	}
	public Professor (String nome, Pesquisador cordenador) {
		super(nome,cordenador);
	}
	
	
	@Override
	public void inserirPesquisador(Pesquisador pesquisador) {
		// TODO Auto-generated method stub
		System.out.println("Nao é Possível inserir um Pesquisador em um Professor!");
	}
	@Override
	public int getQtdPesquisadores() {
		// como eu lanço a excessão aqui??
		// já que não há pesquisadores para adicionar
		return 0;
	}
	
	@Override
	public double getValorPago() {
		return 220 + ( (30/100) * getCoordenador().getValorPago() );
	}
	
}
