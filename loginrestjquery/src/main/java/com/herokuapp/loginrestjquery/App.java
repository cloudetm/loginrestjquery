package com.herokuapp.loginrestjquery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.herokuapp.loginrestjquery.bean.Usuario;

import spark.Spark;

public class App {
	
	private static Gson GSON = new GsonBuilder().create();
	
	public static void main( String[] args ) {
		
		Spark.get("/ping", (request, response) -> "pong");
		
		Spark.post("/user",  (request, response) -> {
			Usuario usuario = null;
			try {
				usuario = GSON.fromJson(request.body(), Usuario.class);
			} catch (Exception e) {
				response.status(400);
				return "INVALID JSON";
			}
			return GSON.toJson(usuario);
		});
		
		Spark.before((request,response)->{
    		response.header("Access-Control-Allow-Origin", "*");
    	});

	}
}
