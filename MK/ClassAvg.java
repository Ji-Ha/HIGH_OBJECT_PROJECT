import java.awt.BorderLayout;
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

	public ClassAvg() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("���� ��� ����");
		window.setLocation(20, 20);
		window.setSize(250, 120);

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
		jb.addActionListener(l);
		window.add(op, BorderLayout.NORTH);
		window.add(s, BorderLayout.CENTER);
		window.setVisible(true);

	}

	// �̺�Ʈ ����
	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			{
				int total1 = 100;

				if (total1 != 100) {

					JOptionPane.showMessageDialog(null, "Total 100 ���� ����", "���� ����", JOptionPane.ERROR_MESSAGE);
				} else {
					window.dispose();
				}
			}
		}
	};
}