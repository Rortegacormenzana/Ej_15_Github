package es.curso.controllers.ejb;

import es.curso.controllers.DarAltaClienteController;
import es.curso.model.Entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class DarAltaClienteControllerEjb implements DarAltaClienteController {
	private ClienteDao clienteDao;
	
	@Override
	public void agregar(Cliente cliente) {
		// Logica del negocio para agregar un cliente
		// Verificar datos, agregarlos (llamar a la capa dao), enviar email etc..
	clienteDao= new ClienteDaoJdbc();
	clienteDao.create(cliente);
	
		
	}
	
	

}
