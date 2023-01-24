<%-- 
    Document   : list-carrito
    Created on : 24/01/2023, 6:26:56 a. m.
    Author     : edyns
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="nav-admin.jsp" />
        <div class="container mt-3">
            <h4 class="text-center">Lista de productos</h4>
            <a href="<%=request.getContextPath()%>/usuario/new" class="btn btn-outline-dark">Nuevo usuario</a>
            <table class="table table-sm table-dark table-striped table-hover mt-1">
                <thead>
                    <th>id</th>
                    <th>id-producto</th>
                    <th>id-usuario</th>
                    <th>acciones</th>
                </thead>
                <tbody>
                    <c:forEach var="car" items="${listCar}">
                        <tr>
                            <td>
                                ${car.getId()}
                            </td>
                            <td>
                                ${car.getIdProducto().getCodigo()}
                            </td>
                            <td>
                                ${car.getIdUsuario().getId()}
                            </td>
                            <td>
                                <a href="editProduct?codigo=<c:out value='${producto.codigo}'/>" class="btn btn-outline-success">Editar</a>
                                <a href="deleteProduct?codigo=<c:out value='${producto.codigo}' />" class="btn btn-outline-danger">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
