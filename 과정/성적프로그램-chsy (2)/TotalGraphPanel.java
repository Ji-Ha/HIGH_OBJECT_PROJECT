import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TotalGraphPanel extends JPanel {
	int numA1, numA0, numB1, numB0, numC1, numC0, numD, numF;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 300, 530, 300);
		g.drawLine(50, 50, 50, 300);
		g.drawLine(530, 50, 530, 300);

		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawLine(50, 300 - 25 * cnt, 530, 300 - 25 * cnt);
			g.drawString(String.valueOf(cnt - 1), 35, 330 - 25 * cnt);
		}

		g.drawString("A+", 80, 320);
		g.drawString("A0", 140, 320);
		g.drawString("B+", 200, 320);
		g.drawString("B0", 260, 320);
		g.drawString("C+", 320, 320);
		g.drawString("C0", 380, 320);
		g.drawString("D", 440, 320);
		g.drawString("F", 500, 320);

		g.setColor(Color.BLUE);

		if (numA1 > 0) {
			g.fillRect(75, 300 - numA1 * 25, 20, numA1 * 25);
			g.drawString((Integer.toString(numA1)), 80, 300 - numA1 * 25 - 10);
		}
		if (numA0 > 0) {
			g.fillRect(135, 300 - numA0 * 25, 20, numA0 * 25);
			g.drawString((Integer.toString(numA0)), 140, 300 - numA0 * 25 - 10);
		}
		if (numB1 > 0) {
			g.fillRect(195, 300 - numB1 * 25, 20, numB1 * 25);
			g.drawString((Integer.toString(numB1)), 200, 300 - numB1 * 25 - 10);
		}
		if (numB0 > 0) {
			g.fillRect(255, 300 - numB0 * 25, 20, numB0 * 25);
			g.drawString((Integer.toString(numB0)), 260, 300 - numB0 * 25 - 10);
		}
		if (numC1 > 0) {
			g.fillRect(315, 300 - numC1 * 25, 20, numC1 * 25);
			g.drawString((Integer.toString(numC1)), 320, 300 - numC1 * 25 - 10);
		}
		if (numC0 > 0) {
			g.fillRect(375, 300 - numC0 * 25, 20, numC0 * 25);
			g.drawString((Integer.toString(numC0)), 380, 300 - numC0 * 25 - 10);
		}
		if (numD > 0) {
			g.fillRect(435, 300 - numD * 25, 20, numD * 25);
			g.drawString((Integer.toString(numD)), 440, 300 - numD * 25 - 10);
		}
		if (numF > 0) {
			g.fillRect(495, 300 - numF * 25, 20, numF * 25);
			g.drawString((Integer.toString(numF)), 500, 300 - numF * 25 - 10);
		}

	}

	void setNums(int numA1, int numA0, int numB1, int numB0, int numC1, int numC0, int numD, int numF) {
		// System.out.println(numA + numB + numC + numD + numF);
		this.numA1 = numA1;
		this.numA0 = numA0;
		this.numB1 = numB1;
		this.numB0 = numB0;
		this.numC1 = numC1;
		this.numC0 = numC0;
		this.numD = numD;
		this.numF = numF;
	}
}
