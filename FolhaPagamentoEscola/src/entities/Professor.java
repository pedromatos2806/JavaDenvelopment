package entities;

import exceptions.NewException;
public class Professor extends Funcionario {

	public Professor(double salarioBase, double horasExtras) throws NewException{
		super(salarioBase, horasExtras);
		this.setFalta(0);
	}

	public Professor(double salarioBase, int falta, double horasExtras) throws NewException{
		super(salarioBase, falta, horasExtras);
		
	}

	private double calcularSalario() {
		return (getSalarioBase()/(12*8) )* (2.5 *getHorasExtras()) - (getFalta() / getSalarioBase()) + getSalarioBase();
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		
		return s 
				+ "Salario: "
				+ this.calcularSalario()
				+" Professor ]";
	}

}
