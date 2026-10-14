

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar productos</title>
</head>
<body>

    <h1>Registrar nuevo producto</h1>

    <form action="productosServlet" method="post">

        <label>Nombre del producto:</label>
        <input type="text" name="nombre" required>
        <br><br>

        <label>Precio:</label>
        <input type="number" name="precio"
               step="0.01" min="0" required>
        <br><br>

        <label>Stock:</label>
        <input type="number" name="stock"
               min="0" step="1" required>
        <br><br>

        <button type="submit">Registrar producto</button>

    </form>

</body>
</html>