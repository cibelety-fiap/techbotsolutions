package br.com.fiap.speventos.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.speventos.beans.Evento;
import br.com.fiap.speventos.beans.Local;
import br.com.fiap.speventos.beans.RealizacaoEvento;
import br.com.fiap.speventos.bo.EventoBO;
import br.com.fiap.speventos.bo.LocalBO;
import br.com.fiap.speventos.bo.RealizacaoEventoBO;
import br.com.fiap.speventos.dao.LocalDAO;
import br.com.fiap.speventos.dao.RealizacaoEventoDAO;
import br.com.fiap.speventos.excecao.Excecao;
import br.com.fiap.speventos.view.Magica;

@WebServlet("/RealizacaoEventoServlet")
public class RealizacaoEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String comando = request.getParameter("comando");
			
			if (comando == null) {
				comando = "listar";
			}
			
			switch (comando) {
			
			case "listar":
				listarRealizacaoEvento(request, response);
				break;
				
			case "adicionar":
				adicionarRealizacaoEvento(request, response);
				break;
				
			case "carregar":
				carregarRealizacaoEvento(request, response);
				break;
				
			case "editar":
				editarRealizacaoEvento(request, response);
				break;
			
			case "remover":
				removerRealizacaoEvento(request, response);
				break;
				
			default:
				listarRealizacaoEvento(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

	private void listarRealizacaoEvento(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
			int codigoEvento = Integer.parseInt(request.getParameter("codigoEvento"));
			List<RealizacaoEvento> listaRealizacaoEvento = RealizacaoEventoBO.consultaRealizEventoPorCodEvento(codigoEvento);
		
			request.setAttribute("LISTA_REALIZACAO_EVENTO", listaRealizacaoEvento);
			request.setAttribute("codigoEvento", codigoEvento);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("formularios/lista_realizacao_evento.jsp");
			dispatcher.forward(request, response);
		}
	
	private void adicionarRealizacaoEvento(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int codigoRealizacaoEvento = RealizacaoEventoBO.consultaProxCodRealizEvento();
		int codigoEvento = Integer.parseInt(request.getParameter("codigoEvento"));
		int codigoLocal = Integer.parseInt(request.getParameter("codigoLocal"));
		String dataHoraInicio = request.getParameter("dataInicio") + " " + request.getParameter("horaInicio") ;
		String dataHoraTermino = request.getParameter("dataTermino") + " " + request.getParameter("horaTermino") ;
		String cadastroLocal = "";
		
		Local local = new Local();
		
		Evento evento = EventoBO.consultaEvento(codigoEvento);
		 
		Local consultaLocal = LocalBO.consultaLocalPorCodigo(codigoLocal);	
		if (consultaLocal.getCodigoLocal()==0) {
			codigoLocal = LocalBO.consultaProxCodLocal();
			local = new Local(codigoLocal, request.getParameter("nomeLocal"), request.getParameter("enderecoLocal"));
			System.out.println(local.getCodigoLocal());
			cadastroLocal = LocalBO.novoLocal(local);
		} else {
			local = consultaLocal;
		}
		
		if (cadastroLocal.equals("1 registro cadastrado") || cadastroLocal.isEmpty()) {
			RealizacaoEvento realizacaoEvento = new RealizacaoEvento(
					codigoRealizacaoEvento, evento, local, dataHoraInicio, dataHoraTermino);
			System.out.println(RealizacaoEventoBO.novaRealizacaoEvento(realizacaoEvento));
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("RealizacaoEventoServlet?comando=listar");
		dispatcher.forward(request, response);
	}
	
	private void carregarRealizacaoEvento(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			int codigoRealizacaoEvento = Integer.parseInt(request.getParameter("codRealizEvento"));
			
			RealizacaoEvento realizacaoEvento = RealizacaoEventoBO.consultaRealizEventoPorCodigo(codigoRealizacaoEvento);
			
			request.setAttribute("REALIZACAO_EVENTO", realizacaoEvento);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("formularios/realizacao_evento.jsp");
			dispatcher.forward(request, response);		
		}

	private void editarRealizacaoEvento(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		int codigoRealizacaoEvento = Integer.parseInt(request.getParameter("codigoRealizacaoEvento"));
		//String evento = request.getParameter("evento");
		int codigoEvento = Integer.parseInt(request.getParameter("codigoEvento"));
		String linkImagem = request.getParameter("linkImagem");
		String nomeEvento = request.getParameter("nomeEvento");
		String tipoEvento = request.getParameter("tipoEvento");
		String subtipoEvento = request.getParameter("subtipoEvento");
		String descricaoEvento = request.getParameter("descricaoEvento");
		String contatoMaisInfo = request.getParameter("contatoMaisInfo");
		//String local = request.getParameter("local");
		int codigoLocal = Integer.parseInt(request.getParameter("codigoLocal"));
		String nomeLocal = request.getParameter("nomeLocal");
		String enderecoLocal = request.getParameter("enderecoLocal");
		String dataHoraInicio = request.getParameter("dataHoraInicio");
		String dataHoraTermino = request.getParameter("dataHoraTermino");
		
		RealizacaoEvento realizacaoEvento = new RealizacaoEvento(
				codigoRealizacaoEvento, 
				new Evento(
						codigoEvento,
						linkImagem,
						nomeEvento,
						tipoEvento,
						subtipoEvento,
						descricaoEvento,
						contatoMaisInfo), 
				new Local(
						codigoLocal,
						nomeLocal,
						enderecoLocal), 
						dataHoraInicio, 
						dataHoraTermino);
		
//		EventoBO.edicaoEvento(evento);
				
		listarRealizacaoEvento(request, response);
		
	}

	private void removerRealizacaoEvento(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			int codEvento = Integer.parseInt(request.getParameter("codEvento"));
			
			EventoBO.remocaoEvento(codEvento);
			
			listarRealizacaoEvento(request, response);
		}
}
