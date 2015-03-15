<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Cadastre-se para dividir quarto, apartamento, casa, etc...</title>
	<link rel="stylesheet" href="css/main.css" />
  <meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
</head>
<body>

  <!-- Header -->
  	<c:import url="../header.jsp"></c:import>
  <!-- Header -->

  <!-- Página -->
  <div id="pagina">

    <!-- Formulário de Cadastro de Anúncio -->
    <section id="formulario">
      <h1 class="linha">Bem vindo, vamos Criar seu anúncio :)</h1>
      <div class="bloco-cad colunas">
        <div class="rs-2colunas primeira hm">
          <img src="imagens/perfil-usuario.jpg" class="circular" width="100" alt="Ronery Souza">
        </div>
        <div class="rs-10colunas ultima">
          <h4>Ronery Souza Ferreira - 28</h4>
          <span>Bela Vista, São Paulo - SP</span>
          <span>Você disse que tem um espaço. Vamos criar seu anúncio agora?</span>
        </div>

        <span class="divisao"></span>
        <span class="legenda">Informações básicas do seu anúncio (obrigatório)</span>
        
        <input type="text" name="titulo" placeholder="Título do seu anúncio (Ex.: Divido apartamento com quarto individual)"/>
        
        <div class="rs-4colunas primeira"><input type="text" name="valor-aluguel" placeholder="Valor do aluguel (R$)"/></div>
        <div class="rs-4colunas"><input type="text" name="valor-despesas" placeholder="Outras despesas (R$)"/></div>
        <div class="rs-4colunas legenda duas-linhas ultima"><input type="checkbox" name="despesas-inclusas" id="despesas-inclusas" checked/><label for="despesas-inclusas">Despesas inclusas no aluguel</label></div>

        <div class="rs-6colunas primeira">
          <select name="qtd-vagas">
            <option value="0">Qtd. de vagas disponíveis</option>
            <option value="1">Tenho 01 vaga</option>
            <option value="2">Tenho 02 vagas</option>
            <option value="3">Tenho 03 vagas</option>
            <option value="4">Tenho 04 vagas</option>
          </select>
        </div>
        <div class="rs-6colunas ultima">
          <select name="tipo-quarto">
            <option value="0">Tipo do quarto</option>
            <option value="individual">Individual</option>
            <option value="2pessoas">Para 02 pessoas</option>
            <option value="3pessoas">Para 03 pessoas</option>
            <option value="4pessoas">Para 04 pessoas</option>
          </select>
        </div>

        <div class="rs-6colunas primeira">
          <input type="text" name="data-disponibilidade" placeholder="Data disponibilidade (dd/mm/aaa)"/>
        </div>
        <div class="rs-6colunas ultima">
          <select name="estadia">
            <option value="0">Estadia mínima</option>
            <option value="1">01 mês</option>
            <option value="2">02 meses</option>
            <option value="3">03 meses</option>
            <option value="4">04 meses</option>
            <option value="5">05 meses</option>
            <option value="6">06 meses</option>
            <option value="12+">12 meses ou +</option>
          </select>
        </div>

        <span class="divisao"></span>
        <div class="legenda rs-12colunas">Diga-nos onde está localizado o imóvel onde a vaga está disponível:</div>
        
        <div class="rs-3colunas primeira"><input type="text" name="cep" placeholder="CEP"/></div>
        <div class="rs-7colunas"><input type="text" name="endereco" placeholder="Endereço (Ex. Rua Rocha)"/></div>
        <div class="rs-2colunas ultima"><input type="text" name="numero" placeholder="Nº"/></div>

        <div class="rs-4colunas primeira">
          <select name="estado">
            <option value="0">Selecione estado</option>
            <option value="sp">SP</option>
            <option value="ba">BA</option>
          </select>
        </div>
        <div class="rs-8colunas ultima">
          <select name="cidade">
            <option value="0">Selecione cidade</option>
            <option value="sp">São Paulo</option>
            <option value="ba">Adamantina</option>
          </select>
        </div>

        <span class="divisao"></span>
        <div class="legenda rs-12colunas">Conte-nos um pouco sobre o imóvel</div>

        <div class="rs-4colunas primeira">
          <select name="tipo-imovel">
            <option value="0">Tipo do imóvel</option>
            <option value="apartamento">Apartamento</option>
            <option value="casa">Casa</option>
            <option value="kitinete">Kitinete</option>
            <option value="pensionato">Pensionato</option>
            <option value="república">República</option>
          </select>
        </div>
        <div class="rs-4colunas ultima">
          <select name="qtd-quartos">
            <option value="0">Qtd. de quartos</option>
            <option value="1">01 quarto</option>
            <option value="2">02 quartos</option>
            <option value="3">03 quartos</option>
            <option value="4">04 quartos</option>
          </select>
        </div>
        <div class="rs-4colunas ultima">
          <select name="qtd-banheiros">
            <option value="0">Qtd. de banheiros</option>
            <option value="1">01 banheiro</option>
            <option value="2">02 banheiros</option>
            <option value="3">03 banheiros</option>
            <option value="4">04 banheiros</option>
          </select>
        </div>

        <select name="situacao-moradia-anunciante">
          <option value="0">Em qual situação você se encaixa? (Selecione)</option>
          <option value="locatario-mora">Sou locatário e moro no imóvel</option>
          <option value="dono-mora">Sou dono e moro no imóvel</option>
          <option value="dono-nao-mora">Sou dono e não moro no imóvel</option>
        </select>

        <span class="divisao"></span>
        <div class="rs-12colunas legenda">Quais suas preferências de companhia?</div>

        <div class="rs-3colunas primeira">
          <strong class="line">Aceita fumantes?</strong>
          <input type="radio" name="preferencia-fumante" value="Sim" id="pref-fumante-sim"/> <label for="pref-fumante-sim">Sim</label>
          <input type="radio" name="preferencia-fumante" value="Não" id="pref-fumante-nao"/> <label for="pref-fumante-nao">Não</label>
        </div>
        <div class="rs-3colunas">
          <strong class="line">Aceita animais?</strong>
          <input type="radio" name="preferencia-animais" value="Sim" id="pref-animais-sim"/> <label for="pref-animais-sim">Sim</label>
          <input type="radio" name="preferencia-animais" value="Não" id="pref-animais-nao"/> <label for="pref-animais-nao">Não</label>
        </div>
        <div class="rs-3colunas">
          <strong class="line">Aceita casais?</strong>
          <input type="radio" name="preferencia-casais" value="Sim" id="pref-casais-sim"/> <label for="pref-casais-sim">Sim</label>
          <input type="radio" name="preferencia-casais" value="Não" id="pref-casais-nao"/> <label for="pref-casais-nao">Não</label>
        </div>
        <div class="rs-3colunas ultima">
          <strong class="line">Aceita criancas?</strong>
          <input type="radio" name="preferencia-criancas" value="Sim" id="pref-criancas-sim"/> <label for="pref-criancas-sim">Sim</label>
          <input type="radio" name="preferencia-criancas" value="Não" id="pref-criancas-nao"/> <label for="pref-criancas-nao">Não</label>
        </div>

        <div class="rs-3colunas primeira">
          <input type="text" name="idade-minima" placeholder="Idade mín. (18)"/>
        </div>
        <div class="rs-3colunas">
          <input type="text" name="idade-maxima" placeholder="Idade máx. (99)"/>
        </div>
        <div class="rs-3colunas">
          <select name="pref-sexo">
            <option value="0">Sexo</option>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
            <option value="outro">Outro</option>
          </select>
        </div>
        <div class="rs-3colunas ultima">
          <select name="pref-orientacao">
            <option value="0">Orientação  </option>
            <option value="bissexual">Bissexual</option>
            <option value="gay">Gay</option>
            <option value="heterossexual">Heterossexual</option>
          </select>
        </div>

        <span class="divisao"></span>
        <div class="rs-12colunas legenda">Conte-nos um pouco mais sobre você :)</div>

        <div class="rs-3colunas primeira">
          <strong class="line">Você fuma?</strong>
          <input type="radio" name="eu-fumante" value="Sim" id="eu-fumante-sim"/> <label for="eu-fumante-sim">Sim</label>
          <input type="radio" name="eu-fumante" value="Não" id="eu-fumante-nao"/> <label for="eu-fumante-nao">Não</label>
        </div>
        <div class="rs-3colunas">
          <strong class="line">Tem animal(is)?</strong>
          <input type="radio" name="eu-animais" value="Sim" id="eu-animais-sim"/> <label for="eu-animais-sim">Sim</label>
          <input type="radio" name="eu-animais" value="Não" id="eu-animais-nao"/> <label for="eu-animais-nao">Não</label>
        </div>
        <div class="rs-3colunas">
          <strong class="line">Procura vaga só?</strong>
          <input type="radio" name="eu-casais" value="Sim" id="eu-casais-sim"/> <label for="eu-casais-sim">Sim</label>
          <input type="radio" name="eu-casais" value="Não" id="eu-casais-nao"/> <label for="eu-casais-nao">Não</label>
        </div>
        <div class="rs-3colunas ultima">
          <strong class="line">Tem crianca(s)?</strong>
          <input type="radio" name="eu-criancas" value="Sim" id="eu-criancas-sim"/> <label for="eu-criancas-sim">Sim</label>
          <input type="radio" name="eu-criancas" value="Não" id="eu-criancas-nao"/> <label for="eu-criancas-nao">Não</label>
        </div>

        <div class="rs-6colunas primeira">
          <select name="minha-orientacao">
            <option value="0">Sua orientação</option>
            <option value="bissexual">Bissexual</option>
            <option value="gay">Gay</option>
            <option value="heterossexual">Heterossexual</option>
          </select>
        </div>
        <div class="rs-6colunas ultima">
          <select name="minha-ocupacao">
            <option value="0">Sua ocupação?</option>
            <option value="trabalho">Trabalho</option>
            <option value="estudo">Estudo</option>
            <option value="trabalho-estudo">Trabalho e estudo</option>
          </select>
        </div>

        <span class="divisao"></span>

        <div class="rs-6colunas primeira legenda rs-2linhas">
          Ao se cadastrar você concorda com os <a href="/termos-de-uso">Termos de Uso</a> e nossa <a href="/politica-privacidade">Política de Privacidade</a>.
        </div>
        <div class="rs-6colunas ultima">
          <a href="#" class="rs-botao laranja full">Finalizar Cadastro</a>
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