package br.com.fiap.speventos.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.AtualizacaoNoticia;
import br.com.fiap.speventos.beans.Colaborador;
import br.com.fiap.speventos.beans.Noticia;
import br.com.fiap.speventos.dao.AtualizacaoNoticiaDAO;


/**
 * Classe para validar e padronizar dados para a tabela T_SGE_ATUALIZACAO_NOTICIA
 * @version 1.0
 * @since 1.0
 * @author Techbot Solutions
 * @see AtualizacaoNoticia
 * @see Colaborador
 * @see Noticia
 * @see AtualizacaoNoticiaDAO
 *  
 *
 */


public class AtualizacaoNoticiaBO {
	
	
	/**
	 * Metodo responsavel por verificar regras de negócio, validacoes e padronizacoes
	 * relacionadas a inserção de uma nova atualizacao de noticia
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de noticia deve ter entre 1 a 5 digitos
	 * A data da atualizacao de noticia deve ter entre 1 a 10 caracteres
	 * O tipo de atualizacao de noticia deve ter de 1 a 30 caracteres
	 * O codigo da atualizacao de noticia não poda se cadastrado caso ja exista no banco
	 * @author Techbot Solutions
	 * @param atualizacaoNoticia recebe um objeto do tipo AtualizacaoNoticia (Beans)
	 * @return uma String com a quantidade de registros inseridos ou o erro ocorrido
	 * @throws Exception - Chamada da exceção checked 
	 *
	 */

	public static String novaAtualizacaoNoticia(AtualizacaoNoticia atualizacaoNoticia, Colaborador codigoColaborador,
			Noticia codigoNoticia) throws Exception {
		if (atualizacaoNoticia.getTipoAtualizacao().isEmpty()
				|| atualizacaoNoticia.getTipoAtualizacao().length() < 30) {
			return "Tipo de atualizacao de noticia errada";
		}
		if (atualizacaoNoticia.getDataHoraAtualizacao().isEmpty()
				|| atualizacaoNoticia.getDataHoraAtualizacao().length() < 10) {
			return "Data da atualização errada";
		}
		if (atualizacaoNoticia.getCodigoAtualizacaoNoticia() < 1
				|| atualizacaoNoticia.getCodigoAtualizacaoNoticia() > 99999) {
			return "Codigo de noticia invalido";
		}

		atualizacaoNoticia.setTipoAtualizacao(atualizacaoNoticia.getTipoAtualizacao().toUpperCase());

		AtualizacaoNoticiaDAO dao = new AtualizacaoNoticiaDAO();

		AtualizacaoNoticia atualizacaoNoticiaCodRepetido = dao
				.consultar(atualizacaoNoticia.getCodigoAtualizacaoNoticia());

		if (atualizacaoNoticiaCodRepetido.getCodigoAtualizacaoNoticia() > 0) {
			return "Atualizacao de noticia já existe";

		}

		dao.cadastrar(atualizacaoNoticia);
		dao.fechar();

		return "OK";

	}
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a consulta de uma atualizacao de noticia por codigo
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de noticia deve ter entre 1 a 5 digitos
	 * @param codigoAtualizacaoNoticia recebe um objeto do tipo int
	 * @return um construtor vazio
	 * @throws Exception - Chamada da excecao checked
	 */

	public static AtualizacaoNoticia consultaAtualizacaoNoticia(int codigoAtualizacaoNoticia) throws Exception {
		if (codigoAtualizacaoNoticia < 1 || codigoAtualizacaoNoticia > 99999) {
			return new AtualizacaoNoticia();
		}

		AtualizacaoNoticiaDAO dao = new AtualizacaoNoticiaDAO();

		AtualizacaoNoticia retorno = dao.consultar(codigoAtualizacaoNoticia);

		dao.fechar();
		return retorno;

	}
	
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a consulta de uma atualizacao de noticia por tipo de atualizacao
	 * Regras de negocio validadas:
	 * O nome da Atualizacao de Noticia deve ter de 1 a 30 caracteres
	 * @param tipoAtualizacao recebe um objeto do tipo String
	 * @return uma lista com objetos do tipo Atualizacao de noticia 
	 * @throws Exception - Chamada da exceção checked
	 */

	public static List<AtualizacaoNoticia> consultaPorTipoAtualizacao(String tipoAtualizacao) throws Exception {

		List<AtualizacaoNoticia> listaAtualizacaoNoticia = new ArrayList<AtualizacaoNoticia>();

		if (tipoAtualizacao.isEmpty() || tipoAtualizacao.length() > 30) {
			return listaAtualizacaoNoticia;
		}

		tipoAtualizacao = tipoAtualizacao.toUpperCase();

		AtualizacaoNoticiaDAO dao = new AtualizacaoNoticiaDAO();
		listaAtualizacaoNoticia = dao.consultarPorTipoAtualizacao(tipoAtualizacao);

		dao.fechar();
		return listaAtualizacaoNoticia;
	}
	
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a edicao da atualizacao de noticia
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de noticia deve ter entre 1 a 5 digitos
	 * O tipo da atualizacao deve ter de 1 a 30 caracteres
	 * A data da atualizacao da noticia 1 a 10 caracteres
	 * @param atualizacaoNoticia recebe um objeto do tipo AtualizacaoNoticia
	 * @return uma String com a quantidade de registros inseridos ou o erro ocorrido
	 * @throws Exception - Chamada da excecao Exception
	 */
	
	public static String edicaoAtualizacaoNoticia(AtualizacaoNoticia AtualizacaoNoticia, int codigoAtualizacaoNoticia)
			throws Exception {
		if (AtualizacaoNoticia.getTipoAtualizacao().isEmpty() || AtualizacaoNoticia.getTipoAtualizacao().length() < 30) {
			return "Tipo de atualizacao de noticia errada";
		}
		if (AtualizacaoNoticia.getDataHoraAtualizacao().isEmpty()
				|| AtualizacaoNoticia.getDataHoraAtualizacao().length() < 10) {
			return "Data da atualização errada";
		}
		if (AtualizacaoNoticia.getCodigoAtualizacaoNoticia() < 1 || AtualizacaoNoticia.getCodigoAtualizacaoNoticia() > 99999) {
			return "Codigo de noticia invalido";
		}

		AtualizacaoNoticia.setTipoAtualizacao(AtualizacaoNoticia.getTipoAtualizacao().toUpperCase());

		AtualizacaoNoticiaDAO dao = new AtualizacaoNoticiaDAO();
		
		String retorno = null;
		
		retorno = dao.editar(AtualizacaoNoticia) + "Atualizacao editada";
		dao.fechar();
		return retorno;
	}
	
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a remocao da atualizacao de noticia
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de noticia deve ter entre 1 a 5 digitos
	 * @param codigoAtualizacaoNoticia recebe um objeto do tipo int
	 * @return uma String com o numero de registros removidos
	 * @throws Exception - Chamada da excecao Exception
	 */
	
	public static String remocaoNoticia(int codigoAtualizacaoNoticia) throws Exception {

		if (codigoAtualizacaoNoticia < 1 || codigoAtualizacaoNoticia > 99999) {
			return "Codigo invalido";
		}
		AtualizacaoNoticiaDAO dao = new AtualizacaoNoticiaDAO();
		
		int retorno = dao.remover(codigoAtualizacaoNoticia);

		dao.fechar();
		
		return retorno + "Atualizacao removido";

	}
	

}