package es.curso.controllers;

import java.util.ArrayList;

import es.curso.model.Entity.Cliente;

public interface BuscarPorNombreController {
	
	public abstract ArrayList<Cliente> buscarPorNombre(String cadenaNombre);
}
