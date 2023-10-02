package entities;

public class Eletricos extends Veiculo{

	public Eletricos(double km, int manutencoes, String placa) {
		super(km, manutencoes, placa);
		this.setCombustivel(0);
		// TODO Auto-generated constructor stub
	}
	public String ConecaoTomada(int ligado) {
		if (ligado == 1 ) {
			return "carro conectado";
		}else {
			return "carro desconectado";
		}
	}
	
}
