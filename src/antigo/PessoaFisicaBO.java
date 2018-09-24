package antigo;

import java.util.List;

import br.com.fiap.speventos.beans.PessoaFisica;
import br.com.fiap.speventos.dao.PessoaFisicaDAO;

public class PessoaFisicaBO {

	public static String novoPessoaFisica(PessoaFisica pessoaFisica) throws Exception {

		if(pessoaFisica.getCodigoUsuario()<1) {
			return "C�digo inv�lido";
		}

		if(pessoaFisica.getNome().isEmpty() || pessoaFisica.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(pessoaFisica.getEmail().isEmpty() || pessoaFisica.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(pessoaFisica.getEmail().indexOf("@")<0 || pessoaFisica.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(pessoaFisica.getSenha().length()<8 || pessoaFisica.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		if(pessoaFisica.getTelefone()>12) {
			return "Numero inv�lido";
		}

		if(pessoaFisica.getEndereco().isEmpty() || pessoaFisica.getEndereco().length()>100) {
			return "Endere�o inv�lido";
		}

		if(pessoaFisica.getCpf()<1 || pessoaFisica.getCpf()>9) {
			return "Cpf inv�lido";
		}

		if(pessoaFisica.getCpfDigito()!=2) {
			return "Cpf inv�lido";
		}

		if(!(pessoaFisica.getGenero() == 'M' || pessoaFisica.getGenero() == 'F' || pessoaFisica.getGenero() == 'O')) {
			return "Genero inv�lido";
		}

		if(pessoaFisica.getRg()!=9) {
			return "Rg inv�lido";
		}

		if(pessoaFisica.getRgDigito()!=1) { //CHECAR SE EST� CERTO
			return "Rg inv�lido";
		}

		//VER SE PRECISA FAZER ALGO PARA O DATA DE NASCIMENTO

		//padronizacao
		pessoaFisica.setNome(pessoaFisica.getNome().toUpperCase());
		pessoaFisica.setEmail(pessoaFisica.getEmail().toUpperCase());
		pessoaFisica.setSenha(pessoaFisica.getSenha().toUpperCase());
		pessoaFisica.setEndereco(pessoaFisica.getEndereco().toUpperCase());
		//VER COMO RESOLVER pessoaFisica.setGenero(String.valueOf(pessoaFisica.getGenero()).toUpperCase());
		

		PessoaFisicaDAO dao = new PessoaFisicaDAO();

		String retorno =  dao.cadastrar(pessoaFisica) + "registro inserido";

		dao.fechar();
		return retorno;
	}
	
	public static PessoaFisica consultaPessoaFisicaPorCodigo(int codigo) throws Exception{

		PessoaFisicaDAO dao = new PessoaFisicaDAO();

		PessoaFisica retorno = dao.consultarPorCodigo(codigo);

		//fazer comparacao codigo, se <1 codigo invalido

		dao.fechar();
		return retorno;
	}
	
	public static List<PessoaFisica> consultaPessoaFisicaPorNome(int nome) throws Exception{

		PessoaFisicaDAO dao = new PessoaFisicaDAO();

		List<PessoaFisica> listaPessoaFisica = dao.consultarPorNome(nome);

		dao.fechar();
		return listaPessoaFisica;
	}
	
	public static String edicaoPessoaFisica(PessoaFisica pessoaFisica) throws Exception{

		if(pessoaFisica.getCodigoUsuario()<1) {
			return "C�digo inv�lido";
		}

		if(pessoaFisica.getNome().isEmpty() || pessoaFisica.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(pessoaFisica.getEmail().isEmpty() || pessoaFisica.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(pessoaFisica.getEmail().indexOf("@")<0 || pessoaFisica.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(pessoaFisica.getSenha().length()<8 || pessoaFisica.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		if(pessoaFisica.getTelefone()>12) {
			return "Numero inv�lido";
		}

		if(pessoaFisica.getEndereco().isEmpty() || pessoaFisica.getEndereco().length()>100) {
			return "Endere�o inv�lido";
		}

		if(pessoaFisica.getCpf()<1 || pessoaFisica.getCpf()>9) {
			return "Cpf inv�lido";
		}

		if(pessoaFisica.getCpfDigito()!=2) {
			return "Cpf inv�lido";
		}

		if(!(pessoaFisica.getGenero() == 'M' || pessoaFisica.getGenero() == 'F' || pessoaFisica.getGenero() == 'O')) {
			return "Genero inv�lido";
		}

		if(pessoaFisica.getRg()!=9) {
			return "Rg inv�lido";
		}

		if(pessoaFisica.getRgDigito()!=1) { //CHECAR SE EST� CERTO
			return "Rg inv�lido";
		}

		//VER SE PRECISA FAZER ALGO PARA O DATA DE NASCIMENTO

		//padronizacao
		pessoaFisica.setNome(pessoaFisica.getNome().toUpperCase());
		pessoaFisica.setEmail(pessoaFisica.getEmail().toUpperCase());
		pessoaFisica.setSenha(pessoaFisica.getSenha().toUpperCase());
		pessoaFisica.setEndereco(pessoaFisica.getEndereco().toUpperCase());
		//VER COMO RESOLVER pessoaFisica.setGenero(String.valueOf(pessoaFisica.getGenero()).toUpperCase());

		PessoaFisicaDAO dao = new PessoaFisicaDAO();

		String retorno =  dao.editar(pessoaFisica) + "registro inserido";

		dao.fechar();
		return retorno;
	}
	public static String remocaoPessoaFisica(int pessoaFisica) throws Exception{

		PessoaFisicaDAO dao = new PessoaFisicaDAO();

		String retorno = null;

		//fazer if para comparacao do codigo, se <1 o codigo � invalido

		retorno = dao.remover(pessoaFisica) + "registro removido";

		dao.fechar();
		return retorno;
	}

}
