
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class NumGraph extends JFrame {
	static NumGraphPanel dp = new NumGraphPanel();
	static Student[] stu;
	static String s;
	static int stuNum;
	static int tempID;

	public NumGraph(String s, Student[] stu, int stuNum) {
		this.s = s;
		this.tempID = Integer.parseInt(s);
		this.stu = stu;
		this.stuNum = stuNum;
		setLocation(500, 200);
		setSize(500, 500);
		add(dp, BorderLayout.CENTER);
		insert();
		setResizable(false);
		setVisible(true);
	}

	public static class scoreInsert {

		public static void insert() {
			int num0 = 0;
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			int num5 = 0;
			int num6 = 0;
			int num7 = 0;
			int num8 = 0;
			int num9 = 0;

			int ID = 0;
			double score = 0;

			if (tempID == 6014) {
				for (int i = 0; i < stuNum; i++) {
					score = Double.parseDouble(stu[i].getAll());
					System.out.print("성적은 ");
					System.out.println(score);

					ID = Integer.parseInt(stu[i].getStudentId());

					int sc = (int) (score - 1) / 10;
					int n = ID / 10000;

					System.out.println(n);

					if (n == 6014) {
						if (sc == 0)
							num0++;
						else if (sc == 1)
							num1++;
						else if (sc == 2)
							num2++;
						else if (sc == 3)
							num3++;
						else if (sc == 4)
							num4++;
						else if (sc == 5)
							num5++;
						else if (sc == 6)
							num6++;
						else if (sc == 7)
							num7++;
						else if (sc == 8)
							num8++;
						else if (sc == 9)
							num9++;
					}
				}
				dp.setNumbers(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9);
			}

			else if (tempID == 6015) {
				for (int i = 0; i < stuNum; i++) {// 학생수만큼

					score = Double.parseDouble(stu[i].getAll());
					System.out.print("성적은 ");
					System.out.println(score);

					ID = Integer.parseInt(stu[i].getStudentId());

					int sc = (int) (score - 1) / 10;
					int n = ID / 10000;

					System.out.println(n);

					if (n == 6015) {
						if (sc == 0)
							num0++;
						else if (sc == 1)
							num1++;
						else if (sc == 2)
							num2++;
						else if (sc == 3)
							num3++;
						else if (sc == 4)
							num4++;
						else if (sc == 5)
							num5++;
						else if (sc == 6)
							num6++;
						else if (sc == 7)
							num7++;
						else if (sc == 8)
							num8++;
						else if (sc == 9)
							num9++;
					}
				}
				dp.setNumbers(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9);

			}

			else if (tempID == 6016) {
				for (int i = 0; i < stuNum; i++) {// 학생수만큼

					score = Double.parseDouble(stu[i].getAll());
					System.out.print("성적은 ");
					System.out.println(score);

					ID = Integer.parseInt(stu[i].getStudentId());

					int sc = (int) (score - 1) / 10;
					int n = ID / 10000;

					System.out.println(n);

					if (n == 6016) {
						if (sc == 0)
							num0++;
						else if (sc == 1)
							num1++;
						else if (sc == 2)
							num2++;
						else if (sc == 3)
							num3++;
						else if (sc == 4)
							num4++;
						else if (sc == 5)
							num5++;
						else if (sc == 6)
							num6++;
						else if (sc == 7)
							num7++;
						else if (sc == 8)
							num8++;
						else if (sc == 9)
							num9++;
					}
				}
				dp.setNumbers(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9);

			}

			else {
				for (int i = 0; i < stuNum; i++) {// 학생수만큼

					score = Double.parseDouble(stu[i].getAll());
					System.out.print("성적은 ");
					System.out.println(score);

					ID = Integer.parseInt(stu[i].getStudentId());

					int sc = (int) (score - 1) / 10;
					int n = ID / 10000;

					System.out.println(n);

					if (n == 6017) {
						if (sc == 0)
							num0++;
						else if (sc == 1)
							num1++;
						else if (sc == 2)
							num2++;
						else if (sc == 3)
							num3++;
						else if (sc == 4)
							num4++;
						else if (sc == 5)
							num5++;
						else if (sc == 6)
							num6++;
						else if (sc == 7)
							num7++;
						else if (sc == 8)
							num8++;
						else if (sc == 9)
							num9++;
					}
				}
				dp.setNumbers(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9);

			}
		}
	}

	private void insert() {
		scoreInsert.insert();
	}
}