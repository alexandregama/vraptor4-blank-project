<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Ronery está procurando um apê na Bela Vista, São Paulo - SP</title>
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
  <div id="pagina" class="colunas">

    <section class="sidebar-perfil rs-3colunas primeira">
      <div class="perfil">
        <figure>
          <img src="imagens/perfil-usuario.jpg" class="circular" alt="Ronery Souza">
          <span class="icon-heart"></span>
        </figure>
        <h2>Ronery Souza Ferreira - 28</h2>
        <p>Buscando uma vaga em: <br> <strong>Bela Vista, São Paulo - SP</strong></p>
        <a href="tel:+11964551258">(11) 96455-1258</a>
        <div class="rs-botao full azul-claro icon-mail3">Enviar Mensagem</div>
        <span id="verPerfilCompleto" class="detalhes">Perfil completo</span>
      </div>      
    </section>

    <section id="lista-anuncios" class="infos-perfil rs-9colunas ultima">
      <div class="container">
        
        <!-- Se o usuário tem um espaço exlua este bloco até o próximo comentário -->
        <div class="rs-12colunas">        
          <h1>Oi, sou o Ronery</h1>
          <p>Estou procurando um apartamento próximo à Av. Paulista, pois trabalho nesta região</p>
          <ul>
            <li class="icon-location2"><strong>Bela Vista, São Paulo - SP</strong></li>
            <li class="icon-checkmark"><strong>Sexo:</strong> Masculino - Orientação: Gay</li>
            <li class="icon-checkmark"><strong>Meu orçamento:</strong> R$ 1.500,00 (Com despesas inclusas)</li>
            <li class="icon-checkmark">Não fumo</li>
            <li class="icon-checkmark">Não tenho animal(is)</li>
            <li class="icon-checkmark">Não tenho criança(s)</li>
          </ul>        
        </div>

        <!-- Se o usuário estiver oferecendo um anúncio exibir este codigo comentado
        <div class="rs-7colunas primeira">        
          <h1>Oi, sou o Ronery</h1>
          <p>Estou procurando um apartamento próximo à Av. Paulista, pois trabalho nesta região</p>
          <ul>
            <li class="icon-location2"><strong>Bela Vista, São Paulo - SP</strong></li>
            <li class="icon-checkmark"><strong>Sexo:</strong> Masculino - Orientação: Gay</li>
            <li class="icon-checkmark"><strong>Meu orçamento:</strong> R$ 1.500,00 (Com despesas inclusas)</li>
            <li class="icon-checkmark">Não fumo</li>
            <li class="icon-checkmark">Não tenho animal(is)</li>
            <li class="icon-checkmark">Não tenho criança(s)</li>
          </ul>        
        </div>
        <div class="rs-5colunas ultima anuncio">  
          <h4>Veja o anúncio da vaga de Ronery</h5>       
          <figure>
            <a href="/anuncio/xxxx/id">
              <img src="imagens/anuncio-default.jpg" alt="Divido apartamento com quarto individual perto da
          Av. Paulista">
              <span class="bg-alpha valor">
                R$<strong>1.300,00</strong>
                <span>por mês</span>
              </span>
            </a>
          </figure>
          <a href="/anuncio/xxxx/id">
            <h3>Divido apartamento com quarto individual perto da Av. Paulista</h3>
            <p>Bel Vista, São Paulo - SP</p>
          </a>
        </div> -->

        <span class="divisao hm"></span>

        <div class="rs-6colunas primeira">
          <h3>Preferências de Moradia</h3>
          <ul>
            <li class="icon-location2">
              <strong>São Paulo - SP</strong>
            </li>
            <li class="icon-location2">
              <strong>Bairros: </strong>Bela Vista, Vila Mariana, Vila Madalena
            </li>
            <li class="icon-checkmark"><strong>Tipo do imóvel:</strong> apartamento</li>
            <li class="icon-checkmark"><strong>Vaga/quarto:</strong> individual</li>
          </ul>
        </div>
        <div class="rs-6colunas ultima">
          <h3>Preferências de Companhia</h3>
          <ul>
            <li class="icon-checkmark"><strong>Sexo:</strong> Masculino - Orientação: Gay</li>
            <li class="icon-checkmark"><strong>Faixa etária:</strong> 18 a 35 anos</li>
            <li class="icon-checkmark">Não fumante</li>
            <li class="icon-checkmark">Que não tenha animal(is)</li>
            <li class="icon-checkmark">Que não tenha crinaça(s)</li>
          </ul>
        </div>

      </div>
    </section>

    <c:import url="../rodape.jsp" />

  </div>


  <!-- Scripts -->
  <script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>