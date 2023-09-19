package entities;

import exceptions.NewException;

public class Administrativo extends Funcionario{
	

	public Administrativo(double salarioBase, int falta, double horasExtras) throws NewException{
		super(salarioBase, falta, horasExtras);
	}
	
	private double calcularSalario() {
		return (this.getSalarioBase()/(30*8) )* (1.5 * this.getHorasExtras()) - (this.getFalta() / getSalarioBase()) + getSalarioBase();
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		
		return s 
				+ "Salario: "
				+ this.calcularSalario()
				+"  Admnistrativo ]";
	}
}
