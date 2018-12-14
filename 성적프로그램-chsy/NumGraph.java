
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

public class NumGraph extends JFrame {
	static NumGraphPanel dp = new NumGraphPanel();
	static Student[] stu;
	static String s;
	static int stuNum;

	public NumGraph(String s, Student[] stu, int stuNum) {
		this.s = s;
		this.stu = stu;
		this.stuNum = stuNum;
		setLocation(500, 200);
		setSize(850, 450);
		add(dp, BorderLayout.CENTER);
	}

	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("연결중...");
			con = DriverManager.getConnection(url, "root", "1234");
			// System.out.println("연결");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQLException : " + ex.getMessage());
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}