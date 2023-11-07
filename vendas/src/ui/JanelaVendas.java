package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import dao.*;
import model.*;

public class JanelaVendas {

	private JFrame frame;
	private JTextField txtFieldQuantidade;
	private JLabel lblProduto = new JLabel("produto");

	private JComboBox cbProduto = new JComboBox<>();
	private JLabel lblQuantidade = new JLabel("quantidade");
	private JButton btnComprar = new JButton("Comprar");
	private JTextArea ValorPago = new JTextArea();
	private JLabel lblValorPago = new JLabel("Valor");
	private DAOProdutosPostgree produtos = new DAOProdutosPostgree();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaVendas window = new JanelaVendas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaVendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblProduto.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblProduto);
		cbProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbProduto.setVisible(true);
				List<Produtos> lista = null;
		        try {
		            lista = produtos.getProdutos();
		            DefaultComboBoxModel<Produtos> model = new DefaultComboBoxModel<>(lista.toArray(new Produtos[0]));
		            cbProduto.setModel(model);
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
				
				
				//cbProduto.add(produtos.getProdutos());
				
				
			}
		});
		
		
		cbProduto.setBounds(66, 42, 211, 22);
		frame.getContentPane().add(cbProduto);
		//cbQuantidade.setModel(new DefaultComboBoxModel(new String[] {""}));
		
		lblQuantidade.setBounds(10, 101, 67, 14);
		frame.getContentPane().add(lblQuantidade);
		
		txtFieldQuantidade = new JTextField();
		txtFieldQuantidade.setBounds(87, 98, 127, 20);
		frame.getContentPane().add(txtFieldQuantidade);
		txtFieldQuantidade.setColumns(10);
		
		
		btnComprar.setBounds(160, 190, 89, 23);
		frame.getContentPane().add(btnComprar);
		
		
		ValorPago.setBounds(86, 143, 321, 22);
		frame.getContentPane().add(ValorPago);
		
		
		lblValorPago.setBounds(10, 148, 46, 14);
		frame.getContentPane().add(lblValorPago);
	}
}