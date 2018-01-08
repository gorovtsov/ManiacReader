package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.controller.command.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.UserService;

public class ChangeRoleCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String login = request.getParameter("userToChange");
		String role = request.getParameter("roleToSet");
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
				
		
		String goToPage = null;
		try {
			userService.changeRole(login, role);
			goToPage="/WEB-INF/jsp/main.jsp";
		}catch (ServiceException e){
			goToPage="error.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);
		
	}
	
}
