package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import DataBase.DbConnection;


public class Login2 extends JFrame implements ActionListener {
	
JButton log,clear,re;
JTextField user,pw;
JLabel valid;
	
	public Login2() {
		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// HEADER
				JPanel heading=new JPanel();
				heading.setBackground(new Color(0,0,0,80));
				heading.setBounds(0, 0, 900, 100);
				
		// Login title
				JLabel title=new JLabel("Login");
				
				title.setFont(new Font("Times New Roman",Font.BOLD,80));
				title.setForeground(Color.WHITE);
				heading.add(title);
				
				
		// Login Pannel
				JPanel login =new JPanel();
				login.setLayout(null);
       			login.setSize(400,350);
				login.setBackground(new Color(0,0,0,100));
				login.setBounds(250,175,400,350);
				
				JLabel lu=new JLabel("Enter Id");
				lu.setBounds(100,30,100,30);
				lu.setForeground(Color.WHITE);
				login.add(lu);
				
				 user = new JTextField();
				user.setBounds(100, 60, 200, 30);
//				user.setBackground(new Color(0,20,30,80));
				login.add(user);
				
				JLabel lp=new JLabel("Enter Password");
				lp.setBounds(100,100,100,30);
				lp.setForeground(Color.WHITE);
				login.add(lp);
				
				 pw = new JPasswordField();
				pw.setBounds(100, 130, 200, 30);
				login.add(pw);
				
				valid=new JLabel("");
				valid.setBounds(100,300,350,30);
				valid.setForeground(Color.red);
				login.add(valid);;
				
	//Buttons			
				 log=new JButton("Login");
				log.setBounds(50,200,80,30);
				log.addActionListener(this);
				login.add(log);
				
				 clear=new JButton("Clear");
				clear.setBounds(155,200,80,30);
				clear.addActionListener(this);
//				clear.setBackground(Color.ORANGE);
//				clear.setForeground(Color.white);
				login.add(clear);
				
				 re=new JButton("Register");
				re.setBounds(260,200,88,30);
				re.addActionListener(this);
			//	re.addMouseListener((MouseListener) this);
		    	login.add(re);
				
		    	
				
				
		
		//Background
		ImageIcon bg=new ImageIcon("D://JAVA//img//bglogin.jpg");
		
		Image img = bg.getImage();
		Image temp=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
		bg=new ImageIcon(temp);
		JLabel background = new JLabel ("",bg,JLabel.CENTER);
		
		background.setBounds(0,0,900,600);
		add(background);
		background.add(heading);  // add heading pannel
		background.add(login); // add login pannel
		
		
		setVisible(true);
	}
//	 Validation
	public boolean validation() {
		
	String id=user.getText();
	String pas=pw.getText();
	if(id.equals("")|| pas.equals("")) {
		JOptionPane.showMessageDialog(this, "Please Enter the Register Id and Password");
		return false;
	}
	return true;
	}
	
	
	void userVerification() {
		
		String username = user.getText();
		String password = pw.getText();
		try {
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps1=conn.prepareStatement("Select * from Signup Where username=? and password=?");
			ps1.setString(1, username);
			ps1.setString(2, password);
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(this, "Login Successful ");
				Home h=new Home();	
			}else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			user.setText("");
			pw.setText("");
		}else if(e.getSource() == re) {
			new Register();
		}else if(e.getSource() == log){
			boolean b=validation();
			if(b==true)
				userVerification();
			
		} else
		   {
			log.setVisible(false);
		   }
		
		
		
	}

	public static void main(String[] args) {
		Login2 l2=new Login2();

	}


	

}
