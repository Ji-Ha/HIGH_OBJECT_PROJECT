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
public class MenuDemo extends JFrame implements ActionListener {

	// 학생 설정.
	static Student[] stu = new Student[40];

	public MenuDemo() throws SQLException {
		super("성적처리 프로그램");
		makeMenu();
		makePanels();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 1200);
		setVisible(true);
	}

	public void makeMenu() {
		JMenuItem item;

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("실행");
		JMenu m3 = new JMenu("통계");
		JMenu m4 = new JMenu("출석");
		JMenu m5 = new JMenu("설정");

		m1.add(new JMenuItem("불러오기"));
		m1.add(new JMenuItem("저장"));

		mb.add(m1);

		m2.add(new JMenuItem("성적 계산"));
		m2.add(new JMenuItem("등급 계산"));
		m2.add(new JMenuItem("출결 점수 계산"));
		m2.add(new JMenuItem("강좌 평균 계산"));
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

		m5.add(new JMenuItem("등급 비율 설정"));
		m5.add(new JMenuItem("각 점수의 반영 비율 설정"));
		m5.add(new JMenuItem("수강 인원 설정"));
		mb.add(m5);

		setJMenuBar(mb);
	}

	public static void main(String[] args) throws SQLException {
		new MenuDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {
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

	public void makePanels() {
		// 최대 40명이기 떄문에, 40개로 만들어 놓았음.
		BorderLayout b = new BorderLayout();
		setLayout(b);
		JPanel Npanel = new JPanel();
		JPanel Cpanel = new JPanel();
		JPanel Spanel = new JPanel();

		add(Npanel, BorderLayout.NORTH);
		add(Cpanel, BorderLayout.CENTER);
		add(Spanel, BorderLayout.SOUTH);

		// 버튼.
		JButton save = new JButton("DB에 저장");

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
			T_All[i].setEnabled(false);
			T_Rank[i] = new JTextField();
			T_Rank[i].setEnabled(false);

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

		setTitle("레이아웃 테스트");

		Spanel.add(save);
		Npanel.setLayout(new GridLayout(0, 12, 3, 3));
		Npanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		Cpanel.setLayout(new GridLayout(40, 12, 3, 3));

		ActionListener listener1 = e -> {
			saveDB save1 = new saveDB();
			if (e.getSource() == save) {
				System.out.println("dhdn");
				for (int i = 0; i < 40; i++) {
					if (T_name[i].getText().isEmpty()) {
						//
					} else {
						stu[i] = new Student();

						stu[i].name = T_name[i].getText();
						stu[i].StudentId = T_ID[i].getText();
						stu[i].Mid = Integer.parseInt(T_mid[i].getText());
						stu[i].Fin = Integer.parseInt(T_fin[i].getText());
						stu[i].Subj = Integer.parseInt(T_Sub[i].getText());
						stu[i].Quiz = Integer.parseInt(T_Quz[i].getText());
						stu[i].Pre = Integer.parseInt(T_Pr[i].getText());
						stu[i].Report = Integer.parseInt(T_Re[i].getText());
						stu[i].Atend = Integer.parseInt(T_Chul[i].getText());
						stu[i].Another = Integer.parseInt(T_Pl[i].getText());

						try {
							saveDB.saving(stu[i]);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

		};
		// save에 리스너 저장.
		save.addActionListener(listener1);
	}

}