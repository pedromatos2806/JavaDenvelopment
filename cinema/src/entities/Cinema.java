package entities;

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
	
	public double FaturamentoCinema() {
		double faturamentototal = 0;
		
		for (SalaGrande sala : grande) {
			faturamentototal += sala.faturamento();
		}
		
		for (SalaMedia sala : media) {
			faturamentototal += sala.faturamento();
		}
		for (SalaPequena sala : pequena) {
			faturamentototal += sala.faturamento();
		}
		return faturamentototal;
	}
		
}
