package test;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MyForm extends JFrame {
	
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyForm form = new MyForm();
				form.setVisible(true);
			}
		});
	}

	public MyForm() {

		// Create Form Frame
		super("ThaiCreate.Com Java GUI Tutorial");
		setSize(668, 345);
		setLocation(500, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Table
		table = new JTable();
		getContentPane().add(table);
		
		// Table Model
		final DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("name");
		model.addColumn("StudentId");
		model.addColumn("Mid");
		model.addColumn("Fin");
		model.addColumn("Subj");
		model.addColumn("Quiz");
		model.addColumn("Pre");
		model.addColumn("Report");
		model.addColumn("Atend");
		model.addColumn("Another");
		model.addColumn("all");
		
		// ScrollPane
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(84, 98, 506, 79);
		getContentPane().add(scroll);


		// Create Button Open JFileChooser
		JButton btnButton = new JButton("Open File Chooser");
		btnButton.setBounds(268, 47, 135, 23);
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileopen = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter(
						"Text/CSV file", "txt", "csv");
				fileopen.addChoosableFileFilter(filter);

				int ret = fileopen.showDialog(null, "Choose file");

				if (ret == JFileChooser.APPROVE_OPTION) {

					// Read Text file
					File file = fileopen.getSelectedFile();

					try {
						BufferedReader br = new BufferedReader(new FileReader(
								file));
						String line;
						int row = 0;
						while ((line = br.readLine()) != null) {
							String[] arr = line.split(",");
							model.addRow(new Object[0]);
							model.setValueAt(arr[0], row, 0);
							model.setValueAt(arr[1], row, 1);
							model.setValueAt(arr[2], row, 2);
							model.setValueAt(arr[3], row, 3);
							model.setValueAt(arr[4], row, 4);
							model.setValueAt(arr[5], row, 5);
							model.setValueAt(arr[6], row, 6);
							model.setValueAt(arr[7], row, 7);
							model.setValueAt(arr[8], row, 8);
							model.setValueAt(arr[9], row, 9);
							model.setValueAt(arr[10], row, 10);
							row++;
						}
						br.close();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}

					lblResult.setText(fileopen.getSelectedFile().toString());
				}

			}
		});
		getContentPane().add(btnButton);
		
		// Button Save
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData(); // save Data
			}
		});
		btnSave.setBounds(292, 228, 89, 23);
		getContentPane().add(btnSave);

	}
	
	
	private void SaveData()
	{
		Connection connect = null;
		Statement s = null;
		String url = "jdbc:mysql://localhost/score?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connect = DriverManager.getConnection(url,"root","12345");

			s = connect.createStatement();
			
			for(int i = 0; i<table.getRowCount();i++)
			{
				String name = table.getValueAt(i, 0).toString();
				String StudentId = table.getValueAt(i, 1).toString();
				String Mid = table.getValueAt(i, 2).toString();
				String Fin = table.getValueAt(i, 3).toString();
				String Subj = table.getValueAt(i, 4).toString();
				String Quiz = table.getValueAt(i, 5).toString();
				String Pre = table.getValueAt(i, 6).toString();
				String Report = table.getValueAt(i, 7).toString();
				String Atend = table.getValueAt(i,8 ).toString();
				String Another = table.getValueAt(i, 9).toString();
				//String all = table.getValueAt(i, 10).toString();
				
				// SQL Insert

				String sql = "INSERT INTO person (name, ID, middle, final, homework, quiz,attendance, announcement, report, other, total) VALUES "
						+ "(" + "'" + name + "'," + StudentId + "," +  Mid + "," +  Fin + "," +  Subj + ","
						+ Quiz + "," + Atend + ","+ Pre + "," +  Report + "," +  Another + "," +  all
						+ ")";
				s.executeUpdate(sql);
			}
				
			JOptionPane.showMessageDialog(null,
					"Import Data Successfully");
			//여기까지 데이터 베이스 저장


		} catch (Exception ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}