package controller;

import bd.dbos.Fornecedor;
import buscacep.Logradouro;
import bd.daos.Fornecedores;

public class Crud {
	public static void criar(Fornecedor fornecedor) {

		try {
			
			Fornecedores.incluir(fornecedor);
		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println(erro.getMessage());
		}

	}

	public static void excluir(int codigo) throws Exception {
		try {
			
			Fornecedores.excluir(codigo);
			
		} catch (Exception erro) {
			  erro.printStackTrace();
			  System.out.println(erro.getMessage());
	
	  }
	}
	
	public static void alterar(Fornecedor fornecedor) throws Exception {
		try {
			
			Fornecedores.alterar(fornecedor.getCodigo(), fornecedor.getCep(), fornecedor.getNumero(),fornecedor.getComplemento());
			
		} catch (Exception erro) {
			  erro.printStackTrace();
			  System.out.println(erro.getMessage());
	
	  }
	}
	
	public static FornecedorLogradouro buscar(int codigo) throws Exception {
		try {
			Fornecedor fornecedor = Fornecedores.getFornecedor(codigo);
			Logradouro logradouro = BuscaCep.getLogradouroByCep(fornecedor.getCep());
									
			return new FornecedorLogradouro(fornecedor, logradouro);
		} catch (Exception erro) {
			  erro.printStackTrace();
			  System.out.println(erro.getMessage());
			  return null;
	  }
	}
}
	
