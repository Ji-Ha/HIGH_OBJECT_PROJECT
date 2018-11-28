import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UCheck extends JFrame implements ActionListener {

	public UCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("출결 관리대장");
		setLocation(20, 20);
		setSize(800, 1300);

		makePanels();
		makeMenu();

		setVisible(true);
	}

	public void makeMenu() {
		JMenuItem item;

		JMenuBar mb = new JMenuBar();

		JMenu m1 = new JMenu("불러오기");
		JMenu m2 = new JMenu("출석점수 계산");

		item = new JMenuItem("파일 불러오기");
		item.addActionListener(this);
		m1.add(item);
		m1.addActionListener(this);

		mb.add(m1);
		mb.add(m2);

		setJMenuBar(mb);

	}

	public void makePanels() {

		BorderLayout br = new BorderLayout();
		setLayout(br);
		JPanel Npanel = new JPanel();
		JPanel Cpanel = new JPanel();

		add(Npanel, BorderLayout.NORTH);
		add(Cpanel, BorderLayout.CENTER);

		JLabel name = new JLabel("학번");
		JLabel n1 = new JLabel("1주차");
		JLabel n2 = new JLabel("2주차");
		JLabel n3 = new JLabel("3주차");
		JLabel n4 = new JLabel("4주차");
		JLabel n5 = new JLabel("5주차");
		JLabel n6 = new JLabel("6주차");
		JLabel n7 = new JLabel("7주차");
		JLabel n8 = new JLabel("8주차");
		JLabel n9 = new JLabel("9주차");
		JLabel n10 = new JLabel("10주차");
		JLabel n11 = new JLabel("11주차");
		JLabel n12 = new JLabel("12주차");
		JLabel n13 = new JLabel("13주차");
		JLabel n14 = new JLabel("14주차");
		JLabel n15 = new JLabel("15주차");
		JLabel n16 = new JLabel("16주차");

		Npanel.add(name);
		Npanel.add(n1);
		Npanel.add(n2);
		Npanel.add(n3);
		Npanel.add(n4);
		Npanel.add(n5);
		Npanel.add(n6);
		Npanel.add(n7);
		Npanel.add(n8);
		Npanel.add(n9);
		Npanel.add(n10);
		Npanel.add(n11);
		Npanel.add(n12);
		Npanel.add(n13);
		Npanel.add(n14);
		Npanel.add(n15);
		Npanel.add(n16);

		JTextField[] T_name = new JTextField[40];
		JTextField[] T_n1 = new JTextField[40];
		JTextField[] T_n2 = new JTextField[40];
		JTextField[] T_n3 = new JTextField[40];
		JTextField[] T_n4 = new JTextField[40];
		JTextField[] T_n5 = new JTextField[40];
		JTextField[] T_n6 = new JTextField[40];
		JTextField[] T_n7 = new JTextField[40];
		JTextField[] T_n8 = new JTextField[40];
		JTextField[] T_n9 = new JTextField[40];
		JTextField[] T_n10 = new JTextField[40];
		JTextField[] T_n11 = new JTextField[40];
		JTextField[] T_n12 = new JTextField[40];
		JTextField[] T_n13 = new JTextField[40];
		JTextField[] T_n14 = new JTextField[40];
		JTextField[] T_n15 = new JTextField[40];
		JTextField[] T_n16 = new JTextField[40];

		for (int i = 0; i < 40; i++) {
			T_name[i] = new JTextField();
			T_n1[i] = new JTextField();
			T_n2[i] = new JTextField();
			T_n3[i] = new JTextField();
			T_n4[i] = new JTextField();
			T_n5[i] = new JTextField();
			T_n6[i] = new JTextField();
			T_n7[i] = new JTextField();
			T_n8[i] = new JTextField();
			T_n9[i] = new JTextField();
			T_n10[i] = new JTextField();
			T_n11[i] = new JTextField();
			T_n12[i] = new JTextField();
			T_n13[i] = new JTextField();
			T_n14[i] = new JTextField();
			T_n15[i] = new JTextField();
			T_n16[i] = new JTextField();

			Cpanel.add(T_name[i]);
			Cpanel.add(T_n1[i]);
			Cpanel.add(T_n2[i]);
			Cpanel.add(T_n3[i]);
			Cpanel.add(T_n4[i]);
			Cpanel.add(T_n5[i]);
			Cpanel.add(T_n6[i]);
			Cpanel.add(T_n7[i]);
			Cpanel.add(T_n8[i]);
			Cpanel.add(T_n9[i]);
			Cpanel.add(T_n10[i]);
			Cpanel.add(T_n11[i]);
			Cpanel.add(T_n12[i]);
			Cpanel.add(T_n13[i]);
			Cpanel.add(T_n14[i]);
			Cpanel.add(T_n15[i]);
			Cpanel.add(T_n16[i]);

		}

		Npanel.setLayout(new GridLayout(0, 17, 3, 3));
		Npanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		Cpanel.setLayout(new GridLayout(40, 17, 3, 3));

	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {

		case "파일 불러오기":
			System.out.println("파일 불러오기");
			new UCheckFile();
			break;
		case "출석점수 계산":
			System.out.println("출석점수 계산");

			break;

		}

	}
}