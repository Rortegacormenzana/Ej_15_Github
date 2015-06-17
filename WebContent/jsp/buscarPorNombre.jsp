<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  header.jsp -->
<%@ include file="../template/header.jsp" %>

   <form action="${pageContext.request.contextPath}/Tienda/buscarPorNombre" method="post" name="buscarPorNombre" enctype="text/html"> 
   <fieldset>
    <legend style="font-size: 1.3em">BUSCAR POR NOMBRE</legend>
   
      <div class="texto">
      <label for="nombre">NOMBRE</label>
    </div>
    <div class="cuadro">
      <input type="text" name="nombre" id="nombre"  />
    </div>
    
    <div class="texto">
     <input type="submit" name="enviar" id="enviar" value="Enviar" /> 
     <input type="reset" name="reiniciar" id="reiniciar" value="Reiniciar" />
    </div>
   
   </fieldset>
   </form>

      <!--  footer.jsp -->
<%@ include file="../template/footer.jsp" %>