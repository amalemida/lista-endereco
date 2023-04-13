package controller;

import bd.dbos.Fornecedor;
import buscacep.Logradouro;

public class FornecedorLogradouro {
	private int codigo;
	private String cnpj;
	private String razaoSocial;
	private String cep;
	private int numero;
	private String complemento;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;

	public FornecedorLogradouro(Fornecedor fornecedor, Logradouro logradouro) {
		this.codigo = fornecedor.getCodigo();
		this.cnpj = fornecedor.getCnpj();
		this.razaoSocial = fornecedor.getRazaoSocial();
		this.cep = fornecedor.getCep();
		this.numero = fornecedor.getNumero();
		this.complemento = fornecedor.getComplemento();
		this.logradouro = logradouro.getLogradouro();
		this.bairro = logradouro.getBairro();
		this.cidade = logradouro.getCidade();
		this.estado = logradouro.getEstado();
	}

	@Override
	public String toString() {
		return "FornecedorLogradouro [codigo=" + codigo + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", cep="
				+ cep + ", numero=" + numero + ", complemento=" + complemento + ", logradouro=" + logradouro
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCep() {
		return cep;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
