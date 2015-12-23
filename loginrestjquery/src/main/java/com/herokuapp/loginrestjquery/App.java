package com.herokuapp.loginrestjquery;

import spark.Spark;

public class App {
	
	public static void main( String[] args ) {
		
		Spark.get("/ping", (request, response) -> "pong");
		
		Spark.before((request,response)->{
    		response.header("Access-Control-Allow-Origin", "*");
    	});
		
		UserController.initRoutes();

	}
}
