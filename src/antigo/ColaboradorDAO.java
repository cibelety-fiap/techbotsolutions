package antigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.Colaborador;
import br.com.fiap.speventos.conexao.Conexao;

public class ColaboradorDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ColaboradorDAO() throws Exception {
		con = new Conexao().conectar();
	}

	public String cadastrar(Colaborador colab) throws Exception {

		stmt = con.prepareStatement("INSERT INTO T_SGE_COLABORADOR "
				+ "(DS_NIVEL_ACESSO, DS_DEPARTAMENTO)"
				+ " VALUES (?, ?)");

		stmt.setString(1, colab.getNivelAcesso());
		stmt.setString(2, colab.getDepartamento());
		
		stmt.executeQuery();

		return "Cadastro Realizado";
	}

	public int editar(Colaborador colaborador) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SGE_COLABORADOR"
				+ " SET DS_NIVEL_ACESSO=?, DS_DEPARTAMENTO=?"
				+ " WHERE T_SGE_USUARIO=?");

		stmt.setString(1, colaborador.getNivelAcesso());
		stmt.setString(2, colaborador.getDepartamento());

		return stmt.executeUpdate();
	}

	public Colaborador consultarPorCodigo(int codigo) throws Exception {

		stmt = con.prepareStatement(
				"SELECT * FROM T_SGE_USUARIO "
						+ "INNER JOIN T_SGE_COLABORADOR ON "
						+ "(T_SGE_USUARIO.CD_USUARIO=T_SGE_COLABORADOR.CD_USUARIO) "
						+ "WHERE T_SGE_COLABORADOR.CD_USUARIO=?");

		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();

		if(rs.next()) {
			return new Colaborador(
					rs.getInt("CD_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_NIVEL_ACESSO"),
					rs.getString("DS_DEPARTAMENTO")
					);
		} else {
			return new Colaborador();
		}
	}

	public List<Colaborador> consultarPorNome(int nome) throws Exception {

		List<Colaborador> lista = new ArrayList<Colaborador>();

		stmt = con.prepareStatement("SELECT * T_SGE_USUARIO "
				+ "INNER JOIN T_SGE_COLABORADOR ON "
				+ "(T_SGE_USUARIO.CD_USUARIO = T_SGE_COLABORADOR.CD_USUARIO) "
				+ "WHERE T_SGE_USUARIO.NM_USUARIO LIKE ?");

		stmt.setString(1, "%" + nome + "%");

		while (rs.next()) {
			lista.add(new Colaborador(
					rs.getInt("CD_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NM_PESSOA"),
					rs.getString("DS_NIVEL_ACESSO"),
					rs.getString("DS_DEPARTAMENTO")
					));
		}
		return lista;
	}
	
	public int remover(int cd_usuario) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SGE_COLABORADOR WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd_usuario);
		
		return stmt.executeUpdate();
	}

	public void fechar() throws Exception {
		con.close();
	}

}