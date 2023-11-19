package model;

import java.util.ArrayList;
import java.util.List;

public class Time {
	
	String nome;
	
	int id ;
	
	List<Jogador> jogadores;
	
	int qtdJogadores;
	
	int pontuacao;

	public Time (int id, String nome ) {
		setNome(nome);
		setId(id);
		setQtdJogadores(0);
		jogadores = new ArrayList<Jogador>();
		setPontuacao(0);
	}
	
	public Time (String nome) {
		setNome(nome);
		setQtdJogadores(0);
		jogadores = new ArrayList<Jogador>();
		setPontuacao(0);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public int getQtdJogadores() {
		return qtdJogadores;
	}

	public void setQtdJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public Jogador addJogador(Jogador jogador) {
		this.jogadores.add(jogador);
		return jogador;
	}
}
