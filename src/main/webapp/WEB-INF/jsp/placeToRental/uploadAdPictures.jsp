<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Deixe seu anúncio mais bonito e atrativo!</title>
	<link rel="stylesheet" href="css/main.css" />
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

    <!-- Formulário de Cadastro de Anúncio -->
    <section id="formulario">
      <h1 class="linha">Vamos deixar seu anúncio mais bonito?</h1>
      <div class="bloco-cad colunas">
        
        <span class="legenda">Seu anúncio foi criado com sucesso, mas ele ainda não possui nenhuma foto. :(</span>
        <div class="info atencao icon-notification">Lembre-se: anúncios com fotos têm mais visibilidade no site!</div>
        <span class="divisao"></span>

        <div class="rs-4colunas primeira">
          <img src="imagens/anuncio-default.jpg" class="responsiva" alt="Faça upload da foto">
        </div>
        <div class="rs-8colunas ultima">
          <h5>Foto Principal</h5>
          <p class="legenda">Escolha um foto que desperte a atenção do visitante.</p>
          <span class="rs-botao azul medio upload icon-upload3">
            Escolher foto principal
            <input type="file" name="imagem-principal" accept="image/*">
          </span>          
        </div>

        <span class="divisao"></span>
        <div class="rs-4colunas primeira">
          <img src="imagens/anuncio-default.jpg" class="responsiva" alt="Faça upload da foto">
          <span class="rs-botao azul medio upload icon-upload3">
            Escolher foto 2
            <input type="file" name="imagem-02" accept="image/*">
          </span>
        </div>
        <div class="rs-4colunas">
          <img src="imagens/anuncio-default.jpg" class="responsiva" alt="Faça upload da foto">
          <span class="rs-botao azul medio upload icon-upload3">
            Escolher foto 3
            <input type="file" name="imagem-03" accept="image/*">
          </span>
        </div>
        <div class="rs-4colunas ultima">
          <img src="imagens/anuncio-default.jpg" class="responsiva" alt="Faça upload da foto">
          <span class="rs-botao azul medio upload icon-upload3">
            Escolher foto 4
            <input type="file" name="imagem-04" accept="image/*">
          </span>
        </div>

        <span class="divisao"></span>
        
        <div class="rs-12colunas">
          <a href="#" class="rs-botao laranja full">Salvar Fotos</a>
        </div>
      </div>
      
    </section>
    <!-- Fim Formulário de Cadastro de Anúncio -->

    <c:import url="../rodape.jsp" />

  </div>


  <!-- Scripts -->
  <script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>