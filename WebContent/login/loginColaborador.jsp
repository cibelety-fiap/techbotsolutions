<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>SP Eventos</title>
  </head>

  <body>
    <div class="container">
      <header>
        <h1 style="float: left;">SP Eventos</h1>
        <a href="login.html"><img style="float: right; width: 60px;" src="img/user.png" /></a>
        <br />
        <br />
        <br />
      </header>
      <div class="topnav" id="myTopnav">
        <a href="index.html">Home</a>
        <div class="dropdown">
          <button class="dropbtn">Cinema
						  <i class="fa fa-caret-down"></i>
						</button>
          <div class="dropdown-content">
            <a href="filmes_em_cartaz.html">Em cartaz</a>
            <a href="proximos_lançamentos.html">Próximos lançamentos</a>
          </div>
        </div>
        <div class="dropdown">
          <button class="dropbtn">Shows
						  <i class="fa fa-caret-down"></i>
						</button>
          <div class="dropdown-content">
            <a href="proximos_shows.html">Próximos shows</a>
            <a href="mais_esperados_ano.html">Mais esperados do ano</a>
          </div>
        </div>
        <div class="dropdown">
          <button class="dropbtn">Teatro
					      <i class="fa fa-caret-down"></i>
					    </button>
          <div class="dropdown-content">
            <a href="teatro_em_cartaz.html">Em cartaz</a>
          </div>
        </div>
        <a href="contato.html">Contato</a>
        <div class="search-container">
          <form>
            <img src="img/search.png" alt="" id="lupa">
            <input type="search" placeholder="Pesquisa" name="search">
          </form>
        </div>
        <a href="javascript:void(0); " style="font-size:15px; " class="icon " onclick="myFunction() ">&#9776;</a>
      </div>
        <article style="float:right;padding-right: 30%;">
          <p>
           Olá, ${usuario.nome}.
           
           Bem vindo(a) ao nosso site!
          </p>
        </article>
        <footer>Copyright &copy; 2018 SP Eventos </footer>
    </div>
<!--  remover javascript -->

    </body>

</html>