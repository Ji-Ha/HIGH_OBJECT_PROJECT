import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TotalGraphPanel extends JPanel {
	int numA, numB, numC, numD, numF;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 300, 400, 300);
		g.drawLine(50, 20, 50, 300);

		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawLine(50, 300 - 25 * cnt, 400, 300 - 25 * cnt);
		}

		g.drawString("A", 80, 320);
		g.drawString("B", 140, 320);
		g.drawString("C", 220, 320);
		g.drawString("D", 280, 320);
		g.drawString("F", 340, 320);

		g.setColor(Color.red);

		if (numA > 0) {
			g.fillRect(70, 300 - numA * 60, 20, numA * 60);
			g.drawString((Integer.toString(numA)), 75, 300 - numA * 60 - 10);
		}
		if (numB > 0) {
			g.fillRect(130, 300 - numB * 60, 20, numB * 60);
			g.drawString((Integer.toString(numB)), 135, 300 - numB * 60 - 10);
		}
		if (numC > 0) {
			g.fillRect(210, 300 - numC * 60, 20, numC * 60);
			g.drawString((Integer.toString(numC)), 215, 300 - numC * 60 - 10);
		}
		if (numD > 0) {
			g.fillRect(270, 300 - numD * 60, 20, numD * 60);
			g.drawString((Integer.toString(numD)), 275, 300 - numD * 60 - 10);
		}
		if (numF > 0) {
			g.fillRect(330, 300 - numF * 60, 20, numF * 60);
			g.drawString((Integer.toString(numF)), 335, 300 - numF * 60 - 10);
		}

	}

	void setNums(int numA, int numB, int numC, int numD, int numF) {
		System.out.println(numA + numB + numC + numD + numF);
		this.numA = numA;
		this.numB = numB;
		this.numC = numC;
		this.numD = numD;
		this.numF = numF;
	}
}
