import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UCheckFile extends JFrame {

	public UCheckFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� �ҷ�����");
		setLocation(20, 20);
		setSize(350, 80);

		JPanel h = new JPanel();
		JTextField h1 = new JTextField(12);
		h1.setEnabled(false);

		JButton jb = new JButton("�ҷ�����");

		h.add(h1);
		h.add(jb);

		add(h, BorderLayout.CENTER);

		setVisible(true);
	}
}