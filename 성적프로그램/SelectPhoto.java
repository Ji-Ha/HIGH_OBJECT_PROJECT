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
	public static String name;
	JFrame window = new JFrame();
	BufferedImage img;
	MenuDemo a = new MenuDemo();

	public SelectPhoto() {

		JPanel p = new JPanel();
		JLabel o = new JLabel("이름:");
		JTextField f = new JTextField(15);

		p.add(o);
		p.add(f);
		System.out.println(a.stu[0].name);
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

				String getE = a.stu[0].name;
				getE = getE.replace(" ", "");
				name = f.getText();
				if (name.equals("")) {

					JOptionPane.showMessageDialog(null, "이름을 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
				} else {

					if (name.equals("강호동")) {
						new Photo();
					} else if (name.equals("기성용")) {
						new Photo();
					} else if (name.equals(a.stu[0].name.replace(" ", ""))) {
						new Photo();
					} else if (name.equals("김건모")) {
						new Photo();
					} else if (name.equals("김종국")) {
						new Photo();
					} else if (name.equals("김희철")) {
						new Photo();
					} else if (name.equals("노홍철")) {
						new Photo();
					} else if (name.equals("메시")) {
						new Photo();
					} else if (name.equals("민경훈")) {
						new Photo();
					} else if (name.equals("박수홍")) {
						new Photo();
					} else if (name.equals("박지성")) {
						new Photo();
					} else if (name.equals("사유리")) {
						new Photo();
					} else if (name.equals("서장훈")) {
						new Photo();
					} else if (name.equals("손흥민")) {
						new Photo();
					} else if (name.equals("송민호")) {
						new Photo();
					} else if (name.equals("신동엽")) {
						new Photo();
					} else if (name.equals("유재석")) {
						new Photo();
					} else if (name.equals("이상민")) {
						new Photo();
					} else if (name.equals("이수근")) {
						new Photo();
					} else if (name.equals("장윤주")) {
						new Photo();
					} else if (name.equals("정준하")) {
						new Photo();
					} else if (name.equals("제니")) {
						new Photo();
					} else if (name.equals("태양")) {
						new Photo();
					} else if (name.equals("피오")) {
						new Photo();
					} else if (name.equals("하하")) {
						new Photo();
					} else if (name.equals("호날두")) {
						new Photo();
					} else if (name.equals("아이유")) {
						new Photo();
					} else if (name.equals("아이린")) {
						new Photo();
					} else if (name.equals("나연")) {
						new Photo();
					} else if (name.equals("송지효")) {
						new Photo();
					} else if (name.equals("이광수")) {
						new Photo();
					} else if (name.equals("박보검")) {
						new Photo();
					} else if (name.equals("공유")) {
						new Photo();
					} else if (name.equals("송중기")) {
						new Photo();
					} else if (name.equals("이병헌")) {
						new Photo();
					} else if (name.equals("김태리")) {
						new Photo();
					} else if (name.equals("양세형")) {
						new Photo();
					} else if (name.equals("박나래")) {
						new Photo();
					} else if (name.equals("정해인")) {
						new Photo();
					} else if (name.equals("이종석")) {
						new Photo();
					} else if (name.equals("박신혜")) {
						new Photo();
					} else if (name.equals("청하")) {
						new Photo();
					} else {
						JOptionPane.showMessageDialog(null, "해당 학생의 사진은 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		};

		j.addActionListener(l);

	};

	void show() {

		window.setTitle("사진검색");
		window.setLocation(20, 20);
		window.setSize(260, 100);
		window.setVisible(true);
	}

	public static void main(String[] args) throws SQLException {

		new SelectPhoto();
	}

	public void paintComponent(Graphics g) {
		window.paintComponents(g);
		g.drawImage(img, 0, 0, null);
	}
}