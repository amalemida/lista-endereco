import bd.daos.Fornecedores;

public class Programa {
  public static void main(String[] args) {
    try {
      Fornecedores.alterar(1, "13010120", 25, "Terreo");
      System.out.println("Fornecedor incluido com sucesso!");
    } catch (Exception erro) {
      erro.printStackTrace();
      System.out.println(erro.getMessage());
    }
  }
}
