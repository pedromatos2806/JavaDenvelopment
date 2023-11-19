package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class janelaNumberRandom {

	private JFrame frame;
	private JTextField txtNumeroRandom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaNumberRandom window = new janelaNumberRandom();
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
	public janelaNumberRandom() {
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
		
		JLabel lblRandom = new JLabel("Número Random :");
		lblRandom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRandom.setBounds(21, 70, 128, 36);
		frame.getContentPane().add(lblRandom);
		
		txtNumeroRandom = new JTextField();
		txtNumeroRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		txtNumeroRandom.setEnabled(false);
		txtNumeroRandom.setBounds(173, 76, 149, 28);
		frame.getContentPane().add(txtNumeroRandom);
		txtNumeroRandom.setColumns(10);
		
		JButton btnTrocarNumber = new JButton("Mudar Numero");
		btnTrocarNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rd = new Random ();
				
				int number = rd.nextInt(11);
				
				txtNumeroRandom.setText("" + number);
			}
		});
		btnTrocarNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTrocarNumber.setBounds(127, 140, 140, 23);
		frame.getContentPane().add(btnTrocarNumber);
	}
}
