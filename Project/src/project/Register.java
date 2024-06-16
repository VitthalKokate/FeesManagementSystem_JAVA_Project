package project;

import javax.swing.*;

import DataBase.DbConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends JFrame implements ActionListener{
	JButton clear,submit,sin;
	JTextField tn,tm,tid;
	JTextArea taddr;
	JPasswordField jpw,jrpw;
	JLabel pwCheck,pw2Check,checkMob;
	String name,phno,addr,id,pass1,pass2;
	public Register() {
		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		// HEADER
		JPanel heading=new JPanel();
		heading.setLayout(null);
		heading.setBackground(new Color(0,0,0,40));
		heading.setBounds(0, 0, 800, 100);
		
		
		JLabel title=new JLabel("Registration");

		title.setBounds(200,10,900,130);
		title.setForeground(Color.WHITE);
		title.setBackground(Color.yellow);
		title.setFont(new Font("Times New Roman",Font.BOLD,50));
		heading.add(title);
		
		
		// Content [Labels, TextField...} Adds
		JPanel content=new JPanel();
		content.setLayout(null);
		content.setBounds(100, 100, 500, 450);
		content.setBackground(new Color(0,0,0,80));
	
		//Name
		JLabel name=new JLabel("Enter Your Name :");
		name.setBounds(10,50,150,20);
		name.setForeground(Color.WHITE);
		content.add(name);
		 tn=new JTextField();
		tn.setBounds(150,50,200,20);
		content.add(tn);
		
		// Phone no
		JLabel mob=new JLabel("Enter Your Phone no. :");
		mob.setBounds(10,100,150,20);
		mob.setForeground(Color.WHITE);
		content.add(mob);	
		 tm=new JTextField();
		tm.setBounds(150,100,200,20);
		content.add(tm);
		 checkMob=new JLabel("");
		checkMob.setBounds(350,100,200,20);
		checkMob.setForeground(Color.red);
		content.add(checkMob);
		
//		addr
		JLabel addr=new JLabel("Enter Your Address :");
		addr.setBounds(10,150,150,20);
		addr.setForeground(Color.WHITE);
		content.add(addr);
		 taddr=new JTextArea();
		taddr.setBounds(150,150,200,50);
		content.add(taddr);
		
// Id
		JLabel id=new JLabel("Enter ID You want :");
		id.setBounds(10,230,150,20);
		id.setForeground(Color.WHITE);
		content.add(id);
		 tid=new JTextField();
		tid.setBounds(150,230,200,20);
		content.add(tid);
		
		
// Password
		JLabel pw=new JLabel("Enter Password :");
		pw.setBounds(10,280,150,20);
		pw.setForeground(Color.WHITE);
		content.add(pw);
	   jpw=new JPasswordField();
		jpw.setBounds(150,280,200,20);
		content.add(jpw);
		//check / validation
		pwCheck =new JLabel("");
		pwCheck.setForeground(Color.RED);
		pwCheck.setBounds(350,280,500,20);
		content.add(pwCheck);
		
		JLabel rpw=new JLabel("Confirm Password :");
		rpw.setBounds(10,330,150,20);
		rpw.setForeground(Color.WHITE);
		content.add(rpw);
		 jrpw=new JPasswordField();
		jrpw.setBounds(150,330,200,20);
		content.add(jrpw);
		// Check / validation
		pw2Check = new JLabel("");
		pw2Check.setBounds(350,330,150,20);
		pw2Check.setForeground(Color.red);
		content.add(pw2Check);
		
		
// Buttons
		 clear =new JButton("Clear");
		clear.setBounds(100,400,80,30);
		content.add(clear);
		clear.addActionListener(this);
		
		 submit =new JButton("Submit");
		submit.setBounds(200,400,80,30);
		submit.addActionListener(this);
		content.add(submit);
		
		 sin = new JButton("Sign-in");
		sin.setBounds(300,400,80,30);
		sin.addActionListener(this);
		content.add(sin);
		
		
		
		
		// Background
		//Background
				ImageIcon bg=new ImageIcon("D://JAVA//img//bgregister.jpg");
				
				Image img = bg.getImage();
				Image temp=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
				bg=new ImageIcon(temp);
				JLabel background = new JLabel ("",bg,JLabel.CENTER);
				background.setBounds(0,0,900,600);
				
				add(background);
				background.add(content);
				background.add(heading);
				setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== clear) {
			tn.setText("");
			tm.setText("");
			taddr.setText("");
			tid.setText("");
			
			jpw.setText("");
			jrpw.setText("");
			
			
		}else if(e.getSource()== submit) {
			boolean b=Test();
			
			
			if(b==true) {
				JOptionPane.showMessageDialog(this, "Registration Sucessfull Goto to the Login Page");
				insert();
			}
			
			
		}else {
			Login2 l2=new Login2();
		}
		
	}
	
	
	
	// validation
	public boolean Test() {
		
		name=tn.getText();
		phno=tm.getText();
		addr=taddr.getText();
		id=tid.getText();
		pass1=jpw.getText();
		pass2=jrpw.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Name");
			return false;
		}
		if(phno.equals("")|| tm.getText().matches("[0-9]+")==false) {
			JOptionPane.showMessageDialog(this, "Please Enter the Contact Details (in numbers)");
			return false;
		}
		if(addr.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Address");
			return false;
		}
		if(id.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Id");
			return false;
		}
		if(pass1.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Password");
			return false;
		}
		if(pass2.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Confirm Password");
			return false;
		}
		
		
		if(pass1.length()<4) {
			JOptionPane.showMessageDialog(this, "Password length should be *4 ");
			return false;
		}
		
		if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(this, "Confirm Password is Not Match");
			return false;
		}
		
		String ch ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		if(phno.equalsIgnoreCase(ch)) {
			JOptionPane.showMessageDialog(this, "Please Enter the Correct Phone Number");
			return false;
		}
		return true;
	}
	
	 

	
	// insert data    JTextField tn,tm,tid;
	public void insert() {
		
		String name=tn.getText();
		int mobNo=Integer.parseInt(tm.getText());
		String addr=taddr.getText();
		String userName = tid.getText();
		String password = jpw.getText();
		
				
				try {
					
					Connection conn = DbConnection.getConnection();
					PreparedStatement ps1=conn.prepareStatement("insert into Signup (name,phono,address,username,password) values (?,?,?,?,?) ");
					ps1.setString(1, name);
					ps1.setInt(2, mobNo);
					ps1.setString(3, addr);
					ps1.setString(4, userName);
					ps1.setString(5, password);

					int record =ps1.executeUpdate();
					
					if(record>0)
						JOptionPane.showMessageDialog(this, "Record inserted .");
					else
						JOptionPane.showMessageDialog(this, "Record Not inserted .");
						
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		
		
	}
	public static void main(String[] args) {
		Register r=new Register();
		
		

	}

	

}
