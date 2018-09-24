package antigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.Usuario;
import br.com.fiap.speventos.conexao.Conexao;

public class UsuarioDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public UsuarioDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	public String cadastrar(Usuario usuario) throws Exception {
		
		stmt = con.prepareStatement("INSERT INTO T_SGE_USUARIO (CD_USUARIO, DS_EMAIL, DS_SENHA, NM_PESSOA)"
				+ " VALUES (?, ?, ?, ?)");
		
		stmt.setInt(1, usuario.getCodigoUsuario());
		stmt.setString(2, usuario.getEmail());
		stmt.setString(3, usuario.getSenha());
		stmt.setString(4,usuario.getNome());
		stmt.executeUpdate();
		
		return "Cadastro Realizado";
	}
	
	//ver como fazer
	public int editar(int nome) throws Exception {
		
		stmt = con.prepareStatement("UPDATE T_SGE_USUARIO SET CD_USUARIO=?, DS_EMAIL=?, DS_SENHA=?, NM_PESSOA=?"
				+ " WHERE T_SGE_USUARIO=?");
		
		stmt.setString(1, "CD_USUARIO");
		stmt.setString(2, "DS_EMAIL");
		stmt.setString(3, "DS_SENHA");
		stmt.setString(4, "NM_PESSOA");
		
		return stmt.executeUpdate();
	}
	
	//CHECAR SE ESTA CERTO
	public int remover(int cd_usuario) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SGE_USUARIO WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd_usuario);
		
		return stmt.executeUpdate();
	}

	public void fechar() throws Exception {
		con.close();
	}
	
	public Usuario logar(String email, String senha) throws Exception {
		stmt = con.prepareStatement("SELECT CD_USUARIO, DS_EMAIL, DS_SENHA, NM_USUARIO FROM T_SGE_USUARIO "
				+ "WHERE DS_EMAIL=? AND DS_SENHA=?");
		

		stmt.setString(1, email);
		stmt.setString(2, senha);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Usuario(
					rs.getInt("CD_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DS_SENHA"),
					rs.getString("NM_USUARIO")
					);
		}
		
		return new Usuario();
	}

}
