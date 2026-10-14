
package my.webapp.productos;

import my.webapp.database.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productosDAO {

    public boolean registrarproductos(productos productos) {

        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";

        database db = new database();

        try {
            Connection conn = db.getConnection();

            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, productos.getNombre());
                ps.setDouble(2, productos.getPrecio());
                ps.setInt(3, productos.getStock());

                return ps.executeUpdate() > 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        } finally {
            db.Close();
        }
    }
    
    public List<productos> listarProductos() {

    List<productos> lista = new ArrayList<>();

    String sql = "SELECT * FROM productos";

    database db = new database();

    try {
        Connection conn = db.getConnection();

        if (conn == null) {
            return lista;
        }

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                productos p = new productos();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));

                lista.add(p);
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();

    } finally {
        db.Close();
    }

    return lista;
}
    
}