package antigo;

import br.com.fiap.speventos.beans.Pessoa;
import br.com.fiap.speventos.dao.PessoaDAO;

public class PessoaBO {

	public static String novoPessoa(Pessoa pessoa) throws Exception{

		if(pessoa.getCodigoUsuario()<=0) {
			return "C�digo inv�lido";
		}

		if(pessoa.getNome().isEmpty() || pessoa.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(pessoa.getEmail().isEmpty() || pessoa.getEmail().length()>60) {
			return "Email inv�lido";
		}
		
		if(pessoa.getEmail().indexOf("@")<0 || pessoa.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(pessoa.getSenha().length()<8 || pessoa.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		pessoa.setNome(pessoa.getNome().toUpperCase());
		pessoa.setEmail(pessoa.getEmail().toUpperCase());
		pessoa.setSenha(pessoa.getSenha().toUpperCase());
		pessoa.setEndereco(pessoa.getEndereco().toUpperCase());

		PessoaDAO dao = new PessoaDAO();

		dao.fechar();
		return "";
	}
}
