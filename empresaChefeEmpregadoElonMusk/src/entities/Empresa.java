package entities;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nome;
	private List<Pessoa>funcionarios;
	
	Empresa(String nome) {
		this.nome = nome;
		funcionarios = new ArrayList();
	}
	Empresa() {
		funcionarios = new ArrayList();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public void adicionarPessoas(Pessoa pessoa) {
		funcionarios.add(pessoa);
	}
	
	public void listarChefe() {
		for(Pessoa pessoa : funcionarios) {
			if(pessoa instanceof Chefe) {
				System.out.println(pessoa);
			}
		}
	}
	
	public void listaEmpregado() {
		for(Pessoa pessoa : funcionarios) {
			if(pessoa instanceof Empregado) {
				System.out.println(pessoa);
			}
		}
	}
}
