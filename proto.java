import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ����ó��.ClassAvg;
import ����ó��.EachGraph;
import ����ó��.Perchant;
import ����ó��.ScoreCal;
import ����ó��.SetGrade;
import ����ó��.TotalGraph;
import ����ó��.UCheck;

public class proto extends JFrame {
	static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/score?characterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	
	static final String DEFAULT_QUERY = "SELECT * FROM person";
	
	private Using_DB tableModel;
	private JTextArea queryArea;
	
	public proto() {
		super("Displaying Query Results");
		
		try {
			tableModel = 
				new Using_DB(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			JMenuItem item;
			
			//�޴��� ����
			JMenuBar mb = new JMenuBar();
			JMenu m1 = new JMenu("����");
			JMenu m2 = new JMenu("����");
			JMenu m3 = new JMenu("���");
			JMenu m4 = new JMenu("�⼮");
			JMenu m5 = new JMenu("����");
			
			//����
			m1.add(new JMenuItem("�� ����"));
			m1.add(new JMenuItem("�ҷ�����"));
			m1.add(new JMenuItem("���� ����"));
			m1.add(new JMenuItem("�ٸ� �̸����� ���� ����"));
			
			//����
			item = new JMenuItem("�������");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("�ݿ����� ����");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("��޼���");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("������� ���");
//			item.addActionListener(this);
			m2.add(item);
			item = new JMenuItem("������� ���");
//			item.addActionListener(this);
			m2.add(item);

			//���
			item = new JMenuItem("������ ������");
//			item.addActionListener(this);
			m3.add(item);
//			m3.addActionListener(this);
			JMenu m = new JMenu("�� ���� ������");
			item = new JMenuItem("�⼮����");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("�߰���������");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("�⸻��������");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("��������");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("��������");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("��ǥ����");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("��������");
//			item.addActionListener(this);
			m.add(item);
			item = new JMenuItem("��Ÿ����");
//			item.addActionListener(this);
			m.add(item);
			m3.add(m);
//			m3.addActionListener(this);

			mb.add(m3);
			//�⼮.
			//�߰� ��Ź.
			
			//����
			m5.add(new JMenuItem("��� ���� ����"));
			m5.add(new JMenuItem("��� ���� ����"));
			m5.add(new JMenuItem("�� ������ �ݿ� ���� ����"));
			m5.add(new JMenuItem("���� �ο� ����"));
			
			//�޴��ٿ� �޴��� �߰�.
			mb.add(m1);mb.add(m2);mb.add(m3);mb.add(m4);mb.add(m5);

			JTable resultTable = new JTable(tableModel);
			
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();
			

			this.add(mb, BorderLayout.NORTH);
			this.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			
			
			//�����ϱ� ���ؼ� �̷��� ����� �־���.
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			this.setSize(500, 250);
			this.setVisible(true);
			
			filterButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String text = filterText.getText();
						
						if(text.length() == 0) {
							sorter.setRowFilter(null);
						}else {
							try {
								sorter.setRowFilter(RowFilter.regexFilter(text));
							}catch(PatternSyntaxException pse) {
								JOptionPane.showMessageDialog(null, "Bad regex pattern", 
										"Bad regex pattern", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			);
		}catch(SQLException sqlException) {
			JOptionPane.showMessageDialog(null,  sqlException.getMessage(),	
					"Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectedFromDatabase();
			System.exit(1);
		}
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosed(WindowEvent event) {
					tableModel.disconnectedFromDatabase();
					System.exit(0);
				}
			}
		);
	}
	
	public static void main(String[] args) {
		new proto();
	}
	
	public void actionPerformed(ActionEvent e) {

		JMenuItem mi = (JMenuItem) (e.getSource());
		switch (mi.getText()) {
		case "�ҷ�����":
			//������������ �������.
			System.out.println("�Ǵ°���?");
			
			break;
		case "�������":
			System.out.println("�������");

			new ScoreCal();
			break;
		case "�ݿ����� ����":
			System.out.println("�ݿ����� ����");
			new Perchant();
			break;
		case "��޼���":
			System.out.println("��޼���");
			new SetGrade();
			break;
		case "������� ���":
			System.out.println("������� ���");
			new UCheck();
			break;
		case "������� ���":
			System.out.println("������� ���");
			new ClassAvg();
			break;
		case "������ ������":
			System.out.println("������ ������ ���");
			new TotalGraph();
			break;
		case "�⼮����":
			System.out.println("�⼮���� ���");
			// new EachGraph("attenance");
			break;
		case "�߰���������":
			System.out.println("�߰��������� ���");
			new EachGraph("middle");
			break;
		case "�⸻��������":
			System.out.println("�⸻�������� ���");
			new EachGraph("final");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("report");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("quiz");
			break;
		case "��ǥ����":
			System.out.println("��ǥ���� ���");
			new EachGraph("announcement");
			break;
		case "��������":
			System.out.println("�������� ���");
			new EachGraph("report");
			break;
		case "��Ÿ����":
			System.out.println("��Ÿ���� ���");
			new EachGraph("other");
			break;

		}

	}
}
