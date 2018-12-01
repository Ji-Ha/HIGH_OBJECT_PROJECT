import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MenuDemo extends Perchant implements ActionListener {
	JFrame jf = new JFrame();
	static Student[] stu = new Student[40];

	public MenuDemo() throws SQLException {
		jf.setTitle("성적처리 프로그램");
		makeMenu();
		makePanels();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(700, 1200);
		jf.setVisible(true);

	}

	public void makeMenu() {
		JMenuItem item;

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("실행");
		JMenu m3 = new JMenu("통계");
		JMenu m4 = new JMenu("출력");
		JMenu m5 = new JMenu("설정");

		m1.add(new JMenuItem("새 파일"));
		m1.add(new JMenuItem("불러오기"));
		m1.add(new JMenuItem("파일 저장"));
		m1.add(new JMenuItem("다른 이름으로 파일 저장"));

		mb.add(m1);

		item = new JMenuItem("성적계산");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("반영비율 설정");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("등급설정");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("출결점수 계산");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("강좌평균 계산");
		item.addActionListener(this);
		m2.add(item);

		mb.add(m2);

		item = new JMenuItem("총점수 분포도");
		item.addActionListener(this);
		m3.add(item);
		m3.addActionListener(this);
		JMenu m = new JMenu("각 점수 분포도");
		item = new JMenuItem("출석점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("중간시험점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("기말시험점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("과제점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("퀴즈점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("발표점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("보고서점수");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("기타점수");
		item.addActionListener(this);
		m.add(item);
		m3.add(m);
		m3.addActionListener(this);

		mb.add(m3);

		m4.add(new JMenuItem("파일 출력"));
		m4.add(new JMenuItem("화면 출력"));
		mb.add(m4);

		m5.add(new JMenuItem("출결 상태 변경"));
		m5.add(new JMenuItem("등급 비율 설정"));
		m5.add(new JMenuItem("각 점수의 반영 비율 설정"));
		m5.add(new JMenuItem("수강 인원 설정"));
		mb.add(m5);

		jf.setJMenuBar(mb);

	}

	public void makePanels() {
		// 최대 40명이기 떄문에, 40개로 만들어 놓았음.
		BorderLayout b = new BorderLayout();
		jf.setLayout(b);
		JPanel Npanel = new JPanel();
		JPanel Cpanel = new JPanel();
		JPanel Spanel = new JPanel();

		jf.add(Npanel, BorderLayout.NORTH);
		jf.add(Cpanel, BorderLayout.CENTER);
		jf.add(Spanel, BorderLayout.SOUTH);

		// 버튼.
		JButton save = new JButton("저장");

		// 라벨.
		JLabel LName = new JLabel("이름");
		JLabel LStuID = new JLabel("학번");
		JLabel LMid = new JLabel("중간");
		JLabel LFin = new JLabel("기말");
		JLabel LSub = new JLabel("과제");
		JLabel LQuz = new JLabel("퀴즈");
		JLabel LPr = new JLabel("발표");
		JLabel LRe = new JLabel("보고서");
		JLabel LPl = new JLabel("기타");
		JLabel LAll = new JLabel("총점");
		JLabel LRank = new JLabel("등급");
		JLabel LChul = new JLabel("출석");
		JButton button = new JButton("성적계산");

		Spanel.add(button);
		Npanel.add(LName);
		Npanel.add(LStuID);
		Npanel.add(LMid);
		Npanel.add(LFin);
		Npanel.add(LSub);
		Npanel.add(LQuz);
		Npanel.add(LPr);
		Npanel.add(LRe);
		Npanel.add(LChul);
		Npanel.add(LPl);
		Npanel.add(LAll);
		Npanel.add(LRank);

		// 이름과 점수.
		JTextField[] T_name = new JTextField[40];
		JTextField[] T_ID = new JTextField[40];
		JTextField[] T_mid = new JTextField[40];
		JTextField[] T_fin = new JTextField[40];
		JTextField[] T_Sub = new JTextField[40];
		JTextField[] T_Quz = new JTextField[40];
		JTextField[] T_Pr = new JTextField[40];
		JTextField[] T_Re = new JTextField[40];
		JTextField[] T_Pl = new JTextField[40];
		JTextField[] T_All = new JTextField[40];
		JTextField[] T_Rank = new JTextField[40];
		JTextField[] T_Chul = new JTextField[40];

		for (int i = 0; i < 40; i++) {
			T_name[i] = new JTextField();
			T_ID[i] = new JTextField();
			T_mid[i] = new JTextField();
			T_fin[i] = new JTextField();
			T_Sub[i] = new JTextField();
			T_Quz[i] = new JTextField();
			T_Pr[i] = new JTextField();
			T_Re[i] = new JTextField();
			T_Pl[i] = new JTextField();
			T_Chul[i] = new JTextField();
			T_All[i] = new JTextField();
			// T_All[i].setEnabled(false);
			T_Rank[i] = new JTextField();
			// T_Rank[i].setEnabled(false);

			Cpanel.add(T_name[i]);
			Cpanel.add(T_ID[i]);
			Cpanel.add(T_mid[i]);
			Cpanel.add(T_fin[i]);
			Cpanel.add(T_Sub[i]);
			Cpanel.add(T_Quz[i]);
			Cpanel.add(T_Pr[i]);
			Cpanel.add(T_Re[i]);
			Cpanel.add(T_Chul[i]);
			Cpanel.add(T_Pl[i]);
			Cpanel.add(T_All[i]);
			Cpanel.add(T_Rank[i]);

		}

		// 총점수를 구하기위한 이벤트

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				double[] all = new double[40];
				// for (int j = 0; j < 1; j++) {
				// String min = T_mid[j].getText();
				// String fin = T_fin[j].getText();
				// String Sub = T_Sub[j].getText();
				// String Quz = T_Quz[j].getText();
				// String Pr = T_Pr[j].getText();
				// String Re = T_Re[j].getText();
				// String Chul = T_Chul[j].getText();
				// String Pl = T_Pl[j].getText();
				//
				// all[j] = Double.parseDouble(min) + Double.parseDouble(fin) +
				// Double.parseDouble(Sub)
				// + Double.parseDouble(Quz) + Double.parseDouble(Pr) + Double.parseDouble(Re)
				// + Double.parseDouble(Chul) + Double.parseDouble(Pl);
				//
				// T_All[j].setText("" + all[j]);

				if (per[0] != 0) {
					for (int j = 0; j < 1; j++) {
						String min = T_mid[j].getText();
						String fin = T_fin[j].getText();
						String Sub = T_Sub[j].getText();
						String Quz = T_Quz[j].getText();
						String Pr = T_Pr[j].getText();
						String Re = T_Re[j].getText();
						String Chul = T_Chul[j].getText();
						String Pl = T_Pl[j].getText();

						all[j] = Double.parseDouble(min) * per[0] + Double.parseDouble(fin) * per[1]
								+ Double.parseDouble(Sub) * per[2] + Double.parseDouble(Quz) * per[3]
								+ Double.parseDouble(Pr) * per[4] + Double.parseDouble(Re) * per[5]
								+ Double.parseDouble(Chul) * per[6] + Double.parseDouble(Pl) * per[7];

						T_All[j].setText("" + all[j]);
					}
				}

			}
		});

		jf.setTitle("레이아웃 테스트");

		Npanel.setLayout(new GridLayout(0, 12, 3, 3));
		Npanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		Cpanel.setLayout(new GridLayout(40, 12, 3, 3));

		// 각각의 항목 비율 계산해주기.

	}

	// 비율을 반영하기위한 메서드

	public static void main(String[] args) throws SQLException {
		new MenuDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {
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