package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.curso.model.Entity.Usuario;
import es.curso.persistence.model.dao.UsuarioDao;

public class UsuarioDaoJdbc implements UsuarioDao {

	private Connection cx;

	// metodo searchForUserNamePassword
	@Override
	public Usuario searchForUserNamePassword(String userName, String password) {
		
		Usuario usuario= null;
		try {
			// 1. abrir conexion
			abrirConexion();
			
			// 2. preparar sentencias
			PreparedStatement ps = cx.prepareStatement
					("SELECT * FROM usuario WHERE userName=? AND password=?");
			// 2.1 rellenar los ?
			ps.setString(1, userName);
			ps.setString(2, password);
			
			// 3. ejecutar la sentencia
			ResultSet consulta = ps.executeQuery();
			if(consulta.next()){
				// traspasar los datos de resultset al usuario
				usuario = new Usuario();
				usuario.setId(consulta.getInt("id"));
				usuario.setNombre(consulta.getString("nombre"));
				usuario.setApellidos(consulta.getString("apellidos"));
				usuario.setUserName(consulta.getString("userName"));
				usuario.setPassword(consulta.getString("password"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			cerrarConexion();
		}
		return usuario;
	}

	// metodo Abrir Conexion
	private void abrirConexion(){
		// 1. determinar y validar si tengo el driver o conector (de mysql)
		try {
			Class.forName("com.mysql.jdbc.Driver");
		// 2. establecer conexion	
			cx= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Tienda", // localizcion de base de datos
					"rootTienda", // usuario
					"rootTienda" // contraseña
					);
		// 3. Iniciar el autoCommit en false
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// metodo Cerrar Conexion
	private void cerrarConexion(){
		try {
			if(cx!=null)
			cx.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
}
