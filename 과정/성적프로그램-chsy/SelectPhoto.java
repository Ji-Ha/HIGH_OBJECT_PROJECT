import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectPhoto {
	JFrame window = new JFrame();
	BufferedImage img;

	public SelectPhoto() {

		JPanel p = new JPanel();
		JLabel o = new JLabel("이름:");
		JTextField f = new JTextField(15);

		p.add(o);
		p.add(f);

		JPanel p2 = new JPanel();
		JButton j = new JButton("검색");
		p2.add(j);
		f.setText("" + "");
		window.add(p, BorderLayout.NORTH);
		System.out.println(f.getText());
		window.add(p2, BorderLayout.SOUTH);
		// JPanel p1 = new JPanel();
		System.out.println(f.getText());
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = f.getText();
				if (name.equals("")) {

					JOptionPane.showMessageDialog(null, "이름을 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
				} else {

					// try {
					System.out.println("asdasd");
					JPanel i = new JPanel();
					new Photo();
				}

			}

		};

		j.addActionListener(l);

		window.setTitle("사진검색");
		window.setLocation(20, 20);
		window.setSize(260, 100);
		window.setVisible(true);

	};

	public static void main(String[] args) throws SQLException {

		new SelectPhoto();
	}

	public void paintComponent(Graphics g) {
		window.paintComponents(g);
		g.drawImage(img, 0, 0, null);
	}
}