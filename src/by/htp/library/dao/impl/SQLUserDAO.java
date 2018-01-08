package by.htp.library.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO {

	public static final String URL = "jdbc:mysql://localhost:3306/library_db";
	public static final String USER = "root";
	public static final String PASSWORD = "Gfhjkm123";

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}

	}

	@Override
	public User logination(String login, String password) throws DAOException {

		User user = null;
		String sqlQuery = "SELECT * FROM user_data WHERE login = ? AND password = ? ;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, login);
			statement.setString(2, password);

			rs = statement.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt(1);
			int birthYear = rs.getInt(7);
			String email = rs.getString(4);
			String name = rs.getString(5);
			String surname = rs.getString(6);
			String role = rs.getString(8);

			user = new User(id, login, password, email, name, surname, birthYear, role);

		} catch (SQLException e) {
			throw new DAOException("Can't check authorization parameters", e);
		} finally {
			closeConnection(rs, statement, connection);
		}

		return user;
	}

	@Override
	public void registration(User user) throws DAOException {

		String sqlQuery = "CALL registration(?, ?, ?, ?, ?, ?);";

		Connection connection = null;
		CallableStatement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareCall(sqlQuery);

			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getName());
			statement.setString(5, user.getSurname());
			statement.setInt(6, user.getBirthYear());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("DAO encured an error!", e);
		} finally {
			closeConnection(statement, connection);
		}
	}
	
	@Override
	public void changeRole(String login, String role) throws DAOException {
		String sqlQuery = "CALL change_user_role(?, ?);";
		Connection connection = null;
		CallableStatement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareCall(sqlQuery);

			statement.setString(1, login);
			statement.setString(2, role);


			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("DAO encured an error!", e);
		} finally {
			closeConnection(statement, connection);
		}
		
	}
	
	@Override
	public void changeEmail(String login, String email) throws DAOException {
		String sqlQuery = "CALL change_email(?, ?);";
		Connection connection = null;
		CallableStatement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareCall(sqlQuery);

			statement.setString(1, login);
			statement.setString(2, email);


			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("DAO encured an error!", e);
		} finally {
			closeConnection(statement, connection);
		}
	}
	@Override
	public List<User> getAllUsers() throws DAOException {
		List<User> users = new ArrayList<>();
		User user = null;
		String sqlQuery = "SELECT * FROM user_data;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement(sqlQuery);

			rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int birthYear = rs.getInt(7);
				String login = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String name = rs.getString(5);
				String surname = rs.getString(6);
				String role = rs.getString(8);

				user = new User(id, login, password, email, name, surname, birthYear, role);

				users.add(user);
			}

		} catch (SQLException e) {
			throw new DAOException("Can't check authorization parameters", e);
		} finally {
			closeConnection(rs, statement, connection);
		}

		return users;
	}

	private void closeConnection(ResultSet rs, Statement st, Connection con) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error while closing resultSet.");
		}

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Error while closing statement.");
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing connection.");
		}
	}

	private void closeConnection(Statement st, Connection con) {

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Error while closing statement.");
		}

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing connection.");
		}
	}

	

}
