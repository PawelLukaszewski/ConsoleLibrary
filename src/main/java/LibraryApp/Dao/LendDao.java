package LibraryApp.Dao;

import LibraryApp.Entities.Lend;
import LibraryApp.Connector.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LendDao {

    private MySQLConnector connector;

    public LendDao() {
        connector = MySQLConnector.getInstance();
    }

    public void addLend(Lend lend) {
        PreparedStatement statement = connector.getPreparedStatement("INSERT INTO lend VALUES(?,?,?,?)");
        try {
            statement.setNull(1, 0);
            statement.setInt(2, lend.getUserID());
            statement.setInt(3, lend.getBookID());
            statement.setNull(4, 0);
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAll() {
        PreparedStatement statement = connector.getPreparedStatement("SELECT * FROM lend");
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("user id: " + rs.getString("user"));
                System.out.println("book id: " + rs.getString("book"));
                System.out.println("Lend date: " + rs.getString("date"));
            }
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeLend(int id) {
        PreparedStatement statement = connector.getPreparedStatement("DELETE FROM lend WHERE  id =? ");
        try {
            statement.setInt(1, id);
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
