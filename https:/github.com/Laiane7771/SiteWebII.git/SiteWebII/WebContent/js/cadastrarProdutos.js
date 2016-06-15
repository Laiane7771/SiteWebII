$(document).ready(function(){

	$('#categorias').load('http://carrinhocompras-visecitecfsa.rhcloud.com/categoryList', function(){
		$('#idSubCategorias').load('http://carrinhocompras-visecitecfsa.rhcloud.com/subCategoryList?idCategoria='+$("#categorias").val());
	});

	$('#categorias').change(function(){
		$('#idSubCategorias').load('http://carrinhocompras-visecitecfsa.rhcloud.com/subCategoryList?idCategoria='+$("#categorias").val());
	});
		$('#btCadastrar').click(function(){
			alert('http://carrinhocompras-visecitecfsa.rhcloud.com/registerProduct?descricao='+$("#areaDescri").val()+'&valorAtual='+$("#ValorA").val()+'&valorAnterior='+$("#ValorAn").val()+'&idSubcategoria='+$("#idSubCategorias").val());
			$.ajax({
				url:'http://carrinhocompras-visecitecfsa.rhcloud.com/registerProduct?descricao='+$("#areaDescri").val()+'&valorAtual='+$("#ValorA").val()+'&valorAnterior='+$("#ValorAn").val()+'&idSubCategoria='+$("#idSubCategorias").val(),
				crossDomain:true,		

				sucess:function(data){
					alert(data);
					alert("Produto cadastrado");
				},
				error:function(){
					alert("erro");
				},
				beforeSend:function(){
					alert("Carregando...");
				},
				complete:function(){
					alert("Produto cadastrado");
				} 
			});
			return false;
		});	
	});

