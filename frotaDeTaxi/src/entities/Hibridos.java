package entities;

public class Hibridos extends Veiculo{

	public Hibridos(double km, int manutencoes, String placa) {
		super(km, manutencoes, placa);
		this.setCombustivel(2.5);
	}
	
	public String ConecaoTomada(int ligado) {
		if (ligado == 1 ) {
			return "carro conectado";
		}else {
			return "carro desconectado";
		}
	}
}
