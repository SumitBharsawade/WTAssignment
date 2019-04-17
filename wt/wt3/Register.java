

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("txt/html");
		PrintWriter out=response.getWriter();
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String mobileno=request.getParameter("mobileno");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","12345");
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?);");
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,mobileno);
			ps.setString(4,email);
			ps.setString(5,gender);
			ps.setString(6,course);
			ps.setString(7,username);
			ps.setString(8,password);
			
			int result=ps.executeUpdate();
			if(result>0)
			{
				out.println("Registration done Sucessfully");
				out.println("<a href='login.jsp'>Click here for login</a>");
			}
			else {
				out.println("Error in Registration");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
