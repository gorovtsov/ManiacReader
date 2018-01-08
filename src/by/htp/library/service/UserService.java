package by.htp.library.service;

import java.util.List;

import by.htp.library.bean.User;

public interface UserService {
	
	User logination(String login, String password) throws ServiceException;
	void registration(User user) throws ServiceException;
	List<User> getAllUsers() throws ServiceException;
	void changeRole(String login, String role) throws ServiceException;
	void changeEmail(String login, String email) throws ServiceException;
}
