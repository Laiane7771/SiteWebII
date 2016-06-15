$(document).ready(function(){
	$('#categorias').load('http://carrinhocompras-visecitecfsa.rhcloud.com/categoryList');

	$('#btnCadastra').click(function(){
		alert('http://carrinhocompras-visecitecfsa.rhcloud.com/registerSubCategory?nomeSubCategoria='+ $("#idSubCategorias").val()+'&idcategoria='+$("#categorias").val());
		$.ajax({
			url:'http://carrinhocompras-visecitecfsa.rhcloud.com/registerSubCategory?nomeSubCategoria='+ $("#idSubCategorias").val()+'&idcategoria='+$("#categorias").val(),
			crossDomain:true,

			sucess:function(data){
				alert(data);
				alert("subcategoria cadastrada");
			},
			error:function(){
				alert("erro");
			},
			beforeSend:function(){
				alert("Carregando...");
			},
			complete:function(){
				alert("subcategoria cadastrada");
			}
		});
		return false;
	});
});


