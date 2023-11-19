package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAO.DaoTimeSQLPostgres;
import model.Time;
import java.awt.Font;
import javax.swing.SwingConstants;


public class Janela {

	private JFrame frame;
	private JTextField txtPts;
	private JTextField txtVit;
	private JTextField txtDer;
	private JTextField txtEmp;
	private JTextField txtUpdateNomeMod;
	private JTextField txtUpdateNewName;
	private JTextField txtUpdatePts;
	private JTextField txtUpdateVit;
	private JTextField txtUpdateDer;
	private JTextField txtUpdateEmp;
	private JTextField txtUpdateQtdJogadores;

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
	 * @throws  
	 */
	private void initialize() {
		List<Time> lista = new ArrayList<Time>();
		DaoTimeSQLPostgres daotime = new DaoTimeSQLPostgres();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlConsultar = new JPanel();
		tabbedPane.addTab("Consultar", null, pnlConsultar, null);
		pnlConsultar.setLayout(null);
		
		JLabel lblTime = new JLabel("Time :");
		lblTime.setBounds(83, 56, 46, 14);
		pnlConsultar.add(lblTime);
		
		JComboBox cmbTimes = new JComboBox();
		cmbTimes.setBounds(139, 52, 115, 22);
		pnlConsultar.add(cmbTimes);
		
		try {
			lista = daotime.getTimes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista.stream().forEach(time -> cmbTimes.addItem(time));
		
		
		
		txtPts = new JTextField();
		txtPts.setBounds(153, 96, 86, 20);
		pnlConsultar.add(txtPts);
		txtPts.setColumns(10);
		
		txtVit = new JTextField();
		txtVit.setBounds(153, 127, 86, 20);
		pnlConsultar.add(txtVit);
		txtVit.setColumns(10);
		
		txtDer = new JTextField();
		txtDer.setBounds(153, 158, 86, 20);
		pnlConsultar.add(txtDer);
		txtDer.setColumns(10);
		
		txtEmp = new JTextField();
		txtEmp.setColumns(10);
		txtEmp.setBounds(153, 189, 86, 20);
		pnlConsultar.add(txtEmp);
		
		JLabel lblPts = new JLabel("pontos :");
		lblPts.setBounds(83, 99, 46, 14);
		pnlConsultar.add(lblPts);
		
		JLabel lblVit = new JLabel("Vitória :");
		lblVit.setBounds(83, 133, 46, 14);
		pnlConsultar.add(lblVit);
		
		JLabel lblDer = new JLabel("Derrota :");
		lblDer.setBounds(83, 164, 46, 14);
		pnlConsultar.add(lblDer);
		
		JLabel lblEmpate = new JLabel("Empate :");
		lblEmpate.setBounds(83, 192, 46, 14);
		pnlConsultar.add(lblEmpate);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time t =(Time) cmbTimes.getSelectedItem();
				txtPts.setText(t.getPontuacao()+"");
				txtEmp.setText(t.getEmp()+"");
				txtDer.setText(""+t.getDer());
				txtVit.setText(t.getVit()+"");
			}
		});
		btnConsultar.setBounds(296, 52, 89, 23);
		pnlConsultar.add(btnConsultar);
		
		JLabel lblConsultarTime = new JLabel("Consultar Times");
		lblConsultarTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarTime.setBounds(142, 0, 145, 35);
		pnlConsultar.add(lblConsultarTime);
		
		JPanel pnlUpdate = new JPanel();
		tabbedPane.addTab("Update", null, pnlUpdate, null);
		pnlUpdate.setLayout(null);
		
		JLabel lblUpdateTime = new JLabel("Update Times");
		lblUpdateTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTime.setBounds(152, 0, 104, 31);
		pnlUpdate.add(lblUpdateTime);
		
		JLabel lblUpdateNome = new JLabel("Nome do time modificado :");
		lblUpdateNome.setBounds(67, 47, 127, 31);
		pnlUpdate.add(lblUpdateNome);
		
		txtUpdateNomeMod = new JTextField();
		txtUpdateNomeMod.setBounds(241, 54, 109, 20);
		pnlUpdate.add(txtUpdateNomeMod);
		txtUpdateNomeMod.setColumns(10);
		
		JLabel lblUpdateNewName = new JLabel("Nome do novo time: ");
		lblUpdateNewName.setBounds(67, 91, 99, 20);
		pnlUpdate.add(lblUpdateNewName);
		
		txtUpdateNewName = new JTextField();
		txtUpdateNewName.setBounds(241, 91, 109, 20);
		pnlUpdate.add(txtUpdateNewName);
		txtUpdateNewName.setColumns(10);
		
		JLabel lblUpdatePts = new JLabel("Pts : ");
		lblUpdatePts.setBounds(67, 132, 46, 14);
		pnlUpdate.add(lblUpdatePts);
		
		txtUpdatePts = new JTextField();
		txtUpdatePts.setColumns(10);
		txtUpdatePts.setBounds(241, 129, 109, 20);
		pnlUpdate.add(txtUpdatePts);
		
		JLabel lblUpdateVit = new JLabel("Vit :");
		lblUpdateVit.setBounds(67, 170, 46, 14);
		pnlUpdate.add(lblUpdateVit);
		
		txtUpdateVit = new JTextField();
		txtUpdateVit.setBounds(241, 160, 109, 20);
		pnlUpdate.add(txtUpdateVit);
		txtUpdateVit.setColumns(10);
		
		JLabel lblUpdateDer = new JLabel("Der :");
		lblUpdateDer.setBounds(67, 206, 46, 14);
		pnlUpdate.add(lblUpdateDer);
		
		txtUpdateDer = new JTextField();
		txtUpdateDer.setBounds(240, 203, 110, 20);
		pnlUpdate.add(txtUpdateDer);
		txtUpdateDer.setColumns(10);
		
		JLabel lblUpdateEmp = new JLabel("Emp :");
		lblUpdateEmp.setBounds(67, 238, 46, 14);
		pnlUpdate.add(lblUpdateEmp);
		
		txtUpdateEmp = new JTextField();
		txtUpdateEmp.setBounds(241, 235, 109, 20);
		pnlUpdate.add(txtUpdateEmp);
		txtUpdateEmp.setColumns(10);
		
		JLabel lblQtdJogador = new JLabel("qtd jogadores :");
		lblQtdJogador.setBounds(67, 276, 127, 14);
		pnlUpdate.add(lblQtdJogador);
		
		txtUpdateQtdJogadores = new JTextField();
		txtUpdateQtdJogadores.setBounds(241, 273, 109, 20);
		pnlUpdate.add(txtUpdateQtdJogadores);
		txtUpdateQtdJogadores.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeMod = txtUpdateNomeMod.getText();
				
				String n = txtUpdateNewName.getText();
				int pts = Integer.parseInt(txtUpdatePts.getText());
				int vit = Integer.parseInt(txtUpdateVit.getText());
				int der = Integer.parseInt(txtUpdateDer.getText());
				int emp = Integer.parseInt(txtUpdateEmp.getText());
				int qtdJog = Integer.parseInt(txtUpdateQtdJogadores.getText());
				Time t = new Time(n,pts,vit,der,emp,qtdJog);
				
				try {
					daotime.updateTime(t, nomeMod);
					JOptionPane.showMessageDialog(btnUpdate, "O time " + t +" foi alterado com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(152, 316, 115, 31);
		pnlUpdate.add(btnUpdate);
	}
}
