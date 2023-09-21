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


@WebServlet("/loginn")
public class AccountantantLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		
		try {
			AccountantCrud accountantCrud=new AccountantCrud();
			Accountant dbAccountant=accountantCrud.getAccountantlogin(email);
			if (password.equals(dbAccountant.getPassword())) {
				resp.sendRedirect("accountantindex.html");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("accountant.html");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			
			System.out.println("Not");
			// TODO: handle exception
		}
	}

}
