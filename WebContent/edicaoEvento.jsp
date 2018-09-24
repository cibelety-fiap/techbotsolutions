<!DOCTYPE html>
<html>

<head>
<title>Evento</title>
</head>

<body>

	<h2>Evento</h2>

	<h3>Atualizacao Evento</h3>

	<form action="EventoServlet" method="GET">

		<input type="hidden" name="comando" value="editar" /> 
		<input type="hidden" name="codUsuario" value="${usuario.codigoUsuario}" />
		<!-- VER COMO PEGAR O COD CERTO -->

		<label>Nome do Evento:</label><br />
		<input type="text" name="nomeEvento" value="${EVENTO.nomeEvento}" /><br />
		
		<!-- CONTINUAR COM OUTROS DADOS A SEREM EDITADOS -->
		
		<button>Enviar</button>

	</form>

	<p>
		<a href="EventoServlet">Voltar</a>
	</p>
</body>

</html>











