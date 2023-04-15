package bd;

import bd.daos.Fornecedores;
import controller.BuscaFornecedor;
import controller.FornecedorLogradouro;

public class Programa {

	public static void main(String[] args) throws Exception {

		try {
			Fornecedores.alterar(1, "13052723", 123, "casa");

		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println(erro.getMessage());

		}

		try {
			FornecedorLogradouro fl = BuscaFornecedor.buscar(1);
			System.out.println(fl);
		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println(erro.getMessage());

		}
		
	}

}
