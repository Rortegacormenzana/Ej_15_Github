package es.curso.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.BuscarPorNombreControllerEjb;
import es.curso.controllers.ejb.DarAltaClienteControllerEjb;
import es.curso.controllers.ejb.ListarTodosControllerEjb;
import es.curso.model.Entity.Cliente;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/Tienda/*")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TiendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String titulo ="Sin título";
		
		RequestDispatcher rd;
				// de alguna manera hay que enviarle a la vista 
				//el resultado de la consulta a la base de datos... 
				
		switch(action){
		
			case "altaCliente": // se debe redirigir hacia el formulario altaCliente
				rd= request.getRequestDispatcher("/html/altaClienteView.html");
				rd.forward(request, response);
				break;
		
			case "listarTodos": // se invocara al controlador adecuado
							// esta peticion redirige a otra pagina
				ListarTodosControllerEjb todos = new ListarTodosControllerEjb();
				ArrayList<Cliente> clientes = todos.listarTodos();
				request.setAttribute("clientes", clientes);
				titulo="Listado general de clientes";
				request.setAttribute("titulo", titulo);
				rd = request.getRequestDispatcher("/jsp/listarTodos.jsp");
				rd.forward(request, response);				
				break;
			case "buscarPorNombre": // se redigira hacia el formulario buscar por nombre
				rd = request.getRequestDispatcher("/jsp/buscarPorNombre.jsp");
				rd.forward(request, response);			
				break;
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		
		switch(action){
			case "altaCliente": // recuperar los datos tecleados en formulario
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String dni = request.getParameter("dni");
				Cliente cliente = new Cliente(0, nombre, apellido, dni);
				// se invocara al controlador adecuado
				DarAltaClienteControllerEjb controlador= new DarAltaClienteControllerEjb();
				controlador.agregar(cliente);
				rd = request.getRequestDispatcher("/index.html");
				rd.forward(request, response);
				break;
				
			case "buscarPorNombre": // recuperar la cadena tecleada en el formulario
				String cadenaNombre= request.getParameter("name");
				
				// llamar al controlador adecuado 
				BuscarPorNombreControllerEjb controladorBusqueda= new BuscarPorNombreControllerEjb();
				ArrayList<Cliente>resultado = controladorBusqueda.buscarPorNombre(cadenaNombre);
				
				// meter en el request el arraylist de respuesta
				request.setAttribute("clientes",resultado);
				
				// mandarle un titulo diferente 
				request.setAttribute("titulo","Búsqueda por " + cadenaNombre);
				
				// y redirigir hacia el jsp ListarTodos
				rd= request.getRequestDispatcher("jsp/listarTodos.jsp");
				rd.forward(request,response);
		}
	}

}
