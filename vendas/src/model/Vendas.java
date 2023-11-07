package model;

public class Vendas {
	
		private int id;
		
		private int quantidade;
		
		private int produto_id;
		
		
		public Vendas(int id, int quantidade , int produto_id) {
			setId(id);
			setProduto_id(produto_id);
			setQuantidade(quantidade);
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


		public int getProduto_id() {
			return produto_id;
		}


		public void setProduto_id(int produto_id) {
			this.produto_id = produto_id;
		}
		


}
