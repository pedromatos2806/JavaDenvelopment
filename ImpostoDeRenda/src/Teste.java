import entities.PessoaFisica;
import entities.PessoaJuridica;
import exceptions.RendaBrutaNegativeException;


public class Teste {

	public static void main(String[] args) throws RendaBrutaNegativeException {
			PessoaFisica p1 = new PessoaFisica("Pedro", 1400, "064.806.465-41");
			System.out.println(p1);
		
			PessoaJuridica p2 = new PessoaJuridica("Jose",1400,"155.155.155-15");
			System.out.println(p2);

		}

}
