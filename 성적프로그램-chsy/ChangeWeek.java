import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeWeek extends JFrame {
	UCheck u = new UCheck();

	void run() {
		setTitle("��ü ��� ����");

		JPanel p = new JPanel();
		JTextField t = new JTextField(16);
		t.setText("�����ϰ� ���� �ָ� �Է��ϼ���");
		JButton b = new JButton("����");
		p.add(t);
		p.add(b);
		add(p);
		ActionListener listener = e -> {
			if (e.getSource() == b) {
				if (t.getText().isEmpty())
					t.setText("�����ϰ� ���� �ָ� �Է��ϼ���!!!!!!!!!");
				else {
					u.setWeek(Integer.parseInt(t.getText()));
					System.out.println(Integer.parseInt(t.getText()));
					for (int i = 0; i < 40; i++) {
						if (u.stuAtt[i] == null) {
							break;
						} else {
							u.stuAtt[i].CheckAttend[u.getWeek() + 1] = "o";
						}
					}

				}
			}
		};

		b.addActionListener(listener);

		setSize(300, 100);
		setVisible(true);

	}
}
