<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  header.jsp -->
<%@ include file="../template/header.jsp" %>

   <form action="${pageContext.request.contextPath}/Tienda/eliminarPorId" method="post" name="eliminarPorId" enctype="text/html"> 
   <fieldset>
    <legend style="font-size: 1.3em">ELIMINAR POR ID</legend>
   
      <div class="texto">
      <label for="nombre">ID</label>
    </div>
    <div class="cuadro">
      <input type="text" name="id" id="id"  />
    </div>
    
    <div class="texto">
     <input type="submit" name="eliminar" id="eliminar" value="Eliminar" /> 
     <input type="reset" name="reiniciar" id="reiniciar" value="Reiniciar" />
    </div>
   
   </fieldset>
   </form>


      <!--  footer.jsp -->
<%@ include file="../template/footer.jsp" %>