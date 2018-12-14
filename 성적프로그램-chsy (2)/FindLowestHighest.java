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
		if (str.equals("�ְ� ���� Ȯ��")) {
			// str = "�ְ� ����";
			o = new JLabel("�� �ְ� ������ ");
		} else {
			// str = "���� ����";
			o = new JLabel("�� ���� ������ ");
		}
		p.add(o);

		JPanel s = new JPanel();
		JTextField ScoreField = new JTextField(10);
		ScoreField.setForeground(Color.BLACK);
		ScoreField.setEnabled(false);
		JButton jb = new JButton("Ȯ��");
		s.add(ScoreField);
		s.add(jb);
		String[] option = { "�߰����", "�⸻���", "����", "����", "����", "��ǥ", "��Ÿ", "�⼮", "������" };
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
				if (s.equals("�ְ� ����")) {
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

	// �̺�Ʈ ����
	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			{
				window.dispose();
			}
		}
	};
}
