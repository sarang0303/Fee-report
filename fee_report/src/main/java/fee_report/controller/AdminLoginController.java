package fee_report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fee_report.crud.AdminCrud;
import fee_report.dto.Admin;

public class AdminLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		AdminCrud adminCrud=new AdminCrud();
		
		try {
			Admin	dbadmin = adminCrud.getAdminlogin(email);
			if (password.equals(dbadmin.getPassword())) {
				resp.sendRedirect("adminindex.html");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("adminlogin.html");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}


