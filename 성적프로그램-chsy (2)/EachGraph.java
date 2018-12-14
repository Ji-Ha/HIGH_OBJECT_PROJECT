import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

public class EachGraph extends JFrame {
	static EachGraphPanel dp = new EachGraphPanel();
	static Student[] stu;
	static String s;
	static int stuNum;

	public EachGraph(String s, Student[] stu, int stuNum) {
		setLocation(500, 200);
		setSize(850, 450);
		this.s = s;
		this.stu = stu;
		this.stuNum = stuNum;
		add(dp, BorderLayout.CENTER);
		insert(s);

		setResizable(false);
		setVisible(true);
	}

	public static class scoreInsert {

		public static void insert(String s) {
			int numZero = 0;
			int numOne = 0;
			int numTwo = 0;
			int numThree = 0;
			int numFour = 0;
			int numFive = 0;
			int numSix = 0;
			int numSeven = 0;
			int numEight = 0;
			int numNine = 0;

			System.out.println("각 점수 확인");
			int score = 0;
			for (int i = 0; i < stuNum; i++) {
				switch (s) {
				case "Mid":
					score = Integer.parseInt(stu[i].getMid());
					break;
				case "Fin":
					score = Integer.parseInt(stu[i].getFin());
					break;
				case "HW":
					score = Integer.parseInt(stu[i].getSubj());
					break;
				case "Quiz":
					score = Integer.parseInt(stu[i].getQuiz());
					break;
				case "Pre":
					score = Integer.parseInt(stu[i].getPre());
					break;
				case "Report":
					score = Integer.parseInt(stu[i].getReport());
					break;
				case "Attend":
					score = Integer.parseInt(stu[i].getAttend());
					break;
				case "Another":
					score = Integer.parseInt(stu[i].getAnother());
					break;
				case "all":
					score = Integer.parseInt(stu[i].getAll());
					break;
				}
				int n = (score - 1) / 10 + 1;
				if (n == 10) {
					numZero++;
				}
				;
				switch (n) {
				case 0:
					numZero++;
					break;
				case 1:
					numOne++;
					break;
				case 2:
					numTwo++;
					break;
				case 3:
					numThree++;
					break;
				case 4:
					numFour++;
					break;
				case 5:
					numFive++;
					break;
				case 6:
					numSix++;
					break;
				case 7:
					numSeven++;
					break;
				case 8:
					numEight++;
					break;
				case 9:
					numNine++;
					break;
				}
				// System.out.println(n);
			}
			dp.setNums(numZero, numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, numEight, numNine);
		}

	}

	// Connection con = null;
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	// try {
	// con = makeConnection();
	// String sql = "SELECT * FROM person";
	// rs = pstmt.executeQuery();
	// while (rs.next()) {
	// int score = rs.getInt(s);
	// int n = (score - 1) / 10;
	// switch (n) {
	// case 0:
	// numZero++;
	// break;
	// case 1:
	// numOne++;
	// break;
	// case 2:
	// numTwo++;
	// break;
	// case 3:
	// numThree++;
	// break;
	// case 4:
	// numFour++;
	// break;
	// case 5:
	// numFive++;
	// break;
	// case 6:
	// numSix++;
	// break;
	// case 7:
	// numSeven++;
	// break;
	// case 8:
	// numEight++;
	// break;
	// case 9:
	// numNine++;
	// break;
	// }
	// System.out.println(n);
	// }
	// dp.setNums(numZero, numOne, numTwo, numThree, numFour, numFive, numSix,
	// numSeven, numEight, numNine);
	// } catch (Exception e) {
	// System.out.println("에러 1" + e.getMessage());
	// System.out.println("실패1");
	// } finally {
	// close(con, pstmt);
	// System.out.println("닫음");
	// }
	// }

	// }

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

	private void insert(String s) {
		scoreInsert.insert(s);
	}

}