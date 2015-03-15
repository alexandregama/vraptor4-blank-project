<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Fazer Login - Procurando Apê</title>
	<link rel="stylesheet" href="${urlAmazonPresenter.s3AssetsUrl}/site-html/css/main.css" />
	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
</head>
<body>

  <!-- Header -->
  <header class="claro clearfix">
    <div class="container colunas">
      <div class="rs-3colunas primeira">
        <a href="#" class="sprite logo"></a>   
        <span id="menu-mobile" class="icon-cross icon-menu sm"></span>     
      </div>
      <div class="rs-9colunas ultima">
        <ul class="menu deslogado">
          <li><a href="/login">Fazer Login</a></li>
          <li><a href="/criar-perfil" class="rs-botao azul-claro medio">Anuncie Grátis</a></li>
        </ul>
        <!-- <ul class="menu menu-profile">
          <li class="hm"><a href="/login" class="icon-bell"></a></li>
          <li class="hm"><a href="/login" class="icon-mail3"></a></li>
          <li class="profile clearfix">              
              <a href="perfil/ronerysouza">
                <img src="imagens/perfil-usuario.jpg" alt="Ronery Souza Procurando Apê">
                <span>Ronery Souza</span>
              </a>              
              <ul class="submenu-profile">
                <li class="sm"><a href="/login">Meus Alertas (3)</a></li>
                <li class="sm"><a href="/login">Minhas Mensagens (1)</a></li>
                <li><a href="meu-painel">Painel de Controle</a></li>
                <li><a href="meus-anuncios">Meus Anúncios</a></li>
                <li><a href="sair">Sair</a></li>
              </ul>
          </li>
          <li id="configPerfil" class="icon-cross icon-cog hm"></li>
        </ul>     -->    
      </div>
    </div>
  </header>

  <!-- Página -->
  <div id="pagina">

    <!-- Formulário de Cadastro de Usuário -->
    <section id="formulario">
      <c:forEach items="${errors}" var="error">
      	${error.message}
      </c:forEach>
      <h1>fazer login :)</h1>
      <a href="" class="icon-facebook2 bt-facebook">Fazer login usando o Facebook</a>
      <a href="" class="icon-google-plus2 bt-google">Fazer login usando o Google +</a>
      <span class="ou"><strong>OU</strong></span>
      
      <div class="bloco-cad colunas">
      	<form action="login" method="POST">
	        <input type="text" name="user.email" placeholder="E-mail" value="${user.email}"/>
	        <div class="rs-9colunas primeira">
	        	<input type="password" name="user.password" placeholder="Senha"/>
	        </div>        
	        <div class="rs-3colunas ultima">
	          <input type="submit" value="Entrar" class="rs-botao laranja full mtop5"></input>
	        </div>
      	</form>
        
        <span class="divisao"></span>
        <div class="rs-12colunas legenda tcenter">
          <a href="/retrieve-password">Esqueci minha senha</a> |
          <a href="/signup">Não tenho login, quero me cadastrar</a>
        </div>
      </div>      
    </section>
    <!-- Fim Formulário de Cadastro de Usuário -->

    <c:import url="../rodape.jsp" />

  </div>


  <!-- Scripts -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>