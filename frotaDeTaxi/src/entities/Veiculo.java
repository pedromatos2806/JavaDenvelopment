package entities;

public class Veiculo {

	private double km;
	
	private int manutencoes;
	
	private double combustivel;
	
	private String placa;

	public Veiculo(double km, int manutencoes, double combustivel,String placa) {
		this.km = km;
		this.manutencoes = manutencoes;
		this.combustivel = combustivel;
		this.placa = placa;
	}

	public Veiculo(double km, int manutencoes,String placa) {
		this.km = km;
		this.manutencoes = manutencoes;
		this.placa=placa;
		}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public int getManutençoes() {
		return manutencoes;
	}

	public void setManutençoes(int manutençoes) {
		this.manutencoes = manutençoes;
	}

	public double getCombustivel() {
		return combustivel;
	}
	public int getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(int manutencoes) {
		this.manutencoes = manutencoes;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}
	
	public String toString() {
		return "Placa: "
				+ placa
				+" quilometragem: "
				+ km 
				+" , quantidade de manutenções: "
				+ manutencoes
				+" , quantidade de combustível: "
				+ combustivel;
	}
	
}
