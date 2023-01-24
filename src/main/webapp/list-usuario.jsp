<%-- 
    Document   : list-usuario
    Created on : 24/01/2023, 4:53:34 a. m.
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
            <h4 class="text-center">lista de usuarios</h4>
            <a href="<%=request.getContextPath()%>/newUser" class="btn btn-outline-dark">Nuevo usuario</a>
            <table class="table table-sm table-dark table-striped table-hover mt-1">
                <thead>
                    <th>id</th>
                    <th>nombre</th>
                    <th>usuario</th>
                    <th>clave</th>
                    <th>acciones</th>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${listUsuarios}">
                        <tr>
                            <td>
                                <c:out value="${usuario.getId()}" />
                            </td>
                            <td>
                                <c:out value="${usuario.getNombre()}" />
                            </td>
                            <td>
                                <c:out value="${usuario.getUsuario()}" />
                            </td>
                            <td>
                                <c:out value="${usuario.getClave()}" />
                            </td>
                            <td>
                                <a href="edit?codigo=<c:out value='${usuario.id}'/>" class="btn btn-outline-success">Editar</a>
                                <a href="delete?codigo=<c:out value='${usaurio.id}' />" class="btn btn-outline-danger">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
