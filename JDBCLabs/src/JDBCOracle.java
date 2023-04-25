import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracle {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//ИМЯ_СЕРВЕРА:ПОРТ/ИМЯ_СЕРВИСА", "GUEST", null);
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getUserName());
        conn.close();
    }
}
