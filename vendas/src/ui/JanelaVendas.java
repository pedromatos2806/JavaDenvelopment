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
import java.util.ArrayList;
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
	private DAOVendasPostgree dao_vendas = new DAOVendasPostgree();;
	private DAOProdutosPostgree dao_produtos = new DAOProdutosPostgree();
	private List<Produtos> listaProdutos = new ArrayList<Produtos>();
	

	
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panelConsultar = new JPanel();
		JLabel lblConsultarID = new JLabel("ID :");
		JLabel lblConsultarProdutos = new JLabel("Produtos :");
		JLabel lblConsultarPreco = new JLabel("Preço :");
		JComboBox cmbConsultarProdutos = new JComboBox();
		JTextPane txtConsultarID = new JTextPane();
		JTextPane txtConsultarPreco = new JTextPane();

		
		JPanel panelAdd = new JPanel();
		JLabel lblAddPreco = new JLabel("Preco");
		JLabel lblAddNome = new JLabel("Nome:");
		JTextField txtAddNome;
		JTextField txtAddPreco;
		JButton btnAddProduto = new JButton("Adicionar Produto");
		

		JPanel panelVender = new JPanel();
		JLabel lblVenderProduto = new JLabel("Produto :");
		JLabel lblVenderQuantidade = new JLabel("Quantidade :");
		JTextField txtVenderQtd;
		JComboBox cmbVenderProdutos = new JComboBox();
		JButton btnVenderAdicionar = new JButton("Adicionar");



		JPanel panelNF = new JPanel();
		JLabel lblNFVendas = new JLabel("Vendas :");
		JLabel lblNFProduto = new JLabel("Produto :");
		JLabel lblNFQuantidade = new JLabel("Quantidade :");
		JTextField txtNFProduto;
		JTextField txtNFQuantidade;
		JComboBox cmbNFVendas = new JComboBox();

		
		
		dao_produtos = new DAOProdutosPostgree();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Consultar", null, panelConsultar, null);
		panelConsultar.setLayout(null);
		
		txtConsultarID.enable(false);
		txtConsultarPreco.enable(false);
		txtConsultarID.setVisible(false);
		txtConsultarPreco.setVisible(false);
		
        try {
            listaProdutos = dao_produtos.getProdutos();
            listaProdutos.stream().forEach(item -> cmbConsultarProdutos.addItem(item.getNomeString()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
		lblConsultarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultarProdutos.setBounds(86, 50, 84, 14);
		panelConsultar.add(lblConsultarProdutos);
		cmbConsultarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtConsultarID.setVisible(true);
            	txtConsultarPreco.setVisible(true);
                int selectedIndex = cmbConsultarProdutos.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Produtos produtoSelecionado = listaProdutos.get(selectedIndex);
                    txtConsultarID.setText(String.valueOf(produtoSelecionado.getId())); 
                    txtConsultarPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
                }
            }
        });
		
		
		cmbConsultarProdutos.setBounds(180, 46, 130, 22);
		panelConsultar.add(cmbConsultarProdutos);
		txtConsultarID.setBounds(157, 101, 224, 20);
		panelConsultar.add(txtConsultarID);
		lblConsultarID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultarID.setBounds(86, 101, 46, 14);
		panelConsultar.add(lblConsultarID);
		lblConsultarPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultarPreco.setBounds(86, 132, 46, 14);
		panelConsultar.add(lblConsultarPreco);
		txtConsultarPreco.setBounds(157, 126, 224, 20);
		panelConsultar.add(txtConsultarPreco);
		

		// Region Add 
		tabbedPane.addTab("Adicionar", null, panelAdd, null);
		panelAdd.setLayout(null);
		

		lblAddNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddNome.setBounds(64, 38, 61, 34);
		panelAdd.add(lblAddNome);
		
		txtAddNome = new JTextField();
		txtAddNome.setBounds(176, 47, 142, 20);
		panelAdd.add(txtAddNome);
		txtAddNome.setColumns(10);
		
		
		lblAddPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddPreco.setBounds(64, 95, 61, 28);
		panelAdd.add(lblAddPreco);
		
		txtAddPreco = new JTextField();
		txtAddPreco.setBounds(176, 101, 142, 20);
		panelAdd.add(txtAddPreco);
		txtAddPreco.setColumns(10);
		
		
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
		btnAddProduto.setBounds(176, 153, 169, 23);
		panelAdd.add(btnAddProduto);
		
		// Region Vender 
		tabbedPane.addTab("Vender", null, panelVender, null);
		panelVender.setLayout(null);
		
		try {
			listaProdutos  = dao_produtos.getProdutos();
			listaProdutos.stream().forEach(item -> {cmbVenderProdutos.addItem(item);});
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblVenderProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVenderProduto.setBounds(92, 47, 72, 14);
		panelVender.add(lblVenderProduto);

		lblVenderQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVenderQuantidade.setBounds(92, 84, 95, 14);
		panelVender.add(lblVenderQuantidade);
		
		txtVenderQtd = new JTextField();
		txtVenderQtd.setColumns(10);
		txtVenderQtd.setBounds(182, 81, 131, 20);
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
		
		
		btnVenderAdicionar.setBounds(137, 127, 176, 23);
		panelVender.add(btnVenderAdicionar);
		cmbVenderProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVenderQtd.setVisible(true);
			}
		});
		
		try {
			var lista_vendas = dao_vendas.getVendas();
			lista_vendas.stream().forEach(item -> cmbNFVendas.addItem(item));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cmbVenderProdutos.setBounds(182, 43, 131, 22);
		panelVender.add(cmbVenderProdutos);
		
		
		// Region NF 
		tabbedPane.addTab("Nota F.", null, panelNF, null);
		panelNF.setLayout(null);

		lblNFProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNFProduto.setBounds(58, 90, 76, 14);
		panelNF.add(lblNFProduto);
		
		txtNFProduto = new JTextField();
		txtNFProduto.setBounds(174, 89, 180, 20);
		panelNF.add(txtNFProduto);
		txtNFProduto.setColumns(10);
		

		
		lblNFQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNFQuantidade.setBounds(58, 127, 86, 20);
		panelNF.add(lblNFQuantidade);
		
		txtNFQuantidade = new JTextField();
		txtNFQuantidade.setBounds(174, 129, 180, 20);
		panelNF.add(txtNFQuantidade);
		txtNFQuantidade.setColumns(10);
		
		
		lblNFVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNFVendas.setBounds(58, 46, 76, 14);
		panelNF.add(lblNFVendas);
		
		txtNFProduto.setVisible(false);
		txtNFQuantidade.setVisible(false);
		txtNFQuantidade.enable(false);
		txtNFProduto.enable(false);
		
		cmbNFVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNFProduto.setVisible(true);
				txtNFQuantidade.setVisible(true);

				Vendas vender = (Vendas) cmbNFVendas.getSelectedItem();

				txtNFProduto.setText(vender.getProduto().getNomeString());
				txtNFQuantidade.setText(String.valueOf(vender.getQuantidade()));

			}
		});
		cmbNFVendas.setBounds(174, 44, 180, 22);
		panelNF.add(cmbNFVendas);
	}
}