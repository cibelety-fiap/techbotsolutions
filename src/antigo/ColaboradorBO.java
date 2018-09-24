package antigo;

import java.util.List;

import br.com.fiap.speventos.beans.Colaborador;
import br.com.fiap.speventos.dao.ColaboradorDAO;

public class ColaboradorBO {

	public static String novoColaborador(Colaborador colaborador) throws Exception{

		if(colaborador.getCodigoUsuario()<=0) {
			return "C�digo inv�lido";
		}

		if(colaborador.getNome().isEmpty() || colaborador.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(colaborador.getEmail().isEmpty() || colaborador.getEmail().length()>60) {
			return "Email inv�lido";
		}
		
		if(colaborador.getEmail().indexOf("@")<0 || colaborador.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(colaborador.getSenha().length()<8 || colaborador.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		colaborador.setNome(colaborador.getNome().toUpperCase());
		colaborador.setEmail(colaborador.getEmail().toUpperCase());
		colaborador.setSenha(colaborador.getSenha().toUpperCase());
		colaborador.setNivelAcesso(colaborador.getNivelAcesso().toUpperCase());
		colaborador.setDepartamento(colaborador.getDepartamento().toUpperCase());

		ColaboradorDAO dao = new ColaboradorDAO();
		Colaborador resultado = dao.consultarPorCodigo(colaborador.getCodigoUsuario());

		if(resultado.getCodigoUsuario()>0) {
			dao.fechar();
			return "Usu�rio j� existe";
		}

		dao.fechar();
		return "";
	}
	
	public static String edicaoColaborador(Colaborador colaborador) throws Exception{
		
		if(colaborador.getCodigoUsuario()<=0) {
			return "C�digo inv�lido";
		}

		if(colaborador.getNome().isEmpty() || colaborador.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(colaborador.getEmail().isEmpty() || colaborador.getEmail().length()>60) {
			return "Email inv�lido";
		}
		
		if(colaborador.getEmail().indexOf("@")<0 || colaborador.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(colaborador.getSenha().length()<8 || colaborador.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		colaborador.setNome(colaborador.getNome().toUpperCase());
		colaborador.setEmail(colaborador.getEmail().toUpperCase());
		colaborador.setSenha(colaborador.getSenha().toUpperCase());
		colaborador.setNivelAcesso(colaborador.getNivelAcesso().toUpperCase());
		colaborador.setDepartamento(colaborador.getDepartamento().toUpperCase());
		
//		UsuarioBO bo = new UsuarioBO();
		
//		String y = UsuarioBO.novoUsuario(colaborador.getCodigoUsuario());
//		bo.novoUsuario(colaborador.getCodigoUsuario(), 
//				colaborador.getEmail(), colaborador.getSenha(), colaborador.getNome(),
//				colaborador.getNivelAcesso(), colaborador.getDepartamento());
//		bo.cadastrar(colaborador.getCodigoUsuario(), );
//		
//		ColaboradorBO bo2 = new ColaboradorBO();
//		bo2.cadastrar
//		
		
		return "";
	}
	
	public static Colaborador consultaColaboradorPorCodigo(int codigo) throws Exception{

		ColaboradorDAO dao = new ColaboradorDAO();

		Colaborador retorno = dao.consultarPorCodigo(codigo);

		//fazer comparacao codigo, se <1 codigo invalido

		dao.fechar();
		return retorno;
	}
	
	public static List<Colaborador> consultaColaboradorPorNome(int nome) throws Exception{

		ColaboradorDAO dao = new ColaboradorDAO();

		List<Colaborador> listaColaborador = dao.consultarPorNome(nome);

		dao.fechar();
		return listaColaborador;
	}
	
	public static String remocaoColaborador(int Colaborador) throws Exception{

		ColaboradorDAO dao = new ColaboradorDAO();

		String retorno = null;

		//fazer if para comparacao do codigo, se <1 o codigo � invalido

		retorno = dao.remover(Colaborador) + "registro removido";

		dao.fechar();
		return retorno;
	}
}