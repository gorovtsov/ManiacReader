package by.htp.library.service.impl;


import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> getAllBooks() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoFactory.getBookDAO();
		List<Book> allBooks = null;
		
		try {
			allBooks = bookDAO.getAllBooks();
		} catch (DAOException e) {
			throw new ServiceException("Error get all books service.");
		}
		
		return allBooks;
	}
	
	@Override
	public void addBook(Book book) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoFactory.getBookDAO();
		
		try {
			if(!bookDAO.isAuthorExist(book.getAuthor())) {
				bookDAO.addAuthor(book.getAuthor());
			}
			
			bookDAO.addBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException("SERVICE EXCEPTION: Cannot get data from book DAO", e);
		}
	}
}
