package by.htp.library.service.impl;

import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.ServiceException;
import by.htp.library.service.UserService;
import by.htp.library.service.validation.Validator;

public class UserServiceImpl implements UserService{
	
	@Override
	public User logination(String login, String password) throws ServiceException {
		if (login == null || login.isEmpty()) {
			return null;
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		
		UserDAO userDAO = daoFactory.getUserDAO();
		
		User user = null;
		try {
			user = userDAO.logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Logination service error.", e);
		}

		return user;
	}

	@Override
	public void registration(User user) throws ServiceException {
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		Validator validator = Validator.getInstance();
		
		try {
			if(validator.validateEmail(user.getEmail()))
			userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException("Registration service error", e);
		}
	}

	@Override
	public void changeRole(String login, String role) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.changeRole(login, role);;
		} catch (DAOException e) {
			throw new ServiceException("Registration service error", e);
		}
		
	}
	
	@Override
	public void changeEmail(String login, String email) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.changeEmail(login, email);;
		} catch (DAOException e) {
			throw new ServiceException("Registration service error", e);
		}
		
	}
	
	@Override
	public List<User> getAllUsers() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		List<User> allUsers = null;
		try {
			allUsers = userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		return allUsers;
	}


}