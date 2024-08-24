<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.UserRegistrationDAO" %>
<%@ page import="bean.UserRegistration" %>

<%
    // Get form parameters
    String fullName = request.getParameter("fullName");
    String dob = request.getParameter("dob");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");

  

    // Create UserRegistration object and set properties
    UserRegistration user = new UserRegistration();
    user.setFullName(fullName);
    user.setDob(java.sql.Date.valueOf(dob));
    user.setEmail(email);
    user.setPassword(password);  // Note: It's recommended to hash the password before storing it

    // Create DAO instance
    UserRegistrationDAO userDAO = new UserRegistrationDAO();

    try {
        // Insert user into the database
        userDAO.insertUser(user);
        out.print("<script>showAlert('Registration successful. Please log in.', 'success');</script>");
    } catch (SQLException e) {
        // Show an error message if registration fails
        out.print("<script>showAlert('Registration failed. Please try again later.', 'error');</script>");
        e.printStackTrace();
    }
%>
