<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--  header.jsp -->
<%@ include file="template/header.jsp" %>
<h1>LOGIN TIENDA MOLASHOP</h1>

 <form action="${pageContext.request.contextPath}/Tienda/login" method="post" enctype="text/html"> 
  <fieldset>
  <legend style="font-size: 1.3em">LOGIN USUARIO</legend>
  
    <div class="texto">
      <label for="userName">Usuario: </label>
    </div>
    <div class="cuadro">
      <input type="text" name="userName" id="userName" value="" />
    </div>
    
    <div class="texto">
      <label for="password">Contraseña</label>
    </div>
    <div class="cuadro">
      <input type="password" name="password" id="password" value="" />
    </div>
    
           
    </fieldset>
    
    <div class="texto">
     <input type="submit" name="login" id="login" value="Login" /> 
    </div>
    
  </form>








<!--  footer.jsp -->
<%@ include file="template/footer.jsp" %>