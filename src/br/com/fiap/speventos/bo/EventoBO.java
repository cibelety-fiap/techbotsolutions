package br.com.fiap.speventos.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.speventos.beans.Evento;
import br.com.fiap.speventos.dao.EventoDAO;

public class EventoBO {
	public static String novoEvento(Evento evento) throws Exception {

		if (evento.getCodigoEvento() < 1) {
			return "Codigo de evento invalido";
		}
		if (evento.getLinkImagem().isEmpty() || evento.getLinkImagem().length() > 50) {
			return "Link do evento invalido";
		}
		if (evento.getNomeEvento().isEmpty() || evento.getNomeEvento().length() > 80) {
			return "Nome do evento invalido";
		}
		if (evento.getTipoEvento().isEmpty() || evento.getTipoEvento().length() > 30) {
			return "Tipo do evento invalido";
		}
		if (evento.getSubtipoEvento().isEmpty() || evento.getSubtipoEvento().length() > 30) {
			return "Subtipo do evento invalido";
		}
		if (evento.getDescricaoEvento().isEmpty() || evento.getDescricaoEvento().length() > 2000) {
			return "Descricao do evento invalida";
		}
		if (evento.getContatoMaisInfo().isEmpty() || evento.getContatoMaisInfo().length() > 60) {
			return "Contato mais info invalido";
		}
		
		EventoDAO dao = new EventoDAO();

		Evento eventoCodRepetido = dao.consultar(evento.getCodigoEvento());

		if (eventoCodRepetido.getCodigoEvento() > 0) {
			return "Evento já existe";
		}
		
		evento.setLinkImagem(evento.getLinkImagem().toUpperCase());
		evento.setNomeEvento(evento.getNomeEvento().toUpperCase());
		evento.setTipoEvento(evento.getTipoEvento().toUpperCase());
		evento.setSubtipoEvento(evento.getSubtipoEvento().toUpperCase());
		evento.setDescricaoEvento(evento.getDescricaoEvento().toUpperCase());
		evento.setContatoMaisInfo(evento.getContatoMaisInfo().toUpperCase());

		String retorno = dao.cadastrar(evento) + "registro inserido";

		dao.fechar();
		return retorno;
	}

	public static Evento consultaEvento(int codigoEvento) throws Exception {
		if (codigoEvento < 1) {
			return new Evento();
		}

		EventoDAO dao = new EventoDAO();

		Evento retorno = dao.consultar(codigoEvento);

		dao.fechar();
		return retorno;

	}

	public static List<Evento> consultaPorNome(String nomeEvento) throws Exception {

		List<Evento> listaEvento = new ArrayList<Evento>();
		
		if (nomeEvento.isEmpty() || nomeEvento.length() > 80 ) {
			return listaEvento;
		}
		
		nomeEvento = nomeEvento.toUpperCase();
		EventoDAO dao = new EventoDAO();
		listaEvento = dao.consultarPorNomeEvento(nomeEvento);
		
		dao.fechar();
		return listaEvento;
	}
	
	public static List<Evento> consultaPorUsuario(int codUsuario) throws Exception {

		List<Evento> listaEvento = new ArrayList<Evento>();
		
		if (codUsuario < 1 || codUsuario > 99999) {
			return listaEvento;
		}

		EventoDAO dao = new EventoDAO();
		listaEvento = dao.consultarPorUsuario(codUsuario);
		
		dao.fechar();
		return listaEvento;
	}

	public static String edicaoEvento(Evento evento) throws Exception {
		
		if (evento.getCodigoEvento() < 1) {
			return "Codigo de evento invalido";
		}
		if (evento.getLinkImagem().isEmpty() || evento.getLinkImagem().length() > 50) {
			return "Link do evento invalido";
		}
		if (evento.getNomeEvento().isEmpty() || evento.getNomeEvento().length() > 80) {
			return "Nome do evento invalido";
		}
		if (evento.getTipoEvento().isEmpty() || evento.getTipoEvento().length() > 30) {
			return "Tipo do evento invalido";
		}
		if (evento.getSubtipoEvento().isEmpty() || evento.getSubtipoEvento().length() > 30) {
			return "Subtipo do evento invalido";
		}
		if (evento.getDescricaoEvento().isEmpty() || evento.getDescricaoEvento().length() > 2000) {
			return "Descricao do evento invalida";
		}
		if (evento.getContatoMaisInfo().isEmpty() || evento.getContatoMaisInfo().length() > 60) {
			return "Contato mais info invalido";
		}

		EventoDAO dao = new EventoDAO();

		String retorno = dao.editar(evento) + " registro editado";
		
		evento.setLinkImagem(evento.getLinkImagem().toUpperCase());
		evento.setNomeEvento(evento.getNomeEvento().toUpperCase());
		evento.setTipoEvento(evento.getTipoEvento().toUpperCase());
		evento.setSubtipoEvento(evento.getSubtipoEvento().toUpperCase());
		evento.setDescricaoEvento(evento.getDescricaoEvento().toUpperCase());
		evento.setContatoMaisInfo(evento.getContatoMaisInfo().toUpperCase());
		
		dao.fechar();	
		return retorno;
	}

	public static String remocaoEvento(int codigoEvento) throws Exception {
		
		if (codigoEvento < 1) {
			return "Codigo invalido";
		}
		
		EventoDAO dao = new EventoDAO();

		String retorno = dao.remover(codigoEvento) + "registro removido";

		dao.fechar();
		return retorno;
	}
}