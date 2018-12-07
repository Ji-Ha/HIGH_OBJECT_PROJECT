package hi;

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
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MenuDemo extends JFrame {
	private JTable table = new JTable();
	static Student[] stu = new Student[40];
	public double[] per = new double[8];
	JTextField searchNameTextField;
	Connection connect = null;
	// 하은누나가 살짝 봐야함.
	private DefaultTableModel model;

	MenuDemo() {
		model = (DefaultTableModel)this.table.getModel();
		//Vector row = new Vector();
		//row.add("");
		//model.addRow(row);
		//model.setRowCount(0);
     	model.setRowCount(40);

	}


	private void run() {
		setTitle("미완성작품입니다.");
		makeMenu();
		setSize(800, 345);
		setLocation(500, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void SetModel(DefaultTableModel m) {

		this.model = m;
	}

	public DefaultTableModel GetModel() {
		return model;
	}

	// void SetPercent(doub);

	void makeMenu() {
		//table = new JTable();

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("실행");
		JMenu m3 = new JMenu("통계");
		JMenu m4 = new JMenu("출석");
		JMenu m5 = new JMenu("설정");
		getContentPane().add(table);

		JMenuItem item = new JMenuItem("불러오기");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("내용 저장");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("DB에 저장");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("CSV에 저장");
		item.addActionListener(new MenuActionListener());
		m1.add(item);

		item = new JMenuItem("성적계산");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("반영비율 설정");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("등급설정");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("출결점수 계산");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("강좌평균 계산");
		item.addActionListener(new MenuActionListener());
		m2.add(item);

		////////////////////////////////// 추가///////////////////////////////////////
		// JMenu search = new JMenu("학생 성적 검색");
		// search.addActionListener(new MenuActionListener());
		// m2.add(search);
		// item = new JMenuItem("학번 검색");
		// item.addActionListener(new MenuActionListener());
		// search.add(item);
		// item = new JMenuItem("이름 검색");
		// item.addActionListener(new MenuActionListener());
		// search.add(item);

		// JLabel searchNameLabel = new JLabel("이름 검색");
		// JTextField searchNameTextField = new JTextField(3);
		// mb.add(searchNameLabel);
		// mb.add(searchNameTextField);

		item = new JMenuItem("총점수 분포도");
		item.addActionListener(new MenuActionListener());
		m3.add(item);
		JMenu m = new JMenu("각 점수 분포도");
		item = new JMenuItem("출석점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("중간시험점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("기말시험점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("과제점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("퀴즈점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("발표점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("보고서점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		item = new JMenuItem("기타점수");
		item.addActionListener(new MenuActionListener());
		m.add(item);
		m3.add(m);
		mb.add(m3);

		item = new JMenuItem("출석 현황");
		item.addActionListener(new MenuActionListener());
		m4.add(item);

		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		////// 추가/////////////////
		mb.add(Box.createHorizontalStrut(30));
		JButton searchName = new JButton("이름 검색");
		searchName.addActionListener(new MenuActionListener());
		searchNameTextField = new JTextField(3);
		mb.add(searchNameTextField);
		mb.add(searchName);
		mb.add(Box.createHorizontalStrut(450));
		setJMenuBar(mb);

		// Table Model
		model = (DefaultTableModel) table.getModel();
		model.addColumn("name");
		model.addColumn("StudentId");
		model.addColumn("Mid");
		model.addColumn("Fin");
		model.addColumn("HW");
		model.addColumn("Quiz");
		model.addColumn("Pre");
		model.addColumn("Report");
		model.addColumn("Attend");
		model.addColumn("Another");
		model.addColumn("Total");
		model.addColumn("Rank");

		SetModel(model);

		// ScrollPane
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(100, 100, 600, 100);
		getContentPane().add(scroll);

	}

	public static void main(String[] args) {
		MenuDemo init = new MenuDemo();
		init.run();
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			switch (cmd) {
			// 밑에 세개로 하은누나가 만들것.
			// 내용저장은 프로그램 내부에서 데이터를 저장할 때 필요함. 혹시 다른 의견이 있으면 말해주기 바람.
			case "불러오기":
				System.out.println("불러오기");
				// 이렇게 하고 싶은데 오류가 나서 놔뒀음.
				// new CallData();
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
							row++;
						}
						br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				for (int i = 0; i < table.getRowCount() - 40; i++) {
					String name = table.getValueAt(i, 0).toString();
					String StudentId = table.getValueAt(i, 1).toString();
					String Attend = table.getValueAt(i, 2).toString();
					String Total = table.getValueAt(i, 3).toString();
					String Mid = table.getValueAt(i, 4).toString();
					String Fin = table.getValueAt(i, 5).toString();
					String HW = table.getValueAt(i, 6).toString();
					String Quiz = table.getValueAt(i, 7).toString();
					String Pre = table.getValueAt(i, 8).toString();
					String Report = table.getValueAt(i, 9).toString();
					stu[i] = new Student(name, StudentId, Attend, Total, Mid, Fin, HW, Quiz, Pre, Report);
				}
				break;

			case "DB에 저장":
				System.out.println("DB에 저장");
				Connection con = null;
				Statement s = null;
				String url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					// System.out.println("데이터베이스 연결 중...");
					con = DriverManager.getConnection(url, "root", "1234");
					// System.out.println("데이터베이스 연결 성공");

					s = con.createStatement();

					for (int i = 0; i < table.getRowCount(); i++) {
						String name = table.getValueAt(i, 0).toString();
						String StudentId = table.getValueAt(i, 1).toString();
						String Attend = table.getValueAt(i, 2).toString();
						String Total = table.getValueAt(i, 3).toString();
						String Mid = table.getValueAt(i, 4).toString();
						String Fin = table.getValueAt(i, 5).toString();
						String HW = table.getValueAt(i, 6).toString();
						String Quiz = table.getValueAt(i, 7).toString();
						String Pre = table.getValueAt(i, 8).toString();
						String Report = table.getValueAt(i, 9).toString();
						String Another = table.getValueAt(i, 10).toString();
						String rank_total = table.getValueAt(i, 11).toString();
						// SQL Insert

						String sql = "INSERT INTO person (name, StudentId, Attend ,Total ,Mid, Fin, HW, Quiz, Pre, Report, Another, rank_total) VALUES "
								+ "(" + "'" + name + "'," + StudentId + "," + Attend + "," + Total + "," + Mid + ","
								+ Fin + "," + HW + "," + Quiz + "," + Pre + "," + Report + "," + Another + "," + "'"
								+ rank_total + "')";
						s.executeUpdate(sql);

					}

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

					String path = "C:\\Users\\채소연\\Desktop\\sample.csv";
					FileWriter writer;

					try {
						File file = new File(path);
						writer = new FileWriter(file, true);

						while ((rec != null) && (rec.next())) {
							writer.write(rec.getString("name"));
							writer.write(",");
							writer.write(rec.getString("StudentId"));
							writer.write(",");
							writer.write(rec.getString("Attend"));
							writer.write(",");
							writer.write(rec.getString("Total"));
							writer.write(",");
							writer.write(rec.getString("Mid"));
							writer.write(",");
							writer.write(rec.getString("Fin"));
							writer.write(",");
							writer.write(rec.getString("HW"));
							writer.write(",");
							writer.write(rec.getString("Quiz"));
							writer.write(",");
							writer.write(rec.getString("Pre"));
							writer.write(",");
							writer.write(rec.getString("Report"));
							writer.write(",");
							writer.write(rec.getString("Another"));
							writer.write(",");
							writer.write(rec.getString("rank_total"));
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

			case "내용 저장":
				System.out.println("내용 저장");
				connect = null;
				s = null;
				url = "jdbc:mysql://localhost/score?characterEncoding=UTF-8&serverTimezone=UTC";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection(url, "root", "1234");

					s = connect.createStatement();

					for (int i = 0; i < table.getRowCount(); i++) {
						// stu[i] = new Student();
						// stu[i].setName(table.getValueAt(i, 0).toString());
						// String StudentId = table.getValueAt(i, 1).toString();
						// String Mid = table.getValueAt(i,2).toString();
						// String Fin = table.getValueAt(i, 3).toString();
						// String HW = table.getValueAt(i, 4).toString();
						// String Quiz = table.getValueAt(i, 5).toString();
						// String Pre = table.getValueAt(i, 6).toString();
						// String Report = table.getValueAt(i, 7).toString();
						// String Attend = table.getValueAt(i, 8).toString();
						// String Another = table.getValueAt(i, 9).toString();
						// String Total = table.getValueAt(i, 10).toString();
						// String Rank = table.getValueAt(i, 11).toString();
						//
						// // SQL Insert
						//
						// System.out.println(name + Mid);

						// String sql = "INSERT INTO person (name, StudentId, Mid ,Fin ,HW, Quiz, Pre,
						// Report, Attend, Another, Total, Rank) VALUES "
						// + "(" + "'" + name + "'," + StudentId + "," + Mid + "," + Fin + "," + HW +
						// ","
						// + Quiz + "," + Pre + "," + Report + "," + Attend + "," + Another + "," +
						// Total + "," + Rank// + "," + all
						// + ")";
						// System.out.println(sql);
						// s.executeUpdate(sql);

					}

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
			case "성적계산":
				System.out.println("성적계산");
				new ScoreCal();
				break;
			case "반영비율 설정":
				System.out.println("반영비율 설정");
				Perchant pc = new Perchant();
				pc.show();
				break;
			case "등급설정":
				System.out.println("등급설정");
				SetGrade sg = new SetGrade();
				sg.show();
				break;
			case "출석 현황":
				System.out.println("출석 현황");
				new UCheck();
				break;
			case "강좌평균 계산":
				System.out.println("강좌평균 계산");
				new ClassAvg(stu, stu.length);
				break;
			case "총점수 분포도":
				System.out.println("총점수 분포도 출력");
				// new TotalGraph();
				new EachGraph("Total");
				break;
			case "출석점수":
				System.out.println("출석점수 출력");
				new EachGraph("Attend");
				break;
			case "중간시험점수":
				System.out.println("중간시험점수 출력");
				new EachGraph("Mid");
				break;
			case "기말시험점수":
				System.out.println("기말시험점수 출력");
				new EachGraph("Fin");
				break;
			case "과제점수":
				System.out.println("과제점수 출력");
				new EachGraph("HW");
				break;
			case "퀴즈점수":
				System.out.println("퀴즈점수 출력");
				new EachGraph("Quiz");
				break;
			case "발표점수":
				System.out.println("발표점수 출력");
				new EachGraph("Pre");
				break;
			case "보고서점수":
				System.out.println("보고서점수 출력");
				new EachGraph("Report");
				break;
			case "기타점수":
				System.out.println("기타점수 출력");
				new EachGraph("Another");
				break;
			/////////////////////////////// 추가//////////////////////////////////
			case "학번 검색":
				System.out.println("학번 검색");
				model.setNumRows(0);
				break;
			case "이름 검색":
				System.out.println("이름 검색");
				int num = table.getRowCount();
				System.out.println(num);
				for (int i = 0; i < num; i++) {
					System.out.println(searchNameTextField.getText());
					if (searchNameTextField.getText().equals(stu[i].name)) {
						model.setNumRows(0);
						model.addRow(new Object[0]);
						model.setValueAt(stu[i].name, 0, 0);
						model.setValueAt(stu[i].StudentId, 0, 1);
						model.setValueAt(stu[i].Mid, 0, 2);
						model.setValueAt(stu[i].Fin, 0, 3);
						model.setValueAt(stu[i].Subj, 0, 4);
						model.setValueAt(stu[i].Pre, 0, 5);
						model.setValueAt(stu[i].Report, 0, 6);
						model.setValueAt(stu[i].Atend, 0, 7);
						model.setValueAt(stu[i].Another, 0, 8);
						if (stu[i].all == null) {
							model.setValueAt(null, 0, 9);
						} else {
							model.setValueAt(stu[i].all, 0, 9);
						}
						if (stu[i].rank == null) {
							model.setValueAt(null, 0, 10);
						} else {
							model.setValueAt(stu[i].rank, 0, 10);
						}
						break;
					}
					System.out.println(stu[i].name);
				}
				if (table.getRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "해당하는 학생 정보가 없습니다.");
				}
				break;

			}
		}

	}

}
