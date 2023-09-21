package fee_report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fee_report.crud.StudentCrud;
import fee_report.dto.Student;

@WebServlet("/newstudent")
public class StudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		int age=Integer.parseInt(req.getParameter("age"));
		String course=req.getParameter("course");
		int fees=Integer.parseInt(req.getParameter("fees"));
		int paid=Integer.parseInt(req.getParameter("paid"));
		int due=Integer.parseInt(req.getParameter("due"));
		
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setPhone(phone);
		student.setAge(age);
		student.setCourse(course);
		student.setFees(fees);
		student.setPaid(paid);
		student.setDue(due);
		
		
		
		StudentCrud crud=new StudentCrud();
		try {
			int result=crud.saveStudent(student);
			if (result!=0) {
				RequestDispatcher dispatcher=req.getRequestDispatcher("accountantindex.html");
				dispatcher.forward(req, resp);
				
			}else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("accountantindex.html");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
