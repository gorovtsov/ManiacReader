package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.bean.Book;
import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class AddBookCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goToPage;
		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		String title = request.getParameter("login");
		String author = request.getParameter("password");
		String publisher = request.getParameter("email");
		String genre = request.getParameter("name");
		String format = request.getParameter("surname");
		String cover = request.getParameter("birthYear");
		int pagesCount = Integer.parseInt(request.getParameter("pagesCount"));
		int printYear = Integer.parseInt(request.getParameter("printYear"));

		Book book = new Book(title, author, publisher, genre, format, cover, pagesCount, printYear);

		try {
			bookService.addBook(book);
			goToPage = "/WEB-INF/jsp/main.jsp";
		} catch (ServiceException e) {
			e.printStackTrace(); //stub
			goToPage = "error.jsp";
		}
		
		request.getRequestDispatcher(goToPage).forward(request, response);
		
	}

}
