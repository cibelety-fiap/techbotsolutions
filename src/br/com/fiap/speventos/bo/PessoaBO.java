package br.com.fiap.speventos.bo;

import br.com.fiap.speventos.beans.Pessoa;
import br.com.fiap.speventos.dao.PessoaDAO;


/**
 *  Classe para validar e padronizar dados para a tabela T_SGE_PESSOA
 *  @version 1.0
 *  @since 1.0
 *  @author Techbot Solutions
 *  @see PessoaDAO
 *  @see Pessoa
 */
public class PessoaBO {

	/**
	 * Metodo para verificar regras de negocio, validacoes e padronizacoes 
	 * relacionadas a insercao de uma nova pessoa 
	 * Regras de negocio validadas:
	 * tamanho do codigo do usuario, tamanho do numero de telefone,
	 * tamanho do endereco
	 * @author Techbot Solutions
	 * @param pessoa recebe um objeto do tipo Pessoa
	 * @return uma String com a quantidade de registros inseridos ou o erro ocorrido
	 * @throws Exception - Chamada da excecao Exception
	 */
	public static String novoPessoa(Pessoa pessoa) throws Exception{

		if(pessoa.getCodigoUsuario()<1 || pessoa.getCodigoUsuario()>99999) {
			return "Codigo invalido";
		}

		if(pessoa.getTelefone()<1 || pessoa.getTelefone()>99999999999L) {
			return "Telefone invalido";
		}

		if(pessoa.getEndereco().isEmpty() || pessoa.getEndereco().length()>100) {
			return "Endereco invalido";
		}

		pessoa.setEndereco(pessoa.getEndereco().toUpperCase());

		PessoaDAO dao = new PessoaDAO();
		
		String retorno = dao.cadastrar(pessoa) + " registro inserido";

		dao.fechar();
		return retorno;
	}
	
	/**
	 * Metodo para verificar regras de negocio, validacoes e padronizacoes 
	 * relacionadas a edicao de uma pessoa 
	 * Regras de negocio validadas:
	 * tamanho do codigo do usuario, tamanho do numero de telefone,
	 * tamanho do endereco
	 * @author Techbot Solutions
	 * @param pessoa recebe um objeto do tipo Pessoa
	 * @return uma String com a quantidade de registros editados ou o erro ocorrido
	 * @throws Exception - Chamada da Exception
	 */
	public static String edicaoPessoa(Pessoa pessoa) throws Exception{

		if(pessoa.getCodigoUsuario()<1 || pessoa.getCodigoUsuario()>99999) {
			return "Codigo invalido";
		}

		if(pessoa.getTelefone()<1 || pessoa.getTelefone()>99999999999L) {
			return "Telefone invalido";
		}

		if(pessoa.getEndereco().isEmpty() || pessoa.getEndereco().length()>100) {
			return "Endereco invalido";
		}

		pessoa.setEndereco(pessoa.getEndereco().toUpperCase());

		PessoaDAO dao = new PessoaDAO();

		String retorno =  dao.editar(pessoa) + " registro editado";

		dao.fechar();
		return retorno;
	}
	
	/**
	 * Metodo para verificar regras de negocio, validacoes e padronizacoes 
	 * relacionadas a remocao de uma pessoa 
	 * Regras de negocio validadas:
	 * tamanho do codigo do usuario
	 * @author Techbot Solutions
	 * @param codigoUsuario recebe um int
	 * @return uma String com a quantidade de registros removidos ou o erro ocorrido
	 * @throws Exception - Chamada da Exception
	 */
	public static String remocaoPessoa(int codigoUsuario) throws Exception{

		if (codigoUsuario < 1 || codigoUsuario > 99999) {
			return "Codigo de usuario invalido";
		}
		
		PessoaDAO dao = new PessoaDAO();

		String retorno = dao.remover(codigoUsuario) + " registro removido";

		dao.fechar();
		return retorno;
	}
}
