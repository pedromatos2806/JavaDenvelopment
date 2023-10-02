package entities;

public class Mulher extends Pessoa{

	public Mulher() {}
	
	public Mulher(double altura, double peso) {
		super(altura, peso);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		double pesoIdeal = (62.1 * getAltura())  - 44.7 ;
		if (pesoIdeal < this.getPeso()) {
			return "acima do peso";
		} else if (pesoIdeal == this.getPeso()) {
			return "dentro do peso";
		} else {
			return "abaixo do peso";
		}
	}
	
}
