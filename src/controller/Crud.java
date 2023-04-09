package controller;
import bd.dbos.Fornecedor;
import bd.daos.Fornecedores;

public class Crud {
	public static void criarFornecedor(int codigo, String cnpj, String razaoSocial, String cep, int numero, String complemento ) {
	    try {
	    	if(Fornecedores.cadastrado(codigo) ) {
	    		System.out.println("Código já cadastrado");
	    	 }
	    	else {
	    		Fornecedores.incluir(new Fornecedor(codigo,cnpj,razaoSocial,cep,numero,complemento));
	    		System.out.println("Fornecedor inserido com sucesso");
	    	}

	    } catch (Exception erro) {
	      System.err.println(erro.getMessage());
	    }
	
	  }
}
