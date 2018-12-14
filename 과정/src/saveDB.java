import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class saveDB {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/score?characterEncoding=UTF-8&serverTimezone=UTC";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결 중...");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return con;

	}

	public static void saving(Student stu) throws SQLException {
		if (stu.name.length() == 0) {
			// 안함.
		} else {
			Connection con = makeConnection();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO person (name, ID, middle, final, homework, quiz, announcement, report, attendance, other, total) VALUES "
					+ "(" + "'" + stu.name + "'," + stu.StudentId + "," + stu.Mid + "," + stu.Fin + "," + stu.Subj + ","
					+ stu.Quiz + "," + stu.Pre + "," + stu.Report + "," + stu.Atend + "," + stu.Another + "," + stu.all
					+ ")";

			System.out.println(sql);
			if (stmt.executeUpdate(sql) == 1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
			con.close();
			stmt.close();
		}
	}

}
