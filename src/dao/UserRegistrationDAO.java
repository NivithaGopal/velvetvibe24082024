package dao;

import java.sql.*;
import java.sql.SQLException;

import bean.UserRegistration;
import dbconnection.DBConnection;

public class UserRegistrationDAO {
	
	
	 public void insertUser(UserRegistration user) throws SQLException {
	        String query = "INSERT INTO user_registration (fullName, dob, email, password) VALUES (?, ?, ?, ?)";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setString(1, user.getFullName());
	            statement.setDate(2, new java.sql.Date(user.getDob().getTime()));
	            statement.setString(3, user.getEmail());
	            statement.setString(4, user.getPassword());

	            statement.executeUpdate();
	        }
	    }


}
