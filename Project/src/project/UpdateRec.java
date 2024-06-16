package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import DataBase.DbConnection;
import NumberConvert.*;

public class UpdateRec extends JFrame implements ActionListener ,MouseListener{
	
	JButton home,search,cEdit,cList,update,back,logout,print,totalb,calculate ,check,cadd,add;
	JLabel upi,bank;
	JComboBox comboBox,comboBoxCourse;
	JTextField upiT,bankT,rcno,receName,courseNm,courseAmt,cgstAmt,sgstAmt,totalT,totalWordtxt,paidAmt,reamtT;
	JFormattedTextField datetxt;
	
	
	public UpdateRec() {
		
		
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
		
		JLabel recept=new JLabel("Reciept No :");
		recept.setLayout(null);
		recept.setBounds(5,2,80,30);
		recept.setForeground(Color.white);
		detail.add(recept);

		rcno = new JTextField();
		rcno.setBounds(85, 10, 100, 20);
	
		rcno.setText("");
		detail.add(rcno);
		
		
		JLabel mode = new JLabel("Mode of Payment :");
		mode.setLayout(null);
		mode.setBounds(5,40,200,30);
		mode.setForeground(Color.white);
		detail.add(mode);
		
		
//		
//		JTextField mode2 = new JTextField();
//		mode2.setBounds(120,60,100,20);
//		detail.add(mode2);
		String[] modes={"Cash","UPI","Bank"};
	   comboBox = new JComboBox(modes);
		comboBox.setLayout(null);
		comboBox.setBounds(120,45,100,20);
		comboBox.addActionListener(this);
		detail.add(comboBox);
		
	    upi=new JLabel("Enter UPI Number:");
		upi.setLayout(null);
		upi.setBounds(250,55,130,20);
		upi.setForeground(Color.white);
		upi.setVisible(false);
		detail.add(upi);
		
	    upiT = new JTextField();
		upiT.setBounds(370, 55, 130, 20);
		upiT.setVisible(false);
		detail.add(upiT);
		
	    bank=new JLabel("Enter A/c Number:");
		bank.setLayout(null);
		bank.setBounds(250,55,130,20);
		bank.setForeground(Color.white);
		bank.setVisible(false);
		detail.add(bank);
		
	    bankT = new JTextField();
		bankT.setBounds(370, 55, 130, 20);
		bankT.setVisible(false);
		detail.add(bankT);
		
		JLabel date=new JLabel("Date :");
		date.setLayout(null);
		date.setBounds(350,5,80,30);
		date.setForeground(Color.white);
		detail.add(date);
		
		  datetxt = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		  datetxt.setValue(new Date());
		  datetxt.setBounds(400,10,50,20);
		    detail.add(datetxt);
		    
		    
		    JLabel rForm=new JLabel("Student Name :");
		    rForm.setLayout(null);
		    rForm.setBounds(5,80,200,30);
		    rForm.setForeground(Color.white);
			detail.add(rForm);
		    
		    
			 receName = new JTextField();
			receName.setBounds(120,85,200,20);
			detail.add(receName);
			
			
			JLabel course=new JLabel(" Course  :");
			course.setLayout(null);
			course.setBounds(5,120,200,30);
			course.setForeground(Color.white);
			detail.add(course);
			
			
			
			List<String> l1 =getCourse();
			
			int n=l1.size();
			String [] arr = new String[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=l1.get(i);
			}
			
			   comboBoxCourse = new JComboBox(arr);
			   comboBoxCourse.setLayout(null);
			   comboBoxCourse.setBounds(120,125,100,20);
			   comboBoxCourse.addActionListener(this);
				detail.add(comboBoxCourse);
		    

		 JLabel line=new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		 line.setLayout(null);
		 line.setBounds(0,150,300,30);
		line.setForeground(Color.white);
		detail.add(line);
		
		
		JLabel line2=new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		line2.setLayout(null);
		line2.setBounds(285,150,300,30);
		line2.setForeground(Color.white);
		detail.add(line2);
					
			
					
		
		
		JLabel courses=new JLabel("Courses ");
		courses.setLayout(null);
		courses.setBounds(50,175,100,30);
		courses.setForeground(Color.white);
		detail.add(courses);
		
		JLabel amt=new JLabel("Amout (Rs) ");
		amt.setLayout(null);
		amt.setBounds(400,175,100,30);
		amt.setForeground(Color.white);
		detail.add(amt);
		
		
		 JLabel line3=new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		 line3.setLayout(null);
		 line3.setBounds(0,200,300,30);
		 line3.setForeground(Color.white);
		detail.add(line3);
		
		 JLabel line4=new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		 line4.setLayout(null);
		 line4.setBounds(285,200,300,30);
		 line4.setForeground(Color.white);
		detail.add(line4);
		
		
		
		 courseNm = new JTextField();
		courseNm.setBounds(20,250,200,20);
		detail.add(courseNm);
		
		 courseAmt = new JTextField();
		courseAmt.setBounds(400,250,80,20);
		courseAmt.addActionListener(this);
		detail.add(courseAmt);
		
		 cgstAmt = new JTextField();
		cgstAmt.setBounds(300,290,80,20);
		detail.add(cgstAmt);
		
		 sgstAmt = new JTextField();
		sgstAmt.setBounds(300,320,80,20);
		detail.add(sgstAmt);
		
		JLabel cgst=new JLabel("CGST  9% ");
		cgst.setLayout(null);
		cgst.setBounds(20,290,100,30);
		cgst.setForeground(Color.white);
		detail.add(cgst);
		
		
		JLabel sgst=new JLabel("SGST  9% ");
		sgst.setLayout(null);
		sgst.setBounds(20,320,100,30);
		sgst.setForeground(Color.white);
		detail.add(sgst);
		
		 calculate = new JButton("Calculate");
		calculate.setBounds(400,320,90,20);
		calculate.addActionListener(this);
		detail.add(calculate);
		
		JLabel total=new JLabel("Total ");
		total.setLayout(null);
		total.setBounds(20,350,100,30);
		total.setForeground(Color.white);
		detail.add(total);
		
		 totalT = new JTextField();
			totalT.setBounds(400,350,80,20);
			detail.add(totalT);
			
			
		
		JLabel paid =new JLabel("Paid");
		paid.setLayout(null);
		paid.setBounds(20,390,300,30);
		paid.setForeground(Color.white);
		detail.add(paid);
		
		 paidAmt = new JTextField();
		 paidAmt.setBounds(400,390,80,20);
			detail.add(paidAmt);
		
		
		
		
		
		JLabel totali =new JLabel("- - - - - - - - - - - - - - - - - - -");
		totali.setLayout(null);
		totali.setBounds(380,410,300,30);
		totali.setForeground(Color.white);
		detail.add(totali);
		
		JLabel reamt =new JLabel("Remaining Amount :- ");
		reamt.setLayout(null);
		reamt.setBounds(20,435,300,30);
		reamt.setForeground(Color.white);
		detail.add(reamt);
		
		reamtT = new JTextField();
		reamtT.setBounds(400,435,80,20);
			detail.add(reamtT);
		
		
		
		
		JLabel totalWord=new JLabel("Total in Words : ");
		totalWord.setLayout(null);
		totalWord.setBounds(10,480,100,30);
		totalWord.setForeground(Color.white);
		detail.add(totalWord);
		
		
		 totalWordtxt = new JTextField();
		totalWordtxt.setBounds(120,485,200,20);
		detail.add(totalWordtxt);
		
		
		
		 print = new JButton("Print");
			print.setLayout(null);
			print.setBounds(200,520,70,20);
			print.addActionListener(this);
			detail.add(print);
		
		
		
		
			totalb = new JButton("Total");
			totalb.setLayout(null);
			totalb.addActionListener(this);
			totalb.setBounds(405,480,70,20);
			totalb.addActionListener(this);
		detail.add(totalb);
		
		
		check = new JButton("Check");
		check.setLayout(null);
		check.addActionListener(this);
		check.setBounds(350,85,80,20);
		check.addActionListener(this);
	detail.add(check);
		
		
		
		
		
		ImageIcon bg=new ImageIcon("D://JAVA//img//bg2.jpg");
		
		Image img = bg.getImage();
		Image temp=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
		bg=new ImageIcon(temp);
		JLabel background = new JLabel ("",bg,JLabel.CENTER);
		
		background.setBounds(0,0,900,600);
		add(background);
		background.add(select);
		background.add(detail);
		
		setVisible(true);
		
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == home){
				Home h=new Home();
			}else if(e.getSource() == back){
				 new SearchRecord();
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
		  
		
		
	// Print Button
		if(e.getSource() == print) {
			if( validation() == true) {
				
			String status =	insertData();
			
			if(status.equals("Success")) {
				JOptionPane.showMessageDialog(this, "Record inserted Successfully");
				String name=receName.getText();
				new Print(name);
			}
			else
				JOptionPane.showMessageDialog(this, "Record insertion Faile");
	
			}
		}	
		
			
			
			
			if(e.getSource() == calculate)
			{
				boolean b=validation();
				if(b==true) {
				 Float amt= Float.parseFloat(courseAmt.getText());
			     
					
				 
			       Float cgst=(float)(amt * 0.09);
			       Float sgst=(float)(amt * 0.09);
			       Float lastAmt = amt+cgst+sgst;
			       
			       
			       cgstAmt.setText(cgst.toString());
			       sgstAmt.setText(sgst.toString());
				   totalT.setText(lastAmt.toString());
				}
				  
			}
		
		if(e.getSource() == totalb) {
			
		boolean b=validation();
		boolean b2 =validPaidAmt();
			 
			  // Calculate
		 if(b==true && b==true) {
			 
			 Float amt= Float.parseFloat(courseAmt.getText());
		     
			
			 
		       Float cgst=(float)(amt * 0.09);
		       Float sgst=(float)(amt * 0.09);
		       
		       Float lastAmt = amt+cgst+sgst;
		       
			   double val= (double )lastAmt;
			   String numberWords=Converter.convert((int)val);
			   
			   Float paid =Float.parseFloat(paidAmt.getText());
			   
			   Double finalAmt= val - paid;
			   
			   reamtT.setText(finalAmt.toString());
			   
			   
			   
			   totalWordtxt.setText(numberWords);
		 }
			   
			 
		}
		// Combobox	
        if(comboBox.getSelectedIndex()==0) {
			
			bank.setVisible(false);
			bankT.setVisible(false);
			
			upi.setVisible(false);
			upiT.setVisible(false);
			
		}else if(comboBox.getSelectedIndex()==1) {
			
			bank.setVisible(false);
			bankT.setVisible(false);
			
			upi.setVisible(true);
			upiT.setVisible(true);
			
		}else if(comboBox.getSelectedIndex()==2) {
			upi.setVisible(false);
			upiT.setVisible(false);
			
			bank.setVisible(true);
			bankT.setVisible(true);
		}
        
		
        
        // ComboboxCourse

       if( comboBoxCourse.getSelectedItem() != null) {
    	   String select = (String) comboBoxCourse.getSelectedItem();
    	   courseNm.setText(select);
    	   
    	   
    	   int price = getCoursePrice(select);
   	    courseAmt.setText(Integer.toString(price));
    			   
       }
       
       
       if(e.getSource()==check) {
    	   boolean val=name();
    	   if(val==true) {
    				
    				String status =	getData();
    				
    				if(status.equals("Success")) {
    					JOptionPane.showMessageDialog(this, "Record Are Availabe");
//    					new Print();
    				}
    				else
    					JOptionPane.showMessageDialog(this, "Record insertion Faile");
    	   }
       }
	}
	public boolean name() {
		
		 if(receName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter the Recevier Name");
				return false;
		 }
		
		return true;
	}
	public String getData() {
		try {
			Connection conn=DbConnection.getConnection();
		  PreparedStatement ps1=conn.prepareStatement("Select * from Fees_Details where studenName = ?");
		  ps1.setString(1, receName.getText());
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				Integer no = rs.getInt(2);
				rcno.setText(no.toString());
				
				receName.setText(rs.getString(3));
//				modPay.setText(rs.getString(4));
				
				Integer acDet = rs.getInt(5);
				bankT.setText(acDet.toString());
				
				Integer upiNo = rs.getInt(6);
				upiT.setText(upiNo.toString());
				
				courseNm.setText(rs.getString(7));
				
				Integer camt=rs.getInt(8);
				courseAmt.setText(camt.toString());
				
				Integer cgstA=rs.getInt(9);
				cgstAmt.setText(cgstA.toString());
				
				Integer sgstA=rs.getInt(10);
				sgstAmt.setText(sgstA.toString());
				
				
				Integer Tot=rs.getInt(11);
				totalT.setText(Tot.toString());
				
				Integer pai=rs.getInt(12);
				paidAmt.setText(pai.toString());
				
				Integer remain=rs.getInt(14);
				reamtT.setText(remain.toString());
				
				totalWordtxt.setText(rs.getString(13));
				
				return "Success";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return "fail";
		
	}
	
	

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// 
	
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
		
		}else if(e.getSource() == update) {
			update.setBackground(Color.orange);
		
		}else if(e.getSource() == back) {
			back.setBackground(Color.orange);
		
		}else if(e.getSource() == logout) {
			logout.setBackground(Color.orange);
			
		}	else if(e.getSource() == cadd) {
			cadd.setBackground(Color.orange);
			
		}else if(e.getSource() == add) {
			add.setBackground(Color.orange);
			
		}else if(e.getSource() == update) {
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
		
		}else if(e.getSource() == update) {
			update.setBackground(Color.yellow);
		
		}else if(e.getSource() == back) {
			back.setBackground(Color.yellow);
		
		}else if(e.getSource() == logout) {
			logout.setBackground(Color.yellow);
			
		}	else if(e.getSource() == cadd) {
			cadd.setBackground(Color.yellow);
			
		}else if(e.getSource() == add) {
			add.setBackground(Color.yellow);
			
		}else if(e.getSource() == update) {
			add.setBackground(Color.yellow);
			
		}

		
	}

	
	public boolean validation() {
		 if(receName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Recevier Name");
			return false;
		}
		 if(comboBox.getSelectedItem().toString().equalsIgnoreCase("UPI")) {
			 if(upiT.getText().equals("")) {
				 JOptionPane.showMessageDialog(this, "Please Enter the UPI Number");
					return false; 
			 }
		 }
			if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Bank")) {
				 if(bankT.getText().equals("")) {
					 JOptionPane.showMessageDialog(this, "Please Enter the Account Information");
						return false; 
				 }
		 }
			
			//&& courseAmt.getText().matches("[0-9]+")==false
			if(courseAmt.getText().equals("") || courseAmt.getText().matches("[0-9]+")==false) {
				
				 JOptionPane.showMessageDialog(this, "Please Enter Amount (in number)");

			}
			
			
		return true;
	}
	
	public boolean validPaidAmt() {
		 if(paidAmt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter the Paid Amount");
				return false;
			}
	return true;
	}
	
	
	public int getRecepitNo() {
		
		int receiptNo =0;
		try {
			Connection conn = DbConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("select MAX(receipt_no) from Fees_Details");
			ResultSet rs=  pst.executeQuery();
			
			if(rs.next()) {
				receiptNo =rs.getInt(1);
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	  return receiptNo+1;
	}

	public String insertData() {
		
		String status="";
		
	
		String date = datetxt.getText();
		int receptNo = Integer.parseInt(rcno.getText());
		String studenName=receName.getText();
		String paymentMode = comboBox.getSelectedItem().toString();
		String acc_No = bankT.getText();
		String upiNo = upiT.getText();
		String coursName= courseNm.getText();
		
		float amt=Float.parseFloat(courseAmt.getText());
		float cgstA=Float.parseFloat(cgstAmt.getText());
		float sgstA=Float.parseFloat(sgstAmt.getText());
		float totalAmt = Float.parseFloat(totalT.getText());
		int paid = Integer.parseInt(paidAmt.getText());
		String totalWods = totalWordtxt.getText();
		float remaining = Float.parseFloat(reamtT.getText());
		
		try {
			Connection conn=DbConnection.getConnection();
			PreparedStatement ps1= conn.prepareStatement("update  Fees_Details set date=?,paymentMode=?,acc_No=?,upiNo=?,coursName=?,amt=?,cgstA=?,sgstA=?,totalAmt=?,paid=?,totalWods=?,remainingAmt=? where studenName = ?");
			ps1.setString(1, date);
			ps1.setString(2, paymentMode);
			ps1.setString(3, acc_No);
			ps1.setString(4, upiNo);
			ps1.setString(5, coursName);
			ps1.setFloat(6, amt);
			ps1.setFloat(7, cgstA);
			ps1.setFloat(8, sgstA);
			ps1.setFloat(9, totalAmt);
			ps1.setInt(10, paid);
			ps1.setString(11, totalWods);
			ps1.setDouble(12, remaining);
			
			ps1.setString(13, studenName);
			

			int rowCount = ps1.executeUpdate();
			
			if(rowCount == 1)
				status="Success";
			else
				status="Failed";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public List<String> getCourse() {
		
		List<String> l1 = new ArrayList<String>();
		
        try {
			

			Connection conn = DbConnection.getConnection();
			PreparedStatement ps1= conn.prepareStatement("Select name from CoursList");
			ResultSet rs = ps1.executeQuery();
			int i=0;
			while(rs.next()) {
//				arr[i]=rs.getString(1);
				l1.add(rs.getString(1));
				i++;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}


		
		return l1;
	//	return arr;
	}
	
	
	
	public int getCoursePrice(String name) {
		try {
		
			Connection conn = DbConnection.getConnection();
			PreparedStatement ps1= conn.prepareStatement("Select price from CoursList where name='"+name+"'");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
public static void main(String[] args) {
		
		UpdateRec ad=new UpdateRec();
	}
}