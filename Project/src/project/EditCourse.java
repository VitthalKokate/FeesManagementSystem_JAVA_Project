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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DataBase.DbConnection;

public class EditCourse extends JFrame implements ActionListener,MouseListener{
	
	JButton home,search,cEdit,cList,all,back,logout,submit,update,cadd,add ;
	JTextField courseName,courseid,coursePrice;
	JTextArea courseDes;
	
	public EditCourse() {
		
		setSize(900,600);
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
		
		JPanel detail=new JPanel();
		detail.setLayout(null);
		detail.setBackground(new Color(0,0,0,150));
		detail.setBounds(350, 10, 500, 550);
		
		JLabel heading=new JLabel("Add Course");
		heading.setBounds(170,0,900,100);
		heading.setForeground(Color.white);
		heading.setFont(new Font("Times New Roman",Font.BOLD,30));
		detail.add(heading);
		
		
		JLabel line=new JLabel("--------------------------------------");
		line.setBounds(130,10,900,100);
		line.setForeground(Color.WHITE);
		line.setFont(new Font("Times New Roman",Font.BOLD,17));
		detail.add(line);
		
		JLabel id=new JLabel(" New Course Id :");
		id.setBounds(20,100,150,20);
		id.setForeground(Color.white);
		detail.add(id);
		
		
		 courseid = new JTextField();
		 courseid.setBounds(150,100,100,20);
		 int num=getCourseId();
		 courseid.setText(Integer.toString(num));
			detail.add(courseid);
		
		
			JLabel nm=new JLabel(" New Course Name :");
			nm.setBounds(20,150,150,20);
			nm.setForeground(Color.white);
			detail.add(nm);
			
		
		 courseName = new JTextField();
		 courseName.setBounds(150,150,100,20);
			detail.add(courseName);
		
		

			JLabel price=new JLabel(" New Course Price :");
			price.setBounds(20,200,150,20);
			price.setForeground(Color.white);
			detail.add(price);
			
		
		 coursePrice = new JTextField();
		 coursePrice.setBounds(150,200,100,20);
			detail.add(coursePrice);
			
			
			
			JLabel cd=new JLabel(" Course Details :");
			cd.setBounds(20,250,150,20);
			cd.setForeground(Color.white);
			detail.add(cd);
		
			courseDes = new JTextArea(10,10);
			courseDes.setBounds(150,250,200,70);
//			courseDes.setForeground(Color.white);
			detail.add(courseDes);
			

		
			submit=new JButton("Submit");
			submit.setBounds(200,380,100,30);
			submit.addActionListener(this);
			detail.add(submit);
		
		
		
		
	ImageIcon bg=new ImageIcon("D://JAVA//img//bg2.jpg");
		
		Image img = bg.getImage();
		Image temp=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
		bg=new ImageIcon(temp);
		JLabel background = new JLabel ("",bg,JLabel.CENTER);
		
		background.setBounds(0,0,900,600);
		background.add(select);
		background.add(detail);
		add(background);
		
		
		setVisible(true);
		
	}
	
	
	
	
	public boolean validation() {	
		 if(courseName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter the Course Name");
				return false;
			}
			
			//&& courseAmt.getText().matches("[0-9]+")==false
			if(coursePrice.getText().equals("") || coursePrice.getText().matches("[0-9]+")==false) {
				 JOptionPane.showMessageDialog(this, "Please Enter Amount (in number)");
			}
			
		
		return true;
	}
	
	
	public int getCourseId() {
		
		int courseId =0;
		try {
			Connection conn = DbConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("select MAX(Id) from courslist");
			ResultSet rs=  pst.executeQuery();
			
			if(rs.next()) {
				courseId =rs.getInt(1);
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	  return courseId+1;
	}
	
	
	public String insertData() {
		
		String status="";
		
	
		int c_id=Integer.parseInt(courseid.getText());
		String c_nm=courseName.getText();
		int c_price=Integer.parseInt(coursePrice.getText());
		String info=courseDes.getText();
		
		
		
		try {
			Connection conn=DbConnection.getConnection();
			PreparedStatement ps1= conn.prepareStatement("insert into courslist values(?,?,?,?)");
	
			ps1.setInt(1, c_id);
			ps1.setString(2, c_nm);
			ps1.setInt(3, c_price);
			ps1.setString(4, info);
		
			
			int rowCount = ps1.executeUpdate();
			
			if(rowCount == 1)
				status="Success";
			else
				status="Failed";
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(this, e);
		}
		
		return status;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			if( validation() == true) {
			String status =	insertData();
			
			if(status.equals("Success")) {
				JOptionPane.showMessageDialog(this, "Record inserted Successfully");
			}
			else
				JOptionPane.showMessageDialog(this, "Record insertion Faile");
	
			}
		}
		
		
		 if(e.getSource() == home){
				Home h=new Home();
			}else if(e.getSource() == back){
				new UpdateRec();
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
		}
		else if(e.getSource() == cadd) {
			cadd.setBackground(Color.orange);
			
		}else if(e.getSource() == add) {
			add.setBackground(Color.orange);
			
		}else if(e.getSource() == update) {
			update.setBackground(Color.orange);
			
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
			
		}else if(e.getSource() == cadd) {
			cadd.setBackground(Color.yellow);
			
		}else if(e.getSource() == add) {
			add.setBackground(Color.yellow);
			
		}else if(e.getSource() == update) {
			update.setBackground(Color.yellow);
			
		}

		
	}




	public static void main(String[] args) {
		EditCourse e=new EditCourse();
		

	}

}
