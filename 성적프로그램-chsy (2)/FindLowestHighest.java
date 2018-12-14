import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindLowestHighest {
	JFrame window = new JFrame();
	Student[] stu;
	int stuNum;
	// String str;

	public FindLowestHighest(String str, Student[] stu, int stuNum) {
		window.setTitle(str);
		window.setLocation(20, 20);
		window.setSize(250, 150);
		this.stu = stu;
		this.stuNum = stuNum;
		JPanel p = new JPanel();
		JLabel o;
		if (str.equals("최고 점수 확인")) {
			// str = "최고 점수";
			o = new JLabel("의 최고 점수는 ");
		} else {
			// str = "최저 점수";
			o = new JLabel("의 최저 점수는 ");
		}
		p.add(o);

		JPanel s = new JPanel();
		JTextField ScoreField = new JTextField(10);
		ScoreField.setForeground(Color.BLACK);
		ScoreField.setEnabled(false);
		JButton jb = new JButton("확인");
		s.add(ScoreField);
		s.add(jb);
		String[] option = { "중간고사", "기말고사", "과제", "퀴즈", "보고서", "발표", "기타", "출석", "총점수" };
		JPanel op = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JComboBox<String> cb = new JComboBox<>(option);
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				int score = 0;
				switch (index) {
				case 0:
					score = getHighLowScore("Mid", str);
					break;
				case 1:
					score = getHighLowScore("Fin", str);
					break;
				case 2:
					score = getHighLowScore("Subj", str);
					break;
				case 3:
					score = getHighLowScore("Quiz", str);
					break;
				case 4:
					score = getHighLowScore("Pre", str);
					break;
				case 5:
					score = getHighLowScore("Report", str);
					break;
				case 6:
					score = getHighLowScore("Another", str);
					break;
				case 7:
					score = getHighLowScore("Attend", str);
					break;
				case 8:
					score = getHighLowScore("all", str);
					break;
				}
				ScoreField.setText(Integer.toString(score));
			}

			public int getHighLowScore(String subj, String s) {
				int highestScore, lowestScore;
				if (s.equals("최고 점수")) {
					highestScore = stu[0].getScore(subj);
					for (int i = 0; i < stuNum; i++) {
						if (highestScore < stu[i].getScore(subj)) {
							highestScore = stu[i].getScore(subj);
						}
					}
					return highestScore;
				} else {
					lowestScore = stu[0].getScore(subj);
					for (int i = 0; i < stuNum; i++) {
						if (lowestScore > stu[i].getScore(subj)) {
							lowestScore = stu[i].getScore(subj);
						}
					}
				}
				return lowestScore;
			}
		});
		op.add(cb);
		op.add(p);
		jb.addActionListener(l);
		window.add(op, BorderLayout.CENTER);
		window.add(s, BorderLayout.SOUTH);
		window.setVisible(true);
	}

	// 이벤트 생성
	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			{
				window.dispose();
			}
		}
	};
}
