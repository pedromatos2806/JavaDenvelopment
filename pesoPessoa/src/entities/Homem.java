package entities;

public class Homem extends Pessoa{

	public Homem() {
		super();
	}
	public Homem (double altura, double peso) {
		super(altura, peso);
	}

	@Override
	public String toString() {
		double pesoIdeal = (72.7 * this.getAltura()) - (58);
		if( pesoIdeal < this.getPeso() ) {
			return "acima do peso";
		}else if( pesoIdeal == this.getPeso() ) {
			return "dentro do peso";
		}else {
			return "abaixo do peso";
		}
	}
}
