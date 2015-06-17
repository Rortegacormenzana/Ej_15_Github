package es.curso.persistence.model.dao;

import java.util.ArrayList;

import es.curso.model.Entity.Cliente;

public interface ClienteDao {
	
	public void create(Cliente cliente);
	
	public ArrayList<Cliente> findAll();
	
	public ArrayList<Cliente> searchByName(String name);
	
	public void update(Cliente cliente);
		
	public void delete(Integer id);
	
	
	

}
