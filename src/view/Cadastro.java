package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.daos.Fornecedores;
import bd.dbos.Fornecedor;
import controller.BuscaLogradouro;
import model.FornecedorLogradouro;
import model.Logradouro;
import controller.BuscaFornecedor;

@SuppressWarnings("serial")
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

	// limpa os dados da tela
	public void limparTela() {

		textCodigo.setText("");
		textCNPJ.setText("");
		textRazaoSocial.setText("");
		textCEP.setText("");
		textNumero.setText("");
		textComplemento.setText("");
		textBairro.setText("");
		textCidade.setText("");
		textEstado.setText("");
		textLogradouro.setText("");
		textCodigo.requestFocus();
		
	}

	public Cadastro() {
		JButton btnIncluir = new JButton("Incluir");
		JButton btnBuscar = new JButton("Buscar");
		JButton btnAtualizar = new JButton("Atualizar");
		JButton btnExcluir = new JButton("Excluir");

		setTitle("CADASTRO DE FORNECEDORES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 390);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
		textRazaoSocial.setColumns(50);

		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textCNPJ.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o CNPJ");
					} else if (textCEP.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o CEP");
					} else if (textRazaoSocial.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite a Razão Social");
					} else if (textNumero.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o número");
					} else {
						String cnpj = textCNPJ.getText();
						String razaoSocial = textRazaoSocial.getText();
						String cep = textCEP.getText();
						String numeroStr = textNumero.getText();
						int numero = Integer.parseInt(numeroStr); // converte o numero string para int
						String complemento = textComplemento.getText();

						Fornecedores.incluir(new Fornecedor(cnpj, razaoSocial, cep, numero, complemento));
						limparTela();
						JOptionPane.showMessageDialog(null, "Fornecedor incluído com sucesso!");
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnIncluir.setBounds(17, 321, 89, 23);
		contentPane.add(btnIncluir);

		JLabel lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setBounds(22, 99, 76, 13);
		contentPane.add(lblCNPJ);

		textCNPJ = new JTextField();
		textCNPJ.setColumns(18);
		textCNPJ.setBounds(108, 96, 178, 19);
		contentPane.add(textCNPJ);

		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(310, 99, 34, 13);
		contentPane.add(lblCEP);

		textCEP = new JTextField();
		textCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					String cep = textCEP.getText();

					Logradouro logradouro = BuscaLogradouro.getLogradouroByCep(cep);
					if (logradouro == null) {
						JOptionPane.showMessageDialog(textCEP, "CEP inválido");
						return; // parar aqui
					}
					textBairro.setText(logradouro.getBairro());
					textCidade.setText(logradouro.getCidade());
					textEstado.setText(logradouro.getEstado());
					textLogradouro.setText(logradouro.getLogradouro());

				} catch (Exception erro) {
					erro.getMessage();
					JOptionPane.showMessageDialog(null, "Erro inesperado");
				}
			}
		});
		textCEP.setColumns(8);
		textCEP.setBounds(352, 95, 104, 19);
		contentPane.add(textCEP);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(498, 135, 64, 13);
		contentPane.add(lblNumero);

		textNumero = new JTextField();
		textNumero.setColumns(4);
		textNumero.setBounds(549, 131, 83, 19);
		contentPane.add(textNumero);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(22, 162, 96, 13);
		contentPane.add(lblComplemento);

		textComplemento = new JTextField();
		textComplemento.setColumns(60);
		textComplemento.setBounds(108, 159, 524, 19);
		contentPane.add(textComplemento);

		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String codigoStr = textCodigo.getText();
					int codigo = Integer.parseInt(codigoStr);

					Fornecedores.excluir(codigo);
					limparTela();
					JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
					btnExcluir.setEnabled(false);
					btnAtualizar.setEnabled(false);
					btnIncluir.setEnabled(true);
					textCodigo.setEditable(true);
					textCNPJ.setEditable(true);
					textRazaoSocial.setEditable(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(399, 321, 89, 23);
		contentPane.add(btnExcluir);

		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textCNPJ.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o CNPJ");
					} else if (textCEP.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o CEP");
					} else if (textRazaoSocial.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite a Razão Social");
					} else if (textNumero.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o número");
					} else {

						String codigoStr = textCodigo.getText();
						int codigo = Integer.parseInt(codigoStr);
						String cep = textCEP.getText();
						String numeroStr = textNumero.getText();
						int numero = Integer.parseInt(numeroStr);
						String complemento = textComplemento.getText();

						Fornecedores.alterar(codigo, cep, numero, complemento);
						
						limparTela();
						JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
						btnAtualizar.setEnabled(false);
						btnExcluir.setEnabled(false);
						btnIncluir.setEnabled(true);
						btnExcluir.setEnabled(false);
						textCNPJ.setEnabled(true);
						textRazaoSocial.setEnabled(true);
						textCodigo.setEditable(true);
						textCNPJ.setEditable(true);
						textRazaoSocial.setEditable(true);

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(277, 321, 89, 23);
		contentPane.add(btnAtualizar);

		btnBuscar.addFocusListener(new FocusAdapter() {

		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = 0;

				try {
					if (textCodigo.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite o código!");
						return;

					} else {
						String codigoStr = textCodigo.getText();
						codigo = Integer.parseInt(codigoStr); //convert o código string em int
					}
					if (Fornecedores.cadastrado(codigo)) {

						FornecedorLogradouro fornecedorLogradouro = BuscaFornecedor.buscar(codigo);

						String codigoString = String.valueOf(fornecedorLogradouro.getCodigo()); // converte o código int
																								// em String
						textCodigo.setText(codigoString);
						textCNPJ.setText(fornecedorLogradouro.getCnpj());
						textRazaoSocial.setText(fornecedorLogradouro.getRazaoSocial());
						textCEP.setText(fornecedorLogradouro.getCep());
						String numeroString = String.valueOf(fornecedorLogradouro.getNumero()); // converte o código int
																								// em String
						textNumero.setText(numeroString);
						textComplemento.setText(fornecedorLogradouro.getComplemento());
						textBairro.setText(fornecedorLogradouro.getBairro());
						textCidade.setText(fornecedorLogradouro.getCidade());
						textEstado.setText(fornecedorLogradouro.getEstado());
						textLogradouro.setText(fornecedorLogradouro.getLogradouro());

						btnExcluir.setEnabled(true);
						btnAtualizar.setEnabled(true);
						btnIncluir.setEnabled(false);
						textCodigo.setEditable(false);
						textCNPJ.setEditable(false);
						textRazaoSocial.setEditable(false);

					} else {
						JOptionPane.showMessageDialog(null, "Código não cadastrado!");
						limparTela();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnBuscar.setBounds(150, 321, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(22, 218, 76, 13);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setColumns(60);
		textCidade.setBounds(108, 215, 334, 19);
		contentPane.add(textCidade);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(506, 218, 76, 13);
		contentPane.add(lblEstado);

		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setColumns(60);
		textEstado.setBounds(567, 214, 64, 19);
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

		JButton btnLimpar = new JButton("Limpa ");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela();
				btnExcluir.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnIncluir.setEnabled(true);
				textCodigo.setEditable(true);
				textCNPJ.setEditable(true);
				textRazaoSocial.setEditable(true);
			}
		});
		btnLimpar.setBounds(525, 321, 89, 23);
		contentPane.add(btnLimpar);
	}

}
