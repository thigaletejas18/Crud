

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		int contact=Integer.parseInt(request.getParameter("contact"));
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		
		try {
			Connection con=DBService.getConn();
			PreparedStatement ps=con.prepareStatement("update Student set name=?,address=?,contact=? where rollno=?");
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setInt(3, contact);
			ps.setInt(4, rollno);
			int rs=ps.executeUpdate();
			if(rs>0) {
				pw.println("Records Updated Successfully");
			}
			else {
				pw.println("Updation Failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<a href='Index.html'>Back To Menu</a>");
	}

}
