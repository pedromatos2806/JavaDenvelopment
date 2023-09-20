public class Sala {

	private String nome;
	
	private int ingressosComprados;

	public Sala(String nome, int ingressosComprados) {
		this.nome = nome;
		this.ingressosComprados = ingressosComprados;
	}

	public Sala(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIngressosComprados() {
		return ingressosComprados;
	}

	public void setIngressosComprados(int ingressosComprados) {
		this.ingressosComprados = ingressosComprados;
	}
	
}
