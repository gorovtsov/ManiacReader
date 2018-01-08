package by.htp.library.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.bean.Book;
import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;

public class GetAllBooksCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		List<Book> books = null;
		String goToPage = null;

		try {
			books = bookService.getAllBooks();

		} catch (ServiceException e) {
			goToPage = "error.jsp";
		}

		if (books != null) {
			request.setAttribute("books", books);
			goToPage = "/WEB-INF/jsp/search/books.jsp";
		} else {
			goToPage = "error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);

	}

}
