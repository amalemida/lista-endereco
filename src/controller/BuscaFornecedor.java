package controller;

import bd.dbos.Fornecedor;
import buscacep.Logradouro;
import bd.daos.Fornecedores;

public class BuscaFornecedor {
	
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
	
