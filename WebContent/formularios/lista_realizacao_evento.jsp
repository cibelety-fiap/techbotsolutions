<%@ include file="../imports/cabeca.jsp"%>

<%
	List<RealizacaoEvento> listaRealizacaoEvento = (List<RealizacaoEvento>) request
			.getAttribute("LISTA_REALIZACAO_EVENTO");

	int codigoEvento = Integer.parseInt(request.getParameter("codigoEvento"));
%>

<nav>
	<div class="menu_lateral">
		<div>
			<a class="menu_lateral" href="tela_usuario.jsp">
				<button class="menu_lateral">Tela Inicial</button>
			</a>
		</div>
		<button onclick="goBack()" class="menu_lateral">Voltar</button>
	</div>
</nav>

<div class="menu_central">
	<br> 
		<button onclick="window.location.href='formularios/nova_realizacao_evento.jsp?codigoEvento=<%= codigoEvento %>'" class="menu_central">Cadastrar Novo</button>
	<br>
	<table class="tabela">
		<tr>
			<th class="tabelaHead">Realizacao Evento</th>
			<th class="tabelaHead">Data Inicio</th>
			<th class="tabelaHead">Data Termino</th>
			<th class="tabelaHead">Local</th>
			<th class="tabelaHead" colspan="2">Acoes</th>
		</tr>


		<%
			for (RealizacaoEvento realizacaoEventoTemp : listaRealizacaoEvento) {
		%>

		<tr>
			<td class="conteudo"><a
				href="RealizacaoEventoServlet?comando=carregar&codRealizEvento=<%=realizacaoEventoTemp.getCodigoRealizacaoEvento()%>"><%=realizacaoEventoTemp.getEvento().getNomeEvento()%></a></td>
			<td class="conteudo"><%=realizacaoEventoTemp.getDataHoraInicio()%></td>
			<td class="conteudo"><%=realizacaoEventoTemp.getDataHoraTermino()%></td>
			<td class="conteudo"><%=realizacaoEventoTemp.getLocal().getNomeLocal()%>
			</td>
			<td class="conteudo">
				<button onclick="location.href='edicaoEvento.jsp'">
					<img src="img/pen.png" id="icons">
				</button>
			</td>
			<td class="conteudo">
				<button onclick="okOrCancel()">
					<img src="img/delete-remove.png" id="icons">
				</button>
			</td>
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