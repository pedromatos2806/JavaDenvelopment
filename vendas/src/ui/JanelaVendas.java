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
import java.awt.Font;

public class JanelaVendas {

	private JFrame frame;

	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelConsultar = new JPanel();
	private final JPanel panelVender = new JPanel();
	private JTextField txtVenderQtd;
	private JComboBox cmbConsultarProdutos = new JComboBox();
	private JButton btnVenderAdicionar = new JButton("Adicionar");
	private JTextPane txtPaneID = new JTextPane();
	private JComboBox cmbVenderProdutos = new JComboBox();
	private JTextPane txtPanelPreco = new JTextPane();
	private DAOProdutosPostgree dao_produtos;
	private List<Produtos> listaProdutos;
	private final JPanel panel = new JPanel();
	private JTextField txtAddNome;
	private JTextField txtAddPreco;
	
	
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
            listaProdutos.stream().forEach(item -> cmbConsultarProdutos.addItem(item.getNomeString()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
        
		JLabel lblProdutos = new JLabel("Produtos :");
		lblProdutos.setBounds(86, 50, 84, 14);
		panelConsultar.add(lblProdutos);
		cmbConsultarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtPaneID.setVisible(true);
            	txtPanelPreco.setVisible(true);
                int selectedIndex = cmbConsultarProdutos.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Produtos produtoSelecionado = listaProdutos.get(selectedIndex);
                    txtPaneID.setText(String.valueOf(produtoSelecionado.getId())); 
                    txtPanelPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
                }
            }
        });
		
		
		cmbConsultarProdutos.setBounds(180, 46, 130, 22);
		panelConsultar.add(cmbConsultarProdutos);
		
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
		
		try {
			listaProdutos  = dao_produtos.getProdutos();
			listaProdutos.stream().forEach(item -> {cmbVenderProdutos.addItem(item);});
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tabbedPane.addTab("Adicionar", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 29, 61, 34);
		panel.add(lblNewLabel);
		
		txtAddNome = new JTextField();
		txtAddNome.setBounds(136, 38, 142, 20);
		panel.add(txtAddNome);
		txtAddNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preco");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 86, 61, 28);
		panel.add(lblNewLabel_1);
		
		txtAddPreco = new JTextField();
		txtAddPreco.setBounds(136, 92, 142, 20);
		panel.add(txtAddPreco);
		txtAddPreco.setColumns(10);
		
		JButton btnAddProduto = new JButton("Adicionar Produto");
		btnAddProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOProdutosPostgree daoprodutos = new DAOProdutosPostgree();

				try {
					
					var produto = daoprodutos.addProduto(txtAddNome.getText(), Double.parseDouble(txtAddPreco.getText()));
						if(produto != null) {
							JOptionPane.showMessageDialog(btnAddProduto, "O produto " + produto +" foi adicionado com sucesso!");
						}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAddProduto.setBounds(136, 144, 169, 23);
		panel.add(btnAddProduto);
		
		tabbedPane.addTab("Vender", null, panelVender, null);
		panelVender.setLayout(null);
		
		JLabel lblVenderProduto = new JLabel("Produto :");
		lblVenderProduto.setBounds(31, 29, 72, 14);
		panelVender.add(lblVenderProduto);
		
		JLabel lblVenderQuantidade = new JLabel("Quantidade :");
		lblVenderQuantidade.setBounds(31, 66, 95, 14);
		panelVender.add(lblVenderQuantidade);
		
		txtVenderQtd = new JTextField();
		txtVenderQtd.setColumns(10);
		txtVenderQtd.setBounds(121, 63, 131, 20);
		panelVender.add(txtVenderQtd);
		txtVenderQtd.setVisible(false);
		
		btnVenderAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVendasPostgree daoVendasPostgree = new DAOVendasPostgree();
				Produtos produto = (Produtos) cmbVenderProdutos.getSelectedItem(); 
				Vendas vendas = new Vendas(Integer.parseInt(txtVenderQtd.getText()) , produto);
				
				try {
					daoVendasPostgree.Vender(vendas);
					JOptionPane.showMessageDialog(btnVenderAdicionar, "o produto " + vendas.getProduto() + " foi vendido!" );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVenderAdicionar.setBounds(76, 109, 176, 23);
		panelVender.add(btnVenderAdicionar);
		cmbVenderProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVenderQtd.setVisible(true);
			}
		});
		

		cmbVenderProdutos.setBounds(121, 25, 131, 22);
		panelVender.add(cmbVenderProdutos);
	}
}