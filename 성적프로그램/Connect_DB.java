import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_DB {

	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:1234/score?charaterEncoding=UTF-8&serverTimezone=UTC";

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DB연결중");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("DB연결성공");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return con;
	}
}
