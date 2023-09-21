package fee_report.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import fee_report.dto.Student;

public class StudentCrud {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feestudent", "root", "root");
		return connection;
	}

	public int saveStudent(Student student) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO Students VALUES (?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getEmail());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.setLong(5, student.getPhone());
		preparedStatement.setInt(6, student.getAge());
		preparedStatement.setString(7, student.getCourse());
		preparedStatement.setInt(8, student.getFees());
		preparedStatement.setInt(9, student.getPaid());
		preparedStatement.setInt(10, student.getDue());
		int results = preparedStatement.executeUpdate();
		connection.close();
		return results;
	}
	
	

	public List<Student> allStudent() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students");
		List<Student> list = new ArrayList<Student>();
		ResultSet resultset = preparedStatement.executeQuery();
		while (resultset.next()) {
			Student student = new Student();
			student.setId(resultset.getInt("id"));
			student.setName(resultset.getString("name"));
			student.setEmail(resultset.getString("email"));
			student.setAge(resultset.getInt("age"));
			student.setFees(resultset.getInt("fees"));
			student.setPaid(resultset.getInt("paid"));
			student.setDue(resultset.getInt("due"));
			student.setAddress(resultset.getString("address"));
			student.setCourse(resultset.getString("course"));
			student.setPhone(resultset.getLong("phone"));
			list.add(student);
		}
		connection.close();
		return list;

	}
	

}
