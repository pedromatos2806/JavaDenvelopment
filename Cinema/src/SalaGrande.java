import exceptions.*;

public class SalaGrande extends Sala {
	private int lugares = 500;
	
	public SalaGrande(String nome, int ingressosComprados) throws LugaresExcedidos{
		super(nome, ingressosComprados);
		if(ingressosComprados > lugares) {
			throw new LugaresExcedidos();
		}
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}
	
	public double Faturamento() {
		return super.getIngressosComprados() * 9 * 0.9; //9 é o valor de cada ingresso
	}
	
	
}
