<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge; text/html; charset=UTF-8">
	<title>Cadastre-se para dividir quarto, apartamento, casa, etc...</title>
	<link rel="stylesheet" href="${urlAmazonPresenter.s3AssetsUrl}/site-html/css/main.css" />
  	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
</head>
<body>

  <!-- Header -->
  	<c:import url="../header.jsp"/>
  <!-- Header -->

  <!-- Página -->
  <div id="pagina">

    <!-- Formulário de Cadastro de Usuário -->
    <section id="formulario">
      <h1>Crie seu perfil de forma rápida e fácil :)</h1>
      <!-- ERROS -->
	      <c:forEach items="${errors}" var="error">
	      	${error.message} <br/>
	      </c:forEach>
      <!-- ERROS -->
      
      <a href="" class="icon-facebook2 bt-facebook">Cadastre-se usando o Facebook</a>
      <a href="" class="icon-google-plus2 bt-google">Cadastre-se usando o Facebook</a>
      <span class="ou"><strong>OU</strong></span>
      
      <div class="bloco-cad colunas">
      	<form action="user" method="post">
	        <select name="user.placeType">
	          <option value="">Tipo do anúncio (Você tem ou precisa de um espaço?)</option>
	          <option value="HAS_PLACE" <c:if test="${user.hasPlaceSelected}">selected</c:if> >Tenho uma vaga</option>
	          <option value="NEEDS_PLACE" <c:if test="${user.needsPlaceSelected}">selected</c:if>>Preciso de uma vaga</option>
	        </select>
	        <div class="rs-6colunas primeira"><input type="text" name="user.firstName" placeholder="Nome" value="${user.firstName}"/></div>
	        <div class="rs-6colunas ultima"><input type="text" name="user.lastName" placeholder="Sobrenome" value="${user.lastName}"/></div>
	        <input type="text" name="user.email" placeholder="E-mail" value="${user.email}"/>
	        <div class="rs-6colunas primeira"><input type="password" name="user.password" placeholder="Senha"/></div>
	        <div class="rs-6colunas ultima"><input type="password" name="user.passwordConfirmation" placeholder="Confirmar senha"/></div>
	        <div class="rs-6colunas primeira">
	          <select name="user.gender" >
	            <option value="">Selecione seu sexo</option>
	            <option value="MALE" <c:if test="${user.maleSelected}">selected</c:if>>Masculino</option>
	            <option value="FEMALE" <c:if test="${user.femaleSelected}">selected</c:if>>Feminino</option>
	            <option value="OTHER" <c:if test="${user.otherSelected}">selected</c:if>>Outro</option>
	          </select>
	        </div>
	        <div class="rs-6colunas ultima"><input type="text" name="user.birthday" placeholder="Nascimento (dd/mm/aaa)" value="${user.formattedBirthday}"/></div>
	        <span class="legenda">Escolha o estado e cidade onde deseja morar</span>
	        <div class="rs-6colunas primeira">
	          <select name="user.city.stateAbbreviation" id="zipcode-state">
		        <option value="">Estado</option>
	          	<c:forEach items="${states}" var="state">
		            <option value="${state.abbreviation}" <c:if test="${state.abbreviation == user.city.stateAbbreviation}">selected</c:if> >${state.name}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="rs-6colunas ultima">
	          <select name="user.city.id" id="zipcode-city">
	            <option value="">Cidade</option>
	          	<c:forEach items="${cities}" var="city">
	          		<option value="${city.id}" <c:if test="${user.city.id == city.id}">selected</c:if> >${city.name}</option>
	          	</c:forEach>
	          </select>
	        </div>
	        <div class="rs-12colunas legenda">
	          <input type="checkbox" name="user.acceptsPerfilSuggestion" checked/>
	          Aceito sugestões de perfis que desejam procurar um lugar junto comigo
	        </div>
	        <div class="rs-6colunas primeira legenda rs-2linhas">	          
	          Ao se cadastrar você concorda com os <a href="/termos-de-uso">Termos de Uso</a> e nossa <a href="/politica-privacidade">Política de Privacidade</a>.
	        </div>
	        
	        <div class="rs-6colunas ultima">
	          <input class="rs-botao laranja full" type="submit" value="Finalizar Cadastro"></input>
	        </div>
	     </form>
      </div>
      
    </section>
    <!-- Fim Formulário de Cadastro de Usuário -->

    <c:import url="../rodape.jsp" />

  </div>


  <!-- SCRIPTS -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  
  <script src="js/city.js" type="text/javascript"></script>
  <!-- FIM SCRIPTS -->

</body>
</html>