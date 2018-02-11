package LibraryApp.Entities;

public class Lend {
    private int userID;
    private int bookID;

    public Lend(int userID, int bookID) {
        this.userID = userID;
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }


}
