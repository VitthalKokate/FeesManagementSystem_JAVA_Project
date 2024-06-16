package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataBase.DbConnection;

public class SearchRecord  extends JFrame implements ActionListener,MouseListener{

	JButton home,search,cEdit,cList,all,back,logout,print,update,cadd,add;
	
	DefaultTableModel model = new DefaultTableModel();
	JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	  JPanel detail=new JPanel();
	
	public SearchRecord() {
		
		
		setSize(1200,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel select=new JPanel();
		select.setLayout(null);
		select.setBackground(new Color(0,0,0,150));
		select.setBounds(20, 10, 300, 550);
	
		ImageIcon imglogo=new ImageIcon("D://JAVA//img//home.png");	
		Image img2 = imglogo.getImage();
		Image temp2=img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		imglogo=new ImageIcon(temp2);
		
		home=new JButton("  Home",imglogo);
		home.setBounds(10,50,250,30);
		home.setBackground(Color.YELLOW);
		home.addActionListener(this);
		home.addMouseListener(this);
		select.add(home);
		
		ImageIcon addlogo=new ImageIcon("D://JAVA//img//add2.png");	
		Image addimg = addlogo.getImage();
		Image addtemp=addimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		addlogo=new ImageIcon(addtemp);
		
		add=new JButton("  Add ",addlogo);
		add.setBounds(10,100,250,30);
		add.setBackground(Color.YELLOW);
		add.addActionListener(this);
		add.addMouseListener(this);
		select.add(add);
	
		
		ImageIcon searchlogo=new ImageIcon("D://JAVA//img//Search.png");
		Image searchimg = searchlogo.getImage();
		Image temp3=searchimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		searchlogo=new ImageIcon(temp3);
		
		search=new JButton("Search Record",searchlogo);
		search.setBounds(10,150,250,30);
		search.setBackground(Color.YELLOW);
		search.addActionListener(this);
		search.addMouseListener(this);
		select.add(search);
		
		
		ImageIcon updatelogo=new ImageIcon("D://JAVA//img//Update2.png");	
		Image updateimg = updatelogo.getImage();
		Image temp4=updateimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		updatelogo=new ImageIcon(temp4);
		
		update=new JButton("Update Record",updatelogo);
		update.setBounds(10,200,250,30);
		update.setBackground(Color.YELLOW);
		update.addActionListener(this);
		update.addMouseListener(this);
		select.add(update);
		
	
		
		ImageIcon cAddlogo=new ImageIcon("D://JAVA//img//courseAdd.png");	
		Image caddimg = cAddlogo.getImage();
		Image tempcadd=caddimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		cAddlogo=new ImageIcon(tempcadd);
		
		cadd=new JButton("Course Add",cAddlogo);
		cadd.setBounds(10,250,250,30);
		cadd.setBackground(Color.YELLOW);
		cadd.addActionListener(this);
		cadd.addMouseListener(this);
		select.add(cadd);
		
		
		
		ImageIcon listlogo=new ImageIcon("D://JAVA//img//courseList.png");	
		Image listimg = listlogo.getImage();
		Image temp5=listimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		listlogo=new ImageIcon(temp5);
		
		cList=new JButton("Course List",listlogo);
		cList.setBounds(10,300,250,30);
		cList.setBackground(Color.YELLOW);
		cList.addActionListener(this);
		cList.addMouseListener(this);
		select.add(cList);
		
		
		ImageIcon backlogo=new ImageIcon("D://JAVA//img//back.png");	
		Image backimg = backlogo.getImage();
		Image temp6=backimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		backlogo=new ImageIcon(temp6);
	
		back=new JButton("  Back",backlogo);
		back.setBounds(10,350,250,30);
		back.setBackground(Color.YELLOW);
		back.addActionListener(this);
		back.addMouseListener(this);
		select.add(back);
		
		
		ImageIcon logoutlogo=new ImageIcon("D://JAVA//img//logout.png");	
		Image logoutimg = logoutlogo.getImage();
		Image temp7=logoutimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Size
		logoutlogo=new ImageIcon(temp7);
		
		logout=new JButton("Logot",logoutlogo);
		logout.setBounds(10,400,250,30);
		logout.setBackground(Color.YELLOW);
		logout.addActionListener(this);
		logout.addMouseListener(this);
		select.add(logout);
	
	
	
		
		
// Second Pannel
		
		detail.setLayout(null);
		detail.setBackground(new Color(0,0,0,150));
		detail.setBounds(350, 10, 800, 550);
		
		JLabel heading=new JLabel("List Of Student");
		heading.setBounds(150,0,900,100);
		heading.setForeground(Color.white);
		heading.setFont(new Font("Times New Roman",Font.BOLD,30));
		detail.add(heading);
		
		
		JLabel line=new JLabel("--------------------------------------");
		line.setBounds(140,10,900,100);
		line.setForeground(Color.WHITE);
		line.setFont(new Font("Times New Roman",Font.BOLD,17));
		detail.add(line);
		
		

		
		
		// second frame
		
		
		 scrlPane.setBounds(0,200,800,600);
		 detail.add(scrlPane);
		    tabGrid.setFont(new Font ("Times New Roman",0,15));

		   	model.addColumn("Receipt No.");
		   	model.addColumn("S_Name");
		  	model.addColumn("Payment Mode");
		  	model.addColumn("Course Name");
		  	model.addColumn("Amount");
		  	model.addColumn("Total Amount");
		  	model.addColumn("Paid Amount");
		  	model.addColumn("Remaining AMT");
		
		
		  	insertData();
		
		
	ImageIcon bg=new ImageIcon("D://JAVA//img//bg2.jpg");
		
		Image img = bg.getImage();
		Image temp=img.getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
		bg=new ImageIcon(temp);
		JLabel background = new JLabel ("",bg,JLabel.CENTER);
		
		background.setBounds(0,0,1200,600);
		add(background);
		background.add(select);
		background.add(detail);
		
		
		
		setVisible(true);
		
	}

	private void insertData() {
	  	int r = 0;
	  	try {
			
	  		Connection con=DbConnection.getConnection();
	  		System.out.println("Connected to database.");
		Statement	stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet    rs = stmt.executeQuery("select * from fees_details");
	          while(rs.next())
	            {
	            	model.insertRow(r++,new Object[]{rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(11),rs.getString(12),rs.getString(14)});

	            }

	             con.close();
	  		
	  		
		} catch(SQLException se)
	       {
	       	  System.out.println(se);
	          JOptionPane.showMessageDialog(null,"SQL Error:"+se);
	       }
	       catch (Exception e) {
	    	   System.out.println(e);
	           JOptionPane.showMessageDialog(null,"Error:"+e);
	       }
			
		
	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource() == home) {
			home.setBackground(Color.orange);
			
		}else if(e.getSource() == search) {
			search.setBackground(Color.orange);
			
		}else if(e.getSource() == cEdit) {
			cEdit.setBackground(Color.orange);

		}else if(e.getSource() == cList) {
			cList.setBackground(Color.orange);
		
		}else if(e.getSource() == all) {
			all.setBackground(Color.orange);
		
		}else if(e.getSource() == back) {
			back.setBackground(Color.orange);
		
		}else if(e.getSource() == logout) {
			logout.setBackground(Color.orange);
		}else if(e.getSource() == update) {
			update.setBackground(Color.orange);
		}
		else if(e.getSource() == add) {
			add.setBackground(Color.orange);
		}
		
		
		
			
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if(e.getSource() == home) {
			home.setBackground(Color.yellow);
			
		}else if(e.getSource() == search) {
			search.setBackground(Color.yellow);
			
		}else if(e.getSource() == cEdit) {
			cEdit.setBackground(Color.yellow);

		}else if(e.getSource() == cList) {
			cList.setBackground(Color.yellow);
		
		}else if(e.getSource() == all) {
			all.setBackground(Color.yellow);
		
		}else if(e.getSource() == back) {
			back.setBackground(Color.yellow);
		
		}else if(e.getSource() == logout) {
			logout.setBackground(Color.yellow);
		}else if(e.getSource() == update) {
			update.setBackground(Color.yellow);
		}else if(e.getSource() == add) {
			add.setBackground(Color.yellow);
		}


	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == home){
			Home h=new Home();
		}else if(e.getSource() == back){
			new Add();
		}else if(e.getSource() == search) {
			new SearchRecord();
		}else if(e.getSource()==update) {
		new UpdateRec();
		}else if(e.getSource()==cadd) {
		new EditCourse();
		}else if(e.getSource()==cList) {
		new ViewCourse();
		}else if(e.getSource()==logout) {
		new Login2();
		}else if(e.getSource()==add) {
			new Add();
			}
		
	}

	

	

	public static void main(String[] args) {
		new SearchRecord();
	}
	
}
