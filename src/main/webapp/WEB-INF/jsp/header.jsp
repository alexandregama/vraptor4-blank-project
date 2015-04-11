<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header -->
  <header class="claro clearfix">
    <div class="container colunas">
      <div class="rs-3colunas primeira">
        <a href="${linkTo[HomeController].index}" class="sprite logo"></a>   
        <span id="menu-mobile" class="icon-cross icon-menu sm"></span>     
      </div>
      <div class="rs-9colunas ultima">
      	<c:choose>
	      	<c:when test="${userSession.userLogged}">
		        <ul class="menu menu-profile">
		          <li class="hm"><a href="/login" class="icon-bell"></a></li>
		          <li class="hm"><a href="/login" class="icon-mail3"></a></li>
		          <li class="profile clearfix">              
		              <a href="perfil/ronerysouza">
		                <img src="<c:url value='${userSession.user.photo}' />" alt="${userSession.user.fullName}">
		                <span>${userSession.user.firstName}</span>
		              </a>              
		              <ul class="submenu-profile">
		                <li class="sm"><a href="${linkTo[UserController].signup}">Meus Alertas (3)</a></li>
		                <li class="sm"><a href="${linkTo[UserController].signup}">Minhas Mensagens (1)</a></li>
		                <li><a href="meu-painel">Painel de Controle</a></li>
		                <li><a href="meus-anuncios">Meus Anúncios</a></li>
		                <li><a href="logout">Sair</a></li>
		              </ul>
		          </li>
		          <li id="configPerfil" class="icon-cross icon-cog hm"></li>
		        </ul>        
	      	</c:when>
	      	<c:otherwise>
		        <ul class="menu">
		          <li><a href="${linkTo[LoginController].login}">Fazer Login</a></li>
		          <li><a href="${linkTo[UserController].signup}" class="rs-botao azul-claro medio">Anuncie Grátis</a></li>
		        </ul>
	      	</c:otherwise>
      	</c:choose>
      </div>
    </div>
  </header>
  <!-- Header -->