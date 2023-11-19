package model;

import java.util.List;

public class Torneio {
	
	private List<Partida> partidas;
	
	private List<Time> times;

	public Torneio(List<Partida> partidas, List<Time> times) {
		super();
		this.partidas = partidas;
		this.times = times;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
}
