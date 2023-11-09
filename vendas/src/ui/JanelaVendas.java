package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelConsultar = new JPanel();
	private final JPanel panelVender = new JPanel();
	private JTextField txtAdicionar_Qtd;
	private JComboBox cbProdutos = new JComboBox();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JTextPane txtPaneID = new JTextPane();
	private JComboBox cmbProdutos = new JComboBox();
	private JTextPane txtPanelPreco = new JTextPane();
	private DAOProdutosPostgree dao_produtos;
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
		dao_produtos = new DAOProdutosPostgree();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Consultar", null, panelConsultar, null);
		panelConsultar.setLayout(null);
		
		
        try {
            listaProdutos = dao_produtos.getProdutos();
            listaProdutos.stream().forEach(item -> cbProdutos.addItem(item.getNomeString()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        
		JLabel lblProdutos = new JLabel("Produtos :");
		lblProdutos.setBounds(86, 50, 84, 14);
		panelConsultar.add(lblProdutos);
		cbProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtPaneID.setVisible(true);
            	txtPanelPreco.setVisible(true);
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
		
		txtPaneID.setVisible(false);
		txtPanelPreco.setVisible(false);
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
		
		tabbedPane.addTab("Vender", null, panelVender, null);
		panelVender.setLayout(null);
		
		JLabel lblAdicionarProduto = new JLabel("Produto :");
		lblAdicionarProduto.setBounds(31, 29, 122, 14);
		panelVender.add(lblAdicionarProduto);
		
		JLabel lblAdicionarQuantidade = new JLabel("Quantidade :");
		lblAdicionarQuantidade.setBounds(31, 66, 95, 14);
		panelVender.add(lblAdicionarQuantidade);
		
		txtAdicionar_Qtd = new JTextField();
		txtAdicionar_Qtd.setColumns(10);
		txtAdicionar_Qtd.setBounds(121, 63, 131, 20);
		panelVender.add(txtAdicionar_Qtd);
		txtAdicionar_Qtd.setVisible(false);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVendasPostgree daoVendasPostgree = new DAOVendasPostgree();
				Produtos produto = (Produtos) cmbProdutos.getSelectedItem(); 
				Vendas vendas = new Vendas(Integer.parseInt(txtAdicionar_Qtd.getText()) , produto);
				
				try {
					daoVendasPostgree.Vender(vendas);
					JOptionPane.showMessageDialog(btnAdicionar, "o produto " + vendas.getProduto() + " foi vendido!" );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdicionar.setBounds(76, 109, 176, 23);
		panelVender.add(btnAdicionar);
		
		try {
			listaProdutos  = dao_produtos.getProdutos();
			listaProdutos.stream().forEach(item -> {cmbProdutos.addItem(item);});
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cmbProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAdicionar_Qtd.setVisible(true);
			}
		});
		

		cmbProdutos.setBounds(121, 25, 131, 22);
		panelVender.add(cmbProdutos);
	}
}