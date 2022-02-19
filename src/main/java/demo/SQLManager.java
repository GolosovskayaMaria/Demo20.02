package demo;

import java.sql.*;
import java.util.LinkedList;

public class SQLManager {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/...", "root", "12345");
    }

    public static LinkedList<ClientEntity> selectAll() throws SQLException {
        LinkedList <ClientEntity> list = new LinkedList<ClientEntity>();
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet client = st.executeQuery("SELECT * FROM ...");

        while (client.next()) {
            ClientEntity e = new ClientEntity(
                    client.getInt("..."),
                    client.getString("..."),
                    client.getDouble("..."),
                    client.getDate("...")
            );
            list.add(e);
        }
        return list;
    }
}
