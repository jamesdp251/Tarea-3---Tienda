
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="my.webapp.productos.productos"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos registrados</title>
</head>
<body>

    <h1>Productos registrados correctamente</h1>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>

        <%
            List<productos> lista =
                (List<productos>) request.getAttribute("productosList");

            if (lista != null) {
                for (productos p : lista) {
        %>

        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getPrecio() %></td>
            <td><%= p.getStock() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <br>

    <a href="<%= request.getContextPath() %>/productos.jsp">
        <button type="button">Agregar nuevo</button>
    </a>

</body>
</html>