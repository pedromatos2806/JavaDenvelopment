import exceptions.LugaresExcedidos;


public class SalaMedia extends Sala{
	private int lugares = 300;
	
	private int hora;
	
	public SalaMedia(String nome, int ingressosComprados, int lugares, int hora) throws LugaresExcedidos {
		super(nome, ingressosComprados);
		if(lugares<ingressosComprados) {
			throw new LugaresExcedidos();
		}
		this.lugares = lugares;
		this.hora=hora;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public double Faturamento() {
		if(hora <= 18) {
			return 9 * super.getIngressosComprados(); //9 se for até as 18
		}else {
			return 12 * super.getIngressosComprados(); // 12 se for dps de 18
		}
	}
	
}
