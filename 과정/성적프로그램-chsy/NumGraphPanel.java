import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class NumGraphPanel extends JPanel {

	// 17,16,15,14
	int num1;
	int num2;
	int num3;
	int num4;

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		// ���� �Էµ����ʾ����� return;
		if ((num1 < 0) || (num2 < 0) || (num3 < 0) || (num4 < 0))
			return;
		// ��ü ���� ���Ѵ�
		int total = num1 + num2 + num3 + num4;
		if (total == 0)
			return;
		// ��ü������ ������ ����.
		// arc4 = ��ü - (arc1+arc2+arc3)�� ����
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		g.setColor(Color.YELLOW);// ��������
		g.fillArc(50, 20, 200, 200, 0, arc1);// (x��,y��,������,������,���۰�,����) - ��ȣ�� �׸�
		g.setColor(Color.RED);// ��������
		g.fillArc(50, 20, 200, 200, arc1, arc2);// (x��,y��,������,������,���۰�,����) - ��ȣ�� �׸�
		g.setColor(Color.BLUE);// ��������
		g.fillArc(50, 20, 200, 200, arc1 + arc2, arc3);// (x��,y��,������,������,���۰�,����) - ��ȣ�� �׸�
		g.setColor(Color.GREEN);// ��������
		g.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3, 360 - (arc1 + arc2 + arc3));// (x��,y��,������,������,���۰�,����) - ��ȣ�� �׸�
		g.setColor(Color.BLACK);// ��������
		g.setFont(new Font("����ü", Font.PLAIN, 12));// ��Ʈ ����
		g.drawString(" 17: ���", 300, 150);// ����(legend)
		g.drawString(" 16: ����", 300, 170);// ����(legend)
		g.drawString(" 15: �Ķ�", 300, 190);// ����(legend)
		g.drawString(" 14: �ʷ�", 300, 210);// ����(legend)
	}

	// ���ڰ� �Է¹޴� �޼ҵ�
	void setNumbers(int num1, int num2, int num3, int num4) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
	}
}