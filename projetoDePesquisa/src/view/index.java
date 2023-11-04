package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import entities.Coordenador;
import entities.Pesquisador;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import entities.*;
;public class index {

	private JFrame frame;
	private JTextField textFieldNomePesquisador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
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
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panelCadastramentoFuncionario = new JPanel();
		tabbedPane.addTab("Cadastramento Funcionário", null, panelCadastramentoFuncionario, null);
		panelCadastramentoFuncionario.setLayout(null);
		
		JLabel lblNomePesquisador = new JLabel("Nome Pesquisador:");
		lblNomePesquisador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomePesquisador.setToolTipText("");
		lblNomePesquisador.setBounds(10, 28, 101, 30);
		panelCadastramentoFuncionario.add(lblNomePesquisador);
		
		textFieldNomePesquisador = new JTextField();
		textFieldNomePesquisador.setBounds(121, 33, 269, 20);
		panelCadastramentoFuncionario.add(textFieldNomePesquisador);
		textFieldNomePesquisador.setColumns(10);
		
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(10, 88, 46, 19);
		panelCadastramentoFuncionario.add(lblTipo);
		
		JLabel lblCoordenador = new JLabel("Coordenador:");
		lblCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCoordenador.setBounds(10, 130, 101, 19);
		panelCadastramentoFuncionario.add(lblCoordenador);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(10, 174, 101, 23);
		panelCadastramentoFuncionario.add(btnCadastrar);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(121, 88, 269, 22);
		panelCadastramentoFuncionario.add(comboBoxTipo);
		
		JComboBox comboBoxCoordenador = new JComboBox();
		comboBoxCoordenador.setBounds(121, 130, 269, 22);
		panelCadastramentoFuncionario.add(comboBoxCoordenador);
		
		JPanel panelConsultas = new JPanel();
		tabbedPane.addTab("Consultas", null, panelConsultas, null);
		panelConsultas.setLayout(null);
		
		JLabel lblPesquisador = new JLabel("Nome Pesquisador:");
		lblPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesquisador.setBounds(10, 8, 137, 20);
		panelConsultas.add(lblPesquisador);
		
		JComboBox comboBoxPesquisador = new JComboBox();
		comboBoxPesquisador.setBounds(157, 9, 261, 22);
		panelConsultas.add(comboBoxPesquisador);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulta.setBounds(10, 50, 137, 23);
		panelConsultas.add(btnConsulta);
		
		JLabel lblQtdPesquisadores = new JLabel("Qtd de Pesquisadores:");
		lblQtdPesquisadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdPesquisadores.setBounds(10, 124, 163, 20);
		panelConsultas.add(lblQtdPesquisadores);
		
		JTextArea textAreaQtdPesquisadores = new JTextArea();
		textAreaQtdPesquisadores.setBounds(194, 124, 201, 22);
		panelConsultas.add(textAreaQtdPesquisadores);
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorPago.setBounds(10, 182, 163, 20);
		panelConsultas.add(lblValorPago);
		
		JTextArea textAreaValorPago = new JTextArea();
		textAreaValorPago.setBounds(194, 182, 201, 22);
		panelConsultas.add(textAreaValorPago);
	}
}
