<%@ include file="../imports/cabeca.jsp"%>
<nav>
        <br />
        <div class="menu_lateral">
          <div><a class="menu_lateral" href="EventoServlet"><button class="menu_lateral">Eventos</button></a></div>
          <div><a class="menu_lateral" href="Logout"><button class="menu_lateral">Sair</button></a></div>
        </div>
      </nav>
<article style="float: right; padding-right: 30%;">
	<p>
		Ol�, ${usuario.nome}! <br /><br />
		Na sua tela voc� pode ver os seus Eventos.<br /><br />
		Tamb&eacute;m pode visualizar, editar e remover as suas Realiza��es de Eventos.
	</p>
</article>
<%@ include file="../imports/rodape.jsp"%>