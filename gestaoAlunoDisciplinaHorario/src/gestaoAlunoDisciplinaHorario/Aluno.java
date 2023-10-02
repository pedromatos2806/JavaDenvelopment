package gestaoAlunoDisciplinaHorario;

import java.util.List;
import java.util.ArrayList;

public class Aluno {
	private String codigoAluno;
	private String nome;
	private List<Disciplina> disciplina;
	private List<Nota> notas;
	private Curso curso;
	
	public Aluno () {}
	
	public Aluno (String codigo, String nome, Curso curso) {
		this.codigoAluno = codigo;
		this.nome = nome;
		this.curso = curso;
		List <Disciplina> disciplina = new ArrayList<>();
		List <Nota> notas = new ArrayList<>();
	}
	
	public String getCodigo() {
		return codigoAluno;
	}
	public void setCodigo(String codigo) {
		this.codigoAluno = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Disciplina> getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void AdicionarNotas(Nota nota) {
		this.notas.add(nota);
	}
	
}