import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author decodigo
 */
public class ConectarBD1 {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL_CONEXION = "jdbc:postgresql://free-tier14.aws-us-east-1.cockroachlabs.cloud:26257/wilted-ayeaye-943.defaultdb";
    public static void main(String args[]) throws SQLException {
        final String usuario = "sai";
        final String password = "krK0TdZqokc0fqahjqgY1Q";
        Connection dbConnection = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
            String selectTableSQL = "SELECT * FROM artefactos";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int medida = rs.getInt("medida");
                int lugar = rs.getInt("lugar");
                System.out.println("id : " + id);
                System.out.println("nombre : " + nombre);
                System.out.println("nombre : " + medida);
                System.out.println("nombre : " + lugar);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
