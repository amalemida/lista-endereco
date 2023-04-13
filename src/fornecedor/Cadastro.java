package fornecedor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.daos.Fornecedores;
import bd.dbos.Fornecedor;
import buscacep.Logradouro;
import controller.BuscaCep;
import controller.Crud;
import controller.FornecedorLogradouro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textRazaoSocial;
	private JTextField textCNPJ;
	private JTextField textCEP;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textBairro;
	private JTextField textLogradouro;
	private JTextField textMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//limpa os dados
	public void clear() {
		
		textCodigo.setText("");
		textCNPJ.setText("");
		textRazaoSocial.setText("");
		textCEP.setText("");
		textCodigo.requestFocus();
		textNumero.setText("");
		textComplemento.setText("");
		textBairro.setText("");
		textCidade.setText("");
		textEstado.setText("");
		textLogradouro.setText("");
		textMsg.setText("");
	}
	public Cadastro() {
		setTitle("CADASTRO DE FORNECEDORES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(22, 23, 45, 13);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(108, 20, 96, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblRazaoSocial = new JLabel("Razão Social");
		lblRazaoSocial.setBounds(22, 71, 84, 13);
		contentPane.add(lblRazaoSocial);
		
		textRazaoSocial = new JTextField();
		textRazaoSocial.setBounds(108, 68, 524, 19);
		contentPane.add(textRazaoSocial);
		textRazaoSocial.setColumns(60);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//String codigoStr = textCodigo.getText();
				//int codigo = Integer.parseInt(codigoStr);
				String cnpj = textCNPJ.getText();
				String razaoSocial = textRazaoSocial.getText();
				String cep = textCEP.getText();
				String numeroStr = textNumero.getText();
				int numero = Integer.parseInt(numeroStr);
				String complemento = textComplemento.getText();
				
				
				
				try {
				
					//Logradouro logradouro = BuscaCep.getLogradouroByCep(cep);
					
										
					//*if(logradouro != null) {
						Fornecedores.incluir(new Fornecedor(cnpj, razaoSocial, cep, numero, complemento ));
					
						clear();
						textMsg.setText("Fornecedor incluído com sucesso!");
					/*}
					else {
						textMsg.setText("CEP inválido!");
					}*/
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnIncluir.setBounds(10, 321, 89, 23);
		contentPane.add(btnIncluir);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(22, 99, 76, 13);
		contentPane.add(lblCNPJ);
		
		textCNPJ = new JTextField();
		textCNPJ.setColumns(60);
		textCNPJ.setBounds(108, 96, 178, 19);
		contentPane.add(textCNPJ);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(310, 99, 34, 13);
		contentPane.add(lblCEP);
		
		textCEP = new JTextField();
		textCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String cep = textCEP.getText();
				Logradouro logradouro = BuscaCep.getLogradouroByCep(cep);
				if(logradouro!=null) {
					textBairro.setText(logradouro.getBairro());
					textCidade.setText(logradouro.getCidade());
					textEstado.setText(logradouro.getEstado());
					textLogradouro.setText(logradouro.getLogradouro());
				}
				else {
					textMsg.setText("CEP Inválido!");
					textBairro.setText("");
					textCidade.setText("");
					textEstado.setText("");
					textLogradouro.setText("");
				}
			}
		});
		textCEP.setColumns(60);
		textCEP.setBounds(352, 95, 104, 19);
		contentPane.add(textCEP);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(489, 134, 64, 13);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(60);
		textNumero.setBounds(549, 131, 83, 19);
		contentPane.add(textNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(22, 162, 96, 13);
		contentPane.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setColumns(60);
		textComplemento.setBounds(118, 159, 514, 19);
		contentPane.add(textComplemento);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoStr = textCodigo.getText();
				int codigo = Integer.parseInt(codigoStr);
				
				try {
					if(Fornecedores.cadastrado(codigo)) {
					
						Fornecedores.getFornecedor(codigo);
						Fornecedor fornecedor = Fornecedores.getFornecedor(codigo);
						Logradouro logradouro = BuscaCep.getLogradouroByCep(fornecedor.getCep());
						
						String codigoString = String.valueOf(fornecedor.getCodigo());
						textCodigo.setText(codigoString);
						textCNPJ.setText(fornecedor.getCnpj());
						textRazaoSocial.setText(fornecedor.getRazaoSocial());
						textCEP.setText(fornecedor.getCep());
						String numeroString = String.valueOf(fornecedor.getNumero());
						textNumero.setText(numeroString);
						textCodigo.setText(codigoString);
						textComplemento.setText(fornecedor.getComplemento());
						textBairro.setText(logradouro.getBairro());
						textCidade.setText(logradouro.getCidade());
						textEstado.setText(logradouro.getEstado());
						textLogradouro.setText(logradouro.getLogradouro());
						
									
					}else 
						textMsg.setText("Código não cadastrado");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnBuscar.setBounds(115, 321, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(22, 218, 76, 13);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setColumns(60);
		textCidade.setBounds(108, 215, 380, 19);
		contentPane.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(489, 218, 76, 13);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setColumns(60);
		textEstado.setBounds(547, 215, 104, 19);
		contentPane.add(textEstado);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(22, 190, 76, 13);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setEditable(false);
		textBairro.setColumns(60);
		textBairro.setBounds(108, 187, 380, 19);
		contentPane.add(textBairro);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(22, 131, 76, 13);
		contentPane.add(lblLogradouro);
		
		textLogradouro = new JTextField();
		textLogradouro.setEditable(false);
		textLogradouro.setColumns(60);
		textLogradouro.setBounds(108, 128, 380, 19);
		contentPane.add(textLogradouro);
		
		textMsg = new JTextField();
		textMsg.setEditable(false);
		textMsg.setColumns(60);
		textMsg.setBounds(108, 268, 259, 19);
		contentPane.add(textMsg);
		
		JButton btnLimpar = new JButton("Limpa ");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnLimpar.setBounds(399, 321, 89, 23);
		contentPane.add(btnLimpar);
		
				
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
						String codigoStr = textCodigo.getText();
						int codigo = Integer.parseInt(codigoStr);
						String cep = textCEP.getText();
						String numeroStr = textNumero.getText();
						int numero = Integer.parseInt(numeroStr);
						String complemento = textComplemento.getText();
						
						Fornecedores.alterar(codigo, cep, numero, complemento);
						
						clear();
						textMsg.setText("Fornecedor atualizado com sucesso!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(209, 321, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codigoStr = textCodigo.getText();
					int codigo = Integer.parseInt(codigoStr);
					Fornecedores.excluir(codigo);
					clear();
					textMsg.setText("Fornecedor excluído com sucesso!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(310, 321, 89, 23);
		contentPane.add(btnExcluir);
	}
}
