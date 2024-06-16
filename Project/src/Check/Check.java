package Check;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Check extends JFrame{
	
	JTable table;
	
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	
	String[] columnNames = {"First","Second","Third","Fourth"};
	
	public Check() throws Exception {
		
		records();
		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel select=new JPanel();
		select.setLayout(null);
		select.setBackground(new Color(0,0,0,150));
		select.setBounds(20, 10, 300, 550);
		
		
		
		
		
		setVisible(true);
		add(table);
		System.out.println("Done");
	}
	
	
	public void records() throws Exception  {
	
		 DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	        
	        table = new JTable();
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        table.setFillsViewportHeight(true);
	        add(table);
	        
	        
	        JScrollPane scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        
	        
	        String uname = "";
	        String email = "";
	        String pass = "";
	        String cou = "";
	        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root123");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("Select * from user");
			
			 int i = 0;
	            if (rs.next()) {
	                uname = rs.getString(1);
	                email = rs.getString(2);
	                pass = rs.getString(3);
	                cou = rs.getString(4);
	                model.addRow(new Object[]{uname, email, pass, cou});
	                i++;
	            }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		new Check();
	}
}