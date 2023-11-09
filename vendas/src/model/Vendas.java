package model;

public class Vendas {
	
		private int id;
		
		private int quantidade;
		
		private Produtos produto;
		
		
		public Vendas(int id, int quantidade , Produtos produto) {
			setId(id);
			setProduto(produto);
			setQuantidade(quantidade);
		}
		
		public Vendas(int quantidade , Produtos produto) {
			setQuantidade(quantidade);
			setProduto(produto);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public Produtos getProduto() {
			return produto;
		}

		public void setProduto(Produtos produto) {
			this.produto = produto;
		}
		
		@Override 
		public String toString() {
			return produto.getNomeString() + getQuantidade()  ;
			}

}
