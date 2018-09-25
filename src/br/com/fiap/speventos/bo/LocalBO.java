package br.com.fiap.speventos.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.Local;
import br.com.fiap.speventos.dao.LocalDAO;


public class LocalBO {

	public static String novoLocal(Local local) throws Exception {
		
		if (local.getCodigoLocal() < 1 || local.getCodigoLocal() > 99999) {
			return "Codigo do local invalido";
		}	
		if (local.getNomeLocal().isEmpty() || local.getNomeLocal().length() > 60) {
			return "Nome do local invalido";
		}
		if (local.getEnderecoLocal().isEmpty() || local.getEnderecoLocal().length() > 100) {
			return "Endereco do local invalido";
		}
		
		LocalDAO dao = new LocalDAO();

		Local localRepetido = LocalBO.consultaLocalPorCodigo(local.getCodigoLocal());
		
		if (localRepetido.getCodigoLocal() > 0) {
			return "local ja existe";
		}
		
		local.setNomeLocal(local.getNomeLocal().toUpperCase());
		local.setEnderecoLocal(local.getEnderecoLocal().toUpperCase());
		
		int retorno = dao.cadastrar(local);
		dao.fechar();
		
		return retorno + " registro cadastrado";
	}
	
	public static Local consultaLocalPorCodigo(int codLocal) throws Exception {
		
		if (codLocal < 1 || codLocal > 99999) {
			return new Local();
		}
		
		LocalDAO dao = new LocalDAO();
		
		Local retorno = dao.consultarPorCodigo(codLocal);
		dao.fechar();
		
		return retorno; 
	}
	
	public static List<Local> consultaLocalPorNome(String nomeLocal) throws Exception {

		List<Local> listaLocal = new ArrayList<Local>();

		if (nomeLocal.isEmpty() || nomeLocal.length() > 60 ) {
			return listaLocal;
		}
		
		nomeLocal = nomeLocal.toUpperCase();
		
		LocalDAO dao = new LocalDAO();
		listaLocal = dao.consultarPorNome(nomeLocal);
		
		dao.fechar();		
		
		return listaLocal; 
		
	}
	
	public static String edicaoLocal(Local local) throws Exception {
		
		if (local.getCodigoLocal() < 1 || local.getCodigoLocal() > 99999) {
			return "Codigo do local invalido";
		}	
		if (local.getNomeLocal().isEmpty() || local.getNomeLocal().length() > 60) {
			return "Nome do local invalido";
		}
		if (local.getEnderecoLocal().isEmpty() || local.getEnderecoLocal().length() > 100) {
			return "Endereco do local invalido";
		}
		
		LocalDAO dao = new LocalDAO();
		
		local.setNomeLocal(local.getNomeLocal().toUpperCase());
		local.setEnderecoLocal(local.getEnderecoLocal().toUpperCase());
		
		int retorno = dao.editar(local);
		dao.fechar();
		
		return retorno + "registro editado";
	}
	
	public static String remocaoLocal(int codLocal) throws Exception {
		
		if (codLocal < 1 || codLocal > 99999) {
			return "Codigo do local invalido";
		}

		
		LocalDAO dao = new LocalDAO();
		
		int retorno = dao.remover(codLocal);
		dao.fechar();
		
		return retorno + "registro removido";
	}
	
	/**
	 * Metodo para chamar o calculo do proximo codigo de local
	 * @author Techbot Solutions
	 * @param nao ha parametros
	 * @return um int com o numero do proximo codigo de local
	 * @throws Exception - Chamada da exceção checked Exception
	 */
	public static int consultaProxCodLocal() throws Exception {
		LocalDAO dao = new LocalDAO();
		int retorno = dao.calcularCodLocal();
		dao.fechar();
		return retorno;
	}
}
