<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Cadastre-se para dividir quarto, apartamento, casa, etc...</title>
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
      <h1>Crie seu perfil de forma rápida e fácil :)</h1>
      <c:forEach items="${errors}" var="error">
      	${error}
      </c:forEach>
      <a href="" class="icon-facebook2 bt-facebook">Cadastre-se usando o Facebook</a>
      <a href="" class="icon-google-plus2 bt-google">Cadastre-se usando o Facebook</a>
      <span class="ou"><strong>OU</strong></span>
      
      <div class="bloco-cad colunas">
      	<form action="user" method="post">
	        <select name="tipo-busca">
	          <option value="0">Tipo do anúncio (Você tem ou precisa de um espaço?)</option>
	          <option value="tenho">Tenho uma vaga</option>
	          <option value="preciso">Preciso de uma vaga</option>
	        </select>
	        <div class="rs-6colunas primeira"><input type="text" name="user.firstName" placeholder="Nome"/></div>
	        <div class="rs-6colunas ultima"><input type="text" name="user.lastName" placeholder="Sobrenome"/></div>
	        <input type="text" name="user.email" placeholder="E-mail"/>
	        <div class="rs-6colunas primeira"><input type="text" name="user.password" placeholder="Senha"/></div>
	        <div class="rs-6colunas ultima"><input type="text" name="user.passwordConfirmation" placeholder="Confirmar senha"/></div>
	        <div class="rs-6colunas primeira">
	          <select name="user.gender">
	            <option value="">Selecione seu sexo</option>
	            <option value="MALE">Masculino</option>
	            <option value="FEMALE">Feminino</option>
	            <option value="OTHER">Outro</option>
	          </select>
	        </div>
	        <div class="rs-6colunas ultima"><input type="text" name="user.birthday" placeholder="Nascimento (dd/mm/aaa)"/></div>
	        <span class="legenda">Escolha o estado e cidade onde deseja morar</span>
	        <div class="rs-6colunas primeira">
	          <select name="estado">
	            <option value="0">Estado</option>
	            <option value="masculino">SP</option>
	            <option value="feminino">BA</option>
	            <option value="outro">Minas</option>
	          </select>
	        </div>
	        <div class="rs-6colunas ultima">
	          <select name="cidade">
	            <option value="0">Cidade</option>
	            <option value="masculino">São Paulo</option>
	            <option value="feminino">Americana</option>
	            <option value="outro">Campinas</option>
	          </select>
	        </div>
	        <div class="rs-12colunas legenda">
	          <input type="checkbox" name="aceito-sugestoes-perfis" checked/>
	          Aceito sugestões de perfis que desejam procurar um lugar junto comigo
	        </div>
	        <div class="rs-6colunas primeira legenda rs-2linhas">
	          <input type="checkbox" name="user.acceptsPerfilSuggestion" checked/>
	          Ao se cadastrar você concorda com os <a href="/termos-de-uso">Termos de Uso</a> e nossa <a href="/politica-privacidade">Política de Privacidade</a>.
	        </div>
	        
	        <div class="rs-6colunas ultima">
	          <input class="rs-botao laranja full" type="submit" value="Finalizar Cadastro"></input>
	        </div>
	     </form>
      </div>
      
    </section>
    <!-- Fim Formulário de Cadastro de Usuário -->

    <!-- Rodapé -->
    <footer>
      <div class="container colunas">
        <div class="rs-3colunas primeira">
          <a href="/" class="sprite logo"></a>
        </div>
        <div class="rs-2colunas">
          <h5>Procurando Apê</h5>
          <ul>
            <li><a href="/quem-somos">Quem Somos</a></li>
            <li><a href="/termos-de-uso">Termos de Uso</a></li>
            <li><a href="/politica-privacidade">Política de Privacidade</a></li>
          </ul>
        </div>
        <div class="rs-2colunas">
          <h5>Tenho um espaço</h5>
          <ul>
            <li><a href="/criar-anuncio">Criar Anúncio</a></li>
          </ul>
          <h5>Preciso de um espaço</h5>
          <ul>
            <li><a href="/criar-perfil">Criar Perfil</a></li>
          </ul>
        </div>
        <div class="rs-2colunas">
          <h5>Ajuda</h5>
          <ul>
            <li><a href="/quem-somos">Visitar nosso FAQ</a></li>
          </ul>
          <h5>Contato</h5>
          <ul>
            <li><a href="/quem-somos">Faleconosco</a></li>
          </ul>
        </div>        
        <div class="rs-3colunas ultima">
          <a href="http://www.facebook.com/procurandoape" class="icon-facebook2"></a>
          <a href="http://www.twitter.com/procurandoape" class="icon-twitter2"></a> 
          <a href="http://www.google.com/procurandoape" class="icon-google-plus2"></a>      
        </div>
      </div>
    </footer>
    <!-- Fim Rodapé -->

  </div>


  <!-- Scripts -->
  <script src="${urlAmazonPresenter.s3AssetsUrl}/js/site-html/jquery-1.11.2.min.js" type="text/javascript"></script>
  <script src="${urlAmazonPresenter.s3AssetsUrl}/js/site-html/main.js" type="text/javascript"></script>
  <!-- Fim Scripts -->

</body>
</html>