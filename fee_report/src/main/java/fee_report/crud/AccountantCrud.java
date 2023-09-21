package fee_report.crud;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fee_report.dto.Accountant;

public class AccountantCrud {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport", "root", "root");
		return connection;
	}

	public int saveAccountantt(Accountant accountant) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Accountant VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, accountant.getId());
		preparedStatement.setString(2, accountant.getName());
		preparedStatement.setString(3, accountant.getEmail());
		preparedStatement.setString(4, accountant.getPassword());
		preparedStatement.setLong(5, accountant.getPhoneno());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public Accountant getAccountantlogin(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Accountant  WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		Accountant accountant = new Accountant();
		while (resultSet.next()) {
			accountant.setPassword(resultSet.getString("password"));

		}
		connection.close();
		return accountant;
	}
}
