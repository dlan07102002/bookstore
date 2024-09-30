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
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import model.Customer;
import util.Encoding;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		String action = request.getParameter("action");
		switch (action) {
		case "login":
			login(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "change-user-info":
			changeUserInfo(request, response);
			break;
		case "change-password":
			changePassword(request, response);
			break;
		case null:
			logout(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = Encoding.toSHA1(password);

			CustomerDAO cDao = new CustomerDAO();
			Customer c = new Customer();
			c.setUsername(username);
			c.setPassword(password);
			c = cDao.selectByUsernameAndPassword(c);

			String url = "";
			if (c != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", c);
				url = "/index.jsp";
			} else {
				request.setAttribute("error", "Username or Password is incorrect. Please try again!");
				url = "/customer/login.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.invalidate();

			// Back to main page without data
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			response.sendRedirect(url + "/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
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

			if (cDao.checkUserName(username)) {
				error = "Username is not available, please try again. <br/>";
			}

			if (!password.equals(confirmPassword)) {
				error = "Password is not match. Please try again";
			} else {
				password = Encoding.toSHA1(password);
			}

			if (error.length() > 0) {
				request.setAttribute("error", error);
				url = "/customer/register.jsp";
			} else {
				Random rd = new Random();
				String customerId = System.currentTimeMillis() + rd.nextInt(1000) + "";
				boolean sex = gender.equals("male") ? true : false;

				System.out.println(password);
				Customer c = new Customer(customerId, username, password, name, sex, address, ordAddress, shipTo,
						Date.valueOf(birthDate), phoneNumber, email, isUseMsgService != null);
				cDao.insert(c);
				url = "/customer/success.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		try {
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");

			String encodedCurrentPassword = Encoding.toSHA1(currentPassword);
			String url = "/customer/changePassword.jsp";
			String err = "";
			String success = "";
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("customer");
			Customer c = null;
			if (obj != null) {
				c = (Customer) obj;
			}

			if (c == null) {
				err = "You are not signed in";

			} else {
				// If user is sign-in
				if (!encodedCurrentPassword.equals(c.getPassword())) {
					err = "Password is incorrect";

				} else {
					if (!newPassword.equals(currentPassword)) {
						if (!newPassword.equals(confirmPassword)) {
							err = "Confirm password is not match";

						} else {
							String encodedNewPassword = Encoding.toSHA1(newPassword);
							c.setPassword(encodedNewPassword);
							CustomerDAO ctDao = new CustomerDAO();
							if (ctDao.changePassword(c)) {
								success = "Change Password Success";
//							url = "/index.jsp";
								

							} else {
								err = "Change Password Failed ";
							}
						}
					} else {
						err = "New password could not same as old password. Please try again";
					}

				}
			}

			request.setAttribute("error", err);
			request.setAttribute("success", success);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void changeUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String birthDate = request.getParameter("birthDate");
			String address = request.getParameter("address");
			String ordAddress = request.getParameter("ordAddress");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			String shipTo = request.getParameter("shipTo");
			String isUseMsgService = request.getParameter("isUseMsgService");

			request.setAttribute("name", name);
			request.setAttribute("gender", gender);
			request.setAttribute("birthDate", birthDate);
			request.setAttribute("address", address);
			request.setAttribute("ordAddress", ordAddress);
			request.setAttribute("email", email);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("shipTo", shipTo);
			request.setAttribute("isUseMsgService", isUseMsgService);

			String url = "/customer/changeUserInfo.jsp";
			String error = "";
			CustomerDAO cDao = new CustomerDAO();

			if (error.length() > 0) {
				request.setAttribute("error", error);
				
			} else {
				HttpSession session = request.getSession();
				Object o = session.getAttribute("customer");
				Customer c = null;
				if (o != null) {
					c = (Customer) o;
					if (c != null) {

						String customerId = c.getCustomerId();
						System.out.println(c.getUsername());
						boolean sex = gender.equals("male") ? true : false;
						c = new Customer(customerId, "", "", name, sex, address, ordAddress, shipTo,
								Date.valueOf(birthDate), phoneNumber, email, isUseMsgService != null);
						cDao.updateInfo(c);
						Customer cChanged = cDao.selectById(c);
						session.setAttribute("customer", cChanged);

						url = "/customer/success.jsp";
					}

				}

			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
