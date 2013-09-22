$(document).ready(function(){
	
	$('#form-cad-midia').submit(function(){
		
		$.ajax({
			url: '/javap1/MidiaServlet',
			dataType: 'json',
			type: 'get',
			data: $('#form-cad-midia').serialize(),
			success: function(data){
				alert('Cadastro efetuado com sucesso!');
			},
			error: function(data){
				alert(data.responseText);
			}
		});
		
		return false;
	});
	
});