<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${user.firstName} está procurando um apê em bairro, ${user.city.name} - ${user.city.stateAbbreviation}</title>
	<link rel="stylesheet" href="${urlAmazonPresenter.s3AssetsUrl}/site-html/css/main.css" />
  <meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
</head>
<body>

  <!-- Header -->
  	<c:import url="../header.jsp"/>
  <!-- Header -->
  

  <!-- Página -->
  <div id="pagina" class="colunas">

    <section class="sidebar-perfil rs-3colunas primeira">
      <div class="perfil">
        <figure>
          <img src="${user.photo}" class="circular" alt="Ronery Souza">
          <span class="icon-heart"></span>
        </figure>
        <h2>${user.fullName} - ${user.age}</h2>
        <p>Buscando uma vaga em: <br> <strong>Bairro, ${user.city.name} - ${user.city.stateAbbreviation}</strong></p>
        <a href="tel:+${user.formattedPhoneWithoutParenteses}">${user.formattedPhone}</a>
        <div class="rs-botao full azul-claro icon-mail3">Enviar Mensagem</div>
        <span id="verPerfilCompleto" class="detalhes">Perfil completo</span>
      </div>      
    </section>

    <section id="lista-anuncios" class="infos-perfil rs-9colunas ultima">
      <div class="container">
        
        <!-- Se o usuário tem um espaço exlua este bloco até o próximo comentário -->
        <div class="rs-12colunas">        
          <h1>Oi, sou ${user.firstNameWithGender}</h1>
          <p>${user.description}</p>
          <ul>
            <li class="icon-location2"><strong>Bela Vista, São Paulo - SP</strong></li>
            <li class="icon-checkmark"><strong>Sexo:</strong> ${user.gender.value} - Orientação: Gay</li>
            <li class="icon-checkmark"><strong>Meu orçamento:</strong> R$ ${user.budgetEstimateFormatted} (Com despesas inclusas)</li>
            <li class="icon-checkmark">${user.smokerDescription}</li>
            <li class="icon-checkmark">${user.animalDescription}</li>
            <li class="icon-checkmark">${user.kidsDescription}</li>
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
              <strong>${user.housingPreferences.cityPreference.name} - SP</strong>
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
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>