import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBService {
	public static Connection getConn() throws SQLException, ClassNotFoundException {
   	 Class.forName("com.mysql.cj.jdbc.driver");
   	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Tejas@123");
   	 return con;
}
}