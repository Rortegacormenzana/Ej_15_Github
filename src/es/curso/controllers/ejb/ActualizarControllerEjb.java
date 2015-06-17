package es.curso.controllers.ejb;

import es.curso.controllers.ActualizarController;
import es.curso.model.Entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class ActualizarControllerEjb implements ActualizarController{

	@Override
	public void actualizar(Cliente cliente) {
		ClienteDao clienteDao = new ClienteDaoJdbc();
		// 1. comprobar si esta autorizado a modificar
		clienteDao.update(cliente);
		// enviar email al cliente
		// enviar email a la seguridad social por ejemplo
		
	}

}
