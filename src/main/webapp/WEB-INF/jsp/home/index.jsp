<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Dividir apartamento, casa ou quarto no Procurando Apê</title>
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
        <!-- <ul class="menu">
          <li><a href="/login">Fazer Login</a></li>
          <li><a href="/criar-perfil" class="rs-botao azul-claro medio">Anuncie Grátis</a></li>
        </ul> -->
        <ul class="menu menu-profile">
          <li class="hm"><a href="/login" class="icon-bell"></a></li>
          <li class="hm"><a href="/login" class="icon-mail3"></a></li>
          <li class="profile clearfix">              
              <a href="perfil/ronerysouza">
                <img src="<c:url value='images/perfil-usuario.jpg' />" alt="Ronery Souza Procurando Apê">
                <span>${userSession.user.firstName}</span>
              </a>              
              <ul class="submenu-profile">
                <li class="sm"><a href="/login">Meus Alertas (3)</a></li>
                <li class="sm"><a href="/login">Minhas Mensagens (1)</a></li>
                <li><a href="meu-painel">Painel de Controle</a></li>
                <li><a href="meus-anuncios">Meus Anúncios</a></li>
                <li><a href="logout">Sair</a></li>
              </ul>
          </li>
          <li id="configPerfil" class="icon-cross icon-cog hm"></li>
        </ul>        
      </div>
    </div>
  </header>

  <!-- Página -->
  <div id="pagina">

    <!-- Feature -->
    <div class="carrossel">
      <span class="imagem-feature" style="background-image:url(images/procurando-ape-02.jpg)"></span>
      <h1>Encontre pessoas para dividir apartamento, quarto, casa</h1>
      <div class="rs-botoes">
        <a href="" class="rs-botao laranja grande">Tenho um espaço</a>
        <a href="" class="rs-botao azul grande">Preciso de um espaço</a>
      </div>
    </div>
    <!-- Fim Feature -->

    <!-- Como Funciona -->
    <section id="como-funciona" class="container colunas">
      <h2 class="tcenter">Como Funciona o Procurando Apê?</h2>
      <div class="rs-4colunas primeira">
        <span class="icon-user-check tcenter"></span>
        <h4 class="tcenter">Crie seu Perfil ou Anúncio</h4>
        <p class="tcenter">Independente se você tem ou busca um espaço para dividir, começe fazendo seu cadastro.</p>
      </div>
      <div class="rs-4colunas">
        <span class="icon-search tcenter"></span>
        <h4 class="tcenter">Encontre Pessoas</h4>
        <p class="tcenter">Após se cadastrar vamos sugerir perfis ou anúncios que se aproximam com seu interesse.
Você também pode fazer a busca do seu jeito.</p>
      </div>
      <div class="rs-4colunas ultima">
        <span class="icon-mail3 tcenter"></span>
        <h4 class="tcenter">Entre em Contato</h4>
        <p class="tcenter">Gostou de um perfil e/ou espaço? Entre em contato com a pessoa por telefone ou mensagem, totalmente grátis!</p>
      </div>
    </section>
    <!-- Fim Como Funciona -->

    <!-- Espaços Disponíveis -->
    <section class="cinza">
      <h2 class="tcenter">Como Funciona o Procurando Apê?</h2>
      
      <div id="lista-anuncios" class="container colunas">
      
	      <c:forEach items="${placesToRental}" var="place">
	        <div class="rs-4colunas anuncio">         
	          <figure>
	            <a href="/anuncio/xxxx/id">
	              <img src="${place.mainPicture}" alt="${place.shortDescription}">
	              <span class="bg-alpha valor">
	                R$<strong>${place.formattedPriceWithoutSymbol}</strong>
	                <span>por mês</span>
	              </span>
	            </a>
	            <a href="/perfil/ronerysouza" class="perfil-anuncio"><img src="${place.user.photo}" alt="${place.user.fullName}"></a>
	          </figure>
	          <a href="/anuncio/xxxx/id">
	            <h3>${place.shortDescription}</h3>
	            <p>${place.city.district}, ${place.city.name} - ${place.city.stateAbbreviation}</p>
	          </a>
	        </div>
	      </c:forEach>
        
      </div>
    </section>
    <!-- Fim Espaços Disponíveis -->

    <!-- Perfis -->
    <section id="lista-perfis" class="container colunas">
      <h2 class="tcenter">Veja algumas pessoas que precisam de um espaço</h2>
      
      <c:forEach items="${usersForHome}" var="user">
	      <div class="rs-3colunas">
	        <a href="/perfil/xxx">
	          <img src="${user.photo}" alt="${user.firstName}">
	          <h4>${user.fullName}</h4>
	          <p>
	            Procura um espaço em: <br>
	            <strong>${user.placeToLive.city.district}, ${user.placeToLive.city.name} - ${user.placeToLive.city.stateAbbreviation}</strong>
	          </p>        
	        </a>
	      </div>
      </c:forEach>
      
    </section>
    <!-- Fim Perfis -->

	<c:import url="../rodape.jsp"/>

  </div>


  <!-- Scripts -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>