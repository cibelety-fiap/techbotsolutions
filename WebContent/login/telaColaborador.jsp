<%@ include file="../imports/cabecaDentroPasta.jsp"%>

<nav>
        <br />
        <div class="menu_lateral">
          <div><a class="menu_lateral" href="EventoServlet"><button class="menu_lateral">Eventos</button></a></div>
          <div><a class="menu_lateral" href="listaNoticia.jsp"><button class="menu_lateral">Not&iacute;cias</button></a></div>
          <div><a class="menu_lateral" href="index.jsp"><button class="menu_lateral">Sair</button></a></div>
        </div>
      </nav>
     <article style="float:right;padding-right: 30%;">
          <p>Colaborador <!-- alterar -->
           Olá, ${usuario.nome}.
           
           Bem vindo(a) ao nosso site!
          </p>
     </article>
<%@ include file="../imports/rodapeDentroPasta.jsp"%>