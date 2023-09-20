
public class Cinema {
	
	private SalaGrande grande [];
	
	private SalaMedia media[];
	
	private SalaPequena pequena[];
	
	public Cinema() {
		this.grande = new SalaGrande[3]; 
		this.media = new SalaMedia[4];
		this.pequena = new SalaPequena[5];
	}
	
	public void addSalaGrande(int i, SalaGrande grande) {
		this.grande[i] = grande;
	}
	
	public void addSalaMedia(int i, SalaMedia media) {
		this.media[i] = media;
	}
	
	public void addSalaPequena(int i , SalaPequena pequena) {
		this.pequena[i] = pequena; 
	}
	
	public void FaturamentoCinema() {
		
		Double Fat = 0.0 ,Fat1 = 0.0 , Fat2 = 0.0;
		int lugar = 0 ,  lugar1 = 0, lugar2 = 0; 
		int lotacao = 0 , lotacao1 = 0 , lotacao2 = 0;
		int lot=0;
		
		for (SalaGrande grande : grande) {
			 Fat = Fat + grande.Faturamento();
			 lugar = lugar + grande.getLugares();
			 lotacao =  grande.getLugares() - grande.getIngressosComprados();
			 lot = lot + lotacao;
			 System.out.println("Lotacao: " + lotacao);
		}
		
		for (SalaMedia media : media) {
			 Fat1 = Fat1 + media.Faturamento();
			 lugar1 = lugar1 + media.getLugares(); 
			 media.getIngressosComprados();
			 lotacao1 = media.getLugares() - media.getIngressosComprados();
			 System.out.println("Lotacao: " + lotacao1);
			 lot= lot + lotacao1;
		}
		
		for (SalaPequena pequena : pequena) {
			 Fat2 = Fat2 + pequena.Faturamento();
			 lugar2 = lugar2 + pequena.getLugares();
			 lotacao2 = pequena.getLugares() - pequena.getIngressosComprados();
			 System.out.println("Lotacao: " + lotacao2);
			 lot= lot + lotacao2;
		}
		
		System.out.println("Faturamento total: " + (Fat + Fat1 + Fat2) );
		System.out.println("Lugares: " + (lugar + lugar1 + lugar2));
		System.out.println("Lotacao: " + lot);
		
	}
}
