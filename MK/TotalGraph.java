import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

public class TotalGraph extends JFrame {
	static TotalGraphPanel dp = new TotalGraphPanel();

	public static class scoreInsert {

		public static void insert() {
			int numA = 0;
			int numB = 0;
			int numC = 0;
			int numD = 0;
			int numF = 0;

			System.out.println("점수 확인");
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = makeConnection();
				String sql = "SELECT * FROM person";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String score = rs.getString("total");
					if ("A".equals(score)) {
						numA = numA + 1;
					}
					if ("B".equals(score)) {
						numB = numB + 1;
					}
					if ("C".equals(score)) {
						numC = numC + 1;
					}
					if ("D".equals(score)) {
						numD = numD + 1;
					}
					if ("F".equals(score)) {
						numF = numF + 1;
					}
				}
				dp.setNums(numA, numB, numC, numD, numF);
			} catch (Exception e) {
				System.out.println("에러 1" + e.getMessage());
				System.out.println("실패1");
			} finally {
				close(con, pstmt);
				System.out.println("닫음");
			}
		}

	}

	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결 중...");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("SQLException : " + ex.getMessage());
		}
		return con;
	}

	public TotalGraph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그래프");
		setLocation(500, 200);
		setSize(450, 400);

		add(dp, BorderLayout.CENTER);
		// JPanel p1 = new JPanel();
		insert();

		setVisible(true);
	}

	private void insert() {
		scoreInsert.insert();
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

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

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