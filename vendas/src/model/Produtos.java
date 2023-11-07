package model;

public class Produtos {
	private int id;
	
	private String nomeString;
	
	private double preco;
	
	
	public Produtos(int id, String nomeString, double preco) {
		this.setId(id);
		this.setNomeString(nomeString);
		this.setPreco(preco);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomeString() {
		return nomeString;
	}


	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
}
