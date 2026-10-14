package my.webapp.productos;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productosServlet")
public class productosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("productos.jsp")
               .forward(request, response);
    }

    
@Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    double precio = Double.parseDouble(request.getParameter("precio"));
    int stock = Integer.parseInt(request.getParameter("stock"));

    productos producto = new productos(nombre, precio, stock);

    productosDAO dao = new productosDAO();

    boolean registrado = dao.registrarproductos(producto);

    if (registrado) {

        request.setAttribute("productosList", dao.listarProductos());

        request.getRequestDispatcher("/productosList.jsp")
               .forward(request, response);

    } else {
        response.getWriter().println(
            "Error al registrar el producto en la base de datos."
        );
    }
}
}
    
