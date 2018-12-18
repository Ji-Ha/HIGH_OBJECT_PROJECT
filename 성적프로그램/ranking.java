import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ranking extends JFrame {
	class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			String sql = "SELECT name, StudentId, Total FROM person ORDER BY Total DESC;";
			new Connect_DB();
			Connection con = Connect_DB.makeConnection();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				int i = 1;
				super.paintComponent(g);

				while (rs.next()) {
					g.drawString(i + "등 : ", 10, 20 * i);
					g.drawString("name : " + rs.getString(1), 50, 20 * i);
					g.drawString("StudentId : " + rs.getString(2), 150, 20 * i);
					g.drawString("Total : " + rs.getString(3), 290, 20 * i);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	ranking() {
		setTitle("석차열람");

		add(new MyPanel());

		setSize(400, 800);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ranking();
	}

}
