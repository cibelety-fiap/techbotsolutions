<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, br.com.fiap.speventos.beans.* "%>
    
<!DOCTYPE html>
<html>

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="../css/style.css" %></style>
    <title>SP Eventos</title>
  </head>

  <body>
<div><br /><br /><br />
	<form action="RealizacaoServlets" method="GET">
		<input type="hidden" name="comando" value="buscarLocal" />
		<center><input type="text" name="nomeLocalBusca" value="" maxlength="100"></center>
		<br />
		<center><button >Buscar</button></center><br /><br />
	</form>
</div>
<%@ include file="../imports/rodape.jsp"%>