package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.curso.model.Entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{
	private Connection cx;
	
// constructor vacio	
	public ClienteDaoJdbc() {
		super();
		
	}

	@Override
	public void create(Cliente cliente) {
		try {
			//instrucciones para conectar con la base de datos
			// 1. abrir conexion
			abrirConexion();
			
			// 2. preparar la sentencia (sql) para agregar
			PreparedStatement ps= 
				cx.prepareStatement	("INSERT INTO CLIENTE VALUES (?,?,?,?)");
				// 2.1 Insertar los datos de cliente en los ?
				ps.setInt(1, 0); // el id lo genera la base de datos automaticamente, ponemos 0 por poner algo
				ps.setString(2, cliente.getNombre()); // nombre es Varchar en SQL, String para Java
				ps.setString(3, cliente.getApellidos()); 
				ps.setString(4, cliente.getDni());
				
			// 3. ejecutar la sentencia (sql) 
				ps.executeUpdate(); // = dar al play en Heidi
				// nota: se usa executeUpdate() para las instrucciones sql 
				// como: insert delete update
				// Esta instruccion devuelve como resultado el numero de registros
				// (o filas) afectadas
				
				//3.1 Hacer Commit
				
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		finally{
		// 4. cerrar la conexion
		cerrarConexion();
		}
	}

	@Override
	public ArrayList<Cliente> findAll() {	
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			// 1. abrir la conexion
			abrirConexion();
			
			// 2. preparar las sentencias
			PreparedStatement ps= cx.prepareStatement("SELECT * FROM CLIENTE");
			
			// 3. ejecutar las sentencias
			ResultSet consulta = ps.executeQuery();
			
			// 3.1 traspasar los datos de la respuesta al arrayList
			while(consulta.next()){
				Cliente clienteTemporal = new Cliente();
				// codigo para traspasar de la consulta(resultSet) hacia el clienteTemporal
				clienteTemporal.setId(consulta.getInt("id"));// lo que esta entre comillas es el nombre del atributo de la base de datos
				clienteTemporal.setNombre(consulta.getString("nombre"));
				clienteTemporal.setApellidos(consulta.getString("apellidos"));
				clienteTemporal.setDni(consulta.getString("dni"));
				
				clientes.add(clienteTemporal);
			}
			
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		finally {
		// 4. cerrar la conexion
		return clientes;
		}
	}

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
			// cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void cerrarConexion(){
		try {
			if(cx!=null)
			cx.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Cliente> searchByName(String name) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			//1. establecer la conexion con la bbdd
			abrirConexion();
			
			//2. preparar la sentencia sql parametrizada
			PreparedStatement ps= cx.prepareStatement("SELECT * FROM CLIENTE WHERE nombre LIKE ?");
			// 2.1 especificar lo que va en ?
			ps.setString(1, "%" + name+"%");
			
			//3. ejecutar la query
			ResultSet resultado = ps.executeQuery();
			
			// 3.1 pasar los datos que vienen de la bbdd (resultSet) hacia
			// el ArrayList<Cliente>
			while(resultado.next()){
				Cliente c= new Cliente();
					c.setId(resultado.getInt("id"));	
					c.setNombre(resultado.getString("nombre"));
					c.setApellidos(resultado.getString("apellidos"));
					c.setDni(resultado.getString("dni"));
				clientes.add(c);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
		//4. cerrar la conexion (finally)
			
		}
		return clientes;
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}

