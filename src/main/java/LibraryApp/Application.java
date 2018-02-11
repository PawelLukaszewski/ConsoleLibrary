package LibraryApp;

import LibraryApp.Dao.BookDao;
import LibraryApp.Dao.LendDao;
import LibraryApp.Dao.UserDao;
import LibraryApp.Entities.Book;
import LibraryApp.Entities.Lend;
import LibraryApp.Entities.User;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("-Choose option-");
        System.out.println("1.Add new user." + "\n" + "2.Remove user." + "\n" + "3.Show all users.");
        System.out.println("4.Add new book." + "\n" + "5.Remove book." + "\n" + "6.Show all books.");
        System.out.println("7.Add new lend." + "\n" + "8.Remove lend." + "\n" + "9.Show all lends.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (number != 0) {
            switch (number) {
                case 1: {
                    addUser();
                    return;
                }
                case 2: {
                    removeUser();
                    return;
                }
                case 3: {
                    UserDao getAllDao = new UserDao();
                    getAllDao.getAll();
                    return;
                }
                case 4: {
                    addBook();
                    return;
                }

                case 5: {
                    removeBook();
                    return;
                }
                case 6: {
                    BookDao getAllBooks = new BookDao();
                    getAllBooks.getAll();
                    return;
                }
                case 7: {
                    addLend();
                    return;
                }
                case 8: {
                    removeLend();
                    return;
                }
                case 9: {
                    LendDao getallDao = new LendDao();
                    getallDao.getAll();
                }
                return;
            }
        }
    }

    public static void addUser() {
        Scanner addUserScanner = new Scanner(System.in);
        System.out.print("Enter the user name: ");
        String name = addUserScanner.nextLine();
        System.out.print("Enter the user surname: ");
        String surName = addUserScanner.nextLine();
        System.out.print("Enter the user phone number: ");
        String phoneNumber = addUserScanner.nextLine();
        User user = new User(name, surName, phoneNumber);
        addUserScanner.close();
        UserDao uDao = new UserDao();
        uDao.addUser(user);
    }

    public static void removeUser() {

        Scanner removeUserScanner = new Scanner(System.in);
        System.out.print("Enter the user ID: ");
        int ID = removeUserScanner.nextInt();
        UserDao removeUserDao = new UserDao();
        removeUserDao.removeUser(ID);
    }

    public static void addBook() {
        Scanner addBookScanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = addBookScanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = addBookScanner.nextLine();
        System.out.print("Enter the book published year: ");
        String publishedYear = addBookScanner.nextLine();
        Book book = new Book(title, author, publishedYear);
        addBookScanner.close();
        BookDao bDao = new BookDao();
        bDao.addBook(book);
    }

    public static void removeBook() {
        Scanner removeBookScanner = new Scanner(System.in);
        System.out.print("Enter the book id: ");
        int ID = removeBookScanner.nextInt();
        BookDao removeBook = new BookDao();
        removeBook.removeBook(ID);
        removeBookScanner.close();
    }

    public static void addLend() {
        Scanner addLendScanner = new Scanner(System.in);
        System.out.print("Enter the user id: ");
        int userID = addLendScanner.nextInt();
        System.out.print("Enter the book id: ");
        int bookID = addLendScanner.nextInt();
        Lend lend = new Lend(userID, bookID);
        LendDao lDao = new LendDao();
        lDao.addLend(lend);
    }

    public static void removeLend() {
        Scanner removeLend = new Scanner(System.in);
        System.out.print("Enter the lend ID: ");
        int ID = removeLend.nextInt();
        LendDao lDao = new LendDao();
        lDao.removeLend(ID);
    }
}
