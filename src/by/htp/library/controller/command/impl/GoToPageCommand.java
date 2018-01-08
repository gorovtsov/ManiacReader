package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.controller.command.Command;

public class GoToPageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goToPage;
		RequestDispatcher dispatcher;
		
		try {			
			goToPage=request.getParameter("destinationPage");
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		}catch (Exception e) {
			goToPage="error.jsp";
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		}
	}
}
