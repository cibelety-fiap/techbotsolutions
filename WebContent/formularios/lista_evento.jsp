<%@ include file="../imports/cabeca.jsp"%>

<%
	List<Evento> listaEvento = (List<Evento>) request.getAttribute("LISTA_EVENTO");
%>

	<div class="menu_central">

		<h1>Eventos</h1>
		<br>

		<br>
		<table class="tabela">
			<tr>
				<th class="tabelaHead">Evento</th>
				<th class="tabelaHead">Tipo</th>
				<th class="tabelaHead">Genero</th>
				<th class="tabelaHead">Descricao</th>
				<th class="tabelaHead" colspan="2">Acoes</th>
			</tr>


			<%
				for (Evento eventoTemp : listaEvento) {
			%>

			<tr>
				<td class="conteudo"><a href="EventoServlet?comando=carregar&codigoEvento=<%=eventoTemp.getCodigoEvento()%>"><%=eventoTemp.getNomeEvento()%></a></td>
				<td class="conteudo"><%=eventoTemp.getTipoEvento()%></td>
				<td class="conteudo"><%=eventoTemp.getSubtipoEvento()%></td>
				<td class="conteudo"><%=eventoTemp.getDescricaoEvento().substring(0, 40)%>
					(...)</td>
				<td class="conteudo"><button onclick="location.href='edicaoEvento.jsp'" type="button"><img
						src="img/pen.png" id="icons"></a></td>
				<td class="conteudo"><button onclick="okOrCancel()" type="button">
						<img src="img/delete-remove.png" id="icons">
					</button></td>

			</tr>
				<%
					}
				%>
			
		</table>
	</div>

	<script>
		function okOrCancel() {
			var txt;
			var r = confirm("Por favor confirme para deletar");
			if (r == true) {
				txt = "You pressed OK!";
			} else {
				txt = "You pressed Cancel!";
			}
		}
	</script>

	<%@ include file="../imports/rodape.jsp"%>