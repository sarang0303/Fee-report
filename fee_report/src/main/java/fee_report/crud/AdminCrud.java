package fee_report.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fee_report.dto.Admin;

public class AdminCrud {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/feereport", "root", "root");
		return connection;
	}
	public Admin getAdminlogin(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Admin  WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
	    Admin admin = new Admin();
		while (resultSet.next()) {
			admin.setPassword(resultSet.getString("password"));
			
		}
		connection.close();
		return admin;
	}

}
