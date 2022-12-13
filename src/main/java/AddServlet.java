

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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		int contact=Integer.parseInt(request.getParameter("contact"));
		
		try {
			Connection con=DBService.getConn();
			PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?)");
			ps.setInt(1, rollno);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.setInt(4, contact);
			int rs=ps.executeUpdate();
			if(rs>0) {
				pw.println("Records Inserted Successfully");
			}
			else {
				pw.println("Insertion Failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<a href='Index.html'>Back To Menu</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
