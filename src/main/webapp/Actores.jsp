<%@ page import="com.example.laboratorio7.Beans.Actores" %><%--
  Created by IntelliJ IDEA.
  User: victor
  Date: 6/06/2022
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Actores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <h1>Reporte de futuros actores POPCORN S.A.C.</h1>

    <table class="table">
        <thead class="table-primary">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>N° Categorias</th>
                <th>N° Peliculas</th>
            </tr>
        </thead>
        <tbody>
            <%for(Actores actores:listaActores){%>
            <tr>
                <td><%=actores.getId()%></td>
                <td><%=actores.getNombre()%><%actores.getApellido()%></td>
                <td><%=actores.getN_categorias()%></td>
                <td><%=actores.getN_peliculas()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
