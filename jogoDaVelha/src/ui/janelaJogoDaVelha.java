package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
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
		
		String x = "X";
		String o = "O";
		
		
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
		
		JComboBox cmb11 = new JComboBox();
		cmb11.setBounds(77, 51, 47, 22);
		frame.getContentPane().add(cmb11);
		
		JComboBox cmb12 = new JComboBox();
		cmb12.setBounds(77, 98, 47, 22);
		frame.getContentPane().add(cmb12);
		
		JComboBox cmb13 = new JComboBox();
		cmb13.setBounds(77, 146, 47, 22);
		frame.getContentPane().add(cmb13);
		
		JComboBox cmb21 = new JComboBox();
		cmb21.setBounds(194, 51, 47, 22);
		frame.getContentPane().add(cmb21);
		
		JComboBox cmb31 = new JComboBox();
		cmb31.setBounds(313, 51, 47, 22);
		frame.getContentPane().add(cmb31);
		
		JComboBox cmb32 = new JComboBox();
		cmb32.setBounds(313, 98, 47, 22);
		frame.getContentPane().add(cmb32);
		
		JComboBox cmb33 = new JComboBox();
		cmb33.setBounds(313, 146, 47, 22);
		frame.getContentPane().add(cmb33);
		
		JComboBox cmb22 = new JComboBox();
		cmb22.setBounds(194, 98, 47, 22);
		frame.getContentPane().add(cmb22);
		
		JComboBox cmb23 = new JComboBox();
		cmb23.setBounds(194, 146, 47, 22);
		frame.getContentPane().add(cmb23);
		
		JLabel lblTitulo = new JLabel("Jogo Da Velha");
		lblTitulo.setBounds(161, 11, 123, 19);
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		frame.getContentPane().add(lblTitulo);
		
		//Coluna 1 
		cmb11.addItem(null);
		cmb11.addItem(x);
		cmb11.addItem(o);
		
		cmb12.addItem(null);
		cmb12.addItem(x);
		cmb12.addItem(o);
		
		cmb13.addItem(null);
		cmb13.addItem(x);
		cmb13.addItem(o);
		
		//Coluna 2
		cmb21.addItem(null);
		cmb21.addItem(x);
		cmb21.addItem(o);

		cmb22.addItem(null);
		cmb22.addItem(x);
		cmb22.addItem(o);
	
	
		cmb23.addItem(null);
		cmb23.addItem(x);
		cmb23.addItem(o);
		
		//Coluna 3
		cmb31.addItem(null);
		cmb31.addItem(x);
		cmb31.addItem(o);
		
		cmb32.addItem(null);
		cmb32.addItem(x);
		cmb32.addItem(o);
		
		cmb33.addItem(null);
		cmb33.addItem(x);
		cmb33.addItem(o);
	
		txtVencedor.enable(false);
		JButton btnConfirme = new JButton("Confirmo a jogada");
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				var value11 = (String) cmb11.getSelectedItem();
				var value12 = (String) cmb12.getSelectedItem();
				var value13 = (String) cmb13.getSelectedItem();
				
				var value21 = (String) cmb21.getSelectedItem();
				var value22 = (String) cmb22.getSelectedItem();
				var value23 = (String) cmb23.getSelectedItem();
				
				var value31 = (String) cmb31.getSelectedItem();
				var value32 = (String) cmb32.getSelectedItem();
				var value33 = (String) cmb33.getSelectedItem();
					
				
				boolean valor11 = false;
				if(value11.equalsIgnoreCase("X")) {
					valor11 = true;
				}else if(value11.equalsIgnoreCase("O")){
					valor11=false;
				}
				
				boolean valor12= (Boolean) null;
				if(value12.equalsIgnoreCase("X")) {
					valor12 = true;
				}else if(value12.equalsIgnoreCase("O")){
					valor12=false;
				}
				
				boolean valor13= (Boolean) null;
				if(value13.equalsIgnoreCase("X")) {
					valor13 = true;
				}else if(value13.equalsIgnoreCase("O")){
					valor13=false;
				}
				
				boolean valor21= false;
				if(value21.equalsIgnoreCase("X")) {
					valor21 = true;
				}else if(value21.equalsIgnoreCase("O")){
					valor21=false;
				}
				
				boolean valor22= (Boolean) null;
				if(value22.equalsIgnoreCase("X")) {
					valor22 = true;
				}else if(value22.equalsIgnoreCase("O")){
					valor22=false;
				}
				
				boolean valor23= (Boolean) null;
				if(value23.equalsIgnoreCase("X")) {
					valor23 = true;
				}else if(value23.equalsIgnoreCase("O")){
					valor23=false;
				}
				
				boolean valor31 = false;
				if(value31.equalsIgnoreCase("X")) {
					valor31 = true;
				}else if(value31.equalsIgnoreCase("O")){
					valor31=false;
				}
				
				boolean valor32= (Boolean) null;
				if(value32.equalsIgnoreCase("X")) {
					valor32 = true;
				}else if(value32.equalsIgnoreCase("O")){
					valor32=false;
				}
				
				boolean valor33= (Boolean) null;
				if(value33.equalsIgnoreCase("X")) {
					valor33 = true;
				}else if(value33.equalsIgnoreCase("O")){
					valor33=false;
				}
				
				if(valor11==valor21==valor31 && valor11 == true) {
					txtVencedor.setText("X é o vencedor da partida!");
				}else if(valor11==valor21==valor31 && valor11 == false) {
					txtVencedor.setText("O é o vencedor da partida");
				}
				
			}
		});
		btnConfirme.setBounds(168, 187, 148, 23); 
		frame.getContentPane().add(btnConfirme);
		
		

	
	
	}
}
