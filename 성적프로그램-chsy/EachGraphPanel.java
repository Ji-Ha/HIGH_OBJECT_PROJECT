import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EachGraphPanel extends JPanel {
	int numZero, numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, numEight, numNine;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 350, 770, 350);
		g.drawLine(50, 50, 50, 350);
		g.drawLine(770, 50, 770, 350);

		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawLine(50, 350 - 30 * cnt, 770, 350 - 30 * cnt);
			g.drawString(String.valueOf(cnt - 1), 33, 380 - 30 * cnt);
		}
		g.drawString("10", 35, 380 - (30 * 11));

		g.drawString("0~10", 70, 370);
		g.drawString("11~20", 140, 370);
		g.drawString("21~30", 210, 370);
		g.drawString("31~40", 280, 370);
		g.drawString("41~50", 350, 370);
		g.drawString("51~60", 420, 370);
		g.drawString("61~70", 490, 370);
		g.drawString("71~80", 560, 370);
		g.drawString("81~90", 630, 370);
		g.drawString("91~100", 700, 370);

		g.setColor(Color.red);

		if (numZero > 0) {
			g.fillRect(80, 350 - numZero * 30, 20, numZero * 30);
			g.drawString((Integer.toString(numZero)), 85, 350 - numZero * 30 - 10);
		}
		if (numOne > 0) {
			g.fillRect(150, 350 - numOne * 30, 20, numOne * 30);
			g.drawString((Integer.toString(numOne)), 155, 350 - numOne * 30 - 10);
		}
		if (numTwo > 0) {
			g.fillRect(220, 350 - numTwo * 30, 20, numTwo * 30);
			g.drawString((Integer.toString(numTwo)), 225, 350 - numTwo * 30 - 10);
		}
		if (numThree > 0) {
			g.fillRect(290, 350 - numThree * 30, 20, numThree * 30);
			g.drawString((Integer.toString(numThree)), 295, 350 - numThree * 30 - 10);
		}
		if (numFour > 0) {
			g.fillRect(360, 350 - numFour * 30, 20, numFour * 30);
			g.drawString((Integer.toString(numFour)), 355, 350 - numFour * 30 - 10);
		}
		if (numFive > 0) {
			g.fillRect(430, 350 - numFive * 30, 20, numFive * 30);
			g.drawString((Integer.toString(numFive)), 435, 350 - numFive * 30 - 10);
		}
		if (numSix > 0) {

			g.fillRect(500, 350 - numSix * 30, 20, numSix * 30);
			g.drawString((Integer.toString(numSix)), 505, 350 - numSix * 30 - 10);
		}
		if (numSeven > 0) {
			g.fillRect(570, 350 - numSeven * 30, 20, numSeven * 30);
			g.drawString((Integer.toString(numSeven)), 575, 350 - numSeven * 30 - 10);
		}
		if (numEight > 0) {
			g.fillRect(640, 350 - numEight * 30, 20, numEight * 30);
			g.drawString((Integer.toString(numEight)), 645, 350 - numEight * 30 - 10);
		}
		if (numNine > 0) {
			g.fillRect(710, 350 - numNine * 30, 20, numNine * 30);
			g.drawString((Integer.toString(numNine)), 715, 350 - numNine * 30 - 10);
		}

	}

	void setNums(int numZero, int numOne, int numTwo, int numThree, int numFour, int numFive, int numSix, int numSeven,
			int numEight, int numNine) {
		this.numZero = numZero;
		this.numOne = numOne;
		this.numTwo = numTwo;
		this.numThree = numThree;
		this.numFour = numFour;
		this.numFive = numFive;
		this.numSix = numSix;
		this.numSeven = numSeven;
		this.numEight = numEight;
		this.numNine = numNine;
		// System.out.println(numZero);
		// System.out.println(numOne);
		// System.out.println(numTwo);
		// System.out.println(numThree);
		// System.out.println(numFour);
		// System.out.println(numSix);
		// System.out.println(numSeven);
		// System.out.println(numEight);
		// System.out.println(numNine);

	}
}
