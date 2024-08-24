package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import bean.ServiceCategoryBean;
import dbconnection.DBConnection;

public class ServiceCategoryDAO {
	public void addCategory(ServiceCategoryBean category) throws SQLException {
		String query = "INSERT INTO service_category (categoryName, serviceCategory, serviceDescription) VALUES (?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
			stmt.setString(1, category.getCategoryName());
			stmt.setInt(2, category.getServiceCategory());
			stmt.setString(3, category.getServiceDescription());
			stmt.executeUpdate();
		}
	}

	public List<ServiceCategoryBean> getAllCategories() throws SQLException {
		List<ServiceCategoryBean> categories = new ArrayList<>();
		String query = "SELECT * FROM service_category";
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = (ResultSet) stmt.executeQuery(query)) {
			while (rs.next()) {
				ServiceCategoryBean category = new ServiceCategoryBean();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setServiceCategory(rs.getInt("serviceCategory"));
				category.setServiceDescription(rs.getString("serviceDescription"));
				categories.add(category);
			}
		}
		return categories;
	}
	
	// Method to update an existing category
    public boolean updateCategory(ServiceCategoryBean category) throws SQLException {
        String query = "UPDATE service_category SET categoryName = ?, serviceCategory = ?, serviceDescription = ? WHERE categoryId = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
            stmt.setString(1, category.getCategoryName());
            stmt.setInt(2, category.getServiceCategory());
            stmt.setString(3, category.getServiceDescription());
            stmt.setInt(4, category.getCategoryId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Method to retrieve a single category by its ID
    public ServiceCategoryBean getCategoryById(int categoryId) throws SQLException {
        ServiceCategoryBean category = null;
        String query = "SELECT * FROM service_category WHERE categoryId = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query)) {
            stmt.setInt(1, categoryId);
            try (ResultSet rs = (ResultSet) stmt.executeQuery()) {
                if (rs.next()) {
                    category = new ServiceCategoryBean();
                    category.setCategoryId(rs.getInt("categoryId"));
                    category.setCategoryName(rs.getString("categoryName"));
                    category.setServiceCategory(rs.getInt("serviceCategory"));
                    category.setServiceDescription(rs.getString("serviceDescription"));
                }
            }
        }
        return category;
    }
}
