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
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class JanelaVendas {

	private JFrame frame;
	private DAOProdutosPostgree produtos = new DAOProdutosPostgree();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelConsultar = new JPanel();
	private final JPanel panelAdicionar = new JPanel();
	private JTextField txtFieldProduto_Adicionar;
	private JTextField textFieldID_Adicionar;
	private JTextField textFieldPreco_Adicionar;
	private JComboBox cbProdutos = new JComboBox();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JLabel lblPreco_Adicionar = new JLabel("Preço :");
	private JTextPane txtPaneID = new JTextPane();
	private JTextPane txtPanelPreco = new JTextPane();
	private List<Produtos> listaProdutos;
	
	
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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Consultar", null, panelConsultar, null);
		panelConsultar.setLayout(null);
		
		
        try {
            listaProdutos = produtos.getProdutos();
            listaProdutos.forEach(item -> cbProdutos.addItem(item.getNomeString()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
		JLabel lblProdutos = new JLabel("Produtos :");
		lblProdutos.setBounds(86, 50, 84, 14);
		panelConsultar.add(lblProdutos);
		cbProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
     
                int selectedIndex = cbProdutos.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Produtos produtoSelecionado = listaProdutos.get(selectedIndex);
                    txtPaneID.setText(String.valueOf(produtoSelecionado.getId())); 
                    txtPanelPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
                }
            }
        });
		
		
		cbProdutos.setBounds(180, 46, 130, 22);
		panelConsultar.add(cbProdutos);
		
		
		txtPaneID.setBounds(157, 101, 224, 20);
		panelConsultar.add(txtPaneID);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setBounds(86, 101, 46, 14);
		panelConsultar.add(lblID);
		
		JLabel lblPreco = new JLabel("Preço :");
		lblPreco.setBounds(86, 132, 46, 14);
		panelConsultar.add(lblPreco);
		
		
		txtPanelPreco.setBounds(157, 126, 224, 20);
		panelConsultar.add(txtPanelPreco);
		
		tabbedPane.addTab("Adicionar", null, panelAdicionar, null);
		panelAdicionar.setLayout(null);
		
		JLabel lblProduto_Adicionar = new JLabel("Produto :");
		lblProduto_Adicionar.setBounds(80, 29, 73, 14);
		panelAdicionar.add(lblProduto_Adicionar);
		
		txtFieldProduto_Adicionar = new JTextField();
		txtFieldProduto_Adicionar.setBounds(189, 26, 131, 20);
		panelAdicionar.add(txtFieldProduto_Adicionar);
		txtFieldProduto_Adicionar.setColumns(10);
		
		JLabel lblID_Adicionar = new JLabel("ID :");
		lblID_Adicionar.setBounds(80, 66, 46, 14);
		panelAdicionar.add(lblID_Adicionar);
		
		textFieldID_Adicionar = new JTextField();
		textFieldID_Adicionar.setColumns(10);
		textFieldID_Adicionar.setBounds(189, 63, 131, 20);
		panelAdicionar.add(textFieldID_Adicionar);
		

		
		lblPreco_Adicionar.setBounds(80, 104, 46, 14);
		panelAdicionar.add(lblPreco_Adicionar);
		
		textFieldPreco_Adicionar = new JTextField();
		textFieldPreco_Adicionar.setColumns(10);
		textFieldPreco_Adicionar.setBounds(189, 101, 131, 20);
		panelAdicionar.add(textFieldPreco_Adicionar);
		
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdicionar.setBounds(119, 143, 176, 23);
		panelAdicionar.add(btnAdicionar);
	}
}