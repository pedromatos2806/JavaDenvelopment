package entities;

public class RendimentoPesca {
	private double peso;
	private double excesso;
	private double multa;
	
	public RendimentoPesca(double peso) {
		this.peso = peso;
		this.multa = 0;
		this.excesso = 0;
	}
	
	public Double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double CalculoMulta () {
		if (this.peso > 50) {
			this.excesso = this.peso - 50;
			this.multa = excesso * 4;
			return multa;
		}else {
			return 0;
		}
	}
}
