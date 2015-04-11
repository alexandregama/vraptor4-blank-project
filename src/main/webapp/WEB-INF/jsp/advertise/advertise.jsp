<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Tenho uma vaga em apartamento próximo à Avenida Paulista</title>
	<link rel="stylesheet" href="${urlAmazonPresenter.s3AssetsUrl}/site-html/css/main.css" />
  <meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
</head>
<body>

  <!-- Header -->
	  <c:import url="../header.jsp"/>
  <!-- Header -->
  
  <!-- Página -->
  <div id="pagina" class="colunas">

    <!-- Mapa -->
    <section id="googleMap" class="mapa"></section>

    <section id="anuncio" class="container clearfix">
      <h1>${placeToRental.shortDescription}</h1>
      <address class="icones icon-location2">Rua Rocha, Bela Vista , São Paulo - SP</address>
      <span class="divisao"></span>
      <div id="album" class="rs-6colunas primeira">
        <div class="album">
          <figure ref="galeria" mini="1" class="open-lightbox">
            <img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/medium/anuncio-default-1.jpg" alt="">
          </figure>
          <ul class="hm clearfix">
            <li ref="galeria" mini="1" class="rs-3colunas primeira active open-lightbox"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/small/anuncio-default-1.jpg" alt=""></li>
            <li ref="galeria" mini="2" class="rs-3colunas open-lightbox"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/small/anuncio-default-2.jpg" alt=""></li>
            <li ref="galeria" mini="3" class="rs-3colunas open-lightbox"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/small/anuncio-default-3.jpg" alt=""></li>
            <li ref="galeria" mini="4" class="rs-3colunas ultima open-lightbox"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/small/anuncio-default-4.jpg" alt=""></li>
          </ul>
        </div>
      </div>

      <div class="infos-anuncio rs-6colunas ultima">        
        <div class="valor"><span class="central">R$<strong>1.300,00</strong><span>por mês</span></span></div>
        <div class="incluso icones icon-checkmark">Incluso água, luz e internet</div>
        <span class="divisao"></span>
        <h3>Descrição do anúncio:</h3>
        <p>Apartamento bem arejado, a 2 minutos da Av. Nove de Julho e a 10min da Av. Paulista. Ótima localização, com shoppings, farmácias, padaria próximas.</p>

        <span class="divisao"></span>

        <div class="rs-7colunas primeira">
          <span id="bt-msg" class="rs-botao azul-claro full icon-mail3">Enviar Mensagem</span>
        </div>
        <div class="rs-5colunas ultima redes">
          <a href="#" class="icon-heart"></a>
          <a href="#" class="icon-facebook2"></a>
          <a href="#" class="icon-twitter2"></a>
          <a href="#" class="icon-google-plus2"></a>
        </div>

        <span class="divisao"></span> 

        <ul class="rs-6colunas primeira">
          <li class="icones icon-checkmark"><strong>1 vaga disponível</strong></li>
          <li class="icones icon-checkmark"><strong>Vaga/quarto:</strong> Individual</li>
          <li class="icones icon-checkmark"><strong>Disponível em:</strong> 13/01/2015</li>
          <li class="icones icon-checkmark"><strong>Estadia:</strong> 1 ano ou +</li>
        </ul>
        <ul class="rs-6colunas ultima">
          <li class="icones icon-checkmark"><strong>Tipo do imóvel:</strong> apartamento</li>
          <li class="icones icon-checkmark"><strong>2 quartos</strong></li>
          <li class="icones icon-checkmark"><strong>1 banheiro</strong></li>
        </ul>        

        <span class="divisao"></span>

        <a href="/perfil/xxx" class="perfil-anunciante clearfix">
          <div class="rs-2colunas primeira">
            <img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/perfil-usuario.jpg" class="circular" alt="">
          </div>
          <div class="rs-10colunas ultima">
            Conheça o dono deste anúncio:
            <h3>Ronery Souza - 32</h3>
            Trabalhador
          </div>
        </a>

        <h3>Preferências do Anunciante</h3>
        <ul class="rs-6colunas primeira">
          <li class="icones icon-checkmark"><strong>Sexo: </strong> masculino</li>
          <li class="icones icon-checkmark"><strong>Idade:</strong> 18 a 35 anos</li>
          <li class="icones icon-checkmark">Não fumante</li>
          <li class="icones icon-checkmark">Que não tenha animal(is)</li>
          <li class="icones icon-checkmark">Que não tenha criança(s)</li>
        </ul>
      </div>
    </section>

    <!-- Envio Mensagem -->
    <section id="envio-msg">
      <div id="formulario" class="box-mensagem">
        <span id="fechar-msg" class="icon-cancel-circle"></span>
        <h2 class="tcenter linha">Envie uma mensagem</h2>
        <p class="legenda">Você enviará uma mensagem para: Ronery Souza</p>
        <div class="send">
          <a href="/perfil/xxx"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/perfil-usuario.jpg" class="circular" alt="Ronery"></a>
          <strong class="icon-circle-right"></strong>
          <a href="/perfil/xxx"><img src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/perfil-usuario.jpg" class="circular"   alt="Ronery"></a>
        </div>
        <textarea name="mensagem" id="mensagem" cols="30" rows="5">Olá #fulano" estou interessado em seu anúncio!</textarea>
        <a href="#" class="rs-botao grande laranja">Enviar mensagem</a>
      </div>
    </section>
    <!-- Fim Envio Mensagem -->



    <c:import url="../rodape.jsp"/>

  </div>

  <!-- Lightbox Imagens -->
  <div id="galeria" class="modal full">
    <span class="icon-cancel-circle bt-fechar close-lightbox"></span>
    <figure>
      <img mini="1" src="${urlAmazonPresenter.s3AssetsUrl}/site-html/imagens/anuncios/large/anuncio-default-1.jpg" alt="Foto 01">
      <span mini="4" class="icon-circle-left"></span>
      <span mini="2" class="icon-circle-right"></span>
    </figure>    
  </div>
  <!-- Fim Lightbox Imagens -->

  <!-- Scripts -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/maps.js"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/anuncio.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>