package controller;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import buscacep.ClienteWS;
import buscacep.Logradouro;

public class BuscaCep {
	public static Logradouro getLogradouroByCep(String cep) {
		try {

			Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class,
					"https://api.postmon.com.br/v1/cep/" + cep);

			return logradouro;

		} catch (Exception erro) {
			erro.printStackTrace();
		}

		return null;
	}

}