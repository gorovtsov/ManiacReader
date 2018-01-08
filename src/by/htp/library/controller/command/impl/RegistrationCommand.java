package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.bean.User;
import by.htp.library.controller.command.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goToPage;
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));

		User user = new User(login, password, email, name, surname, birthYear);

		try {
			userService.registration(user);
			goToPage = "index.jsp";
		} catch (ServiceException e) {
			e.printStackTrace(); //stub
			goToPage = "error.jsp";
		}
		
		request.getRequestDispatcher(goToPage).forward(request, response);
	}
}
