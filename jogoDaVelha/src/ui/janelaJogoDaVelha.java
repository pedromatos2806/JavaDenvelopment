package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class janelaJogoDaVelha {

	private JFrame frame;
	private JTextField txtVencedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaJogoDaVelha window = new janelaJogoDaVelha();
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
	public janelaJogoDaVelha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbVencedor = new JLabel("Vencedor :");
		lbVencedor.setBounds(130, 236, 78, 19);
		lbVencedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lbVencedor);
		
		txtVencedor = new JTextField();
		txtVencedor.setBounds(218, 234, 131, 27);
		frame.getContentPane().add(txtVencedor);
		txtVencedor.setColumns(10);
	
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(181, 274, 123, 38);
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnIniciar);
		
		JComboBox<String> cmb11 = new JComboBox();
		cmb11.setBounds(77, 51, 47, 22);
		frame.getContentPane().add(cmb11);
		
		JComboBox<String> cmb12 = new JComboBox();
		cmb12.setBounds(77, 98, 47, 22);
		frame.getContentPane().add(cmb12);
		
		JComboBox<String> cmb13 = new JComboBox();
		cmb13.setBounds(77, 146, 47, 22);
		frame.getContentPane().add(cmb13);
		
		JComboBox<String> cmb21 = new JComboBox();
		cmb21.setBounds(194, 51, 47, 22);
		frame.getContentPane().add(cmb21);
			
		JComboBox<String> cmb22 = new JComboBox();
		cmb22.setBounds(194, 98, 47, 22);
		frame.getContentPane().add(cmb22);
		
		JComboBox<String> cmb23 = new JComboBox();
		cmb23.setBounds(194, 146, 47, 22);
		frame.getContentPane().add(cmb23);
		
		JComboBox<String> cmb31 = new JComboBox();
		cmb31.setBounds(313, 51, 47, 22);
		frame.getContentPane().add(cmb31);

		JComboBox<String> cmb32 = new JComboBox();
		cmb32.setBounds(313, 98, 47, 22);
		frame.getContentPane().add(cmb32);
		
		JComboBox<String> cmb33 = new JComboBox();
		cmb33.setBounds(313, 146, 47, 22);
		frame.getContentPane().add(cmb33);
		
		JLabel lblTitulo = new JLabel("Jogo Da Velha");
		lblTitulo.setBounds(161, 11, 123, 19);
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		frame.getContentPane().add(lblTitulo);
		
		//Coluna 1 
		cmb11.addItem("");
		cmb11.addItem("X");
		cmb11.addItem("O");
		
		cmb12.addItem("");
		cmb12.addItem("X");
		cmb12.addItem("O");
		
		cmb13.addItem("");
		cmb13.addItem("X");
		cmb13.addItem("O");
		
		//Coluna 2
		cmb21.addItem("");
		cmb21.addItem("X");
		cmb21.addItem("O");

		cmb22.addItem("");
		cmb22.addItem("X");
		cmb22.addItem("O");
	
	
		cmb23.addItem("");
		cmb23.addItem("X");
		cmb23.addItem("O");
		
		//Coluna 3
		cmb31.addItem("");
		cmb31.addItem("X");
		cmb31.addItem("O");
		
		cmb32.addItem("");
		cmb32.addItem("X");
		cmb32.addItem("O");
		
		cmb33.addItem("");
		cmb33.addItem("X");
		cmb33.addItem("O");
	
		//txtVencedor.enable(false);
		
		JButton btnConfirme = new JButton("Confirmo a jogada");
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String winner = null;

				if(( cmb11.getSelectedItem().equals(cmb12.getSelectedItem()) ) && (cmb11.getSelectedItem().equals( cmb13.getSelectedItem()) )&& (cmb11.getSelectedItem() != "") ){
					winner =(String) cmb11.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				} if  ( (cmb21.getSelectedItem().equals(cmb22.getSelectedItem()) )&& (cmb21.getSelectedItem().equals(cmb23.getSelectedItem()) )&& (cmb21.getSelectedItem() != "") ) {
					winner =(String) cmb21.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				} if((cmb31.getSelectedItem().equals( cmb32.getSelectedItem())) && ( cmb31.getSelectedItem().equals( cmb33.getSelectedItem()) ) && (cmb31.getSelectedItem() != "") ){
					winner = (String) cmb31.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				}if( (cmb11.getSelectedItem().equals(cmb21.getSelectedItem()) )&&( cmb11.getSelectedItem().equals(cmb31.getSelectedItem()) ) && (cmb11.getSelectedItem() != "") ){
					winner =(String) cmb11.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				}if( (cmb12.getSelectedItem().equals(cmb22.getSelectedItem()) ) && (cmb12.getSelectedItem().equals( cmb32.getSelectedItem()) )&& (cmb12.getSelectedItem() != "") ){
					winner= (String)cmb12.getSelectedItem();
					txtVencedor.setText(winner);
					return;
					
				} if( (cmb13.getSelectedItem().equals(cmb23.getSelectedItem()) ) && (cmb13.getSelectedItem().equals( cmb33.getSelectedItem()) )&& (cmb13.getSelectedItem() != "") ){
					winner=(String) cmb13.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				} if((cmb11.getSelectedItem().equals(cmb22.getSelectedItem()) )&& (cmb11.getSelectedItem().equals(cmb33.getSelectedItem()) )&& (cmb11.getSelectedItem() != "") ){
					winner=(String)cmb11.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				} if ((cmb31.getSelectedItem().equals(cmb22.getSelectedItem()) ) && (cmb31.getSelectedItem().equals(cmb13.getSelectedItem()) )&& (cmb31.getSelectedItem() != "") ){
					winner=(String)cmb31.getSelectedItem();
					txtVencedor.setText(winner);
					return;
				}
			}
		});
		btnConfirme.setBounds(168, 187, 148, 23); 
		frame.getContentPane().add(btnConfirme);
		
		

	
	
	}
}
