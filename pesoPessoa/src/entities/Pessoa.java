package entities;

public abstract class Pessoa {
	
	private double altura;
	private double peso;
	
	public Pessoa() {}
	
	public Pessoa(double altura, double peso) {
		this.altura = altura;
		this.peso = peso;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
