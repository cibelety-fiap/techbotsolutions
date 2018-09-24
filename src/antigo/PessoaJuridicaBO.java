package antigo;

import java.util.List;

import br.com.fiap.speventos.beans.PessoaJuridica;
import br.com.fiap.speventos.dao.PessoaJuridicaDAO;

public class PessoaJuridicaBO {

	public static String novoPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception {

		if(pessoaJuridica.getCodigoUsuario()<1) {
			return "C�digo inv�lido";
		}

		if(pessoaJuridica.getNome().isEmpty() || pessoaJuridica.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(pessoaJuridica.getRazaoSocial().isEmpty() || pessoaJuridica.getRazaoSocial().length()>60) {
			return "Raz�o Social inv�lida";
		}

		if(pessoaJuridica.getEmail().isEmpty() || pessoaJuridica.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(pessoaJuridica.getEmail().indexOf("@")<0 || pessoaJuridica.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(pessoaJuridica.getSenha().length()<8 || pessoaJuridica.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		if(pessoaJuridica.getCnpj()!=12) {
			return "Cnpj inv�lido";
		}

		if(pessoaJuridica.getCnpjDigito()!=2) {
			return "Cnpj inv�lido";
		}

		if(pessoaJuridica.getTelefone()>12) {
			return "Numero inv�lido";
		}

		if(pessoaJuridica.getEndereco().isEmpty() || pessoaJuridica.getEndereco().length()>100) {
			return "Endere�o inv�lido";
		}

		//padronizacao
		pessoaJuridica.setNome(pessoaJuridica.getNome().toUpperCase());
		pessoaJuridica.setEmail(pessoaJuridica.getEmail().toUpperCase());
		pessoaJuridica.setSenha(pessoaJuridica.getSenha().toUpperCase());
		pessoaJuridica.setRazaoSocial((pessoaJuridica.getRazaoSocial().toUpperCase()));
		pessoaJuridica.setEndereco(pessoaJuridica.getEndereco().toUpperCase());

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

		String retorno =  dao.cadastrar(pessoaJuridica) + "registro inserido";

		dao.fechar();
		return retorno;
	}

	public static PessoaJuridica consultaPessoaJuridicaPorCodigo(int codigo) throws Exception{

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

		PessoaJuridica retorno = dao.consultarPorCodigo(codigo);

		//fazer comparacao codigo, se <1 codigo invalido

		dao.fechar();
		return retorno;
	}

	public static List<PessoaJuridica> consultaPessoaJuridicaPorNome(int nome) throws Exception{

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

		List<PessoaJuridica> listaPessoaJuridica = dao.consultarPorNome(nome);

		dao.fechar();
		return listaPessoaJuridica;
	}

	public static String edicaoPessoaJuridica(PessoaJuridica pessoaJuridica) throws Exception{

		if(pessoaJuridica.getCodigoUsuario()<1) {
			return "C�digo inv�lido";
		}

		if(pessoaJuridica.getNome().isEmpty() || pessoaJuridica.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(pessoaJuridica.getRazaoSocial().isEmpty() || pessoaJuridica.getRazaoSocial().length()>60) {
			return "Raz�o Social inv�lida";
		}

		if(pessoaJuridica.getEmail().isEmpty() || pessoaJuridica.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(pessoaJuridica.getEmail().indexOf("@")<0 || pessoaJuridica.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(pessoaJuridica.getSenha().length()<8 || pessoaJuridica.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		if(pessoaJuridica.getCnpj()!=12) {
			return "Cnpj inv�lido";
		}

		if(pessoaJuridica.getCnpjDigito()!=2) {
			return "Cnpj inv�lido";
		}

		if(pessoaJuridica.getTelefone()>12) {
			return "Numero inv�lido";
		}

		if(pessoaJuridica.getEndereco().isEmpty() || pessoaJuridica.getEndereco().length()>100) {
			return "Endere�o inv�lido";
		}

		//padronizacao
		pessoaJuridica.setNome(pessoaJuridica.getNome().toUpperCase());
		pessoaJuridica.setEmail(pessoaJuridica.getEmail().toUpperCase());
		pessoaJuridica.setSenha(pessoaJuridica.getSenha().toUpperCase());
		pessoaJuridica.setRazaoSocial((pessoaJuridica.getRazaoSocial().toUpperCase()));
		pessoaJuridica.setEndereco(pessoaJuridica.getEndereco().toUpperCase());

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

		String retorno =  dao.editar(pessoaJuridica) + "registro inserido";

		dao.fechar();
		return retorno;
	}
	public static String remocaoPessoaJuridica(int pessoaJuridica) throws Exception{

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

		String retorno = null;

		//fazer if para comparacao do codigo, se <1 o codigo � invalido

		retorno = dao.remover(pessoaJuridica) + "registro removido";

		dao.fechar();
		return retorno;
	}
}
