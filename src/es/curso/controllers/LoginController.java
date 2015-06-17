package es.curso.controllers;

import es.curso.model.Entity.Usuario;

public interface LoginController {

	Usuario login(String userName, String password);
	
}
