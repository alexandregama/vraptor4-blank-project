$(document).ready(function(){
	
	// Menu Fixo::::::::::::::::::::::::::::	
	$('#configPerfil').click(function(){
		$('header .submenu-profile').slideToggle();
		$(this).toggleClass("icon-cog");
	});	

	// Mobile
	$('#menu-mobile').click(function(){
		$('header .menu').slideToggle();
		$(this).toggleClass("icon-menu");
	});
	resizeTela();

	// Resize Tela 
	$(window).resize(function() {
		resizeTela();
	});
	function resizeTela(){
		if($(window).width() > 760){
			$('header .menu .submenu-profile').hide();
			$('header .menu').show();	
			$('#configPerfil').addClass("icon-cog");
		}else{
			$('header .menu').hide();
			$('header .menu .submenu-profile').show();
			$('#menu-mobile').addClass("icon-menu");			
		}
	}





});