import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class NumGraphPanel extends JPanel {

	int num0;
	int num1;
	int num2;
	int num3;
	int num4;
	int num5;
	int num6;
	int num7;
	int num8;
	int num9;
	int n;// 학번

	public void paint(Graphics g) {
		// g.clearRect(0, 0, getWidth(), getHeight());
		// 값이 입력되지않았으면 return;
		if ((num0 < 0) || (num1 < 0) || (num2 < 0) || (num3 < 0) || (num4 < 0) || (num5 < 0) || (num6 < 0) || (num7 < 0)
				|| (num8 < 0) || (num9 < 0)) {
			System.out.println("값이 입력되지 않았습니다.");
			return;
		}
		// 전체 합을 구한다
		int total = num0 + num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9;
		System.out.println(total);
		if (total == 0)
			return;
		// 전체에서의 비중을 구함.
		// arc4 = 전체 - (arc1+arc2+arc3)로 구함
		int arc0 = (int) 360.0 * num0 / total;
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		int arc4 = (int) 360.0 * num4 / total;
		int arc5 = (int) 360.0 * num5 / total;
		int arc6 = (int) 360.0 * num6 / total;
		int arc7 = (int) 360.0 * num7 / total;
		int arc8 = (int) 360.0 * num8 / total;
		int arc9 = (int) 360.0 * num9 / total;
		///////
		g.setColor(Color.RED);// 색상지정
		g.fillArc(50, 20, 200, 200, 0, arc0);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.ORANGE);
		g.fillArc(50, 20, 200, 200, arc0, arc1);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.YELLOW);// 색상지정
		g.fillArc(50, 20, 200, 200, arc0 + arc1, arc2);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.GREEN);// 색상지정
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2, arc3);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.BLUE);// 색상지정
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3, arc4);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림

		g.setColor(Color.GRAY);// 색상지정
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4, arc5);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.CYAN);
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4 + arc5, arc6);// (x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
		g.setColor(Color.PINK);
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4 + arc5 + arc6, arc7);// (x축,y축,반지름,반지름,시작각,끝각) -
		// 원호를 그림
		g.setColor(Color.MAGENTA);
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7, arc8);// (x축,y축,반지름,반지름,시작각,끝각)
		// - 원호를 그림
		g.setColor(Color.RED);
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8, arc9);// (x축,y축,반지름,반지름,시작각,끝각)
		// - 원호를 그림
		g.setColor(Color.YELLOW);
		g.fillArc(50, 20, 200, 200, arc0 + arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9,
				360 - (arc0 + arc1 + arc2 + arc3 + arc4 + arc5 + arc6 + arc7 + arc8 + arc9));// (x축,y축,반지름,반지름,시작각,끝각) -
																								// 원호를 그림

		g.setColor(Color.BLACK);
		g.setFont(new Font("굴림체", Font.BOLD, 25));// 폰트 지정
		if (num0 > 0) {
			g.setColor(Color.RED);// 색상지정
			g.drawString("0~10", 300, 180);
		}
		if (num1 > 0) {
			g.setColor(Color.ORANGE);
			g.drawString("11~20", 300, 190);
		}
		if (num2 > 0) {
			g.setColor(Color.YELLOW);
			g.drawString("21~30", 300, 200);
		}
		if (num3 > 0) {
			g.setColor(Color.GREEN);
			g.drawString("31~40", 300, 210);
		}
		if (num4 > 0) {
			g.setColor(Color.BLUE);
			g.drawString("41~50", 300, 220);
		}
		if (num5 > 0) {
			g.setColor(Color.GRAY);
			g.drawString("51~60", 300, 230);
		}
		if (num6 > 0) {
			g.setColor(Color.CYAN);
			g.drawString("61~70", 300, 240);
		}
		if (num7 > 0) {
			g.setColor(Color.PINK);
			g.drawString("71~80", 300, 250);
		}
		if (num8 > 0) {
			g.setColor(Color.MAGENTA);
			g.drawString("81~90", 300, 260);
		}
		if (num9 > 0) {
			g.setColor(Color.RED);
			g.drawString("91~100", 300, 270);
		}

		// g.setColor(Color.BLUE);

	}

	// 숫자값 입력받는 메소드
	void setNumbers(int num0, int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8,
			int num9) {
		this.num0 = num0;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
		this.num7 = num7;
		this.num8 = num8;
		this.num9 = num9;
	}
}
