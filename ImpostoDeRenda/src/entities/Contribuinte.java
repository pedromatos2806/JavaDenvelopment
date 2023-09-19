package entities;
import exceptions.RendaBrutaNegativeException;

public  class Contribuinte {
	private String nome;

	protected double rendaBruta;

	public Contribuinte(String nome, double rendaBruta) throws RendaBrutaNegativeException {
		if(rendaBruta <0) {
			throw new RendaBrutaNegativeException();
		}
		this.nome = nome;
		this.rendaBruta = rendaBruta;

	}
	public double getRendaBruta() {
		return rendaBruta;
	}
	
	public void setRendaBruta(double rendaBruta) {
		this.rendaBruta = rendaBruta;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String s = "Nome: " + nome;
		s += " ; rendaBruta: " + rendaBruta;
		
		return s;
	}
}
