import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClassAvg extends JFrame {

	public ClassAvg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("강좌 평균 점수");
		setLocation(20, 20);
		setSize(250, 120);

		JPanel p = new JPanel();
		JLabel o = new JLabel("의 평균점수는");
		p.add(o);

		JPanel s = new JPanel();
		JTextField score = new JTextField(10);
		score.setEnabled(false);
		JButton jb = new JButton("확인");

		s.add(score);
		s.add(jb);

		String[] option = { "중간고사", "기말고사", "과제", "퀴즈", "발표", "보고서", "총점수" };
		JPanel op = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JComboBox<String> cb = new JComboBox<>(option);
		op.add(cb);
		op.add(p);
		add(op, BorderLayout.NORTH);
		add(s, BorderLayout.CENTER);
		setVisible(true);
	}
}