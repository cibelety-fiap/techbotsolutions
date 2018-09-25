<%@ include file="../imports/cabeca.jsp" %>


<div class="menu_central">

	<h1>Novo Evento</h1>
		<br><br>
	
	<form action="EventoServlet" method="GET" id="form1" autocomplete="off">

		<input type="hidden" name="comando" value="atualizar" /> 
		<label>Nome	do Evento:</label>
		<br /> 
		<input type="text" name="titulo" value="" maxlength="80">
		<br><br>
		<label>Contato:</label>
		<br>
		<input type="text" name="contato" value="" maxlength="60">
		<br>
		<br>
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
		<label>Qual o genero do evento?</label>
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
		<br><br><br>
		<button class="tamanho_botao" name="enviar" id="enviar">Enviar</button>
		<input type="reset" name="reset" value="Reset" class="tamanho_botao">
	</form>

	</div>
	
	
<%@ include file="../imports/rodape.jsp" %>		

<script>

var botao = document.querySelector("#enviar");
botao.addEventListener("click", function(event) {
	event.preventDefault();

	var form = document.querySelector("#form1");

	if (validar(form)) {
		form.submit();
	}
});

function validar(form) {
	var titulo = form.titulo.value;

	if (titulo == "") {
		alert('DIGITE O TITULO DO TEXTO');
		form.titulo.focus();
		return false
	}
	return true;
}
</script>