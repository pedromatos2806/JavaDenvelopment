package model;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	
	private int id;
	
	private List<Time> times;	

	private Time vencedor;

	
	public Partida (Time vencedor) {
		times = new ArrayList<Time>();
		setVencedor(vencedor);
	}
	
	public Partida (int id, Time vencedor) {
		setId(id);
		setVencedor(vencedor);
		times = new ArrayList<Time>();
	}
			
	public Partida (int id, Time vencedor , List<Time> times) {
		setId(id);
		setVencedor(vencedor);
		setTimes(times);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Time getVencedor() {
		return vencedor;
	}

	public void setVencedor(Time vencedor) {
		this.vencedor = vencedor;
	}
	
	public Time addTime(Time time) {
		getTimes().add(time);
		return time;
	}
	
	public void GolFeito(String time , String nomeJogador , int qtdGols) {
		for (Time item : times) {
			if(item.getNome().equals(time)) {
				for (Jogador jogador : item.getJogadores()) {
					if(jogador.getNome().equals(nomeJogador)) {
						jogador.setGolsFeitos(qtdGols);
					}
				}
			}
		}
	}
	public void GolVazado(String time , String nomeJogador , int qtdGols) {
		for (Time item : times) {
			if(item.getNome().equals(time)) {
				for (Jogador jogador : item.getJogadores()) {
					if(jogador.getNome().equals(nomeJogador)) {
						jogador.setGolsVasados(qtdGols);
					}
				}
			}
		}
	}
	public void Pontuacao(Time vencedor) {
		if(vencedor == null) // ou seja ocorreu um empate!
		{
			for (Time item : times) {
				var pts = item.getPontuacao();
				item.setPontuacao(pts += 1);
			}
		}else { // adicionar 3 pontos para o time vencedor
			for (Time item : times) {
				if(item.getNome().equals(vencedor.getNome())) {
					var pts = item.getPontuacao();
					
					item.setPontuacao(3+pts);
				}
			}
		}
	}
}
