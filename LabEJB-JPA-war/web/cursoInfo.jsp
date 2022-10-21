<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="cursoservlet" method="POST">
            <table>
                <tr>
                    <td>ID del curso</td>
                    <td><input type="text" name="cursotId" value="${curso.cursoid}" /></td>
                </tr>
                <tr>
                    <td>Nombre del curso</td>
                    <td><input type="text" name="nombre" value="${curso.nombre}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Numero de estudiantes</td>
                    <td><input type="text" name="estudiantesAdmitidos" value="${curso.estuduantesadmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                        <button>
                            <a href="index.html">Volver</a>
                        </button>
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>nombre</th>
            <th>creditos</th>
            <th>semestre</th>
            <th>estudiantes</th>
                <c:forEach items="${allCursos}" var="curs">
                <tr>
                    <td>${curs.cursoid}</td>
                    <td>${curs.nombre}</td>
                    <td>${curs.creditos}</td>
                    <td>${curs.semestre}</td>
                    <td>${curs.estuduantesadmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
