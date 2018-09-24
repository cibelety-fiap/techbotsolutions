<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>Insert title here</title>



</head>
<body>

	<form action="TesteData" method="POST">
		<p>
			Data: <input type="text" class="data" name="data" id="data" />
		</p>
		Hora: <input type="text" class="hora" name="hora" /><br />

	</form>
	<script type="text/javascript" src="js/jquery.mask.js"></script>
	<script type="text/javascript" src="js/teste.js"></script>

	<script>
		$(document).ready(function() {
			$('.data').mask('00/00/0000');
		});

		$(document).ready(function() {
			$('.hora').mask('00:00');
		});
	</script>

</body>
</html>