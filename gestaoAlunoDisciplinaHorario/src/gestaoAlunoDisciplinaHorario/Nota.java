package gestaoAlunoDisciplinaHorario;

public class Nota {
	private Disciplina disciplina;
	private int valor;
	private String codigoAluno;
	
	public Nota() {}
	
	public Nota(Disciplina disciplina, int valor , String codigoAluno) {
		this.codigoAluno = codigoAluno;
		this.disciplina = disciplina;
		this.valor = valor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(String codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	
}
