package entities;
import exceptions.LugaresExcedidosException;

public class SalaGrande extends Sala {

	public SalaGrande(String nome, int tamanho) {
		super(nome, tamanho);
		// TODO Auto-generated constructor stub
	}
	public void comprarIngresso(int sessao, int bilhetes) throws LugaresExcedidosException{
		if (this.getTamanho() * 0.9 < (bilhetes + this.getSessao(sessao).getAssentosDisponiveis() ) || this.getSessao(sessao).getAssentosDisponiveis() < bilhetes  ) {
			throw new LugaresExcedidosException();
		}else {
			  
			this.getSessao(sessao).setAssentosDisponiveis(this.getSessao(sessao).getAssentosDisponiveis() - bilhetes);
		}
	}
}
