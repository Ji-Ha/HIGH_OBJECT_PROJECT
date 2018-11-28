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
		setTitle("���� ��� ����");
		setLocation(20, 20);
		setSize(250, 120);

		JPanel p = new JPanel();
		JLabel o = new JLabel("�� ���������");
		p.add(o);

		JPanel s = new JPanel();
		JTextField score = new JTextField(10);
		score.setEnabled(false);
		JButton jb = new JButton("Ȯ��");

		s.add(score);
		s.add(jb);

		String[] option = { "�߰����", "�⸻���", "����", "����", "��ǥ", "����", "������" };
		JPanel op = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JComboBox<String> cb = new JComboBox<>(option);
		op.add(cb);
		op.add(p);
		add(op, BorderLayout.NORTH);
		add(s, BorderLayout.CENTER);
		setVisible(true);
	}
}