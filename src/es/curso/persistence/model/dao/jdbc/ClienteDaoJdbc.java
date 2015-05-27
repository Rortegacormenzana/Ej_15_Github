package es.curso.persistence.model.dao.jdbc;

import java.util.ArrayList;

import es.curso.model.Entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{

	private ArrayList<Cliente> clientes;
	
// constructor vacio	
	public ClienteDaoJdbc() {
		super();
		clientes = new ArrayList<Cliente>();
	}

	@Override
	public void create(Cliente cliente) {
		//instrucciones para conectar con la base de datos
		// preparar la sentencia (sql) para agregar
		// ejecutar la sentencia (sql) 
		// cerrar la conexion
		clientes.add(cliente);
		
	}

	@Override
	public ArrayList<Cliente> findAll() {
		
		clientes.add(new Cliente(1, "Jose", "Perez", "1242334G"));
		clientes.add(new Cliente(2, "Joselito", "Suarez", "45235624G"));
		clientes.add(new Cliente(3, "Josele", "Rodriguez", "8785454G"));
		clientes.add(new Cliente(4, "Josefa", "Marquez", "7456745G"));
		clientes.add(new Cliente(5, "Jose Luis", "Sanchez", "876546343G"));
		clientes.add(new Cliente(6, "Jose María", "Ordoñez", "45235232G"));
		clientes.add(new Cliente(7, "Jose Angel", "Juarez", "525232G"));
		clientes.add(new Cliente(8, "Jose Antonio", "Perez", "213412341G"));
		clientes.add(new Cliente(9, "Jose Javier", "Jimenez", "967845647G"));
		clientes.add(new Cliente(10, "Jose Francisco", "Gimenez", "64534563G"));
		
		return clientes;
	}

}
