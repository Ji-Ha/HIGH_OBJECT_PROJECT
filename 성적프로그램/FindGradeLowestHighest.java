import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindGradeLowestHighest {
	JFrame window = new JFrame();
	Student[] stu;
	int stuNum;

	public FindGradeLowestHighest(String str, Student[] stu, int stuNum) {
		window.setTitle(str);
		window.setLocation(500, 200);
		window.setSize(250, 150);
		this.stu = stu;
		this.stuNum = stuNum;
		JPanel p = new JPanel();
		JLabel o;
		if (str.equals("등급별 최고 점수 확인")) {
			o = new JLabel("중의 최고 점수는");
		} else {
			o = new JLabel("중의 최저 점수는");
		}
		p.add(o);

		JPanel s = new JPanel();
		JTextField ScoreField = new JTextField(10);
		ScoreField.setForeground(Color.BLACK);
		ScoreField.setEnabled(false);
		JButton jb = new JButton("확인");
		s.add(ScoreField);
		s.add(jb);
		String[] option = { "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F" };
		JPanel op = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JComboBox<String> cb = new JComboBox<>(option);
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				double score = 0;
				switch (index) {
				case 0: // A+인경우
					score = getLowestScore("A+", str);
					break;
				case 1:
					score = getLowestScore("A", str);
					getLowestScore("A", str);
					break;
				case 2:
					score = getLowestScore("B+", str);
					getLowestScore("B+", str);
					break;
				case 3:
					score = getLowestScore("B", str);
					getLowestScore("B", str);
					break;
				case 4:
					score = getLowestScore("C+", str);
					getLowestScore("C+", str);
					break;
				case 5:
					score = getLowestScore("C", str);
					getLowestScore("C", str);
					break;
				case 6:
					score = getLowestScore("D+", str);
					getLowestScore("D+", str);
					break;
				case 7:
					score = getLowestScore("D", str);
					getLowestScore("D", str);
					break;
				case 8:
					score = getLowestScore("F", str);
					getLowestScore("F", str);
					break;
				}
				ScoreField.setText(Double.toString(score));
			}

			public double getLowestScore(String grade, String s) {
				Double lowestScore = 0.0;
				Double highestScore = 0.0;
				Double[] gradeScore = new Double[40];
				int gradeNum = 0;
				try {
					// 먼저 등급 A+이 선택되면 A+인 점수 내에서 최저 점수를 찾아낸다
					if (s.equals("등급별 최고 점수 확인")) {
						System.out.print(grade);
						// 해당 등급 점수들 배열에 넣기
						for (int i = 0; i < stuNum; i++) {
							if (grade.equals(stu[i].getRank())) {
								highestScore = Double.parseDouble(stu[i].getAll());
								gradeScore[gradeNum] = highestScore;
								gradeNum++;
							}
						}
						// 넣은 배열들 중 가장 높은 점수 확인
						highestScore = gradeScore[0];
						System.out.println("최고점수");
						for (int i = 1; i < gradeNum; i++) {
							if (highestScore < gradeScore[i]) {
								highestScore = gradeScore[i];
							}
						}
						return highestScore;

					} else {
						System.out.print(grade);
						System.out.print("최저 점수");
						// 해당 등급 점수들 배열에 넣기
						for (int i = 0; i < stuNum; i++) {
							if (grade.equals(stu[i].getRank())) {
								lowestScore = Double.parseDouble(stu[i].getAll());
								gradeScore[gradeNum] = lowestScore;
								gradeNum++;
							}
						}
						// 넣은 배열들 중 가장 낮은 점수 확인
						lowestScore = gradeScore[0];
						System.out.println("최저점수");
						for (int i = 1; i < gradeNum; i++) {
							if (lowestScore > gradeScore[i]) {
								lowestScore = gradeScore[i];
							}
						}
					}
					return lowestScore;
				} catch (NullPointerException np) {
					JOptionPane.showMessageDialog(null, "해당 등급에는 학생이 없습니다.");
				}
				return 0.0;
			}
		});
		op.add(cb);
		op.add(p);
		jb.addActionListener(l);
		window.add(op, BorderLayout.CENTER);
		window.add(s, BorderLayout.SOUTH);
		window.setVisible(true);
	}

	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			{
				window.dispose();
			}
		}
	};
}