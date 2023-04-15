package bd.daos;

import java.sql.SQLException;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import bd.dbos.Fornecedor;

public class Fornecedores {
	public static boolean cadastrado(int codigo) throws Exception {
		boolean retorno = false;

		try {
			String sql;

			sql = "SELECT * " + "FROM FORNECEDORES " + "WHERE CODIGO = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);

			BDSQLServer.COMANDO.setInt(1, codigo);

			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

			retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou
											// resultado.absotule(numeroDaLinha)

			/*
			 * // ou, se preferirmos,
			 * 
			 * String sql;
			 * 
			 * sql = "SELECT COUNT(*) AS QUANTOS " + "FROM FORNECEDORES " +
			 * "WHERE CODIGO = ?";
			 * 
			 * BDSQLServer.COMANDO.prepareStatement (sql);
			 * 
			 * BDSQLServer.COMANDO.setInt (1, codigo);
			 * 
			 * MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
			 * 
			 * resultado.first();
			 * 
			 * retorno = resultado.getInt("QUANTOS") != 0;
			 * 
			 */
		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar fornecedor");
		}

		return retorno;
	}

	public static void incluir(Fornecedor fornecedor) throws Exception {
		if (fornecedor == null)
			throw new Exception("Fornecedor nao fornecido");

		try {
			String sql;

			sql = "INSERT INTO FORNECEDORES " + "(CNPJ,RAZAOSOCIAL,CEP,NUMERO,COMPLEMENTO) " + "VALUES "
					+ "(?,?,?,?,?)";

			BDSQLServer.COMANDO.prepareStatement(sql);

			BDSQLServer.COMANDO.setString(1, fornecedor.getCnpj());
			BDSQLServer.COMANDO.setString(2, fornecedor.getRazaoSocial());
			BDSQLServer.COMANDO.setString(3, fornecedor.getCep());
			BDSQLServer.COMANDO.setInt(4, fornecedor.getNumero());
			BDSQLServer.COMANDO.setString(5, fornecedor.getComplemento());

			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		} catch (SQLException erro) {
			BDSQLServer.COMANDO.rollback();
			throw new Exception("Erro ao inserir fornecedor");
		}
	}

	public static void excluir(int codigo) throws Exception {
		if (!cadastrado(codigo))
			throw new Exception("Nao cadastrado");

		try {
			String sql;

			sql = "DELETE FROM FORNECEDORES " + "WHERE CODIGO=?";

			BDSQLServer.COMANDO.prepareStatement(sql);

			BDSQLServer.COMANDO.setInt(1, codigo);

			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		} catch (SQLException erro) {
			BDSQLServer.COMANDO.rollback();
			throw new Exception("Erro ao excluir fornecedor");
		}
	}

	public static void alterar(int codigo, String cep, int numero, String complemento) throws Exception {
		if (codigo <= 0)
			throw new Exception("Fornecedor nao fornecido");

		if (!cadastrado(codigo))
			throw new Exception("Nao cadastrado");

		try {
			String sql;

			sql = "UPDATE FORNECEDORES " + "SET CEP= ? , " + "NUMERO= ? , " + "COMPLEMENTO = ? " + "WHERE CODIGO = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);

			BDSQLServer.COMANDO.setString(1, cep);
			BDSQLServer.COMANDO.setInt(2, numero);
			BDSQLServer.COMANDO.setString(3, complemento);
			BDSQLServer.COMANDO.setInt(4, codigo);

			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		} catch (SQLException erro) {
			BDSQLServer.COMANDO.rollback();
			throw new Exception("Erro ao atualizar dados de fornecedor");
		}
	}

	public static Fornecedor getFornecedor(int codigo) throws Exception {
		Fornecedor fornecedor = null;

		try {
			String sql;

			sql = "SELECT * " + "FROM FORNECEDORES " + "WHERE CODIGO = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);

			BDSQLServer.COMANDO.setInt(1, codigo);

			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

			if (!resultado.first())
				throw new Exception("Nao cadastrado");

			fornecedor = new Fornecedor(resultado.getInt("CODIGO"), 
							resultado.getString("CNPJ"),
							resultado.getString("RAZAOSOCIAL"),
							resultado.getString("CEP"),
							resultado.getInt("NUMERO"),
							resultado.getString("COMPLEMENTO"));
		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar fornecedor");
		}

		return fornecedor;
	}

	public static MeuResultSet getFornecedores() throws Exception {
		MeuResultSet resultado = null;

		try {
			String sql;

			sql = "SELECT * " + "FROM FORNECEDORES";

			BDSQLServer.COMANDO.prepareStatement(sql);

			resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
		} catch (SQLException erro) {
			throw new Exception("Erro ao recuperar fornecedors");
		}

		return resultado;
	}
}
