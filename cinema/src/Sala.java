import exceptions.LugaresExcedidosException;

public class Sala {

	private String nome;
	private Sessao[] sessao;
	private int tamanho;
	
	public Sala(String nome , int tamanho) {
		this.nome = nome;
		this.sessao = new Sessao[10];
		this.tamanho = tamanho;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sessao[] getSessao() {
		return sessao;
	}
	public Sessao getSessao(int i) {
		return sessao[i];
	}
	public void setSessao(Sessao[] sessao) {
		this.sessao = sessao;
	}

	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public double faturamento() {
		double valor = 0;
		for (Sessao obj : sessao) {
			valor += obj.faturamento();
		}
		return valor;
	}
	public double qtdIngressosVendidos() {
		double valor = 0;
		for (Sessao obj : sessao) {
			valor += obj.getAssentosVendidos();
		}
		return valor;
	}
	
	public void comprarIngresso(int sessao, int bilhetes) throws LugaresExcedidosException{
		if (this.sessao[sessao].getAssentosDisponiveis() < bilhetes ) {
			throw new LugaresExcedidosException();
		}else {
			this.sessao[sessao].setAssentosDisponiveis(this.sessao[sessao].getAssentosDisponiveis() - bilhetes);
		}
	}
	
	@Override
	public String toString() {
		return this.nome
			+ faturamento()
			+ qtdIngressosVendidos();
	}
}
