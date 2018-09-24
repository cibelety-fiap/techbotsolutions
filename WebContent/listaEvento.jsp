<%@ page import="java.util.*, br.com.fiap.speventos.beans.* "%>
<!DOCTYPE html>
<html>

<head>
<title>Evento</title>
</head>

<%
	List<Evento> listaEvento = (List<Evento>) request.getAttribute("LISTA_EVENTO");
%>

<body>
	<h2>Evento</h2>

	<table>
		<tr>
			<th>Nome do Evento</th>
			<th>Genero</th>
			<th>Descricao</th>
		</tr>
		<%
			for (Evento eventoTemp : listaEvento) {
		%>

		<tr>

			<td><%= eventoTemp.getNomeEvento() %></td>
			<td><%= eventoTemp.getSubtipoEvento() %></td>
			<td><%= eventoTemp.getDescricaoEvento().substring(0,40) %></td>
		</tr>

		<%
			}
		%>

	</table>
</body>
</html>








