

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("txt/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Boolean flag=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","12345");
			PreparedStatement ps=con.prepareStatement("select * from student where username=? and password=?;");
			
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet result=ps.executeQuery();
			flag=result.next();
			if(flag)
			{
				HttpSession session=request.getSession();
				session.setAttribute("username",username);
				RequestDispatcher rds= request.getRequestDispatcher("homepage.html");
				rds.forward(request, response);
			}
			else {
				out.println("user not found");
				RequestDispatcher rds= request.getRequestDispatcher("login.html");
				rds.forward(request, response);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
