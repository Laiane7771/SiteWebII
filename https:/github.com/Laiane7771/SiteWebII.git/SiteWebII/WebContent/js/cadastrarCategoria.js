$(document).ready(function(){
	$('#botao').click(function(){
		$.ajax({
			url:'http://carrinhocompras-visecitecfsa.rhcloud.com/registerCategory?nomeCategoria='+ $('#NomeCategoriainput').val(),
			crossDomain: true,
				sucess: function(data){
					altert(data);
					alert("Categoria Cadastrada com sucesso!");
				},
				error: function(){
					alert("erro");
				},
				beforeSend: function(){
					alert("Carregando...");
				},
				complete:function(){
					/*alert("Categoria Cadastrada com sucesso!");*/
					alert("Categoria Cadastrada com sucesso!");
				}
		});
		return false;
	});
});		                	
		                		
  