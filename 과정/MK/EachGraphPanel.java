import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EachGraphPanel extends JPanel {
	int numZero, numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, numEight, numNine;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 400, 770, 400);
		g.drawLine(50, 10, 50, 400);

		for (int cnt = 1; cnt < 11; cnt++) {
			// g.drawLine(50, 300 - 25 * cnt, 800, 300 - 25 * cnt);
		}

		g.drawString("0~10", 70, 420);
		g.drawString("11~20", 140, 420);
		g.drawString("21~30", 210, 420);
		g.drawString("31~40", 280, 420);
		g.drawString("41~50", 350, 420);
		g.drawString("51~60", 420, 420);
		g.drawString("61~70", 490, 420);
		g.drawString("71~80", 560, 420);
		g.drawString("81~90", 630, 420);
		g.drawString("91~100", 700, 420);

		g.setColor(Color.red);

		if (numZero > 0) {
			g.fillRect(80, 400 - numZero * 60, 20, numZero * 60);
			g.drawString((Integer.toString(numZero)), 85, 400 - numZero * 60 - 10);
		}
		if (numOne > 0) {
			g.fillRect(150, 400 - numOne * 60, 20, numOne * 60);
			g.drawString((Integer.toString(numOne)), 155, 400 - numOne * 60 - 10);
		}
		if (numTwo > 0) {
			g.fillRect(220, 400 - numTwo * 60, 20, numTwo * 60);
			g.drawString((Integer.toString(numTwo)), 225, 400 - numTwo * 60 - 10);
		}
		if (numThree > 0) {
			g.fillRect(290, 400 - numThree * 60, 20, numThree * 60);
			g.drawString((Integer.toString(numThree)), 295, 400 - numThree * 60 - 10);
		}
		if (numFour > 0) {
			g.fillRect(360, 400 - numFour * 60, 20, numFour * 60);
			g.drawString((Integer.toString(numFour)), 355, 400 - numFour * 60 - 10);
		}
		if (numFive > 0) {
			g.fillRect(430, 400 - numFive * 60, 20, numFive * 60);
			g.drawString((Integer.toString(numFive)), 435, 400 - numFive * 60 - 10);
		}
		if (numSix > 0) {
			g.fillRect(550, 400 - numSix * 60, 20, numSix * 60);
			g.drawString((Integer.toString(numSix)), 555, 400 - numSix * 60 - 10);
		}
		if (numSeven > 0) {
			g.fillRect(570, 400 - numSeven * 60, 20, numSeven * 60);
			g.drawString((Integer.toString(numSeven)), 555, 400 - numSeven * 60 - 10);
		}
		if (numEight > 0) {
			g.fillRect(640, 400 - numEight * 60, 20, numEight * 60);
			g.drawString((Integer.toString(numEight)), 645, 400 - numEight * 60 - 10);
		}
		if (numNine > 0) {
			g.fillRect(710, 400 - numNine * 60, 20, numNine * 60);
			g.drawString((Integer.toString(numNine)), 715, 400 - numNine * 60 - 10);
		}

	}

	void setNums(int numZero, int numOne, int numTwo, int numThree, int numFour, int numFive, int numSix, int numSeven,
			int numEight, int numNine) {
		this.numZero = numZero;
		this.numOne = numOne;
		this.numTwo = numTwo;
		this.numThree = numThree;
		this.numFour = numFour;
		this.numSix = numSix;
		this.numSeven = numSeven;
		this.numEight = numEight;
		this.numNine = numNine;
	}
}
