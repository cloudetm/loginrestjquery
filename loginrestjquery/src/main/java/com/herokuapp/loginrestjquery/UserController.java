package com.herokuapp.loginrestjquery;

import spark.Spark;

import com.google.gson.Gson;
import com.herokuapp.loginrestjquery.bean.Usuario;

public class UserController {
	
	public static void initRoutes(){
		UserController controller = new UserController();
		Gson gson = new Gson();
		
		Spark.post("/user",  (request, response) -> {
			Usuario usuario = null;
			try {
				usuario = gson.fromJson(request.body(), Usuario.class);
			} catch (Exception e) {
				response.status(400);
				return "JSON INVALIDO";
			}
			
			if(null==controller.validar(usuario)){
				response.status(403);
				response.body("ACESSO NAO PERMITIDO");
				return "ACESSO NAO PERMITIDO";
			}

			return gson.toJson(usuario);
		});
	}
	
	private Usuario validar(Usuario usuario){
		if("cris".equals(usuario.getLogin()) && "123".equals(usuario.getSenha())){
			usuario.setNome("Cristhiano");
			return usuario;
		}
		return null;
	}

}
