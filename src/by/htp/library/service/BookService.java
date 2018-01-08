package by.htp.library.service;

import java.util.List;

import by.htp.library.bean.Book;

public interface BookService {
	List<Book> getAllBooks() throws ServiceException;
	void addBook(Book book) throws ServiceException;
}
