package LibraryApp.Dao;

import LibraryApp.Entities.Book;
import LibraryApp.Connector.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

    private MySQLConnector connector;

    public BookDao() {
        connector = MySQLConnector.getInstance();
    }

    public void addBook(Book book) {
        PreparedStatement statement = connector.getPreparedStatement("INSERT INTO book VALUES(?,?,?,?)");
        try {
            statement.setNull(1, 0);
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublishedYear());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getAll(){
        PreparedStatement statement = connector.getPreparedStatement("SELECT * FROM `book`");
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Published Year: " + rs.getString("publishedYear"));
            }
            statement.execute();
            statement.closeOnCompletion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeBook(int id){
        PreparedStatement statement = connector.getPreparedStatement("DELETE FROM book WHERE id=?");
        try {
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
