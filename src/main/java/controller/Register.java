package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/do-register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");
		String address = request.getParameter("address");
		String ordAddress = request.getParameter("ordAddress");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String shipTo = request.getParameter("shipTo");
		String isUseMsgService = request.getParameter("isUseMsgService");


//		Setting attributes to pass back to the register.jsp
		// Setting attributes to pass back to the JSP
		request.setAttribute("username", username);
	
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("birthDate", birthDate);
		request.setAttribute("address", address);
		request.setAttribute("ordAddress", ordAddress);
		request.setAttribute("email", email);
		request.setAttribute("phoneNumber", phoneNumber);
		request.setAttribute("shipTo", shipTo);
		request.setAttribute("isUseMsgService", isUseMsgService);

		
		String url = "";
		String error = "";
		CustomerDAO cDao = new CustomerDAO();

		if(cDao.checkUserName(username)) {
			error = "Username is not available, please try again. <br/>";
		}
		
		if(!password.equals(confirmPassword)) {
			error = "Password is not match. Please try again";
		}
			
		if(error.length() > 0) {
			request.setAttribute("error", error);
			url = "/register.jsp";
		}
		else {
			Random rd = new Random();
			String customerId = System.currentTimeMillis()+ rd.nextInt(1000) + "";
			boolean sex = false;
			if(gender.equals("male")) {
				sex = true;
			}
			Customer c = new Customer(customerId, username, confirmPassword, name, sex, address, ordAddress, shipTo, Date.valueOf(birthDate), phoneNumber, email, isUseMsgService != null);
			cDao.insert(c);
			url = "/success.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	

}
