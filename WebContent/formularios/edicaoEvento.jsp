<%@ include file="../imports/cabeca.jsp" %>

<div class="menu_central">

	<h1>Atualizar Evento</h1>

	<form action="EventoServlet" method="GET">

		<input type="hidden" name="comando" value="editar" /> 
		<input type="hidden" name="codUsuario" value="${usuario.codigoUsuario}" />
		<!-- VER COMO PEGAR O COD CERTO -->
		<br>
		<label>Nome do Evento:</label>
		<br />
		<input type="text" name="nomeEvento" value="${EVENTO.nomeEvento}" />
             <br><br>
             <label>Contato:</label>
		<br>
		<input type="text" name="contato" value="" maxlength="60">
		<br><br>
             <h4>Descri&ccedil;&atilde;o do Evento:</h4>
		<textarea name="message" rows="10" cols="80" maxlength="2000"></textarea>
		<br><br>
		<label>Procurar imagens</label>
		<input type="file">
		<br><br>
		<label>Qual tipo de evento?</label>
		<select>
			<option></option>
				<option value="show">Show</option>
                 <option value="cinema">Cinema</option>
                 <option value="teatro">Teatro</option>
             </select>
		<br><br>
		<label>Qual o subtipo do evento?</label>
		<select>
			<option></option>
				<option value="acao">Acao</option>
				<option value="acao">Animacao</option>
				<option value="aventura">Aventura</option>
				<option value="comedia">Comedia</option>
				<option value="cult">Cult</option>
                 <option value="drama">Drama</option>
                 <option value="romance">Romance</option>
                 <option value="terror">Terror</option>
             </select>
		<!-- CONTINUAR COM OUTROS DADOS A SEREM EDITADOS -->
		<br><br><br>
		<button class="tamanho_botao" name="enviar" id="enviar">Enviar</button>
		<input type="reset" name="reset" value="Reset" class="tamanho_botao">
	</form>

	</div>
	
<%@ include file="../imports/rodape.jsp" %>











