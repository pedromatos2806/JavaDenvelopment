package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DropMode;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;

public class index {

	private JFrame frmCalculaImc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.frmCalculaImc.setVisible(true);
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
		frmCalculaImc = new JFrame();
		frmCalculaImc.getContentPane().setForeground(Color.BLACK);
		frmCalculaImc.setForeground(Color.BLACK);
		frmCalculaImc.setTitle("Calcula IMC");
		frmCalculaImc.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCalculaImc.setBounds(100, 100, 241, 195);
		frmCalculaImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculaImc.getContentPane().setLayout(null);
		
		JTextArea txtrAltura = new JTextArea();
		txtrAltura.setForeground(Color.BLACK);
		txtrAltura.setEditable(false);
		txtrAltura.setBackground(Color.LIGHT_GRAY);
		txtrAltura.setText("Altura :");
		txtrAltura.setBounds(10, 41, 66, 22);
		frmCalculaImc.getContentPane().add(txtrAltura);
		
		JEditorPane pnAltura = new JEditorPane();
		pnAltura.setForeground(Color.BLACK);
		pnAltura.setDropMode(DropMode.INSERT);
		pnAltura.setBounds(75, 43, 107, 20);
		frmCalculaImc.getContentPane().add(pnAltura);
		
		JTextArea txtSexo = new JTextArea();
		txtSexo.setLineWrap(true);
		txtSexo.setForeground(Color.BLACK);
		txtSexo.setEditable(false);
		txtSexo.setText("Sexo:");
		txtSexo.setBackground(Color.LIGHT_GRAY);
		txtSexo.setBounds(10, 69, 53, 22);
		frmCalculaImc.getContentPane().add(txtSexo);
		
		JRadioButton rdbtnSexoMasculino = new JRadioButton("Masculino");
		rdbtnSexoMasculino.setForeground(Color.BLACK);
		rdbtnSexoMasculino.setSelected(true);
		rdbtnSexoMasculino.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSexoMasculino.setBackground(Color.LIGHT_GRAY);
		rdbtnSexoMasculino.setBounds(65, 70, 79, 22);
		frmCalculaImc.getContentPane().add(rdbtnSexoMasculino);
		
		JRadioButton rdbtnSexoFeminino = new JRadioButton("Feminino");
		rdbtnSexoFeminino.setForeground(Color.BLACK);
		rdbtnSexoFeminino.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSexoFeminino.setBackground(Color.LIGHT_GRAY);
		rdbtnSexoFeminino.setBounds(139, 70, 80, 22);
		frmCalculaImc.getContentPane().add(rdbtnSexoFeminino);
		
		JTextArea txtNumeroDeFaltas = new JTextArea();
		txtNumeroDeFaltas.setLineWrap(true);
		txtNumeroDeFaltas.setForeground(Color.BLACK);
		txtNumeroDeFaltas.setEditable(false);
		txtNumeroDeFaltas.setText("Peso :");
		txtNumeroDeFaltas.setBackground(Color.LIGHT_GRAY);
		txtNumeroDeFaltas.setBounds(10, 11, 53, 20);
		frmCalculaImc.getContentPane().add(txtNumeroDeFaltas);
		
		JEditorPane pnPeso = new JEditorPane();
		pnPeso.setForeground(Color.BLACK);
		pnPeso.setDropMode(DropMode.INSERT);
		pnPeso.setBounds(65, 11, 107, 20);
		frmCalculaImc.getContentPane().add(pnPeso);
		
		JButton btnConfirmar = new JButton("confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(83, 100, 89, 44);
		frmCalculaImc.getContentPane().add(btnConfirmar);
	}
}
