package br.com.fiap.speventos.bo;

import java.util.ArrayList;
import java.util.List;


import br.com.fiap.speventos.beans.AtualizacaoEvento;
import br.com.fiap.speventos.beans.Evento_antigo;
import br.com.fiap.speventos.beans.Usuario;
import br.com.fiap.speventos.dao.AtualizacaoEventoDAO;

/**
 * Classe para validar e padronizar dados para a tabela T_SGE_ATUALIZACAO_EVENTO
 * @version 1.0
 * @since 1.0
 * @author Techbot Solutions
 * @see AtualizacaoEvento
 * @see Usuario
 * @see Evento_antigo
 * @see AtualizacaoEventoDAO
 *  
 *
 */

public class AtualizacaoEventoBO {
	
	/**
	 * Metodo responsavel por verificar regras de negócio, validacoes e padronizacoes
	 * relacionadas a inserção de uma nova atualizacao de evento
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de evento deve ter entre 1 a 5 digitos
	 * A data da atualizacao de evento deve ter entre 1 a 10 caracteres
	 * O tipo de atualizacao de evento deve ter de 1 a 30 caracteres
	 * O codigo da atualizacao de evento não poda se cadastrado caso ja exista no banco
	 * @author Techbot Solutions
	 * @param atualizacaoEvento recebe um objeto do tipo AtualizacaoEvento (Beans)
	 * @return uma String com a quantidade de registros inseridos ou o erro ocorrido
	 * @throws Exception - Chamada da exceção checked 
	 *
	 */
	
	public static String novaAtualizacaoEvento(AtualizacaoEvento atualizacaoEvento, Usuario codigoUsuario,
			Evento_antigo codigoEvento) throws Exception {
		if (atualizacaoEvento.getTipoAtualizacao().isEmpty() || atualizacaoEvento.getTipoAtualizacao().length() < 30) {
			return "Tipo de atualizacao de evento errada";
		}
		if (atualizacaoEvento.getDataHoraAtualizacao().isEmpty()
				|| atualizacaoEvento.getDataHoraAtualizacao().length() < 10) {
			return "Data da atualização errada";
		}
		if (atualizacaoEvento.getCodigoAtualizacaoEvento() < 1 || atualizacaoEvento.getCodigoAtualizacaoEvento() > 99999) {
			return "Codigo de evento invalido";
		}

		atualizacaoEvento.setTipoAtualizacao(atualizacaoEvento.getTipoAtualizacao().toUpperCase());

		AtualizacaoEventoDAO dao = new AtualizacaoEventoDAO();

		AtualizacaoEvento atualizacaoEventoCodRepetido = dao.consultar(atualizacaoEvento.getCodigoAtualizacaoEvento());

		if (atualizacaoEventoCodRepetido.getCodigoAtualizacaoEvento() > 0) {
			return "Atualizacao de evento já existe";

		}

		dao.cadastrar(atualizacaoEvento);
		dao.fechar();

		return "OK";

	}
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a consulta de uma atualizacao de evento por codigo
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de evento deve ter entre 1 a 5 digitos
	 * @param codigoAtualizacaoEvento recebe um objeto do tipo int
	 * @return um construtor vazio
	 * @throws Exception - Chamada da excecao checked
	 */
	
	

	public static AtualizacaoEvento consultaAtualizacaoEvento(int codigoAtualizacaoEvento) throws Exception {
		if (codigoAtualizacaoEvento < 1 || codigoAtualizacaoEvento > 99999) {
			return new AtualizacaoEvento();
		}

		AtualizacaoEventoDAO dao = new AtualizacaoEventoDAO();

		AtualizacaoEvento retorno = dao.consultar(codigoAtualizacaoEvento);

		dao.fechar();
		return retorno;

	}
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a consulta de uma atualizacao de evento por tipo de atualizacao
	 * Regras de negocio validadas:
	 * O nome da Atualizacao de Evento deve ter de 1 a 30 caracteres
	 * @param tipoAtualizacao recebe um objeto do tipo String
	 * @return uma lista com objetos do tipo Atualizacao de Evento 
	 * @throws Exception - Chamada da exceção checked
	 */

	public static List<AtualizacaoEvento> consultaPorTipoAtualizacao(String tipoAtualizacao) throws Exception {
		
		List<AtualizacaoEvento> listaAtualizacaoEvento = new ArrayList<AtualizacaoEvento>();
		
		if (tipoAtualizacao.isEmpty() || tipoAtualizacao.length() > 30 ) {
			return listaAtualizacaoEvento;
		}
		
		tipoAtualizacao = tipoAtualizacao.toUpperCase();

		AtualizacaoEventoDAO dao = new AtualizacaoEventoDAO();
		listaAtualizacaoEvento = dao.consultarPorTipoAtualizacao(tipoAtualizacao);
		
		dao.fechar();
		return listaAtualizacaoEvento;
	}
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a edicao da atualizacao de evento
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de evento deve ter entre 1 a 5 digitos
	 * O tipo da atualizacao deve ter de 1 a 30 caracteres
	 * A data da atualizacao da evento 1 a 10 caracteres
	 * @param atualizacaoEvento recebe um objeto do tipo AtualizacaoEvento
	 * @return uma String com a quantidade de registros inseridos ou o erro ocorrido
	 * @throws Exception - Chamada da excecao Exception
	 */

	public static String edicaoAtualizacaoEvento(AtualizacaoEvento atualizacaoEvento, int codigoAtualizacaoEvento)
			throws Exception {
		if (atualizacaoEvento.getTipoAtualizacao().isEmpty() || atualizacaoEvento.getTipoAtualizacao().length() < 30) {
			return "Tipo de atualizacao de evento errada";
		}
		if (atualizacaoEvento.getDataHoraAtualizacao().isEmpty()
				|| atualizacaoEvento.getDataHoraAtualizacao().length() < 10) {
			return "Data da atualização errada";
		}
		if (atualizacaoEvento.getCodigoAtualizacaoEvento() < 1 || atualizacaoEvento.getCodigoAtualizacaoEvento() > 99999) {
			return "Codigo de evento invalido";
		}

		atualizacaoEvento.setTipoAtualizacao(atualizacaoEvento.getTipoAtualizacao().toUpperCase());

		AtualizacaoEventoDAO dao = new AtualizacaoEventoDAO();
		
		String retorno = null;
		
		retorno = dao.editar(atualizacaoEvento) + "Atualizacao editada";
		dao.fechar();
		return retorno;
	}
	
	/**
	 * Metodo responsavel por verificar regras de negocio, validacoes e padronizacoes
	 * relacionadas a remocao da atualizacao de evento
	 * Regras de negocio validadas:
	 * O codigo da atualizacao de evento deve ter entre 1 a 5 digitos
	 * @param codigoAtualizacaoEvento recebe um objeto do tipo int
	 * @return uma String com o numero de registros removidos
	 * @throws Exception - Chamada da excecao Exception
	 */
	
	public static String remocaoEvento(int codigoAtualizacaoEvento) throws Exception {

		if (codigoAtualizacaoEvento < 1 || codigoAtualizacaoEvento > 99999) {
			return "Codigo invalido";
		}
		AtualizacaoEventoDAO dao = new AtualizacaoEventoDAO();
		
		int retorno = dao.remover(codigoAtualizacaoEvento);

		dao.fechar();
		
		return retorno + "Atualizacao removido";

	}

}
