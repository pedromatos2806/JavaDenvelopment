package model;

public class X implements valueJogodaVelha{
	
	private boolean valor;
	
	private String name;
	
	
	public X () {
		setValor(true);
		setName("X");
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
		return "X";
	}
	

	
}
