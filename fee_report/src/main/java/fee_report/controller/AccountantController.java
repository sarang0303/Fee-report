package fee_report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fee_report.crud.AccountantCrud;
import fee_report.dto.Accountant;
@WebServlet("/sign")
public class AccountantController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		long phoneno=Long.parseLong(req.getParameter("phone"));
		
		Accountant accountant=new Accountant();
		accountant.setId(id);
		accountant.setName(name);
		accountant.setPassword(password);
		accountant.setEmail(email);
		accountant.setPhoneno(phoneno);
		
		
		
		try {
			AccountantCrud accountantCrud=new AccountantCrud();
			int result=accountantCrud.saveAccountantt(accountant);
			if (result!=0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("adminindex.html");
				dispatcher.forward(req, resp);
				
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("accountantsignup.html");
				dispatcher.forward(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
