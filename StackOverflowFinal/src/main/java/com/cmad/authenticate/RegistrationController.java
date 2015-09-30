package com.cmad.authenticate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.cmad.database.User;
import com.cmad.database.UserDBImpl;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error;
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		
		HttpSession session = request.getSession();
		int result = 0;
		
		UserDBImpl userDBImpl = new UserDBImpl();
		System.out.println("String is "+email);
		User u = userDBImpl.getUserByEmail(email);
				
		if(u.getEmail() == null){
			System.out.println("User does not exist and can be created");
			User user = new User(fullname,email,password,gender,birthdate);
			result = userDBImpl.createOrUpdateUser(user);		
		}
		else{
			System.out.println("EmailId already in use");
//			ShowMessage("EmailId already in use");
		}
		if(result == 0){
			System.out.println("User could not be registered");
			response.sendRedirect("index.jsp#register");			
		}else{
			System.out.println(" You have been registered successfully");
			response.sendRedirect("success.jsp");
		}
		
	}
	
}

