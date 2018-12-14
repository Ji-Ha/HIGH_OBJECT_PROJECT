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

public class ClassAvg {
	JFrame window = new JFrame();
	Student[] stu;
	int stuNum;

	public ClassAvg(Student[] stu, int stuNum) {
		window.setTitle("강좌 평균 점수");
		window.setLocation(20, 20);
		window.setSize(250, 150);

		JPanel p = new JPanel();
		JLabel o = new JLabel("의 평균점수는");
		p.add(o);

		JPanel s = new JPanel();
		JTextField score = new JTextField(10);
		score.setForeground(Color.BLACK);
		score.setEnabled(false);
		JButton jb = new JButton("확인");

		s.add(score);
		s.add(jb);

		this.stu = stu;
		this.stuNum = stuNum;

		String[] option = { "중간고사", "기말고사", "과제", "퀴즈", "보고서", "발표", "기타", "출석", "총점수" };
		JPanel op = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JComboBox<String> cb = new JComboBox<>(option);
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				int avg = 0;
				switch (index) {
				case 0:
					avg = getAvg("Mid");
					System.out.println(avg);
					break;
				case 1:
					avg = getAvg("Fin");
					System.out.println(avg);
					break;
				case 2:
					avg = getAvg("Subj");
					System.out.println(avg);
					break;
				case 3:
					avg = getAvg("Quiz");
					System.out.println(avg);
					break;
				case 4:
					avg = getAvg("Pre");
					System.out.println(avg);
					break;
				case 5:
					avg = getAvg("Report");
					System.out.println(avg);
					break;
				case 6:
					avg = getAvg("Another");
					System.out.println(avg);
					break;
				case 7:
					avg = getAvg("Attend");
					System.out.println(avg);
					break;
				case 8:
					avg = getAvg("all");
					System.out.println(avg);
					break;
				}
				score.setForeground(Color.BLACK);
				score.setText(Integer.toString(avg));
			}

			public int getAvg(String s) {
				int sum = 0;
				int avg = 0;
				for (int i = 0; i < stuNum; i++) {
					switch (s) {
					case "Mid":
						sum = sum + Integer.parseInt(stu[i].getMid());
						break;
					case "Fin":
						sum = sum + Integer.parseInt(stu[i].getFin());
						break;
					case "Subj":
						sum = sum + Integer.parseInt(stu[i].getSubj());
						break;
					case "Quiz":
						sum = sum + Integer.parseInt(stu[i].getQuiz());
						break;
					case "Pre":
						sum = sum + Integer.parseInt(stu[i].getPre());
						break;
					case "Report":
						sum = sum + Integer.parseInt(stu[i].getReport());
						break;
					case "Attend":
						sum = sum + Integer.parseInt(stu[i].getAttend());
						break;
					case "Another":
						sum = sum + Integer.parseInt(stu[i].getAnother());
						break;
					case "all":
						sum = sum + Integer.parseInt(stu[i].getAll());
						break;
					}

				}
				avg = sum / stuNum;
				return avg;
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
				int total1 = 100;
				if (total1 != 100) {
					JOptionPane.showMessageDialog(null, "Total 100 으로 설정", "비율 오류", JOptionPane.ERROR_MESSAGE);
				} else {
					window.dispose();
				}
			}
		}
	};
}