import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetGrade {
	JFrame window = new JFrame();
	static public double[] per = new double[8];

	void show() {
		window.setTitle("등급 설정");
		window.setLocation(20, 20);
		window.setSize(380, 210);
		window.setVisible(true);

	}

	public SetGrade() {

		JPanel p = new JPanel();
		JLabel o = new JLabel("등급 설정(%)");

		p.add(o);

		JPanel p1 = new JPanel();
		JPanel a = new JPanel();
		JLabel a1 = new JLabel("A+");
		JTextField a2 = new JTextField(5);
		a2.setText("" + 10);
		JPanel b = new JPanel();
		JLabel b1 = new JLabel("A");
		JTextField b2 = new JTextField(5);
		b2.setText("" + 20);
		JPanel c = new JPanel();
		JLabel c1 = new JLabel("B+");
		JTextField c2 = new JTextField(5);
		c2.setText("" + 40);
		JPanel d = new JPanel();
		JLabel d1 = new JLabel("B");
		JTextField d2 = new JTextField(5);
		d2.setText("" + 50);
		JPanel e = new JPanel();
		JLabel e1 = new JLabel("C+");
		JTextField e2 = new JTextField(5);
		e2.setText("" + 60);
		JPanel f = new JPanel();
		JLabel f1 = new JLabel("C");
		JTextField f2 = new JTextField(5);
		f2.setText("" + 70);
		JPanel g = new JPanel();
		JLabel g1 = new JLabel("D+");
		JTextField g2 = new JTextField(5);
		g2.setText("" + 80);
		JPanel h = new JPanel();
		JLabel h1 = new JLabel("D");
		JTextField h2 = new JTextField(5);
		h2.setText("" + 90);
		JPanel i = new JPanel();
		JLabel i1 = new JLabel("F");
		JTextField i2 = new JTextField(5);
		i2.setText("" + 100);

		JButton jb = new JButton("완료");
		// 중간 기말 과제 퀴즈 발표 보고서 출석 기타
		a.add(a1);
		a.add(a2);
		b.add(b1);
		b.add(b2);
		c.add(c1);
		c.add(c2);
		d.add(d1);
		d.add(d2);
		e.add(e1);
		e.add(e2);
		f.add(f1);
		f.add(f2);
		g.add(g1);
		g.add(g2);
		h.add(h1);
		h.add(h2);
		i.add(i1);
		i.add(i2);

		p1.add(a);
		p1.add(b);
		p1.add(c);
		p1.add(e);
		p1.add(f);
		p1.add(g);
		p1.add(h);
		p1.add(i);
		p1.add(jb);

		JPanel p2 = new JPanel();
		JLabel ex = new JLabel("(예시: A+:10 A:20 B+:40 B:60)");
		JLabel ex1 = new JLabel("F 에서는 100%로 끝나야한다");

		p2.add(ex);
		p2.add(ex1);

		window.add(p, BorderLayout.NORTH);
		window.add(p1, BorderLayout.CENTER);
		window.add(p2, BorderLayout.SOUTH);
		// JPanel p1 = new JPanel();

		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					String gd = i2.getText();

					Double total1;
					total1 = Double.parseDouble(gd);

					if (total1 != 100) {

						JOptionPane.showMessageDialog(null, "마지막 비율(F)을 100% 로 설정하세요", "비율 오류",
								JOptionPane.ERROR_MESSAGE);
					} else {

						window.dispose();
					}

				}

			}

		};
		jb.addActionListener(l);

	}

	public static void main(String[] args) throws SQLException {
		// show();
		new SetGrade();
	}
}