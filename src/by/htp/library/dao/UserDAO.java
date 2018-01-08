package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOException;

public interface UserDAO {
	
	User logination(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;
	List<User> getAllUsers() throws DAOException;
	void changeRole(String login, String role) throws DAOException;
	void changeEmail(String login, String email) throws DAOException;
}
