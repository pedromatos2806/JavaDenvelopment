package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entities.*;
import exceptions.NatimortoNaoTemFilhoException;

import javax.swing.JRadioButton;


;public class JanelaArvoreGenealogica {

	private JFrame frame;
	private JTextField txtNome;
	private Pessoa joao = new Filho("João", null);
	JComboBox cbDescendentes = new JComboBox();
	JTextArea textAreaDescendentes = new JTextArea();
	JButton btnAdicionar = new JButton("Adicionar");
	JLabel lblDescendentes = new JLabel("Descendentes");
	JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	ButtonGroup rd = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaArvoreGenealogica window = new JanelaArvoreGenealogica();
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
	public JanelaArvoreGenealogica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 32, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(91, 29, 149, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		

		lblDescendentes.setBounds(10, 75, 82, 14);
		frame.getContentPane().add(lblDescendentes);
		
		
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAdicionar) {
					String nomeNovaPessoa=txtNome.getText();
					String nomePai = "" + cbDescendentes.getSelectedItem();
					Pessoa pai = joao.findPessoa(nomePai);
					String sexo = "";
				if(rdbtnFeminino.isSelected()) {
					 sexo = "Feminino";
				}else {
					 sexo = "Masculino";
				}
					if(pai!=null) {
						try {
							
/*							if ("masculino".equalsIgnoreCase(sexo)) {
								Pessoa nova = new Filho();
							}else {
								Pessoa nova = new Filha();
							}
*/							
							  Pessoa nova = pai.cadastrarFilho(nomeNovaPessoa,sexo);
							cbDescendentes.addItem(nova.getNome());
						} catch (NatimortoNaoTemFilhoException e1) {
							JOptionPane.showMessageDialog(btnAdicionar, "Natimorto não pode ter filhos!");
						}
					}else {
						System.out.println("pessoa nula");
					}
				}
			}
		});
		btnAdicionar.setBounds(20, 110, 149, 40);
		frame.getContentPane().add(btnAdicionar);
		
		
		textAreaDescendentes.setBounds(10, 161, 464, 152);
		frame.getContentPane().add(textAreaDescendentes);
		
		
		cbDescendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == cbDescendentes) {
					String nomePessoaSelecionada = "" + cbDescendentes.getSelectedItem();
					
					Pessoa pessoaSelecionada = joao.findPessoa(nomePessoaSelecionada);
					if(pessoaSelecionada != null) {
						String ascendentes = pessoaSelecionada.listarAscendentes();
						textAreaDescendentes.setText(ascendentes);
					}
				}
			}
		});
		cbDescendentes.setModel(new DefaultComboBoxModel(new String[] {"", "Sr. João"} ));
		cbDescendentes.setBounds(99, 71, 126, 22);
		frame.getContentPane().add(cbDescendentes);
		

		rdbtnMasculino.setBounds(203, 119, 109, 23);
		frame.getContentPane().add(rdbtnMasculino);
		
		
		rdbtnFeminino.setBounds(327, 119, 109, 23);
		frame.getContentPane().add(rdbtnFeminino);
		
		rd.add(rdbtnFeminino);
		rd.add(rdbtnMasculino);
	}
}
