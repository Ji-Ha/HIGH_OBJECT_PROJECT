import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class setF extends JFrame {
	UCheck u = new UCheck();

	void run() {
		setTitle("F���� ����");

		JPanel p = new JPanel();
		JTextField t = new JTextField(16);
		JButton b = new JButton("����");
		p.add(t);
		p.add(b);
		add(p);
		ActionListener listener = e -> {
			if (e.getSource() == b) {
				if (t.getText().isEmpty())
					t.setText("������ �Է��ϼ���!");
				else {
					u.setFRuler(Integer.parseInt(t.getText()));
					System.out.println(Integer.parseInt(t.getText()));
				}
			}
		};

		b.addActionListener(listener);

		setSize(300, 100);
		setVisible(true);

	}
}
