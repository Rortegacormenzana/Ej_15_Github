<%@page import="es.curso.model.Entity.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar clientes</title>
<link rel="stylesheet" href="../css/estilos.css">

</head>
<body>
    <h1><%= request.getAttribute("titulo") %></h1>
   <!-- tabla html, dinamica -->
   
   <span><%=LocalDateTime.now() %></span>
   <span>Valor enviado desde el servlet Tienda IVA: </span>
   <span><%= (Integer)(request.getAttribute("iva")) %></span>
   <% ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("clientes");%>
   
   
   <table>
      <tr>
         <th>ID</th>
         <th>NOMBRE</th>
         <th>APELLIDOS</th>
         <th>DNI</th>        
      </tr>
     <% for(Cliente c: clientes){ %>
        <form action="${pageContext.request.contextPath}/Tienda/eliminarPorId" method="post" name="eliminarPorId" distabled="disabled" enctype="text/html">
    	 <tr id="<%= c.getId()%>"/>
    	   <td><input type="text" name="id" value="<%= c.getId()%>"/></td>
    	   <td><%= c.getId() %></td>
    	   <td><%= c.getNombre() %></td>
    	   <td><%= c.getApellidos() %></td>
    	   <td><%= c. getDni() %></td>   
    	   <td><input class="btnSinBordes" type="submit" value="Eliminar" 
    	       name="btn<%= c.getId()%>"/></td> 	   
    	 </tr>
        </form>
     <% } %>
     
     
     
     
      <!--  las siguientes tr se construyen dinamicamente usando instrucciones java-->
   </table>

</body>
</html>