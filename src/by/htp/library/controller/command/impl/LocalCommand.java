package by.htp.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.library.controller.command.Command;

public class LocalCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession(true).setAttribute("local", request.getParameter("local"));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
