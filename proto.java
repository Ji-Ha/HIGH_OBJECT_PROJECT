import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import 성적처리.ClassAvg;
import 성적처리.EachGraph;
import 성적처리.Perchant;
import 성적처리.ScoreCal;
import 성적처리.SetGrade;
import 성적처리.TotalGraph;
import 성적처리.UCheck;

public class proto extends JFrame {
	static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/score?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	
	static final String DEFAULT_QUERY = "SELECT * FROM person";
	
	private Using_DB tableModel;
	private JTextArea queryArea;
	
	public proto() {
		super("Displaying Query Results");
		
		try {
			tableModel = 
				new Using_DB(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			JMenuItem item;
			
			//메뉴바 생성
			JMenuBar mb = new JMenuBar();
			JMenu m1 = new JMenu("파일");
			JMenu m2 = new JMenu("실행");
			JMenu m3 = new JMenu("통계");
			JMenu m4 = new JMenu("출석");
			JMenu m5 = new JMenu("설정");
			
			//파일
			m1.add(new JMenuItem("새 파일"));
			m1.add(new JMenuItem("불러오기"));
			m1.add(new JMenuItem("파일 저장"));
			m1.add(new JMenuItem("다른 이름으로 파일 저장"));
			
			//실행
			item = new JMenuItem("성적계산");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("반영비율 설정");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("등급설정");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("출결점수 계산");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("강좌평균 계산");
//			item.addActionListener(this);
			m2.add(item);

			//통계
			item = new JMenuItem("총점수 분포도");
//			item.addActionListener(this);
			m3.add(item);
//			m3.addActionListener(this);
			JMenu m = new JMenu("각 점수 분포도");
			item = new JMenuItem("출석점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("중간시험점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("기말시험점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("과제점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("퀴즈점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("발표점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("보고서점수");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("기타점수");
//			item.addActionListener(this);
			m.add(item);
			m3.add(m);
//			m3.addActionListener(this);

			mb.add(m3);
			//출석.
			//추가 부탁.
			
			//설정
			m5.add(new JMenuItem("출결 상태 변경"));
			m5.add(new JMenuItem("등급 비율 설정"));
			m5.add(new JMenuItem("각 점수의 반영 비율 설정"));
			m5.add(new JMenuItem("수강 인원 설정"));
			
			//메뉴바에 메뉴들 추가.
			mb.add(m1);mb.add(m2);mb.add(m3);mb.add(m4);mb.add(m5);

			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();
			

			this.add(mb, BorderLayout.NORTH);
			this.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			
			
			//접근하기 위해서 이렇게 만들어 주었음.
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			this.setSize(500, 250);
			this.setVisible(true);
			
			filterButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String text = filterText.getText();
						
						if(text.length() == 0) {
							sorter.setRowFilter(null);
						}else {
							try {
								sorter.setRowFilter(RowFilter.regexFilter(text));
							}catch(PatternSyntaxException pse) {
								JOptionPane.showMessageDialog(null, "Bad regex pattern", 
										"Bad regex pattern", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			);
		}catch(SQLException sqlException) {
			JOptionPane.showMessageDialog(null,  sqlException.getMessage(),	
					"Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectedFromDatabase();
			System.exit(1);
		}
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosed(WindowEvent event) {
					tableModel.disconnectedFromDatabase();
					System.exit(0);
				}
			}
		);
	}
	
	public static void main(String[] args) {
		new proto();
	}
	
	public void actionPerformed(ActionEvent e) {

		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {
		case "불러오기":
			//하은누나꺼랑 섞어야해.
			System.out.println("되는거지?");
			
			break;
		case "성적계산":
			System.out.println("성적계산");

			new ScoreCal();
			break;
		case "반영비율 설정":
			System.out.println("반영비율 설정");
			new Perchant();
			break;
		case "등급설정":
			System.out.println("등급설정");
			new SetGrade();
			break;
		case "출결점수 계산":
			System.out.println("출결점수 계산");
			new UCheck();
			break;
		case "강좌평균 계산":
			System.out.println("강좌평균 계산");
			new ClassAvg();
			break;
		case "총점수 분포도":
			System.out.println("총점수 분포도 출력");
			new TotalGraph();
			break;
		case "출석점수":
			System.out.println("출석점수 출력");
			// new EachGraph("attenance");
			break;
		case "중간시험점수":
			System.out.println("중간시험점수 출력");
			new EachGraph("middle");
			break;
		case "기말시험점수":
			System.out.println("기말시험점수 출력");
			new EachGraph("final");
			break;
		case "과제점수":
			System.out.println("과제점수 출력");
			new EachGraph("report");
			break;
		case "퀴즈점수":
			System.out.println("퀴즈점수 출력");
			new EachGraph("quiz");
			break;
		case "발표점수":
			System.out.println("발표점수 출력");
			new EachGraph("announcement");
			break;
		case "보고서점수":
			System.out.println("보고서점수 출력");
			new EachGraph("report");
			break;
		case "기타점수":
			System.out.println("기타점수 출력");
			new EachGraph("other");
			break;

		}

	}
}
