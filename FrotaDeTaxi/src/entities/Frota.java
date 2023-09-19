package entities;

public class Frota {
	private Veiculo veiculo[] ;
	
	public Frota() {
		super();
		this.veiculo = new Veiculo[4];
	}
	
	public void addVeiculo(Veiculo veiculo, int i) {
		this.veiculo[i]= veiculo;
	}
	
	public void ImprimirLista() {
		
		for (Veiculo veiculo : veiculo) {
			System.out.println(veiculo);
		}
	}
}