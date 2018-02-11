package LibraryApp.Dao;

import LibraryApp.Entities.User;
import LibraryApp.Connector.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private MySQLConnector connector;

    public UserDao() {
        connector = MySQLConnector.getInstance();
    }

    public void addUser(User user) {
        PreparedStatement statement = connector.getPreparedStatement("INSERT INTO user VALUES(?,?,?,?)");
        try {
            statement.setNull(1, 0);
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurName());
            statement.setString(4, user.getPhoneNumber());
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAll(){
        PreparedStatement statement = connector.getPreparedStatement("SELECT * FROM `user`");
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("surname: " + rs.getString("surName"));
                System.out.println("phone number: " + rs.getString("phoneNumber"));
            }
            statement.execute();
            statement.closeOnCompletion();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUser(int id){
        PreparedStatement statement = connector.getPreparedStatement("DELETE FROM user WHERE  id=?");
        try {
            statement.setInt(1,id);
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
