package gestaoAlunoDisciplinaHorario;

import java.util.ArrayList;
import java.util.List;

import exceptions.ExisteDisciplinaException;

public class Curso {
	private String nome;
	private String codigo;
	private List<Horario> horarios;
	private List <Disciplina> disciplinas;
	private List <Aluno> alunos;
	
	public Curso() {
		
	}
	
	public Curso(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.horarios = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void AdicionarDisciplina(Disciplina disciplina) throws ExisteDisciplinaException{
		for ( Disciplina obj : disciplinas ) {
			if(obj.getCodigo() == disciplina.getCodigo()) {
				throw new ExisteDisciplinaException();
			}
		}
		this.disciplinas.add(disciplina);	
	}
	
	
}
