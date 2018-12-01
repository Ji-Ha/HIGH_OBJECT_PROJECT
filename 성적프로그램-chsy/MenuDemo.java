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
		jf.setTitle("����ó�� ���α׷�");
		makeMenu();
		makePanels();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(700, 1200);
		jf.setVisible(true);

	}

	public void makeMenu() {
		JMenuItem item;

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("����");
		JMenu m2 = new JMenu("����");
		JMenu m3 = new JMenu("���");
		JMenu m4 = new JMenu("���");
		JMenu m5 = new JMenu("����");

		m1.add(new JMenuItem("�� ����"));
		m1.add(new JMenuItem("�ҷ�����"));
		m1.add(new JMenuItem("���� ����"));
		m1.add(new JMenuItem("�ٸ� �̸����� ���� ����"));

		mb.add(m1);

		item = new JMenuItem("�������");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("�ݿ����� ����");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("��޼���");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("������� ���");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("������� ���");
		item.addActionListener(this);
		m2.add(item);

		mb.add(m2);

		item = new JMenuItem("������ ������");
		item.addActionListener(this);
		m3.add(item);
		m3.addActionListener(this);
		JMenu m = new JMenu("�� ���� ������");
		item = new JMenuItem("�⼮����");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("�߰���������");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("�⸻��������");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("��������");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("��������");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("��ǥ����");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("��������");
		item.addActionListener(this);
		m.add(item);
		item = new JMenuItem("��Ÿ����");
		item.addActionListener(this);
		m.add(item);
		m3.add(m);
		m3.addActionListener(this);

		mb.add(m3);

		m4.add(new JMenuItem("���� ���"));
		m4.add(new JMenuItem("ȭ�� ���"));
		mb.add(m4);

		m5.add(new JMenuItem("��� ���� ����"));
		m5.add(new JMenuItem("��� ���� ����"));
		m5.add(new JMenuItem("�� ������ �ݿ� ���� ����"));
		m5.add(new JMenuItem("���� �ο� ����"));
		mb.add(m5);

		jf.setJMenuBar(mb);

	}

	public void makePanels() {
		// �ִ� 40���̱� ������, 40���� ����� ������.
		BorderLayout b = new BorderLayout();
		jf.setLayout(b);
		JPanel Npanel = new JPanel();
		JPanel Cpanel = new JPanel();
		JPanel Spanel = new JPanel();

		jf.add(Npanel, BorderLayout.NORTH);
		jf.add(Cpanel, BorderLayout.CENTER);
		jf.add(Spanel, BorderLayout.SOUTH);

		// ��ư.
		JButton save = new JButton("����");

		// ��.
		JLabel LName = new JLabel("�̸�");
		JLabel LStuID = new JLabel("�й�");
		JLabel LMid = new JLabel("�߰�");
		JLabel LFin = new JLabel("�⸻");
		JLabel LSub = new JLabel("����");
		JLabel LQuz = new JLabel("����");
		JLabel LPr = new JLabel("��ǥ");
		JLabel LRe = new JLabel("����");
		JLabel LPl = new JLabel("��Ÿ");
		JLabel LAll = new JLabel("����");
		JLabel LRank = new JLabel("���");
		JLabel LChul = new JLabel("�⼮");
		JButton button = new JButton("�������");

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

		// �̸��� ����.
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

		// �������� ���ϱ����� �̺�Ʈ

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

		jf.setTitle("���̾ƿ� �׽�Ʈ");

		Npanel.setLayout(new GridLayout(0, 12, 3, 3));
		Npanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		Cpanel.setLayout(new GridLayout(40, 12, 3, 3));

		// ������ �׸� ���� ������ֱ�.

	}

	// ������ �ݿ��ϱ����� �޼���

	public static void main(String[] args) throws SQLException {
		new MenuDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {
		case "�������":
			System.out.println("�������");

			new ScoreCal();
			break;
		case "�ݿ����� ����":
			System.out.println("�ݿ����� ����");
			new Perchant();
			break;
		case "��޼���":
			System.out.println("��޼���");
			new SetGrade();
			break;
		case "������� ���":
			System.out.println("������� ���");
			new UCheck();
			break;
		case "������� ���":
			System.out.println("������� ���");
			new ClassAvg();
			break;
		case "������ ������":
			System.out.println("������ ������ ���");
			new TotalGraph();
			break;
		case "�⼮����":
			System.out.println("�⼮���� ���");
			// new EachGraph("attenance");
			break;
		case "�߰���������":
			System.out.println("�߰��������� ���");
			new EachGraph("middle");
			break;
		case "�⸻��������":
			System.out.println("�⸻�������� ���");
			new EachGraph("final");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("report");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("quiz");
			break;
		case "��ǥ����":
			System.out.println("��ǥ���� ���");
			new EachGraph("announcement");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("report");
			break;
		case "��Ÿ����":
			System.out.println("��Ÿ���� ���");
			new EachGraph("other");
			break;

		}

	}

}