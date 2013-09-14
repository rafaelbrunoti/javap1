$(document).ready(function(){
	$(".btn-danger").click(function(){
		if (confirm("Deseja continuar essa operação?")){
			return true;
		}
		return false;
	});
	
	$("#input-image").change(function(){
		$("#image").html("<img src='' id='image'  class='img-rounded'>", $("#input-image").val());
	});
});