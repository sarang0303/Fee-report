package fee_report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fee_report.crud.StudentCrud;
import fee_report.dto.Student;

@WebServlet("/all")
public class FindALLStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
        

		StudentCrud studentCrud = new StudentCrud();
		try {
			List<Student> students =  studentCrud.allStudent();
			
				
					req.setAttribute("student", students);
					RequestDispatcher dispatcher=req.getRequestDispatcher("allstudent.jsp");
					dispatcher.forward(req, resp);	
									
			
			
				
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NOT");
		}

	}

}
