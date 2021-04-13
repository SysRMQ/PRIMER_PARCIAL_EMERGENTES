<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Pacientes"%>
<%@page import="com.emergentes.modelo.GestorPacientes"%>

<%
    if(session.getAttribute("vacunas") == null){
        GestorPacientes objeto1 = new GestorPacientes();
        objeto1.insertarPaciente(new Pacientes(1, "Brunito Diaz", 25, 1.40, "Si"));
        objeto1.insertarPaciente(new Pacientes(2, "Juancito Pinto", 30, 1.52, "No"));
        
        session.setAttribute("vacunas", objeto1);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vacunas</title>
    </head>
    <body>
        <table border="1">
            <th>
                <p>PRIMER PARCIAL TEM-742</p>
                <p>Nombre: Gilmer Ruddy Mamani Quenta</p>
                <p>Carnet: 9258381 Lp</p>
            </th>
            <br><br>
        </table>
        <h1>Registro de vacunas</h1>
        <a href="controlador?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Talla</th>
                <th>Vacuna</th>
                <th>Modificar</th>
                <th>Cantidad</th>
            </tr>
            <c:forEach var="item" items="${sessionScope.vacunas.getLista()}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.peso}</td>
                    <td>${item.talla}</td>
                    <td>${item.vacuna}</td>
                    <td><a href="controlador?op=editar&id=${item.id}">Editar</a></td>
                    <td><a href="controlador?op=eliminar&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
