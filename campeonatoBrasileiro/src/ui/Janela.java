package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Jogador;

public class Janela {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtPosicao;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTime = new JPanel();
		tabbedPane.addTab("Time", null, panelTime, null);
		panelTime.setLayout(null);
		
		JPanel panelJogador = new JPanel();
		tabbedPane.addTab("Jogador", null, panelJogador, null);
		panelJogador.setLayout(null);
		
		JLabel lblJogadorNome = new JLabel("Nome :");
		lblJogadorNome.setBounds(10, 27, 46, 14);
		panelJogador.add(lblJogadorNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 24, 150, 20);
		panelJogador.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblJogadorPosicao = new JLabel("Posicao :");
		lblJogadorPosicao.setBounds(10, 55, 46, 14);
		panelJogador.add(lblJogadorPosicao);
		
		txtPosicao = new JTextField();
		txtPosicao.setColumns(10);
		txtPosicao.setBounds(77, 52, 150, 20);
		panelJogador.add(txtPosicao);
		
		JButton btnAddJogador = new JButton("Adicionar Jogador");
		btnAddJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.getText();
				txtPosicao.getText();

				int id = Integer.parseInt(txtID.getText());
				if(  Integer instanceof id ) {
					Jogador jogador = new Jogador(id,txtNome.getText());
				}
				

			}
		});
		btnAddJogador.setBounds(92, 148, 128, 23);
		panelJogador.add(btnAddJogador);
		
		JLabel lblId = new JLabel("Id :");
		lblId.setBounds(10, 97, 46, 14);
		panelJogador.add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(77, 94, 150, 20);
		panelJogador.add(txtID);
		txtID.setColumns(10);
	}
}
