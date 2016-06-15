$(document).ready(function(){
				var heightProduto = 1800;
				alert("chamou!");
				$(window).scroll(function(){
				
					if($(this).scrollTop() + $(this).height() >= heightProduto){
						heightProduto+=192;
						console.log("fim");
					}
				});
});


