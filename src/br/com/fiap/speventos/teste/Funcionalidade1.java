package br.com.fiap.speventos.teste;

import javax.swing.JOptionPane;

import br.com.fiap.speventos.beans.Local;
import br.com.fiap.speventos.beans.RealizacaoEvento;
import br.com.fiap.speventos.bo.EventoBO;
import br.com.fiap.speventos.bo.LocalBO;
import br.com.fiap.speventos.bo.RealizacaoEventoBO;
import br.com.fiap.speventos.dao.RealizacaoEventoDAO;
import br.com.fiap.speventos.excecao.Excecao;
import br.com.fiap.speventos.view.Magica;

public class Funcionalidade1 {

	public static void main(String[] args) {

		try {	

			int codigoRealizEvento = 0;
			int codEvento = Magica.inteiro("Codigo do Evento");
			int codLocal = Magica.inteiro("Codigo Local");

			RealizacaoEventoDAO dao = new RealizacaoEventoDAO();
			codigoRealizEvento = dao.calcularCodRealizEvento();
			System.out.println(codigoRealizEvento);
	
			Local local = LocalBO.consultaLocalPorCodigo(codLocal);
			if (local.getCodigoLocal()==0) {
				JOptionPane.showMessageDialog(null, "Local não encontrado, preencha os próximos dados.");
				local = new Local(codLocal, Magica.texto("Nome Local"), Magica.texto("Endereco do local"));
			} else {
				JOptionPane.showMessageDialog(null, "Local encontrado, os dados serão preenchidos automaticamente.");
			}
			String dataHoraInicio = Magica.texto("Data de inicio = dd/mm/yyyy") + " " + Magica.texto("Hora de inicio - hh:mi");
			String dataHoraTermino = Magica.texto("Data de termino = dd/mm/yyyy") + " " + Magica.texto("Hora de termino - hh:mi");
			
			RealizacaoEvento realizacaoEvento2 = new RealizacaoEvento(
					codigoRealizEvento,
					EventoBO.consultaEvento(codEvento),
					local, 
					dataHoraInicio,
					dataHoraTermino
				);
			
			System.out.println(RealizacaoEventoBO.novaRealizacaoEvento(realizacaoEvento2));			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
