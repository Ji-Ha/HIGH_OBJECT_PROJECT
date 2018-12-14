import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class setRule extends JFrame {
	UCheck u = new UCheck();

	void run() {
		setTitle("기준 설정");

		JPanel p = new JPanel();
		JTextField t = new JTextField("ex) 지각 3번 -> 결석 1번: 3 입력",16);
		JButton b = new JButton("설정");
		p.add(t);
		p.add(b);
		add(p);
		ActionListener listener = e -> {
			if (e.getSource() == b) {
				if (isStringDouble(t.getText())==false)
					t.setText("숫자로 입력하세요!");
				else {
					u.setRuler(Integer.parseInt(t.getText()));
					System.out.println(Integer.parseInt(t.getText()));
					dispose();
				}
			}
		};

		b.addActionListener(listener);

		setSize(300, 100);
		setVisible(true);
		

	}
	
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
