<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TIENDA MOLA SHOP</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
</head>
<body>

<header>
    <nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/Tienda/altaCliente">Alta Cliente</a></li>
        <li><a href="${pageContext.request.contextPath}/Tienda/listarTodos">Listar todos</a></li>
        <li><a href="${pageContext.request.contextPath}/Tienda/buscarPorNombre">Buscar por nombre</a></li>
        <li><a href="${pageContext.request.contextPath}/Tienda/eliminarPorId">Eliminar cliente por ID</a></li>
        <li><a href="${pageContext.request.contextPath}/Tienda/login">LOGIN</a></li>
    </ul>
    </nav>

</header> 