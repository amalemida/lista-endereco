
import bd.daos.Fornecedores;

public class Programa {
	
  public static void main(String[] args) {
    try {
            System.out.println(Fornecedores.getFornecedor(1));
    } catch (Exception erro) {
      erro.printStackTrace();
      System.out.println(erro.getMessage());
    }
  }
}
