<%@ include file="imports/cabeca.jsp"%>

<body>
        <article style="float: left;">
          <form action="Login" id="form1" method="POST">
            <label>E-mail:</label>
            <br>
            <input type="text" placeholder="Nome de usu&aacute;rio" name="email">
            <br><br>
            <label>Senha:</label>
            <br>
            <input type="password" placeholder="Senha" name="senha">
            <br><br>
            <button class="tamanho_botao">Entrar</button>
            <input type="reset" name="reset" value="Reset" class="tamanho_botao">
          </form>
          <br>
          <p>
            Caso n&atilde;o tenha cadastro <a href="cadastro.jsp">Clique aqui</a>
          </p>
        </article>
        <article style="float:right;padding-right: 26%;">
          <p>
            Para fazer login como usu&aacute;rio:
            <br> Login: <strong>user</strong>
            <br> Senha: <strong>user</strong>
          </p>
          <br>
          <p>
            Para fazer login como administrador:
            <br> Login: <strong>admin</strong>
            <br> Senha: <strong>admin</strong>
          </p>
        </article>
 
        <%@ include file="imports/rodape.jsp"%>