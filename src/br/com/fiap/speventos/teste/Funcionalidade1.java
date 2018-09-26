package br.com.fiap.speventos.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.speventos.beans.Local;
import br.com.fiap.speventos.beans.RealizacaoEvento;
import br.com.fiap.speventos.bo.EventoBO;
import br.com.fiap.speventos.bo.LocalBO;
import br.com.fiap.speventos.bo.RealizacaoEventoBO;
import br.com.fiap.speventos.excecao.Excecao;
import br.com.fiap.speventos.view.Magica;

public class Funcionalidade1 {

	public static void main(String[] args) {

		try {

			int codigoRealizEvento = RealizacaoEventoBO.consultaProxCodRealizEvento();
			int codEvento = 30; //Evento ja existente na base, na servlet ele eh preenchido automaticamente 
								//por GET. Pode ser encontrado na busca por "os incriveis"

			String codLocal = null;
			String cadastroLocal = "";
			String nomeLocal = Magica.texto("Busque um local");
			
			Local local = new Local();
			
			List<Local> resultadoBusca = LocalBO.consultaLocalPorNome(nomeLocal);
			if(!resultadoBusca.isEmpty()) {
				for (Local localTemp : resultadoBusca) {
					System.out.println(localTemp.getCodigoLocal());
					System.out.println(localTemp.getNomeLocal());
					System.out.println(localTemp.getEnderecoLocal());
					System.out.println("-------------------------------");
				}
				codLocal = Magica.texto("Digite um dos codigos listados ou cancele.");
				System.out.println(codLocal);
			} else {
				JOptionPane.showMessageDialog(null, "Local nao encontrado, preencha os proximos dados.");
			}
			if (resultadoBusca.isEmpty() || codLocal.equals(null)) {
				JOptionPane.showMessageDialog(null, "Preencha os proximos dados.");
				codLocal = LocalBO.consultaProxCodLocal();
				local = new Local(codLocal, Magica.texto("Nome Local"), Magica.texto("Endereco do local"));						
				cadastroLocal = LocalBO.novoLocal(local);
			}
			
			String dataHoraInicio = Magica.texto("Data de inicio = dd/mm/yyyy") + " "
					+ Magica.texto("Hora de inicio - hh:mi");
			String dataHoraTermino = Magica.texto("Data de termino = dd/mm/yyyy") + " "
					+ Magica.texto("Hora de termino - hh:mi");

			if (cadastroLocal.equals("1 registro cadastrado") || cadastroLocal.isEmpty()) {
				RealizacaoEvento realizacaoEvento = new RealizacaoEvento(
						codigoRealizEvento, EventoBO.consultaEvento(codEvento), local, dataHoraInicio, dataHoraTermino);
				System.out.println(RealizacaoEventoBO.novaRealizacaoEvento(realizacaoEvento));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
			
		}
	}
	
//		try {
//
//			int codigoRealizEvento = RealizacaoEventoBO.consultaProxCodRealizEvento();
//			int codEvento = 30; //Evento ja existente na base, na servlet ele eh preenchido automaticamente por doGET
//								//Pode ser encontrado na base por "os incriveis"
//			int codLocal = Magica.inteiro("Codigo Local");
//			Local local = new Local();
//			String cadastroLocal = "";
//
//			System.out.println(codigoRealizEvento);
//
//			Local consultaLocal = LocalBO.consultaLocalPorCodigo(codLocal);
//			if (consultaLocal.getCodigoLocal() == 0) {
//				JOptionPane.showMessageDialog(null, "Local não encontrado, preencha os próximos dados.");
//				codLocal = LocalBO.consultaProxCodLocal();
//				local = new Local(codLocal, Magica.texto("Nome Local"), Magica.texto("Endereco do local"));
//				cadastroLocal = LocalBO.novoLocal(local);
//			} else {
//				JOptionPane.showMessageDialog(null, "Local encontrado, os dados serão preenchidos automaticamente.");
//				local = consultaLocal;
//			}
//			String dataHoraInicio = Magica.texto("Data de inicio = dd/mm/yyyy") + " "
//					+ Magica.texto("Hora de inicio - hh:mi");
//			String dataHoraTermino = Magica.texto("Data de termino = dd/mm/yyyy") + " "
//					+ Magica.texto("Hora de termino - hh:mi");
//
//			if (cadastroLocal.equals("1 registro cadastrado") || cadastroLocal.isEmpty()) {
//				RealizacaoEvento realizacaoEvento = new RealizacaoEvento(
//						codigoRealizEvento, EventoBO.consultaEvento(codEvento), local, dataHoraInicio, dataHoraTermino);
//				System.out.println(RealizacaoEventoBO.novaRealizacaoEvento(realizacaoEvento));
//			}
//		} catch (Exception e) {
////			e.printStackTrace();
//			System.out.println(Excecao.tratarExcecao(e));
//		}
//	}
}
