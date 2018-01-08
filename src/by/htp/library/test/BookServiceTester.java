package by.htp.library.test;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class BookServiceTester {
	public static void main(String[] args) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();
		
		List<Book> books = bookService.getAllBooks();
		
		for (Book book: books) {
			System.out.println(book.toString());
		}
	}
}
