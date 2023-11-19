package model;

public class Jogador {
	
	int id;
	
	String nome;
	
	String posicao;
	
	int golsVasados;
	
	int golsFeitos;
	
	public Jogador(int id, String nome , String posicao) {
		setId(id);
		setNome(nome);
		setPosicao(posicao);
		setGolsVasados(0);
		setGolsFeitos(0);
	}
	
	public Jogador( int id, String nome ) {
		setId(id);
		setNome(nome);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public int getGolsVasados() {
		return golsVasados;
	}

	public void setGolsVasados(int golsVasados) {
		this.golsVasados = golsVasados;
	}

	public int getGolsFeitos() {
		return golsFeitos;
	}

	public void setGolsFeitos(int golsFeitos) {
		this.golsFeitos = golsFeitos;
	}


}
