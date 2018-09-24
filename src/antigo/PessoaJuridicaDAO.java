package antigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.PessoaJuridica;
import br.com.fiap.speventos.beans.Usuario;
import br.com.fiap.speventos.conexao.Conexao;

public class PessoaJuridicaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public PessoaJuridicaDAO() throws Exception {
		con = new Conexao().conectar();
	}

	public String cadastrar(PessoaJuridica pj) throws Exception {

		stmt = con.prepareStatement("INSERT INTO T_SGE_PESSOA_JURIDICA "
				+ "(CD_USUARIO, DS_EMAIL, DS_SENHA, NM_USUARIO," + 
				"				+ NR_TELEFONE, DS_ENDERECO," + 
				"				+ NM_RAZAO_SOCIAL, NR_CNPJ, NR_CNPJ_DIGITO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, "CD_USUARIO");
		stmt.setString(2, "DS_EMAIL");
		stmt.setString(3, "DS_SENHA");
		stmt.setString(4, "NM_USUARIO");
		stmt.setString(5, "NR_TELEFONE");
		stmt.setString(6, "DS_ENDERECO");
		stmt.setString(7, "NM_RAZAO_SOCIAL");
		stmt.setString(8, "NR_CNPJ");
		stmt.setString(9, "NR_CNPJ_DIGITO");
		stmt.executeQuery();

		return "Cadastro Realizado";
	}

	public PessoaJuridica consultarPorCodigo(int codigo) throws Exception {

		stmt = con.prepareStatement(
				"SELECT * FROM T_SGE_PESSOA_JURIDICA"
						+ " INNER JOIN T_SGE_PESSOA ON "
						+ "(T_SGE_PESSOA_JURIDICA.CD_USUARIO=T_SGE_PESSOA.CD_USUARIO)"
						+ " INNER JOIN T_SGE_USUARIO ON "
						+ "(T_SGE_PESSOA_JURIDICA.CD_USUARIO=T_SGE_USUARIO.CD_USUARIO"
						+ " WHERE CD_USUARIO = ?");

		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();

		if(rs.next()) {
			return new PessoaJuridica(
					rs.getInt("CD_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NM_USUARIO"),
					rs.getLong("NR_TELEFONE"),
					rs.getString("DS_ENDERECO"),
					rs.getString("NM_RAZAO_SOCIAL"),
					rs.getLong("NR_CNPJ"),
					rs.getInt("NR_CNPJ_DIGITO"));

		} else {
			return new PessoaJuridica();
		}
	}

	public List<PessoaJuridica> consultarPorNome(int nome) throws Exception {

		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();

		stmt = con.prepareStatement("SELECT * FROM T_SGE_PESSOA_JURIDICA"
				+ " INNER JOIN T_SGE_PESSOA ON "
				+ "(T_SGE_PESSOA_JURIDICA.CD_USUARIO=T_SGE_PESSOA.CD_USUARIO)"
				+ " INNER JOIN T_SGE_USUARIO ON "
				+ "(T_SGE_PESSOA_JURIDICA.CD_USUARIO=T_SGE_USUARIO.CD_USUARIO"
				+ " WHERE NM_USUARIO LIKE ?");

		stmt.setString(1, "%" + nome + "%");

		while (rs.next()) {
			lista.add(new PessoaJuridica(
					rs.getInt("CD_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NM_USUARIO"),
					rs.getLong("NR_TELEFONE"),
					rs.getString("DS_ENDERECO"),
					rs.getString("NM_RAZAO_SOCIAL"),
					rs.getLong("NR_CNPJ"),
					rs.getInt("NR_CNPJ_DIGITO")));
		}
		return lista;
	}

	public int editar(PessoaJuridica pessoaJuridica) throws Exception {

		stmt = con.prepareStatement(
				"UPDATE T_SGE_USUARIO SET NM_RAZAO_SOCIAL=?, NR_CNPJ=?, NR_CNPJ_DIGITO=? WHERE CD_USUARIO=?");

		
		stmt.setString(1, pessoaJuridica.getRazaoSocial());
		stmt.setLong(2, pessoaJuridica.getCnpj());
		stmt.setInt(3, pessoaJuridica.getCnpjDigito());

		return stmt.executeUpdate();
	}
	
	public int remover(int cd_usuario) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SGE_USUARIO WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd_usuario);

		return stmt.executeUpdate();
	}

	public void fechar() throws Exception {
		con.close();
	}
}
