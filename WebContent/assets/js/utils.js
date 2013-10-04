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
	
$(function(){
	$("#calendario").datepicker({
	    dateFormat: 'dd/mm/yy',
	    dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado','Domingo'
	        ],
	    dayNamesMin: [
	    'D','S','T','Q','Q','S','S','D'
	    ],
	    dayNamesShort: [
	    'Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'
	    ],
	    monthNames: [  'Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro',
	    'Outubro','Novembro','Dezembro'
	    ],
	    monthNamesShort: [
	    'Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set',
	    'Out','Nov','Dez'
	    ],
	    nextText: 'Pr�ximo',
	    prevText: 'Anterior'
 });
	
});
