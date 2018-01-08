package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.library.bean.User;
import by.htp.library.controller.command.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;

public class LoginationCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		User user = null;
		String goToPage="error.jsp";
		
		try {
			user = userService.logination(login, password);
			if(user != null) {
				goToPage="/WEB-INF/jsp/main.jsp";
				session.setAttribute("user", user);
			}
		} catch (ServiceException e) {
			//logging
			request.setAttribute("message", "Logination failed");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);
		
	}

}
