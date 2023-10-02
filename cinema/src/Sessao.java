
public class Sessao {
	
	private double assentosDisponiveis;
	private double assentosVendidos;
	private int horario;
	private double ingresso;
	
	public Sessao(double assentosDisponiveis, double assentosVendidos, int horario, double ingresso) {
		this.assentosDisponiveis = assentosDisponiveis;
		this.assentosVendidos = assentosVendidos;
		this.horario = horario;
		this.ingresso = ingresso;
	}

	public double getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(double assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}

	public double getAssentosVendidos() {
		return assentosVendidos;
	}

	public void setAssentosVendidos(double assentosVendidos) {
		this.assentosVendidos = assentosVendidos;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public double getIngresso() {
		return ingresso;
	}

	public void setIngresso(double ingresso) {
		this.ingresso = ingresso;
	}
	
	public double faturamento() {
		return this.ingresso * assentosVendidos;
	}
}
