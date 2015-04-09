<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastre-se para dividir quarto, apartamento, casa, etc...</title>
	<link rel="stylesheet" href="css/main.css" />
  	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">

	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script>
	<script src="js/maps.js" type="text/javascript"></script>	
	  	
</head>
<body onload="initialize()">

  <!-- Header -->
  	<c:import url="../header.jsp"></c:import>
  <!-- Header -->

  <!-- Página -->
  <div id="pagina">

    <!-- Formulário de Cadastro de Anúncio -->
	<section id="formulario">
	    <form action="${linkTo[PlaceToRentalController].save}" method="POST">
	      <h1 class="linha">${t['placetorenta.welcome.message']}</h1>
	      <div class="bloco-cad colunas">
	        <div class="rs-2colunas primeira hm">
	          <img src="${user.photo}" class="circular" width="100" alt="Ronery Souza">
	        </div>
	        <div class="rs-10colunas ultima">
	          <h4>${user.fullName} - ${user.age}</h4>
	          <span>Bela Vista, ${user.city.name} - ${user.city.stateAbbreviation}</span>
	        </div>

			<!-- Terrible. Change it as soon as possible -->	
			<c:forEach items="${errors}" var="error">
				<c:if test="${error.category == 'bathroomQuantity'}">
					${error.message}
				</c:if>
			</c:forEach>
			
	        <span class="divisao"></span>
	        <span class="legenda">${t['placetorental.basic.information']}</span>
	        
		        <input type="text" name="placeToRental.shortDescription" value="${placeToRental.shortDescription}" placeholder="${t['placetorental.title']}"/>
		        <input type="text" name="placeToRental.description" value="${placeToRental.description}" placeholder="${t['placetorental.description']}"/>
		        
		        <div class="rs-4colunas primeira">
		        	<input type="text" name="placeToRental.price" value="${placeToRental.price}" placeholder="${t['placetorental.input.price']}"/>
		        </div>
		        
		        <div class="rs-4colunas">
		        	<input type="text" name="placeToRental.priceExpenses" value="${placeToRental.priceExpenses}" placeholder="${t['placetorental.input.price.expenses']}"/>
		        </div>
		        
		        <div class="rs-4colunas legenda duas-linhas ultima">
		        	<input type="checkbox" name="despesas-inclusas" id="despesas-inclusas" />
		        	<label for="despesas-inclusas">Despesas inclusas no aluguel</label>
		        </div>
		
		        <div class="rs-6colunas primeira">
		          <select name="placeToRental.availablePlacesAmount">
		            <option value="">${t['placetorental.select.availableplaces']}</option>
		            <option value="1" <c:if test="${placeToRental.availablePlacesAmount == 1}">selected="selected"</c:if> >Tenho 01 vaga</option>
		            <option value="2" <c:if test="${placeToRental.availablePlacesAmount == 2}">selected="selected"</c:if> >Tenho 02 vagas</option>
		            <option value="3" <c:if test="${placeToRental.availablePlacesAmount == 3}">selected="selected"</c:if> >Tenho 03 vagas</option>
		            <option value="4" <c:if test="${placeToRental.availablePlacesAmount == 4}">selected="selected"</c:if> >Tenho 04 vagas</option>
		            <option value="5" <c:if test="${placeToRental.availablePlacesAmount == 5}">selected="selected"</c:if> >Tenho 05 vagas</option>
		            <option value="6" <c:if test="${placeToRental.availablePlacesAmount == 6}">selected="selected"</c:if> >Tenho 06 vagas</option>
		          </select>
		        </div>
		        <div class="rs-6colunas ultima">
		          <select name="placeToRental.roomTypeAmount">
		            <option value="0">Tipo do quarto</option>
		            <option value="1" <c:if test="${placeToRental.roomTypeAmount == 1}">selected="selected"</c:if> >Individual</option>
		            <option value="2" <c:if test="${placeToRental.roomTypeAmount == 2}">selected="selected"</c:if> >Para 02 pessoas</option>
		            <option value="3" <c:if test="${placeToRental.roomTypeAmount == 3}">selected="selected"</c:if> >Para 03 pessoas</option>
		            <option value="4" <c:if test="${placeToRental.roomTypeAmount == 4}">selected="selected"</c:if> >Para 04 pessoas</option>
		            <option value="5" <c:if test="${placeToRental.roomTypeAmount == 5}">selected="selected"</c:if> >Para 05 pessoas</option>
		            <option value="6" <c:if test="${placeToRental.roomTypeAmount == 6}">selected="selected"</c:if> >Para 06 pessoas</option>
		          </select>
		        </div>
		
		        <div class="rs-6colunas primeira">
		          <input type="text" name="placeToRental.availableDate" value="${placeToRental.availableDate}" placeholder="Data disponibilidade (dd/mm/aaa)"/>
		        </div>
		        <div class="rs-6colunas ultima">
		          <select name="placeToRental.minimumStay">
		            <option value="">${t['placetorental.select.minimumstay']}</option>
		            <option value="0" <c:if test="${placeToRental.minimumStay == 6}">selected="selected"</c:if> >Indiferente</option>
		            <option value="1" <c:if test="${placeToRental.minimumStay == 1}">selected="selected"</c:if> >${t['placetorental.option.month'].count(1)}</option>
		            <option value="2" <c:if test="${placeToRental.minimumStay == 2}">selected="selected"</c:if> >${t['placetorental.option.month'].count(2)}</option>
		            <option value="3" <c:if test="${placeToRental.minimumStay == 3}">selected="selected"</c:if> >${t['placetorental.option.month'].count(3)}</option>
		            <option value="4" <c:if test="${placeToRental.minimumStay == 4}">selected="selected"</c:if> >${t['placetorental.option.month'].count(4)}</option>
		            <option value="5" <c:if test="${placeToRental.minimumStay == 5}">selected="selected"</c:if> >${t['placetorental.option.month'].count(5)}</option>
		            <option value="6" <c:if test="${placeToRental.minimumStay == 6}">selected="selected"</c:if> >${t['placetorental.option.month'].count(6)}</option>
		            <option value="12" <c:if test="${placeToRental.minimumStay == 12}">selected="selected"</c:if> >${t['placetorental.option.month.twelve']}</option>
		          </select>
		        </div>
		
		        <span class="divisao"></span>
		        <div class="legenda rs-12colunas">${t['placetorental.legend.location']}</div>
		        
        	    <div id="locationField">
			      <input id="autocomplete" name="placeToRental.completeGoogleAddress" placeholder="${t['placetorental.address.placeholder.text']}" onFocus="geolocate()" type="text"></input>
			    </div>		        
		        <div class="rs-7colunas">
		        	<input type="hidden" id="route" name="placeToRental.address" value="${placeToRental.address}" placeholder="${t['placetorental.input.address']}"/>
		        </div>
		        <div class="rs-3colunas primeira">
		        	<input type="text" id="postal_code" name="placeToRental.zipcode" value="${placeToRental.zipcode}" placeholder="CEP"/>
		        </div>
		        <div class="rs-2colunas ultima">
		        	<input type="text" id="street_number" name="placeToRental.addressNumber" value="${placeToRental.addressNumber}" placeholder="${t['text.numero']}"/>
		        </div>
		        <div class="rs-7colunas">
		        	<input type="text" id="zipcode-neighborhood" name="placeToRental.neighborhood" value="${placeToRental.neighborhood}" placeholder="Bairro"/>
		        </div>
		        <div class="rs-7colunas">
		        	<input type="text" id="administrative_area_level_1" name="placeToRental.state" value="${placeToRental.neighborhood}" placeholder="Estado"/>
		        </div>
		        <div class="rs-7colunas">
		        	<input type="text" id="locality" name="placeToRental.city" value="${placeToRental.neighborhood}" placeholder="Cidade"/>
		        </div>
				<input class="field" id="country"></input>		        
		
		        <span class="divisao"></span>
		        <div class="legenda rs-12colunas">${t['placetorental.legend.about.local']}</div>
		
		        <div class="rs-4colunas primeira">
		          <select name="placeToRental.propertyType">
		            <option selected value="">${t['placetorental.select.propertytype']}</option>
		            <option value="APARTAMENT" <c:if test="${placeToRental.propertyType == 'APARTAMENT'}">selected="selected"</c:if> >Apartamento</option>
		            <option value="HOUSE"    <c:if test="${placeToRental.propertyType == 'HOUSE'}">selected="selected"</c:if> >Casa</option>
		            <option value="KITNET"   <c:if test="${placeToRental.propertyType == 'KITNET'}">selected="selected"</c:if> >Kitinete</option>
		            <option value="HOSTEL"   <c:if test="${placeToRental.propertyType == 'HOSTEL'}">selected="selected"</c:if> >Pensionato</option>
		            <option value="REPUBLIC" <c:if test="${placeToRental.propertyType == 'REPUBLIC'}">selected="selected"</c:if> >${t['placetorental.property.type.republic']}</option>
		          </select>
		        </div>
		        <div class="rs-4colunas ultima">
		          <select name="placeToRental.roomQuantity">
		            <option value="">Qtd. de quartos</option>
		            <option value="1" <c:if test="${placeToRental.roomQuantity == 1}">selected="selected"</c:if> >01 quarto</option>
		            <option value="2" <c:if test="${placeToRental.roomQuantity == 2}">selected="selected"</c:if> >02 quartos</option>
		            <option value="3" <c:if test="${placeToRental.roomQuantity == 3}">selected="selected"</c:if> >03 quartos</option>
		            <option value="4" <c:if test="${placeToRental.roomQuantity == 4}">selected="selected"</c:if> >04 quartos</option>
		            <option value="5" <c:if test="${placeToRental.roomQuantity == 5}">selected="selected"</c:if> >05 quartos</option>
		            <option value="6" <c:if test="${placeToRental.roomQuantity == 6}">selected="selected"</c:if> >06 quartos</option>
		            <option value="7" <c:if test="${placeToRental.roomQuantity == 7}">selected="selected"</c:if> >07 quartos</option>
		            <option value="8" <c:if test="${placeToRental.roomQuantity == 8}">selected="selected"</c:if> >08 quartos</option>
		          </select>
		        </div>
		        <div class="rs-4colunas ultima">
		          <select name="placeToRental.bathroomQuantity">
		            <option value="0" <c:if test="${placeToRental.bathroomQuantity == 0}">selected="selected"</c:if> >Qtd. de banheiros</option>
		            <option value="1" <c:if test="${placeToRental.bathroomQuantity == 1}">selected="selected"</c:if> >01 banheiro</option>
		            <option value="2" <c:if test="${placeToRental.bathroomQuantity == 2}">selected="selected"</c:if> >02 banheiros</option>
		            <option value="3" <c:if test="${placeToRental.bathroomQuantity == 3}">selected="selected"</c:if> >03 banheiros</option>
		            <option value="4" <c:if test="${placeToRental.bathroomQuantity == 4}">selected="selected"</c:if> >04 banheiros</option>
		            <option value="5" <c:if test="${placeToRental.bathroomQuantity == 5}">selected="selected"</c:if> >05 banheiros</option>
		            <option value="6" <c:if test="${placeToRental.bathroomQuantity == 6}">selected="selected"</c:if> >06 banheiros</option>
		            <option value="7" <c:if test="${placeToRental.bathroomQuantity == 7}">selected="selected"</c:if> >07 banheiros</option>
		            <option value="8" <c:if test="${placeToRental.bathroomQuantity == 8}">selected="selected"</c:if> >08 banheiros</option>
		          </select>
		        </div>
		
		        <select name="placeToRental.advertiseSituation">
		          <option value="" selected>${t['placetorental.select.advertise.situation']}</option>
		          <option value="RENTER_LIVING" <c:if test="${placeToRental.advertiseSituation == 'RENTER_LIVING'}">selected="selected"</c:if> >${t['placetorental.advertise.situation.renter.living']}</option>
		          <option value="RENTER_NOT_LIVING" <c:if test="${placeToRental.advertiseSituation == 'RENTER_NOT_LIVING'}">selected="selected"</c:if> >${t['placetorental.advertise.situation.renter.notliving']}</option>
		          <option value="OWNER_LIVING" <c:if test="${placeToRental.advertiseSituation == 'OWNER_LIVING'}">selected="selected"</c:if> >${t['placetorental.advertise.situation.owner.living']}</option>
		          <option value="OWNER_NOT_LIVING" <c:if test="${placeToRental.advertiseSituation == 'OWNER_NOT_LIVING'}">selected="selected"</c:if> >${t['placetorental.advertise.situation.owner.notliving']}</option>
		        </select>
		
		        <span class="divisao"></span>
		        <div class="rs-12colunas legenda">${t['placetorental.legend.preferences']}</div>
		
		        <div class="rs-3colunas primeira">
		          <strong class="line">Aceita fumantes?</strong>
		          <input type="radio" name="placeToRental.acceptsSmoker" value="Y" id="pref-fumante-sim" <c:if test="${placeToRental.acceptsSmoker}">checked="checked"</c:if> /> <label for="pref-fumante-sim">Sim</label>
		          <input type="radio" name="placeToRental.acceptsSmoker" value="N" id="pref-fumante-nao" <c:if test="${not placeToRental.acceptsSmoker}">checked="checked"</c:if> /> <label for="pref-fumante-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas">
		          <strong class="line">Aceita animais?</strong>
		          <input type="radio" name="placeToRental.acceptsAnimal" value="Y" id="pref-animais-sim" <c:if test="${placeToRental.acceptsAnimal}">checked="checked"</c:if> /> <label for="pref-animais-sim">Sim</label>
		          <input type="radio" name="placeToRental.acceptsAnimal" value="N" id="pref-animais-nao" <c:if test="${not placeToRental.acceptsAnimal}">checked="checked"</c:if> /> <label for="pref-animais-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas">
		          <strong class="line">Aceita casais?</strong>
		          <input type="radio" name="placeToRental.acceptsCouple" value="Y" id="pref-casais-sim" <c:if test="${placeToRental.acceptsCouple}">checked="checked"</c:if> /> <label for="pref-casais-sim">Sim</label>
		          <input type="radio" name="placeToRental.acceptsCouple" value="N" id="pref-casais-nao" <c:if test="${not placeToRental.acceptsCouple}">checked="checked"</c:if> /> <label for="pref-casais-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas ultima">
		          <strong class="line">${t['placetorental.input.accepts.kid']}</strong>
		          <input type="radio" name="placeToRental.acceptsChildren" value="Y" id="pref-criancas-sim" <c:if test="${placeToRental.acceptsChildren}">checked="checked"</c:if> /> <label for="pref-criancas-sim">Sim</label>
		          <input type="radio" name="placeToRental.acceptsChildren" value="N" id="pref-criancas-nao" <c:if test="${not placeToRental.acceptsChildren}">checked="checked"</c:if> /> <label for="pref-criancas-nao">${t['text.no']}</label>
		        </div>
		
		        <div class="rs-3colunas primeira">
		          <input type="text" name="placeToRental.minimumAge" value="${placeToRental.minimumAge}" placeholder="${t['placetorental.input.minimumage']}"/>
		        </div>
		        <div class="rs-3colunas">
		          <input type="text" name="placeToRental.maximumAge" value="${placeToRental.maximumAge}" placeholder="${t['placetorental.input.maximumage']}"/>
		        </div>
		        <div class="rs-3colunas">
		          <select name="placeToRental.genderPreference">
		            <option value="0" selected="selected">Sexo</option>
		            <option value="MALE">Masculino</option>
		            <option value="FEMALE">Feminino</option>
		            <option value="OTHER">Outro</option>
		          </select>
		        </div>
		        <div class="rs-3colunas ultima">
		          <select name="pref-orientacao">
		            <option value="" selected="selected">${t['placetorental.select.gender.orientation']}Orientação</option>
		            <option value="BISSEXUAL">Bissexual</option>
		            <option value="GAY">Gay</option>
		            <option value="HETEROSEXUAL">Heterossexual</option>
		          </select>
		        </div>
		
		        <span class="divisao"></span>
		        <div class="rs-12colunas legenda">${t['placetorental.legend.user.information']}</div>
		
		        <div class="rs-3colunas primeira">
		          <strong class="line">${t['placetorental.input.user.smoke']}</strong>
		          <input type="radio" name="placeToRental.userSmokes" value="Y" id="eu-fumante-sim" <c:if test="${placeToRental.userSmokes}">checked="checked"</c:if> /> <label for="eu-fumante-sim">Sim</label>
		          <input type="radio" name="placeToRental.userSmokes" value="N" id="eu-fumante-nao" <c:if test="${not placeToRental.userSmokes}">checked="checked"</c:if>  /> <label for="eu-fumante-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas">
		          <strong class="line">Tem animal(is)?</strong>
		          <input type="radio" name="placeToRental.userHasAnimal" value="Y" id="eu-animais-sim" <c:if test="${placeToRental.userHasAnimal}">checked="checked"</c:if> /> <label for="eu-animais-sim">Sim</label>
		          <input type="radio" name="placeToRental.userHasAnimal" value="N" id="eu-animais-nao" <c:if test="${not placeToRental.userHasAnimal}">checked="checked"</c:if> /> <label for="eu-animais-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas">
		          <strong class="line">${t['placetorental.input.user.looking']}</strong>
		          <input type="radio" name="placeToRental.userLookingAlone" value="Y" id="eu-casais-sim" <c:if test="${placeToRental.userLookingAlone}">checked="checked"</c:if> /> <label for="eu-casais-sim">Sim</label>
		          <input type="radio" name="placeToRental.userLookingAlone" value="N" id="eu-casais-nao" <c:if test="${not placeToRental.userLookingAlone}">checked="checked"</c:if> /> <label for="eu-casais-nao">${t['text.no']}</label>
		        </div>
		        <div class="rs-3colunas ultima">
		          <strong class="line">${t['placetorental.input.user.haskid']}</strong>
		          <input type="radio" name="placeToRental.userHasKid" value="Y" id="eu-criancas-sim" <c:if test="${placeToRental.userHasKid}">checked="checked"</c:if> /> <label for="eu-criancas-sim">Sim</label>
		          <input type="radio" name="placeToRental.userHasKid" value="N" id="eu-criancas-nao" <c:if test="${not placeToRental.userHasKid}">checked="checked"</c:if> /> <label for="eu-criancas-nao">${t['text.no']}</label>
		        </div>
		
		        <div class="rs-6colunas primeira">
		          <select name="placeToRental.userGenderOrientation">
		            <option value="">${t['placetorental.input.user.gender.orientation']}</option>
		            <option value="BISSEXUAL" <c:if test="${placeToRental.userGenderOrientation == 'BISSEXUAL'}">selected="selected"</c:if> >Bissexual</option>
		            <option value="GAY" <c:if test="${placeToRental.userGenderOrientation == 'GAY'}">selected="selected"</c:if> >Gay</option>
		            <option value="HETEROSEXUAL" <c:if test="${placeToRental.userGenderOrientation == 'HETEROSEXUAL'}">selected="selected"</c:if> >Heterossexual</option>
		          </select>
		        </div>
		        <div class="rs-6colunas ultima">
		          <select name="placeToRental.userOccupation">
		            <option value="">${t['placetorental.input.user.occupation']}</option>
		            <option value="WORKER" <c:if test="${placeToRental.userOccupation == 'WORKER'}">selected="selected"</c:if> >Trabalho</option>
		            <option value="STUDENT" <c:if test="${placeToRental.userOccupation == 'STUDENT'}">selected="selected"</c:if> >Estudo</option>
		            <option value="WORKER_STUDENT" <c:if test="${placeToRental.userOccupation == 'WORKER_STUDENT'}">selected="selected"</c:if> >Trabalho e estudo</option>
		            <option value="UNEMPLOYED" <c:if test="${placeToRental.userOccupation == 'UNEMPLOYED'}">selected="selected"</c:if> >Desempregado</option>
		          </select>
		        </div>
	
	        <span class="divisao"></span>
	
	        <div class="rs-6colunas primeira legenda rs-2linhas">
	          ${t['placetorental.privacy.policy']}
	        </div>
	        <div class="rs-6colunas ultima">
	          <input type="submit" class="rs-botao laranja full" value="Finalizar Cadastro"></input>
	        </div>
	      </div>
	      
		</form>
	</section>
    <!-- Fim Formulário de Cadastro de Anúncio -->

    <c:import url="../rodape.jsp" />

  </div>


  <!-- Scripts -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/site-html/js/main.js" type="text/javascript"></script>
  <script src="js/cep.js" type="text/javascript"></script>
  <script src="js/city.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>