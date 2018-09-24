<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <article style="float: left;">
          <form id="login" action="Login" method="POST" > <!-- alterar -->
            <label>Login:</label>
            <br>
            <input type="text" placeholder="E-mail" name="email"><!-- alterar-->
            <br><br>
            <label>Senha:</label>
            <br>
            <input type="password" placeholder="Senha" name="senha">
            <br><br>
            <button>Enviar</button><!-- adicionar -->
            <!-- <input type="button" onclick="Login()" class="tamanho_botao" value="Login" id="enviar">--><!--  remover -->
            <input type="reset" name="reset" value="Reset" class="tamanho_botao">
          </form>
          <br>
          <p>
            Caso não tenha cadastro <a href="cadastro.html">Clique aqui</a>
          </p>
        </article>
        <article style="float:right;padding-right: 30%;">
          <p>
            Para fazer login como usuário:
            <br> E-mail: <strong>user@user.com</strong><!-- alterar -->
            <br> Senha: <strong>user</strong>
          </p>
          <br>
          <p>
            Para fazer login como administrador:
            <br> E-mail: <strong>admin@admin.com</strong><!-- alterar -->
            <br> Senha: <strong>admin</strong>
          </p>
        </article>
        <footer>Copyright &copy; 2018 SP Eventos </footer>
    </div>
<!--  remover javascript -->

    </body>

</html>