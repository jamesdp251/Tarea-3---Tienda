
package my.webapp.database;

import java.sql.*;

public class database {

    Connection conn;

    public database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Tienda",
                "root",
                "Admin$1234"
            );

        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(database.class.getName())
                  .log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void Close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.getLogger(database.class.getName())
                  .log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
