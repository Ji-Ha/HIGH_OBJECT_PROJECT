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
			/////////////////////////////////////////////////////이거 주소 확인하세요///////////////////////////////
			image = ImageIO.read(new File("C:\\Users\\채소연\\Desktop\\등급 & 사진\\Sangrul.PNG"));

		} catch (IOException e) {
			System.err.println(e);
		}
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel, BorderLayout.CENTER);
		application.setSize(600, 800);
		application.setResizable(false);
		application.setVisible(true);
	}

	public static void main(String[] args) {
		new Photo();
	}
}