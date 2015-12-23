$('#nuser').hide();

$(document).ready(function(){
	$('#btn-logar')
		.on('click',function(ev){
			var usuario = $('#txt-login').val();
			var senha = $('#txt-senha').val();

			var user = {"login":usuario,"senha":senha};		

			$.post('http://localhost:4567/user',JSON.stringify(user))
				.done(function(data,status) {
					if(status==200){
						var usuario = JSON.parse(data);
						$('#nlogin').hide();
						$('#nuser').append(usuario.nome)						
						$('#nuser').show();
					}else{
						alert("ERRO "+status);
					}
				})
				.fail(function(data,status){
					alert("ERRO "+status);
				});
		});	
});

