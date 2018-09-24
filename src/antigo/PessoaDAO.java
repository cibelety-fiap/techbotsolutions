package antigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.speventos.beans.Pessoa;
import br.com.fiap.speventos.conexao.Conexao;

public class PessoaDAO extends UsuarioDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public PessoaDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
public String cadastrar(Pessoa pessoa) throws Exception {
		
		stmt = con.prepareStatement("INSERT INTO T_SGE_PESSOA (NR_TELEFONE, DS_ENDERECO)"
				+ " VALUES (?, ?)");
		
		stmt.setLong(1, pessoa.getTelefone());
		stmt.setString(2, pessoa.getEndereco());
		
		stmt.executeUpdate();
		
		return "Cadastro Realizado";
	}

	public int editar(int nome) throws Exception {

		stmt = con.prepareStatement("UPDATE T_SGE_PESSOA SET NR_TELEFONE=?, DS_ENDERECO=?"
				+ " WHERE T_SGE_PESSOA=?");

		stmt.setString(1, "NR_TELEFONE");
		stmt.setString(2, "DS_ENDENRECO");

		return stmt.executeUpdate();
	}

	//CHECAR SE ESTA CERTO
	public int remover(int cd_usuario) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SGE_PESSOA WHERE CD_USUARIO = ?");
		stmt.setInt(1, cd_usuario);

		return stmt.executeUpdate();
	}

	public void fechar() throws Exception {
		con.close();
	}

}
