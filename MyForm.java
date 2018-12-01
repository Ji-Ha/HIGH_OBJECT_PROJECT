package test;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//import javax.swing.JLabel;
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
		model.addColumn("Atend");
		model.addColumn("Total");
		model.addColumn("Mid");
		model.addColumn("Fin");
		model.addColumn("HW");
		model.addColumn("Quiz");
		model.addColumn("Pre");
		model.addColumn("Report");
		model.addColumn("Another");
		model.addColumn("Rank");

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
							model.setValueAt(arr[11], row, 11);
							row++;
						}
						br.close();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}

					//lblResult.setText(fileopen.getSelectedFile().toString());
				}

			}
		});
		getContentPane().add(btnButton);

		// Button Save in DB
		JButton btnSave = new JButton("SaveDB");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData(); // save Data
			}
		});

		// Button Save in CSV File
		JButton btnCSV = new JButton("SaveCSV");
		btnCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveCSV();
			}
		});

		btnSave.setBounds(360, 228, 89, 23);
		getContentPane().add(btnSave);

		btnCSV.setBounds(200,228,89,23);
		getContentPane().add(btnCSV);

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
				String Attend = table.getValueAt(i,2).toString();
				String Total = table.getValueAt(i, 3).toString();
				String Mid = table.getValueAt(i, 4).toString();
				String Fin = table.getValueAt(i, 5).toString();
				String HW = table.getValueAt(i, 6).toString();
				String Quiz = table.getValueAt(i, 7).toString();
				String Pre = table.getValueAt(i, 8).toString();
				String Report = table.getValueAt(i, 9).toString();
				String Another = table.getValueAt(i, 10).toString();
				String Rank = table.getValueAt(i, 11).toString();

				// SQL Insert

				String sql = "INSERT INTO person (name, ID, attendance ,total ,middle, final, homework, quiz, announcement, report, other, rank_total) VALUES "
						+ "(" + "'" + name + "'," + StudentId + "," +  Attend + "," +  Total + "," +  Mid + ","
						+ Fin + "," + HW + "," + Quiz + "," +  Pre + "," +  Report + "," + Another + "," + Rank // + "," +  all
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



	private void SaveCSV()
	{
		Connection connect = null;
		Statement s = null;
		String url = "jdbc:mysql://localhost/score?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url,"root","12345");

			s = connect.createStatement();
			//String sql = "SELECT * FROM score.person";

			ResultSet rec = s.executeQuery("SELECT * FROM score.person");

			String path = "C:\\Users\\user\\Desktop\\csv\\sample.csv";
			FileWriter writer;

			try {
				File file = new File(path);
				writer = new FileWriter(file,true);

				while((rec!=null)&&(rec.next())) {
					writer.write(rec.getString("name"));
					writer.write(",");
					writer.write(rec.getString("ID"));
					writer.write(",");
					writer.write(rec.getString("attendance"));
					writer.write(",");
					writer.write(rec.getString("total"));
					writer.write(",");
					writer.write(rec.getString("middle"));
					writer.write(",");
					writer.write(rec.getString("final"));
					writer.write(",");
					writer.write(rec.getString("homework"));
					writer.write(",");
					writer.write(rec.getString("quiz"));
					writer.write(",");
					writer.write(rec.getString("announcement"));
					writer.write(",");
					writer.write(rec.getString("report"));
					writer.write(",");
					writer.write(rec.getString("other"));
					writer.write(",");
					writer.write(rec.getString("rank_total"));
					writer.write("\n"); //\r\n
				}
				writer.flush();
				writer.close();

				System.out.println("Write success!");

			}catch(IOException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close
		try {
			if(connect != null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
