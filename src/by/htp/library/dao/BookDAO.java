package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOException;

public interface BookDAO {

	List<Book> getAllBooks() throws DAOException;
	void addBook(Book book) throws DAOException;
	void addAuthor(String name) throws DAOException;
	boolean isAuthorExist(String name) throws DAOException;

}
