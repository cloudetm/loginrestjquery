$('#btn-logar').on('click',function(ev){
	var usuario = $('#txt-login').val();
	var senha = $('#txt-senha').val();
	
	var user = {"login":usuario,"senha":senha};
	
	$.post('http://localhost:4567/user',user)
		.done(function( data ) {
			alert("Bem vindo " + data);
		})
		.fail(function( data ) {
			alert( "error" + data);
		})
	
	
});	
