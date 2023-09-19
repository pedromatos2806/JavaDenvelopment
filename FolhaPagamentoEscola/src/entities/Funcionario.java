package entities;

import exceptions.NewException;

public class Funcionario {
	
	private double salarioBase;
	
	private int falta;
	
	private double horasExtras;
	


	public Funcionario(double salarioBase, int falta, double horasExtras) throws NewException{
		if(falta < 0 || salarioBase < 0 || horasExtras <0) {
			throw new NewException();
		}
		this.salarioBase = salarioBase;
		this.falta = falta;
		this.horasExtras = horasExtras;
	}

	public Funcionario(double salarioBase, double horasExtras) {
		this.salarioBase = salarioBase;
		this.horasExtras = horasExtras;
		this.falta = 0;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}
	
	@Override
	public String toString() {
		return "[ Salario: " 
				+ this.salarioBase 
				+ " , Faltas: " 
				+  this.falta
				+" , Horas Extras: "
				+ this.horasExtras
				+" ";
	}
}
