import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class UCheck extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel model;
	Connection connect = null;
	static StudentAttend[] stuAtt = new StudentAttend[40];
	public static int rule = 0;
	public static int Frule = 0;
	public static int Changewk = 0;

	void setRuler(int r) {
		rule = r;
	}

	void setFRuler(int r) {
		Frule = r;
	}

	void setWeek(int r) {
		Changewk = r;
	}

	int getWeek() {
		return Changewk;
	}

	public UCheck() {

	}

	void run() {
		setTitle("출결 관리대장");
		setLocation(20, 20);
		setSize(800, 1300);

		makeMenu();

		setVisible(true);
	}

	public void makeMenu() {
		table = new JTable();
		getContentPane().add(table);
		JMenuItem item;

		JMenuBar mb = new JMenuBar();

		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("출결 계산 및 상태변경");
		JMenu m3 = new JMenu("출결 설정");

		// m1
		item = new JMenuItem("파일 불러오기");
		item.addActionListener(this);
		m1.add(item);

		item = new JMenuItem("변경내용 저장");
		item.addActionListener(this);
		m1.add(item);

		item = new JMenuItem("DB에 저장");
		item.addActionListener(this);
		m1.add(item);

		item = new JMenuItem("CSV에 저장");
		item.addActionListener(this);
		m1.add(item);

		// m2
		item = new JMenuItem("출결점수 계산");
		item.addActionListener(this);
		m2.add(item);

		item = new JMenuItem("전체 출결 변경");
		item.addActionListener(this);
		m2.add(item);

		// m3
		item = new JMenuItem("출결기준 설정");
		item.addActionListener(this);
		m3.add(item);

		item = new JMenuItem("F기준 설정");
		item.addActionListener(this);
		m3.add(item);

		// add menu to menu_bar
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);

		setJMenuBar(mb);

		// model setup
		model = (DefaultTableModel) table.getModel();
		model.addColumn("name");
		model.addColumn("StudentId");
		model.addColumn("1주");
		model.addColumn("2주");
		model.addColumn("3주");
		model.addColumn("4주");
		model.addColumn("5주");
		model.addColumn("6주");
		model.addColumn("7주");
		model.addColumn("8주");
		model.addColumn("9주");
		model.addColumn("10주");
		model.addColumn("11주");
		model.addColumn("12주");
		model.addColumn("13주");
		model.addColumn("14주");
		model.addColumn("15주");
		model.addColumn("16주");
		model.addColumn("총점");

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(100, 100, 600, 100);
		getContentPane().add(scroll);

	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {

		case "파일 불러오기":
			System.out.println("파일 불러오기");
			JFileChooser fileopen = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");
			fileopen.addChoosableFileFilter(filter);

			int ret = fileopen.showDialog(null, "Choose file");

			if (ret == JFileChooser.APPROVE_OPTION) {

				// Read Text file
				File file = fileopen.getSelectedFile();

				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					int row = 0;
					while ((line = br.readLine()) != null) {
						String[] arr = line.split(",");
						model.addRow(new Object[0]);
						model.setValueAt(arr[0], row, 0);
						model.setValueAt(arr[1], row, 1);
						model.setValueAt(arr[2], row, 2);
						model.setValueAt(arr[3], row, 3);
						model.setValueAt(arr[4], row, 4);
						model.setValueAt(arr[5], row, 5);
						model.setValueAt(arr[6], row, 6);
						model.setValueAt(arr[7], row, 7);
						model.setValueAt(arr[8], row, 8);
						model.setValueAt(arr[9], row, 9);
						model.setValueAt(arr[10], row, 10);
						model.setValueAt(arr[11], row, 11);
						model.setValueAt(arr[12], row, 12);
						model.setValueAt(arr[13], row, 13);
						model.setValueAt(arr[14], row, 14);
						model.setValueAt(arr[15], row, 15);
						model.setValueAt(arr[16], row, 16);
						model.setValueAt(arr[17], row, 17);
						// model.setValueAt(arr[18], row, 18);
						row++;
					}
					br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			for (int i = 0; i < table.getRowCount(); i++) {
				stuAtt[i] = new StudentAttend();
				for (int j = 0; j < 18; j++) {

					stuAtt[i].CheckAttend[j] = table.getValueAt(i, j).toString();
				}
			}
			break;
		case "변경내용 저장":
			for (int i = 0; i < table.getRowCount(); i++) {
				for (int j = 0; j < 18; j++) {
					stuAtt[i].CheckAttend[j] = table.getValueAt(i, j).toString();
				}
			}
			break;
		case "DB에 저장":
			System.out.println("DB에 저장");
			Connection con = null;
			Statement s = null;
			String url = "jdbc:mysql://localhost:1234/attend?characterEncoding=UTF-8&serverTimezone=UTC";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// System.out.println("데이터베이스 연결 중...");
				con = DriverManager.getConnection(url, "root", "1234");
				// System.out.println("데이터베이스 연결 성공");

				s = con.createStatement();

				String sql = "INSERT INTO person (name, 1week) VALUES " + "(" + "'" + stuAtt[0].CheckAttend[0] + "',"
						+ stuAtt[0].CheckAttend[1] + "')";
				s.executeUpdate(sql);

				JOptionPane.showMessageDialog(null, "Import Data Successfully");

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				ex.printStackTrace();
			}

			try {
				if (s != null) {
					s.close();
					connect.close();
				}
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

			break;

		case "CSV에 저장":
			System.out.println("CSV에 저장");
			connect = null;
			s = null;
			url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection(url, "root", "1234");

				s = connect.createStatement();

				ResultSet rec = s.executeQuery("SELECT * FROM person");

				String path = "C:\\Users\\njh10\\Documents\\test.csv";
				FileWriter writer;

				try {
					File file = new File(path);
					writer = new FileWriter(file, true);

					while ((rec != null) && (rec.next())) {
						writer.write(rec.getString("name"));
						writer.write(",");
						writer.write(rec.getString("StudentId"));
						writer.write(",");
						writer.write(rec.getString("1주"));
						writer.write(",");
						writer.write(rec.getString("2주"));
						writer.write(",");
						writer.write(rec.getString("3주"));
						writer.write(",");
						writer.write(rec.getString("4주"));
						writer.write(",");
						writer.write(rec.getString("5주"));
						writer.write(",");
						writer.write(rec.getString("6주"));
						writer.write(",");
						writer.write(rec.getString("7주"));
						writer.write(",");
						writer.write(rec.getString("8주"));
						writer.write(",");
						writer.write(rec.getString("9주"));
						writer.write(",");
						writer.write(rec.getString("10주"));
						writer.write(",");
						writer.write(rec.getString("11주"));
						writer.write(",");
						writer.write(rec.getString("12주"));
						writer.write(",");
						writer.write(rec.getString("13주"));
						writer.write(",");
						writer.write(rec.getString("14주"));
						writer.write(",");
						writer.write(rec.getString("15주"));
						writer.write(",");
						writer.write(rec.getString("16주"));
						writer.write("\n");
						System.out.println(1);
					}
					writer.flush();
					writer.close();

					System.out.println("Write success!");

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			// Close
			try {
				if (connect != null) {
					s.close();
					connect.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			break;
		case "출결점수 계산":
			System.out.println("출석점수 계산");
			int countX = 0;
			int countT = 0;
			for (int i = 0; i < 40; i++) {
				if (stuAtt[i] == null)
					break;
				for (int j = 0; j < 18; j++) {
					if (stuAtt[i].CheckAttend[j].equals(" x") || stuAtt[i].CheckAttend[j].equals("x")) {
						countX++;
						// System.out.println("몇개야");
					}
					if (stuAtt[i].CheckAttend[j] == " △" || stuAtt[i].CheckAttend[j] == "△") {
						countT++;
					}
					// 이부분에서 무엇인가 해야함.

					countX = 0;
					countT = 0;
				}
			}

			break;
		case "출결기준 설정":
			new setRule().run();
			break;
		case "F기준 설정":
			System.out.println(stuAtt[0].CheckAttend[4]);
			new setF().run();
			break;

		case "전체 출결 변경":
			new ChangeWeek().run();
			break;
		}
	}

	public static void main(String[] args) {
		new UCheck().run();
	}
}

// System.out.println("불러오기");
//// 이렇게 하고 싶은데 오류가 나서 놔뒀음.
//// new CallData();
