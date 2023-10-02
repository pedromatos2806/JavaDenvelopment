package entities;

public class Combustao extends Veiculo{

	public Combustao(double km, int manutencoes,String placa) {
		super(km,manutencoes,placa);
		this.setCombustivel(12);
	}

}
