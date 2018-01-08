package by.htp.library.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.bean.User;
import by.htp.library.controller.command.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;

public class GetAllUsersCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();

		List<User> users = null;
		String goToPage = null;

		try {
			users = userService.getAllUsers();
		} catch (ServiceException e) {
			goToPage = "error.jsp";
		}

		if (users != null) {
			request.setAttribute("users", users);
			goToPage = "/WEB-INF/jsp/search/users.jsp";
		} else {
			goToPage = "error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);
	}

}
