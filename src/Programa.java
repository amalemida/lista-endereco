
import bd.daos.Fornecedores;
import bd.dbos.Fornecedor;
import controller.BuscaCep;
import controller.Crud;

public class Programa {
	
  public static void main(String[] args) {
    try {
            //System.out.println(BuscaCep.getLogradouroByCep("13052550"));
            System.out.println("Digite o CNPJ");
            String cnpj = Teclado.getUmString();
            System.out.println("Digite a Razão Social");
            String razaoSocial = Teclado.getUmString();
            System.out.println("Digite o CEP");
            String cep = Teclado.getUmString();
            System.out.println("Digite o número");
            int numero = Teclado.getUmInt();
            System.out.println("Digite o complemento, ou enter para continuar");
            String complemento = Teclado.getUmString();
            int codigo = 2;
            Fornecedores.incluir(new Fornecedor(codigo,cnpj, razaoSocial,cep,numero, complemento));
    } catch (Exception erro) {
      erro.printStackTrace();
      System.out.println(erro.getMessage());
    }
  }
}
