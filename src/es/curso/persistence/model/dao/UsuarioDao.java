package es.curso.persistence.model.dao;

import es.curso.model.Entity.Usuario;

public interface UsuarioDao {

	Usuario searchForUserNamePassword(String userName, String password);
	
}
