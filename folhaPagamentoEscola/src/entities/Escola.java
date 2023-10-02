package entities;

public class Escola {
	
	private Funcionario lista[];
	
	public Escola() {
		super();
		this.lista = new Funcionario[4];
	}
	public void addFuncionario(Funcionario funcionario, int i) {
		lista[i]= funcionario;
	}
	
	public void imprimirFolha() {
		for(Funcionario funcionario : lista) {
			System.out.println(funcionario);
		}
	}
}
