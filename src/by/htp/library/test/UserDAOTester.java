package by.htp.library.test;

import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;

public class UserDAOTester {
	public static void main(String[] args) throws DAOException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		//Logination testing
	/*	User user = userDAO.logination("garavek", "BNMhgf765");
		System.out.println(user.toString());*/
		
		//registration testing
		//userDAO.registration(new User("olaf29", "apenka1", "alala@tut.com", "Валик", "Фенькин", 1975));
		
		List<User> users = userDAO.getAllUsers();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
}
