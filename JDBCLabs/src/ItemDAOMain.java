import com.javatunes.util.ItemDAO;
import com.javatunes.util.MusicItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class ItemDAOMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", null);
        MusicItem musicItem = new MusicItem(15L, "Me", "I", new java.util.Date(),
                                            new BigDecimal("15.98"), new BigDecimal("16.89"));
        ItemDAO itemDAO = new ItemDAO(conn);
        //System.out.println(itemDAO.searchById(1L).getArtist());
        //System.out.println(itemDAO.searchById(100L).getArtist());

        //Collection<MusicItem> result = itemDAO.searchByKeyword("of");
        //System.out.println(result.size());
        //result = itemDAO.searchByKeyword("Gay");
        //System.out.println(result.size());

        itemDAO.create(musicItem);
    }
}
