package br.com.fiap.speventos.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBO {

	public static boolean validacaoDataHora(String dataHora) {
		return dataHora
				.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9][0-9] ([01][0-9]|2[0-3]):([0-5][0-9])");
	}
	
	public static boolean compararDtHrInicioTermino(String inicio, String termino) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Date dtHrInicio = format.parse(inicio);
		Date dtHrTermino = format.parse(termino);
		
		if (dtHrTermino.compareTo(dtHrInicio) > 0) {
	        return true;
	    } else {
	    	return false;
	    }
	}
}
