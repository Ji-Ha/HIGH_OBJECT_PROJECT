import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MenuDemo extends JFrame {
	private JTable table;
	static Student[] stu = new Student[40];
	static public double[] per = new double[8];
	static public double[] per1 = new double[8];
	JTextField searchNameTextField;
	Connection connect = null;
	int stuNum;
	private DefaultTableModel model;
	static int How_many_stu;

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JCheckBox jc;

		public TableCell() {
			jc = new JCheckBox();
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
				int arg5) {
			return jc;
		}

		@Override
		public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
			return jc;
		}

	}

	MenuDemo() {
		// 성적계산 버튼생성
		JPanel jp = new JPanel();
		JButton jb = new JButton("성적계산");
		jp.add(jb);
		add(jp, BorderLayout.SOUTH);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (per[0] == 0) {
						JOptionPane.showMessageDialog(null, "성적비율을 입력하세요.", "성적비율 미설정", JOptionPane.ERROR_MESSAGE);
					} else {
						double[] total = new double[40];
						for (int i = 0; i < table.getRowCount(); i++) {

							String Mid = table.getValueAt(i, 3).toString();
							String Fin = table.getValueAt(i, 4).toString();
							String HW = table.getValueAt(i, 5).toString();
							String Quiz = table.getValueAt(i, 6).toString();
							String Pre = table.getValueAt(i, 7).toString();
							String Report = table.getValueAt(i, 8).toString();
							String Att = table.getValueAt(i, 9).toString();
							String Another = table.getValueAt(i, 10).toString();

							total[i] = Double.parseDouble(Mid) * per[0] + Double.parseDouble(Fin) * per[1]
									+ Double.parseDouble(HW) * per[2] + Double.parseDouble(Quiz) * per[3]
									+ Double.parseDouble(Pre) * per[4] + Double.parseDouble(Report) * per[5]
									+ Double.parseDouble(Att) * per[6] + Double.parseDouble(Another) * per[7];

							model.setValueAt(total[i], i, 11);
							try {
								stu[i].setAll(Double.toString(total[i]));
							} catch (NullPointerException c) {

							}
						}
					}
					if (per1[0] == 0) {

						JOptionPane.showMessageDialog(null, "등급비율을 입력하세요.", "등급비율 미설정", JOptionPane.ERROR_MESSAGE);
					} else {

						double[] index = { table.getRowCount() * per1[0], table.getRowCount() * per1[1],
								table.getRowCount() * per1[2], table.getRowCount() * per1[3],
								table.getRowCount() * per1[4], table.getRowCount() * per1[5],
								table.getRowCount() * per1[6], table.getRowCount() * per1[7] };

						String[] src = new String[40];
						double[] sr = new double[40];// 총점이 큰순서대로 나열된 배열 0-9까지있다.
						double[] high = new double[40];// 원래 그대로의 총점 점수 배열

						for (int i = 0; i < table.getRowCount(); i++) {
							src[i] = table.getValueAt(i, 10).toString();
							sr[i] = Double.parseDouble(src[i]);
							high[i] = Double.parseDouble(src[i]);
						}

						for (int i = 0; i < table.getRowCount(); i++) {
							for (int j = i + 1; j < table.getRowCount(); j++) {
								double tmp;
								if (sr[i] < sr[j]) {
									tmp = sr[i];
									sr[i] = sr[j];
									sr[j] = tmp;
								}
							}
						}

						// high에는 원래배열 sr 큰수배열 index 비율배열
						for (int i = 0; i <= index[0]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("A+", j, 12);
								}
							}
						}
						for (int i = (int) index[0] + 1; i <= index[1]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("A", j, 12);
								}
							}
						}
						for (int i = (int) index[1] + 1; i <= index[2]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("B+", j, 12);
								}
							}
						}
						for (int i = (int) index[2] + 1; i <= index[3]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("B", j, 12);
								}
							}
						}
						for (int i = (int) index[3] + 1; i <= index[4]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("C+", j, 12);
								}
							}
						}
						for (int i = (int) index[4] + 1; i <= index[5]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("C", j, 12);
								}
							}
						}
						for (int i = (int) index[5] + 1; i <= index[6]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("D", j, 12);
								}
							}
						}
						for (int i = (int) index[6] + 1; i <= index[7]; i++) {
							for (int j = 0; j < table.getRowCount(); j++) {
								if (sr[i] == high[j]) {
									model.setValueAt("F", j, 12);
								}
							}
						}
						for (int i = 0; i < table.getRowCount(); i++) {
							stu[i].setRank(table.getValueAt(i, 12).toString());
						}
					}
				} catch (NumberFormatException nf) {
					JOptionPane.showMessageDialog(null, "미입력 칸이 있습니다.");
				}
			}
		});

	}

	private void run() {
		setTitle("성적 처리 프로그램");
		makeMenu();
		setSize(800, 345);
		setLocation(500, 280);
		model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(40);
		table.getColumnModel().getColumn(0).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(0).setCellEditor(new TableCell());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void SetModel(DefaultTableModel m) {
		this.model = m;
	}

	public DefaultTableModel GetModel() {
		return model;
	}

	void makeMenu() {
		table = new JTable();
		getContentPane().add(table);
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("실행");
		JMenu m3 = new JMenu("통계");
		JMenu m4 = new JMenu("출석");
		JMenu m5 = new JMenu("정렬");

		JMenuItem item = new JMenuItem("csv파일 불러오기");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("DB불러오기");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("DB에 저장");
		item.addActionListener(new MenuActionListener());
		m1.add(item);
		item = new JMenuItem("CSV에 저장");
		item.addActionListener(new MenuActionListener());
		m1.add(item);

		item = new JMenuItem("인원수 설정");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("반영비율 설정");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("등급설정");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("석차 열람");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("최고 점수 확인");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("최저 점수 확인");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("등급별 최고 점수 확인");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("등급별 최저 점수 확인");
		item.addActionListener(new MenuActionListener());
		m2.add(item);
		item = new JMenuItem("사진 검색");
		item.addActionListener(new MenuActionListener());
		m2.add(item);

		item = new JMenuItem("각 점수 평균 계산");
		item.addActionListener(new MenuActionListener());
		m3.add(item);
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

		JMenu mm = new JMenu("학번별 분포도");
		item = new JMenuItem("17학번");
		item.addActionListener(new MenuActionListener());
		mm.add(item);
		item = new JMenuItem("16학번");
		item.addActionListener(new MenuActionListener());
		mm.add(item);
		item = new JMenuItem("15학번");
		item.addActionListener(new MenuActionListener());
		mm.add(item);
		item = new JMenuItem("14학번");
		item.addActionListener(new MenuActionListener());
		mm.add(item);
		m3.add(mm);
		mb.add(m3);

		item = new JMenuItem("출석 현황");
		item.addActionListener(new MenuActionListener());
		m4.add(item);
		item = new JMenuItem("출석 새로고침");
		item.addActionListener(new MenuActionListener());
		m4.add(item);

		item = new JMenuItem("이름 정렬");
		item.addActionListener(new MenuActionListener());
		m5.add(item);

		item = new JMenuItem("학번 정렬");
		item.addActionListener(new MenuActionListener());
		m5.add(item);

		item = new JMenuItem("총점 정렬");
		item.addActionListener(new MenuActionListener());
		m5.add(item);

		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);

		mb.add(Box.createHorizontalStrut(30));
		JButton searchName = new JButton("이름 검색");
		JButton searchStudentId = new JButton("학번 검색");
		JButton showAllStu = new JButton("전체학생보기");
		searchStudentId.addActionListener(new MenuActionListener());
		searchName.addActionListener(new MenuActionListener());
		showAllStu.addActionListener(new MenuActionListener());
		searchNameTextField = new JTextField(3);
		mb.add(searchNameTextField);
		mb.add(searchName);
		mb.add(searchStudentId);
		mb.add(showAllStu);
		mb.add(Box.createHorizontalStrut(100));
		setJMenuBar(mb);

		// Table Model
		model = (DefaultTableModel) table.getModel();
		model.addColumn("Check");
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
			case "csv파일 불러오기":
				System.out.println("불러오기");
				JFileChooser fileopen = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("Text/CSV file", "txt", "csv");
				fileopen.addChoosableFileFilter(filter);

				int ret = fileopen.showDialog(null, "Choose file");

				if (ret == JFileChooser.APPROVE_OPTION) {
					if (model != null) {
						model.setNumRows(0);
					}
					// Read Text file
					File file = fileopen.getSelectedFile();

					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String line;
						int row = 0;
						while ((line = br.readLine()) != null) {
							String[] arr = line.split(",");
							model.addRow(new Object[0]);
							table.getColumnModel().getColumn(0).setCellRenderer(new TableCell());
							table.getColumnModel().getColumn(0).setCellEditor(new TableCell());
							model.setValueAt(arr[0], row, 1);
							model.setValueAt(arr[1], row, 2);
							model.setValueAt(arr[2], row, 3);
							model.setValueAt(arr[3], row, 4);
							model.setValueAt(arr[4], row, 5);
							model.setValueAt(arr[5], row, 6);
							model.setValueAt(arr[6], row, 7);
							model.setValueAt(arr[7], row, 8);
							model.setValueAt(arr[8], row, 9);
							model.setValueAt(arr[9], row, 10);
							row++;
						}
						br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				for (int i = 0; i < table.getRowCount(); i++) {
					String name = table.getValueAt(i, 1).toString();
					String StudentId = table.getValueAt(i, 2).toString();
					String Mid = table.getValueAt(i, 3).toString();
					String Fin = table.getValueAt(i, 4).toString();
					String HW = table.getValueAt(i, 5).toString();
					String Quiz = table.getValueAt(i, 6).toString();
					String Pre = table.getValueAt(i, 7).toString();
					String Report = table.getValueAt(i, 8).toString();
					String Attend = table.getValueAt(i, 9).toString();
					String Another = table.getValueAt(i, 10).toString();
					String Total = "0";// table.getValueAt(i, 10).toString();
					// String rank_total = table.getValueAt(i, 11).toString();
					stu[i] = new Student(name, StudentId, Mid, Fin, HW, Quiz, Pre, Report, Attend, Another);
					// System.out.println(Fin);
				}
				stuNum = table.getRowCount();
				break;
			case "DB불러오기":
				model.setNumRows(0);
				System.out.println("DB에 저장");
				Connection con = null;
				PreparedStatement pstmt = null;
				String url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, "root", "1234");

					pstmt = con.prepareStatement("SELECT * FROM person");
					ResultSet rs = pstmt.executeQuery();

					int row = 0;
					while (rs.next()) {
						model.addRow(new Object[0]);
						table.getColumnModel().getColumn(0).setCellRenderer(new TableCell());
						table.getColumnModel().getColumn(0).setCellEditor(new TableCell());
						model.setValueAt(rs.getString(1), row, 1);
						model.setValueAt(rs.getString(2), row, 2);
						model.setValueAt(rs.getString(3), row, 3);
						model.setValueAt(rs.getString(4), row, 4);
						model.setValueAt(rs.getString(5), row, 5);
						model.setValueAt(rs.getString(6), row, 6);
						model.setValueAt(rs.getString(7), row, 7);
						model.setValueAt(rs.getString(8), row, 8);
						model.setValueAt(rs.getString(9), row, 9);
						model.setValueAt(rs.getString(10), row, 10);
						stu[row] = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
								rs.getString(10));
						if (rs.getString(11) != null) {
							model.setValueAt(rs.getString(11), row, 11);
							stu[row].setAll(rs.getString(11));
						}
						if (rs.getString(12) != null) {
							model.setValueAt(rs.getString(12), row, 12);
							stu[row].setRank(rs.getString(12));
						}
						// System.out.println(Integer.parseInt(stu[row].getMid()));
						// System.out.print(stu[row].getName());
						row++;
					}
					stuNum = table.getRowCount();
					JOptionPane.showMessageDialog(null, "Export Data Successfully");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
				break;
			case "DB에 저장":
				System.out.println("DB에 저장");
				con = null;
				Statement s = null;
				url = "jdbc:mysql://localhost:1234/score?characterEncoding=UTF-8&serverTimezone=UTC";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, "root", "1234");

					s = con.createStatement();
					s.executeUpdate("DELETE FROM person");
					try {
						for (int i = 0; i < table.getRowCount(); i++) {
							String name = table.getValueAt(i, 1).toString();
							String StudentId = table.getValueAt(i, 2).toString();
							String Mid = table.getValueAt(i, 3).toString();
							String Fin = table.getValueAt(i, 4).toString();
							String HW = table.getValueAt(i, 5).toString();
							String Quiz = table.getValueAt(i, 6).toString();
							String Pre = table.getValueAt(i, 7).toString();
							String Report = table.getValueAt(i, 8).toString();
							String Attend = table.getValueAt(i, 9).toString();
							String Another = table.getValueAt(i, 10).toString();
							String Total = null;
							String rank_total = null;
							if (table.getValueAt(i, 11) != null) {
								Total = table.getValueAt(i, 11).toString();
							} else {

							}
							if (table.getValueAt(i, 12) != null) {
								rank_total = table.getValueAt(i, 12).toString();
							} else {

							}

							String sql = "INSERT INTO person (name, StudentId, Attend ,Total ,Mid, Fin, HW, Quiz, Pre, Report, Another, rank_total) VALUES "
									+ "(" + "'" + name + "'," + StudentId + "," + Attend + "," + Total + "," + Mid + ","
									+ Fin + "," + HW + "," + Quiz + "," + Pre + "," + Report + "," + Another + "," + "'"
									+ rank_total + "')";
							s.executeUpdate(sql);

						}
					} catch (NullPointerException ex) {
						// continue;
					}
					JOptionPane.showMessageDialog(null, "Import Data Successfully");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
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
							writer.write(rec.getString("Report"));
							writer.write(",");
							writer.write(rec.getString("Attend"));
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
						JOptionPane.showMessageDialog(null, "CSV 파일에 저장을 성공했습니다.");
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
				new UCheck().run();
				break;
			case "출석 새로고침":
				for (int i = 0; i < table.getRowCount(); i++) {
					if (stu[i] == null) {
						break;
					}
					model.setValueAt(stu[i].Attend, i, 9);
					if (stu[i].rank.equals("F")) {
						model.setValueAt(stu[i].rank, i, 12);
					}
				}

				break;
			case "각 점수 평균 계산":
				System.out.println("강좌평균 계산");
				new ClassAvg(stu, stuNum);
				break;
			case "총점수 분포도":
				System.out.println("총점수 분포도 출력");
				// new TotalGraph();
				new EachGraph("all", stu, stuNum);
				break;
			case "학번별 분포도":
				System.out.println("학번별 분포도 출력");
				// new TotalGraph();
				new NumGraph("all", stu, stuNum);
				break;
			case "출석점수":
				System.out.println("출석점수 출력");
				new EachGraph("Attend", stu, stuNum);
				break;
			case "중간시험점수":
				System.out.println("중간시험점수 출력");
				new EachGraph("Mid", stu, stuNum);
				break;
			case "기말시험점수":
				System.out.println("기말시험점수 출력");
				new EachGraph("Fin", stu, stuNum);
				break;
			case "과제점수":
				System.out.println("과제점수 출력");
				new EachGraph("HW", stu, stuNum);
				break;
			case "퀴즈점수":
				System.out.println("퀴즈점수 출력");
				new EachGraph("Quiz", stu, stuNum);
				break;
			case "발표점수":
				System.out.println("발표점수 출력");
				new EachGraph("Pre", stu, stuNum);
				break;
			case "보고서점수":
				System.out.println("보고서점수 출력");
				new EachGraph("Report", stu, stuNum);
				break;
			case "기타점수":
				System.out.println("기타점수 출력");
				new EachGraph("Another", stu, stuNum);
				break;
			case "17학번":
				System.out.println("17학번 총점수 분포도");
				new NumGraph("6017", stu, stuNum);
				break;
			case "16학번":
				System.out.println("16학번 총점수 분포도");
				new NumGraph("6016", stu, stuNum);
				break;
			case "15학번":
				System.out.println("15학번 총점수 분포도");
				new NumGraph("6015", stu, stuNum);
				break;
			case "14학번":
				System.out.println("14학번 총점수 분포도");
				new NumGraph("6014", stu, stuNum);
				break;

			/////////////////////////////// 추가//////////////////////////////////
			case "학번 검색":
				System.out.println("학번 검색");
				// int num1 = table.getRowCount();
				System.out.println(stuNum);
				for (int i = 0; i < stuNum; i++) {
					if (stu[i] == null) {
						break;
					}
					System.out.println(searchNameTextField.getText());
					if (searchNameTextField.getText().equals(stu[i].StudentId)) {
						model.setNumRows(0);
						model.addRow(new Object[0]);
						model.setValueAt(stu[i].name, 0, 1);
						model.setValueAt(stu[i].StudentId, 0, 2);
						model.setValueAt(stu[i].Mid, 0, 3);
						model.setValueAt(stu[i].Fin, 0, 4);
						model.setValueAt(stu[i].Subj, 0, 5);
						model.setValueAt(stu[i].Quiz, 0, 6);
						model.setValueAt(stu[i].Pre, 0, 7);
						model.setValueAt(stu[i].Report, 0, 8);
						model.setValueAt(stu[i].Attend, 0, 9);
						model.setValueAt(stu[i].Another, 0, 10);
						if (stu[i].all == null) {
							model.setValueAt(null, 0, 11);
						} else {
							model.setValueAt(stu[i].all, 0, 11);
						}
						if (stu[i].rank == null) {
							model.setValueAt(null, 0, 12);
						} else {
							model.setValueAt(stu[i].rank, 0, 12);
						}
						break;
					}
					System.out.println(stu[i].name);
				}
				if (table.getRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "해당하는 학생 정보가 없습니다.");
				}
				break;
			case "이름 검색":
				System.out.println("이름 검색");
				System.out.println(stuNum);
				for (int i = 0; i < stuNum; i++) {
					if (stu[i] == null) {
						break;
					}
					System.out.println(searchNameTextField.getText());
					if (searchNameTextField.getText().equals(stu[i].name)) {
						model.setNumRows(0);
						model.addRow(new Object[0]);
						model.setValueAt(stu[i].name, 0, 1);
						model.setValueAt(stu[i].StudentId, 0, 2);
						model.setValueAt(stu[i].Mid, 0, 3);
						model.setValueAt(stu[i].Fin, 0, 4);
						model.setValueAt(stu[i].Subj, 0, 5);
						model.setValueAt(stu[i].Quiz, 0, 6);
						model.setValueAt(stu[i].Pre, 0, 7);
						model.setValueAt(stu[i].Report, 0, 8);
						model.setValueAt(stu[i].Attend, 0, 9);
						model.setValueAt(stu[i].Another, 0, 10);
						// if (stu[i].all == null) {
						// model.setValueAt(null, 0, 11);
						// } else {
						// model.setValueAt(stu[i].all, 0, 11);
						// }
						model.setValueAt(stu[i].all, 0, 11);
						model.setValueAt(stu[i].rank, 0, 12);
						// if (stu[i].rank == null) {
						// model.setValueAt(null, 0, 12);
						// } else {
						// model.setValueAt(stu[i].rank, 0, 12);
						// }
						break;
					}
					System.out.println(stu[i].name);
				}
				if (table.getRowCount() != 1) {
					JOptionPane.showMessageDialog(null, "해당하는 학생 정보가 없습니다.");
				}
				break;
			case "전체학생보기":
				System.out.println("전체학생보기");
				model.setNumRows(0);
				for (int i = 0; i < stuNum; i++) {
					if (stu[i] == null) {
						break;
					}
					model.addRow(new Object[0]);
					model.setValueAt(stu[i].name, i, 1);
					model.setValueAt(stu[i].StudentId, i, 2);
					model.setValueAt(stu[i].Mid, i, 3);
					model.setValueAt(stu[i].Fin, i, 4);
					model.setValueAt(stu[i].Subj, i, 5);
					model.setValueAt(stu[i].Quiz, i, 6);
					model.setValueAt(stu[i].Pre, i, 7);
					model.setValueAt(stu[i].Report, i, 8);
					model.setValueAt(stu[i].Attend, i, 9);
					model.setValueAt(stu[i].Another, i, 10);
					model.setValueAt(stu[i].all, i, 11);
					model.setValueAt(stu[i].rank, i, 12);
				}
				break;
			case "최고 점수 확인":
				System.out.println("최고 점수 확인");
				if (stuNum == 0) {
					JOptionPane.showMessageDialog(null, "학생 정보 입력 후 실행해주세요.");
					break;
				}
				new FindLowestHighest("최고 점수 확인", stu, stuNum);
				break;
			case "최저 점수 확인":
				System.out.println("최저 점수 확인");
				if (stuNum == 0) {
					JOptionPane.showMessageDialog(null, "학생 정보 입력 후 실행해주세요.");
					break;
				}
				new FindLowestHighest("최저 점수 확인", stu, stuNum);
				break;
			case "이름 정렬":
				System.out.println("이름으로 정렬");
				new name_sort();
				break;
			case "학번 정렬":
				System.out.println("이름으로 정렬");
				new ID_sort();
				break;
			case "총점 정렬":
				System.out.println("이름으로 정렬");
				new Total_sort();
				break;
			case "석차 열람":
				System.out.println("석차 열람");
				new ranking();
				break;
			case "사진 검색":
				System.out.println("사진 검색");
				SelectPhoto a1 = new SelectPhoto();
				a1.show();
				break;
			case "인원수 설정":
				System.out.println("인원 수 설정");
				new SaveNum_Peo().run();
				break;
			case "등급별 최고 점수 확인":
				System.out.println("등급별 최고 점수 확인");
				if (stuNum == 0) {
					JOptionPane.showMessageDialog(null, "학생 정보 입력 후 실행해주세요.");
					break;
				}
				new FindGradeLowestHighest("등급별 최고 점수 확인", stu, stuNum);
				break;
			case "등급별 최저 점수 확인":
				System.out.println("등급별 최저 점수 확인");
				if (stuNum == 0) {
					JOptionPane.showMessageDialog(null, "학생 정보 입력 후 실행해주세요.");
					break;
				}
				new FindGradeLowestHighest("등급별 최저 점수 확인", stu, stuNum);
				break;
			}
		}

	}

}