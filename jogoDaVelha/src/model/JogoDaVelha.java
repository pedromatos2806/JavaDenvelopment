package model;

import java.util.ArrayList;

import javax.swing.JComboBox;

import ui.*;
public class JogoDaVelha {

	private boolean winner;
	
	private String campeao;

	public JogoDaVelha() {
		
	}
	
	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public String getCampeao() {
		return campeao;
	}

	public void setCampeao(String campeao) {
		this.campeao = campeao;
	}
	
	public void verificarWinner(ArrayList<JComboBox> lista) {
	
		
		
	}
	
}
