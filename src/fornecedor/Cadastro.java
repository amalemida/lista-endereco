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
		lblRazaoSocial.setBounds(22, 50, 76, 13);
		contentPane.add(lblRazaoSocial);
		
		textRazaoSocial = new JTextField();
		textRazaoSocial.setBounds(108, 47, 380, 19);
		contentPane.add(textRazaoSocial);
		textRazaoSocial.setColumns(60);
		
		JButton btnCriar = new JButton("Incluir");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoStr = textCodigo.getText();
				int codigo = Integer.parseInt(codigoStr);
				String cnpj = textCNPJ.getText();
				String razaoSocial = textRazaoSocial.getText();
				String cep = textCEP.getText();
				String numeroStr = textNumero.getText();
				int numero = Integer.parseInt(numeroStr);
				String complemento = textComplemento.getText();
				
				
				try {
					Fornecedores.incluir(new Fornecedor(codigo, cnpj, razaoSocial, cep, numero, complemento ));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnCriar.setBounds(10, 321, 89, 23);
		contentPane.add(btnCriar);
		
		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(22, 77, 76, 13);
		contentPane.add(lblCNPJ);
		
		textCNPJ = new JTextField();
		textCNPJ.setColumns(60);
		textCNPJ.setBounds(108, 74, 380, 19);
		contentPane.add(textCNPJ);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(22, 108, 76, 13);
		contentPane.add(lblCEP);
		
		textCEP = new JTextField();
		textCEP.setColumns(60);
		textCEP.setBounds(108, 105, 380, 19);
		contentPane.add(textCEP);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(22, 135, 76, 13);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(60);
		textNumero.setBounds(108, 132, 380, 19);
		contentPane.add(textNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(22, 162, 76, 13);
		contentPane.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setColumns(60);
		textComplemento.setBounds(108, 159, 380, 19);
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
		btnBuscar.setBounds(138, 321, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(22, 189, 76, 13);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setColumns(60);
		textCidade.setBounds(108, 186, 380, 19);
		contentPane.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(22, 216, 76, 13);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setColumns(60);
		textEstado.setBounds(108, 213, 380, 19);
		contentPane.add(textEstado);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(22, 243, 76, 13);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setColumns(60);
		textBairro.setBounds(108, 240, 380, 19);
		contentPane.add(textBairro);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(22, 270, 76, 13);
		contentPane.add(lblLogradouro);
		
		textLogradouro = new JTextField();
		textLogradouro.setColumns(60);
		textLogradouro.setBounds(108, 267, 380, 19);
		contentPane.add(textLogradouro);
		
		textMsg = new JTextField();
		textMsg.setColumns(60);
		textMsg.setBounds(224, 19, 219, 19);
		contentPane.add(textMsg);
		
		JButton btnClear = new JButton("Limpa ");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(258, 321, 89, 23);
		contentPane.add(btnClear);
	}
}
