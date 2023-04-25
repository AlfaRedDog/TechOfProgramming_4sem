import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", null);
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getUserName());

        conn.close();
    }
}
