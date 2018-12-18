import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Photo extends JComponent {
	MenuDemo md = new MenuDemo();
	SelectPhoto a = new SelectPhoto();
	public static final int IMG_WIDTH = 600;
	public static final int IMG_HEIGHT = 800;
	private static BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private static BufferedImage icon[] = { new BufferedImage(60, 34, BufferedImage.TYPE_INT_ARGB),
			new BufferedImage(60, 34, BufferedImage.TYPE_INT_ARGB),
			new BufferedImage(60, 34, BufferedImage.TYPE_INT_ARGB),
			new BufferedImage(60, 34, BufferedImage.TYPE_INT_ARGB) };

	public Photo() {
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null)
					g.drawImage(image, 0, 0, null);
				if (icon[0] != null && icon[1] != null && icon[2] != null && icon[3] != null)
					for (int i = 0; i < 10; i++) {
						g.drawImage(icon[0], 60 * i, 100, null);
						g.drawImage(icon[1], 60 * i, 134, null);
						g.drawImage(icon[2], 60 * i, 168, null);
						g.drawImage(icon[3], 60 * i, 202, null);
					}
			}
		};
		try {
			if (a.name.equals("강호동")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\강호동.PNG"));
			} else if (a.name.equals("기성용")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\기성용.PNG"));
			} else if (a.name.equals("김건모")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\김건모.PNG"));
			} else if (a.name.equals("김종국")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\김종국.PNG"));
			} else if (a.name.equals("김희철")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\김희철.PNG"));
			} else if (a.name.equals("노홍철")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\노홍철.PNG"));
			} else if (a.name.equals("메시")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\메시.PNG"));
			} else if (a.name.equals("민경훈")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\민경훈.PNG"));
			} else if (a.name.equals("박수홍")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\박수홍.PNG"));
			} else if (a.name.equals("박지성")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\박지성.PNG"));
			} else if (a.name.equals("사유리")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\사유리.PNG"));
			} else if (a.name.equals("서장훈")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\서장훈.PNG"));
			} else if (a.name.equals("손흥민")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\손흥민.PNG"));
			} else if (a.name.equals("송민호")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\송민호.PNG"));
			} else if (a.name.equals("신동엽")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\신동엽.PNG"));
			} else if (a.name.equals("유재석")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\유재석.PNG"));
			} else if (a.name.equals("이상민")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\이상민.PNG"));
			} else if (a.name.equals("이수근")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\이수근.PNG"));
			} else if (a.name.equals("장윤주")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\장윤주.PNG"));
			} else if (a.name.equals("정준하")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\정준하.PNG"));
			} else if (a.name.equals("제니")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\제니.PNG"));
			} else if (a.name.equals("태양")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\태양.PNG"));
			} else if (a.name.equals("피오")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\피오.PNG"));
			} else if (a.name.equals("하하")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\하하.PNG"));
			} else if (a.name.equals("호날두")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\호날두.PNG"));
			} else if (a.name.equals("아이린")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\아이린.PNG"));
			} else if (a.name.equals("나연")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\나연.PNG"));
			} else if (a.name.equals("송지효")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\송지효.PNG"));
			} else if (a.name.equals("이광수")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\이광수.PNG"));
			} else if (a.name.equals("박보검")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\박보검.PNG"));
			} else if (a.name.equals("공유")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\공유.PNG"));
			} else if (a.name.equals("송중기")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\송중기.PNG"));
			} else if (a.name.equals("아이유")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\아이유.PNG"));
			} else if (a.name.equals("이병헌")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\이병헌.PNG"));
			} else if (a.name.equals("김태리")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\김태리.PNG"));
			} else if (a.name.equals("양세형")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\양세형.PNG"));
			} else if (a.name.equals("박나래")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\박나래.PNG"));
			} else if (a.name.equals("정해인")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\정해인.PNG"));
			} else if (a.name.equals("이종석")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\이종석.PNG"));
			} else if (a.name.equals("박신혜")) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\박신혜.PNG"));
			} else if (a.name.equals(md.stu[0].name)) {
				image = ImageIO.read(new File("C:\\Users\\user\\Desktop\\고급객체사진\\공유.PNG"));
			}

		} catch (IOException e) {
			System.err.println(e);
		}
		JFrame application = new JFrame();
		application.add(panel, BorderLayout.CENTER);
		application.setSize(70, 200);
		application.setVisible(true);

	}

	public static void main(String[] args) {
		new Photo();
	}
}