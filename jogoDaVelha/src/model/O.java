package model;

public class O implements valueJogodaVelha{

	private boolean valor;
	
	private String name;

	
	public O() {
		this.valor = false;
		this.name = "O";
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "O";
	}
	
	
}
