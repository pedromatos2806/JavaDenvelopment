import exceptions.LugaresExcedidos;

public class SalaPequena extends Sala{
	
	private int lugares = 100;
	
	public SalaPequena(String nome, int ingressosComprados) throws LugaresExcedidos {
		super(nome, ingressosComprados);
		if(lugares<ingressosComprados) {
			throw new LugaresExcedidos();
		}
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}

	public Double Faturamento() {
		return (double) (super.getIngressosComprados() * 12);
	}
}
