package controller;

import buscacep.ClienteWS;
import buscacep.Logradouro;

public class BuscaCep {
  public static Logradouro getLogradouroByCep(String cep) {
    try {
      Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep/"+ cep);

      return logradouro;

    } catch (Exception erro) {
      System.err.println(erro.getMessage());
      return null;
    }
  }
}
