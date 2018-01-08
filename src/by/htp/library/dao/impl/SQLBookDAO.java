package by.htp.library.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.exception.DAOException;

public class SQLBookDAO implements BookDAO {

	public static final String URL = "jdbc:mysql://localhost:3306/library_db";
	public static final String USER = "root";
	public static final String PASSWORD = "Gfhjkm123";

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}

	}

	@Override
	public List<Book> getAllBooks() throws DAOException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		String sqlQuery = "SELECT * FROM book_data;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement(sqlQuery);

			rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int pagesCount = rs.getInt(8);
				int printYear = rs.getInt(9);
				int amount = rs.getInt(10);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				String genre = rs.getString(5);
				String format = rs.getString(6);
				String cover = rs.getString(7);	

				book = new Book(id, title, author, publisher, genre, format, cover, pagesCount, printYear, amount);

				books.add(book);
			}

		} catch (SQLException e) {
			throw new DAOException("Can't check authorization parameters", e);
		} finally {
			closeConnection(rs, statement, connection);
		}

		return books;
	}
	
	public void addBook(Book book) throws  DAOException{
		String sqlQuery = "CALL add_book(?, ?, ?, ?, ?, ?, ?, ?);";

		Connection connection = null;
		CallableStatement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareCall(sqlQuery);

			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getPublisher());
			statement.setString(4, book.getGenre());
			statement.setString(5, book.getFormat());
			statement.setString(6, book.getCover());
			statement.setInt(7, book.getPagesCount());
			statement.setInt(8, book.getPrintYear());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("DAO encured an error!", e);
		} finally {
			closeConnection(statement, connection);
		}
	}
	
	@Override
	public  void addAuthor(String name) throws DAOException {
		String sqlQuery = "INSERT INTO `library_db`.`authors` (`name`) VALUES (?);";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		
		try {
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1, name);
			
			rs = statement.executeQuery();


		} catch (SQLException e) {
			throw new DAOException("Can't check authorization parameters", e);
		} finally {
			closeConnection(rs, statement, connection);
		}
	}
	
	public boolean isAuthorExist(String name) throws DAOException {

		String sqlQuery = "SELECT * FROM library_db.authors WHERE name = ?;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		
		try {
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1, name);
			
			rs = statement.executeQuery();


		} catch (SQLException e) {
			throw new DAOException("Can't check authorization parameters", e);
		} finally {
			closeConnection(rs, statement, connection);
		}
		
		if (rs!= null) {
			return true;
		}
		
		return false;	
	}
	
	private void closeConnection(ResultSet rs, Statement st, Connection con) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error while closing resultSet.");
		}

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Error while closing statement.");
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing connection.");
		}
	}

	private void closeConnection(Statement st, Connection con) {

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Error while closing statement.");
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing connection.");
		}
	}


}
