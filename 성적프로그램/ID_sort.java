import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ID_sort extends JFrame {
	class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			String sql = "SELECT name, StudentId, Total FROM person ORDER BY StudentId;";
			new Connect_DB();
			Connection con = Connect_DB.makeConnection();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				int i = 1;
				super.paintComponent(g);

				while (rs.next()) {
					g.drawString("name : " + rs.getString(1), 20, 20 * i);
					g.drawString("StudentId : " + rs.getString(2), 120, 20 * i);
					g.drawString("Total : " + rs.getString(3), 260, 20 * i);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	ID_sort() {
		setTitle("학번 정렬");

		add(new MyPanel());

		setSize(400, 800);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ID_sort();
	}

}
