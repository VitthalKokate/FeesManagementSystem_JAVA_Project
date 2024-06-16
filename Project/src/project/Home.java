
package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Home extends JFrame implements ActionListener,MouseListener{
	
	JButton adt,search,editCourse,viewCourse,logOut,update;
	
	public Home()
	{
		setSize(900,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel info=new JPanel();
		info.setLayout(null);
		info.setBackground(new Color(0,0,0,150));
		info.setBounds(80, 0, 700, 550);
		
		
		JLabel nm=new JLabel("CODING CLOUD");
		nm.setBounds(250,0,900,100);
		nm.setForeground(Color.red);
		nm.setFont(new Font("Times New Roman",Font.BOLD,30));
		info.add(nm);
		
		JLabel nm2=new JLabel("CODING CLOUD PVT.LMT.");
		nm2.setBounds(270,25,900,100);
		nm2.setForeground(Color.red);
		nm2.setFont(new Font("Times New Roman",Font.BOLD,15));
		info.add(nm2);
		
		JLabel addr=new JLabel("Deccan Cornar, Near JM Road, Pune 04");
		addr.setBounds(250,45,900,100);
		addr.setForeground(Color.red);
		addr.setFont(new Font("Times New Roman",Font.BOLD,15));
		info.add(addr);
		
		
		
ImageIcon imglogo=new ImageIcon("D://JAVA//img//add2.png");	
		Image img2 = imglogo.getImage();
		Image temp2=img2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);  // Size
		imglogo=new ImageIcon(temp2);
	
		 adt=new JButton("AddFees",imglogo);
			adt.setBounds(50,170,150,120);
			adt.setBackground(Color.YELLOW);
			adt.addActionListener(this);
			adt.addMouseListener(this);
			info.add(adt);
			
			
			ImageIcon searchlogo=new ImageIcon("D://JAVA//img//Search.png");
			Image searchimg = searchlogo.getImage();
			Image temp3=searchimg.getScaledInstance(65, 65, Image.SCALE_SMOOTH);  // Size
			searchlogo=new ImageIcon(temp3);
			
			 search=new JButton("Search ",searchlogo);
			 search.setBounds(250,170,150,120);
			 search.setBackground(Color.YELLOW);
			 search.addActionListener(this);
			 search.addMouseListener(this);
			info.add(search);
			
			
			ImageIcon updatelogo=new ImageIcon("D://JAVA//img//Update2.png");	
			Image updateimg = updatelogo.getImage();
			Image temp4=updateimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);  // Size
			updatelogo=new ImageIcon(temp4);
			
			 update=new JButton("Update ",updatelogo);
			 update.setBounds(450,170,150,120);
			 update.setBackground(Color.YELLOW);
			 update.addActionListener(this);
			 update.addMouseListener(this);
			info.add(update);
			
			ImageIcon courselogo=new ImageIcon("D://JAVA//img//Course1.jpg");	
			Image courseimg = courselogo.getImage();
			Image temp5=courseimg.getScaledInstance(70, 70, Image.SCALE_SMOOTH);  // Size
			courselogo=new ImageIcon(temp5);
			
			editCourse=new JButton("Add Course",courselogo);
			editCourse.setBounds(150,350,180,120);
			editCourse.setBackground(Color.YELLOW);
			editCourse.addActionListener(this);
			editCourse.addMouseListener(this);
			info.add(editCourse);
			
			
			
			ImageIcon viewlogo=new ImageIcon("D://JAVA//img//View.png");	
			Image viewimg = viewlogo.getImage();
			Image temp6=viewimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);  // Size
			courselogo=new ImageIcon(temp6);
			
			viewCourse=new JButton("View Course",courselogo);
			viewCourse.setBounds(380,350,180,120);
			viewCourse.setBackground(Color.yellow);
			viewCourse.addActionListener(this);
			viewCourse .addMouseListener(this);
			info.add(viewCourse);
					
			
			
			
			ImageIcon logoutlogo=new ImageIcon("D://JAVA//img//logout.png");	
			Image logoutimg = logoutlogo.getImage();
			Image temp7=logoutimg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);  // Size
			logoutlogo=new ImageIcon(temp7);

			logOut=new JButton("Log Out",logoutlogo);
			logOut.setBounds(5,490,130,80);
			logOut.setBackground(Color.YELLOW);
			logOut.addActionListener(this);
			logOut.addMouseListener(this);
			info.add(logOut);
			
		
		
		
		
		
				ImageIcon bg=new ImageIcon("D://JAVA//img//bg2.jpg");
				
				Image img = bg.getImage();
				Image temp=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
				bg=new ImageIcon(temp);
				JLabel background = new JLabel ("",bg,JLabel.CENTER);
				
				background.setBounds(0,0,900,600);
				add(background);
				background.add(info);
				setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adt) {
			new Add();
		}
		else if(e.getSource() == search) {
			new SearchRecord();
		}
		else if(e.getSource() == editCourse) {
			new EditCourse();
		}
		else if(e.getSource() == viewCourse) {
			new ViewCourse();
		}else if(e.getSource() == update) {
			new UpdateRec();
			
		}else if(e.getSource() == logOut) {
		new Login2();
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
		
		if(e.getSource() == adt) {
			adt.setBackground(Color.orange);
			
		}else if(e.getSource() == search) {
			search.setBackground(Color.orange);
			

		}else if(e.getSource() == editCourse) {
			editCourse.setBackground(Color.orange);
		
		}else if(e.getSource() == viewCourse) {
			viewCourse.setBackground(Color.orange);

		}else if(e.getSource() == update) {
			update.setBackground(Color.orange);
		
		}else if(e.getSource() == logOut) {
			logOut.setBackground(Color.orange);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if(e.getSource() == adt) {
			adt.setBackground(Color.yellow);
			
		}else if(e.getSource() == search) {
			search.setBackground(Color.yellow);
			
		}else if(e.getSource() == editCourse) {
			editCourse.setBackground(Color.yellow);
		
		}else if(e.getSource() == update) {
			update.setBackground(Color.yellow);
			
		}else if(e.getSource() == viewCourse) {
			viewCourse.setBackground(Color.yellow);
		
		}else if(e.getSource() == logOut) {
			logOut.setBackground(Color.yellow);
		}
		
		
		
	}

	
	public static void main(String[] args) {
		
		Home h=new Home();
	}


	
}
