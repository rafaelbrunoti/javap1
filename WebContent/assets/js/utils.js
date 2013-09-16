$(document).ready(function(){
	$(".btn-danger").click(function(){
		if (confirm("Deseja continuar essa opera��o?")){
			return true;
		}
		return false;
	});
	
	$("#input-image").change(function(){
		$("#image").html("<img src='' id='image'  class='img-rounded'>", $("#input-image").val());
	});
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) {
			$('#blah')
			.attr('src', e.target.result)
			.width(220)
			.height(150);
		};
		reader.readAsDataURL(input.files[0]);
	}
}
