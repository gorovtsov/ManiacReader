package by.htp.library.test;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.exception.DAOException;

public class BookDAOTester {

	public static void main(String[] args) throws DAOException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAO();
		
		List<Book> books = dao.getAllBooks();
		
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

}
