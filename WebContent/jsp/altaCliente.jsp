<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  header.jsp -->
<%@ include file="../template/header.jsp" %>

    <form action="${pageContext.request.contextPath}/Tienda/altaCliente" method="post" enctype="text/html"> 
  <fieldset>
  <legend style="font-size: 1.3em">ALTA CLIENTE</legend>
  
    <div class="texto">
      <label for="nombre">NOMBRE</label>
    </div>
    <div class="cuadro">
      <input type="text" name="nombre" id="nombre"  />
    </div>
    
    <div class="texto">
      <label for="apellido">APELLIDO</label>
    </div>
    <div class="cuadro">
      <input type="text" name="apellido" id="apellido" />
    </div>
    
    <div class="texto">
      <label>NÚMERO DE DNI</label>
    </div>
    <div class="cuadro">
      <input type="text"  id="dni" name="dni" />
    </div>
    
    <div class="cuadro">
      <input type="hidden"  id="id" name="id" />
    </div>
       
    </fieldset>
    
    <div class="texto">
     <input type="submit" name="enviar" id="enviar" value="Enviar" /> 
     <input type="reset" name="reiniciar" id="reiniciar" value="Reiniciar" />
    </div>
    
  </form>
  <!--  footer.jsp -->
<%@ include file="../template/footer.jsp" %>