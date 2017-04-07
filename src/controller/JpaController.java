package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAOImp;

/**
 * Servlet implementation class JpaController
 */
@WebServlet(name = "Users", urlPatterns = { "/Users", "/users.jsp", "/users.html", "/users" })
public class JpaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAOImp daoImp = new UserDAOImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JpaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<table></tr><th>User ID</th><th>Name</th><th>Email</th><th>Password</th></tr>");
		List<User> users = daoImp.getAllUsers();
		/*for (User user : users) {
			out.write("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getEmail()
					+ "</td><td>" + user.getPassword() + "</td></tr>");

		}*/
		request.setAttribute("users",users );
		request.getRequestDispatcher("userslist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response.sendRedirect("/users");
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		User user =new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		daoImp.addUser(user);
		
		response.sendRedirect("user.jsp");
	}

}
