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

public class Perchant extends SetGrade {
	MenuDemo pr = new MenuDemo();

	JFrame window = new JFrame();

	void show() {
		window.setTitle("반영비율 계산");
		window.setSize(430, 235);
		window.setLocation(20, 20);
		window.setVisible(true);

	}

	public Perchant() {

		JPanel p = new JPanel();
		JLabel o = new JLabel("성적비율 설정(%)");
		p.add(o);

		JPanel p1 = new JPanel();
		JPanel a = new JPanel();
		JLabel a1 = new JLabel("중간");
		JTextField a2 = new JTextField(5);
		a2.setText("" + 30);
		JPanel b = new JPanel();
		JLabel b1 = new JLabel("기말");
		JTextField b2 = new JTextField(5);
		b2.setText("" + 30);
		JPanel c = new JPanel();
		JLabel c1 = new JLabel("과제");
		JTextField c2 = new JTextField(5);
		c2.setText("" + 5);
		JPanel d = new JPanel();
		JLabel d1 = new JLabel("퀴즈");
		JTextField d2 = new JTextField(5);
		d2.setText("" + 10);
		JPanel e = new JPanel();
		JLabel e1 = new JLabel("발표");
		JTextField e2 = new JTextField(5);
		e2.setText("" + 5);
		JPanel f = new JPanel();
		JLabel f1 = new JLabel("보고서");
		JTextField f2 = new JTextField(5);
		f2.setText("" + 10);
		JPanel g = new JPanel();
		JLabel g1 = new JLabel("출석");
		JTextField g2 = new JTextField(5);
		g2.setText("" + 5);
		JPanel h = new JPanel();
		JLabel h1 = new JLabel("기타");
		JTextField h2 = new JTextField(5);
		h2.setText("" + 5);
		// 중간 기말 과제 퀴즈 발표 보고서 출석 기타
		JButton jb = new JButton("성적비율 설정완료");

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

		p1.add(a);
		p1.add(b);
		p1.add(c);
		p1.add(d);
		p1.add(e);
		p1.add(f);
		p1.add(g);
		p1.add(h);

		window.add(p1, BorderLayout.CENTER);
		window.add(p, BorderLayout.NORTH);
		window.add(jb, BorderLayout.SOUTH);
		// 이벤트 생성.

		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					String min = a2.getText();
					String fin = b2.getText();
					String Sub = c2.getText();
					String Quz = d2.getText();
					String Pr = e2.getText();
					String Re = f2.getText();
					String Chul = g2.getText();
					String Pl = h2.getText();

					Double total1;
					total1 = Double.parseDouble(min) + Double.parseDouble(fin) + Double.parseDouble(Sub)
							+ Double.parseDouble(Quz) + Double.parseDouble(Pr) + Double.parseDouble(Re)
							+ Double.parseDouble(Chul) + Double.parseDouble(Pl);

					if (total1 != 100) {

						JOptionPane.showMessageDialog(null, "Total 100 으로 설정", "비율 오류", JOptionPane.ERROR_MESSAGE);
					} else {

						pr.per[0] = Double.parseDouble(min) / 100;
						pr.per[1] = Double.parseDouble(fin) / 100;
						pr.per[2] = Double.parseDouble(Sub) / 100;
						pr.per[3] = Double.parseDouble(Quz) / 100;
						pr.per[4] = Double.parseDouble(Pr) / 100;
						pr.per[5] = Double.parseDouble(Re) / 100;
						pr.per[6] = Double.parseDouble(Chul) / 100;
						pr.per[7] = Double.parseDouble(Pl) / 100;

						window.dispose();
					}

				}

			}

		};

		jb.addActionListener(l);

	}

	public static void main(String[] args) throws SQLException {
		// show();
		new Perchant();
	}

}
