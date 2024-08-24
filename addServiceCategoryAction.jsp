<%@ page import="dao.ServiceCategoryDAO" %>
<%@ page import="bean.ServiceCategoryBean" %>
<%@ page import="java.sql.SQLException" %>

<%
    // Retrieve form data
    String categoryName = request.getParameter("categoryName");
    String serviceCategory = request.getParameter("serviceCategory");
    String serviceDescription = request.getParameter("serviceDescription");
    
    // Check if form fields are empty
    if (categoryName == null || categoryName.trim().isEmpty() ||
        serviceCategory == null || serviceCategory.trim().isEmpty() ||
        serviceDescription == null || serviceDescription.trim().isEmpty()) {
        out.print("<script type='text/javascript'>");
        out.print("alert('All fields are required.');");
        out.print("window.location.href = 'addServiceCategory.jsp';");
        out.print("</script>");
        return;
    }

    // Create an instance of ServiceCategoryBean
    ServiceCategoryBean categoryBean = new ServiceCategoryBean();
    categoryBean.setCategoryName(categoryName);
    categoryBean.setServiceCategory(Integer.parseInt(serviceCategory)); // Ensure proper conversion
    categoryBean.setServiceDescription(serviceDescription);

    // Create an instance of ServiceCategoryDAO
    ServiceCategoryDAO categoryDAO = new ServiceCategoryDAO();

    boolean isAdded = false;
    try {
        // Add the category to the database
        categoryDAO.addCategory(categoryBean);
        isAdded = true;
    } catch (SQLException e) {
        e.printStackTrace();
        isAdded = false;
    }

    // Redirect or forward based on the result
    if (isAdded) {
        out.print("<script type='text/javascript'>");
        out.print("alert('Category added successfully.');");
        out.print("window.location.href = 'viewServiceCategory.jsp';");
        out.print("</script>");
    } else {
        out.print("<script type='text/javascript'>");
        out.print("alert('Failed to add category.');");
        out.print("window.location.href = 'addServiceCategory.jsp';");
        out.print("</script>");
    }
%>
