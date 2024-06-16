package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataBase.DbConnection;

public class Print extends JFrame implements ActionListener,MouseListener {
	
	JButton home,search,cEdit,cList,all,back,logout,print,cadd,update,add;
	JLabel upiT,bankT,rcno,receName,courseNm,courseAmt,cgstAmt,sgstAmt,totalT,totalWordtxt,paidAmt,reamtT,modPay;
	JPanel detail;
	String name;
	
	public Print(String name) {
		this.name=name;
		
		
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
		
		
		
		print=new JButton("Print");
		print.setBounds(200,500,80,30);
//		print.setBackground(Color.YELLOW);
		print.addActionListener(this);
		print.addMouseListener(this);
		select.add(print);
	
		
	// Second  Pannel	
		detail=new JPanel();
		detail.setLayout(null);
		detail.setBackground(Color.white);
		detail.setBounds(350, 10, 500, 550);
		
		
// Image Logo
	ImageIcon cloudlogo=new ImageIcon("D://JAVA//img//cloud.png");
		
		Image cloud = cloudlogo.getImage();
		Image cloudtemp=cloud.getScaledInstance(80, 80, Image.SCALE_SMOOTH);  // Size
		cloudlogo=new ImageIcon(cloudtemp);
		JLabel logo = new JLabel ("",cloudlogo,JLabel.RIGHT);
		
		logo.setBounds(40,10,100,100);
		detail.add(logo);
		
	//  Heading Details
		JLabel nm=new JLabel("CODING CLOUD");
		nm.setBounds(150,0,900,100);
		nm.setForeground(Color.black);
		nm.setFont(new Font("Times New Roman",Font.BOLD,30));
		detail.add(nm);
		
		JLabel nm2=new JLabel("CODING CLOUD PVT.LMT.");
		nm2.setBounds(180,25,900,100);
		nm2.setForeground(Color.black);
		nm2.setFont(new Font("Times New Roman",Font.BOLD,15));
		detail.add(nm2);
		
		JLabel addr=new JLabel("Deccan Cornar, Near JM Road, Pune 04");
		addr.setBounds(150,45,900,100);
		addr.setForeground(Color.black);
		addr.setFont(new Font("Times New Roman",Font.BOLD,15));
		detail.add(addr);
		

		JLabel line=new JLabel("-----------------------------------------------");
		line.setBounds(10,55,1000,120);
		line.setForeground(Color.black);
		line.setFont(new Font("Times New Roman",Font.BOLD,30));
		detail.add(line);

    
// Data 
		JLabel recept=new JLabel("Reciept No :");
		recept.setLayout(null);
		recept.setBounds(10,130,80,30);
		recept.setForeground(Color.black);
		recept.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(recept);
		

		
		rcno = new JLabel("1010");
		rcno.setBounds(90,130,80,30);
		detail.add(rcno);
		
		
		JLabel mode = new JLabel("Mode of Payment :");
		mode.setLayout(null);
		mode.setBounds(10,150,100,30);
		mode.setForeground(Color.black);
		mode.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(mode);
			
	
		modPay = new JLabel("mode");
		modPay.setBounds(120,150,80,30);
		detail.add(modPay);
	
		
		JLabel bank = new JLabel("Bank A/c no :");
		bank.setLayout(null);
		bank.setBounds(10,170,100,30);
		bank.setForeground(Color.black);
		bank.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(bank);
		
		bankT = new JLabel("A/C detail");
		bankT.setBounds(90,170,100,30);
		detail.add(bankT);
		
		JLabel upi = new JLabel("UPI no :");
		upi.setLayout(null);
		upi.setBounds(10,190,100,30);
		upi.setForeground(Color.black);
		upi.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(upi);
		
		upiT = new JLabel("UPI detail");
		upiT.setBounds(90,190,100,30);
		detail.add(upiT);
		
		JLabel studNm = new JLabel("Student Name :");
		studNm.setLayout(null);
		studNm.setBounds(10,210,100,30);
		studNm.setForeground(Color.black);
		studNm.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(studNm);
		
		
		receName = new JLabel("Receiver Name ");
		receName.setBounds(100,210,100,30);
		detail.add(receName);
		
		
		
		JLabel date=new JLabel("Date :");
		date.setLayout(null);
		date.setBounds(350,130,80,30);
		date.setForeground(Color.black);
		date.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(date);
		

		JFormattedTextField  datetxt = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		  datetxt.setValue(new Date());
		  datetxt.setBounds(400,135,50,20);
		    detail.add(datetxt);
		
		
		    JLabel gstIn=new JLabel("GSTIN :");
		    gstIn.setLayout(null);
		    gstIn.setBounds(330,150,80,30);
		    gstIn.setForeground(Color.black);
		    gstIn.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(gstIn);
		
			
			
			  JLabel gstInNo=new JLabel("22AAAAA00A1Z5");
			  gstInNo.setLayout(null);
			  gstInNo.setBounds(380,150,100,30);
			  gstInNo.setForeground(Color.black);
			  gstInNo.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(gstInNo);
				
		JLabel line2=new JLabel("------------------------------------------------------------------------------");
		line2.setBounds(10,200,1000,120);
		line2.setForeground(Color.black);
		line2.setFont(new Font("Times New Roman",Font.BOLD,18));
		detail.add(line2);
		
	
				
		  JLabel cName=new JLabel("Course Name");
		  cName.setLayout(null);
		  cName.setBounds(20,260,100,30);
		  cName.setForeground(Color.black);
		  cName.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(cName);
			
		
			 JLabel amount=new JLabel("Amount");
			 amount.setLayout(null);
			 amount.setBounds(380,260,100,30);
			 amount.setForeground(Color.black);
			 amount.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(amount);
		
		JLabel line3=new JLabel("------------------------------------------------------------------------------");
		line3.setBounds(10,230,1000,120);
		line3.setForeground(Color.black);
		line3.setFont(new Font("Times New Roman",Font.BOLD,18));
		detail.add(line3);	
		
		
		  courseNm=new JLabel("Selected Course");
		  courseNm.setLayout(null);
		  courseNm.setBounds(30,300,100,30);
		  courseNm.setForeground(Color.black);
		  courseNm.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(courseNm);
		
		
			courseAmt=new JLabel("Rs");
			courseAmt.setLayout(null);
			courseAmt.setBounds(400,300,100,30);
			courseAmt.setForeground(Color.black);
			courseAmt.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(courseAmt);		
			
	
			JLabel  cgst=new JLabel("CGST 9%");
			cgst.setLayout(null);
			cgst.setBounds(30,320,100,30);
			cgst.setForeground(Color.black);
			cgst.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(cgst);
		
		cgstAmt=new JLabel("Rs");
		cgstAmt.setLayout(null);
		cgstAmt.setBounds(400,320,100,30);
		cgstAmt.setForeground(Color.black);
		cgstAmt.setFont(new Font("Times New Roman",Font.BOLD,12));
		detail.add(cgstAmt);
		
		
		
		
		JLabel  sgst=new JLabel("SGST 9%");
		sgst.setLayout(null);
		sgst.setBounds(30,340,100,30);
		sgst.setForeground(Color.black);
		sgst.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(sgst);
		
		
		sgstAmt=new JLabel("Rs");
		sgstAmt.setLayout(null);
		sgstAmt.setBounds(400,340,100,30);
		sgstAmt.setForeground(Color.black);
		sgstAmt.setFont(new Font("Times New Roman",Font.BOLD,12));
			detail.add(sgstAmt);
		
			
			
			JLabel  total=new JLabel("Total");
			total.setLayout(null);
			total.setBounds(30,360,100,30);
			total.setForeground(Color.black);
			total.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(total);	
	
				
			
			totalT=new JLabel("Rs");
			totalT.setLayout(null);
			totalT.setBounds(400,360,100,30);
			totalT.setForeground(Color.black);
			totalT.setFont(new Font("Times New Roman",Font.BOLD,12));
			   detail.add(totalT);
			
					
			JLabel  paid=new JLabel("Paid");
			paid.setLayout(null);
			paid.setBounds(30,380,100,30);
			paid.setForeground(Color.black);
			paid.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(paid);	
				
				
				
				paidAmt=new JLabel("Rs");
				paidAmt.setLayout(null);
				paidAmt.setBounds(400,380,100,30);
				paidAmt.setForeground(Color.black);
				paidAmt.setFont(new Font("Times New Roman",Font.BOLD,12));
		          detail.add(paidAmt);
			
		      	JLabel  line4=new JLabel("-----------------");
		      	line4.setLayout(null);
		      	line4.setBounds(370,400,100,30);
		      	line4.setForeground(Color.black);
		      	line4.setFont(new Font("Times New Roman",Font.BOLD,12));
					detail.add(line4);		
		
				
			JLabel  remaining=new JLabel("Remaining Amount :-");
			remaining.setLayout(null);
			remaining.setBounds(30,420,150,30);
			remaining.setForeground(Color.black);
			remaining.setFont(new Font("Times New Roman",Font.BOLD,12));
				detail.add(remaining);
		
				
				
				reamtT=new JLabel("Rs");
				reamtT.setLayout(null);
				reamtT.setBounds(400,420,100,30);
				reamtT.setForeground(Color.black);
				reamtT.setFont(new Font("Times New Roman",Font.BOLD,12));
		          detail.add(reamtT);	
	
		      	JLabel  totalW=new JLabel("Total in Words :-");
		      	totalW.setLayout(null);
		      	totalW.setBounds(30,450,150,30);
		      	totalW.setForeground(Color.black);
		      	totalW.setFont(new Font("Times New Roman",Font.BOLD,12));
					detail.add(totalW);	
			
				
					
				totalWordtxt=new JLabel("Total Words");
				totalWordtxt.setLayout(null);
				totalWordtxt.setBounds(130,450,200,30);
				totalWordtxt.setForeground(Color.black);
				totalWordtxt.setFont(new Font("Times New Roman",Font.BOLD,12));
			          detail.add(totalWordtxt);
			
			
			JLabel  lineSign=new JLabel("-----------------------");
			lineSign.setLayout(null);
			lineSign.setBounds(365,480,150,30);
			lineSign.setForeground(Color.black);
			lineSign.setFont(new Font("Times New Roman",Font.BOLD,14));
			  detail.add(lineSign);
			
				JLabel  recevierSign=new JLabel("Receiver Signature");
				recevierSign.setLayout(null);
				recevierSign.setBounds(370,500,150,30);
				recevierSign.setForeground(Color.black);
				recevierSign.setFont(new Font("Times New Roman",Font.BOLD,12));
					detail.add(recevierSign);
				
					
					getRecords();
				
		
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
	
	


	
	
	public void getRecords() {
		try {
			
			Connection conn=DbConnection.getConnection();//order by receipt_no desc limit 1
			PreparedStatement ps1= conn.prepareStatement("Select * from Fees_Details where studenName ='"+name+"'");
			ResultSet rs=ps1.executeQuery();
			rs.next();
			
			Integer no = rs.getInt(2);
			rcno.setText(no.toString());
			
			receName.setText(rs.getString(3));
			modPay.setText(rs.getString(4));
			
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
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		Print p = new Print(null);

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
			
		}else if(e.getSource() == cadd) {
			cadd.setBackground(Color.orange);
			
		}else if(e.getSource() == update) {
			update.setBackground(Color.orange);
			
		}else if(e.getSource() == add) {
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
			
		}else if(e.getSource() == cadd) {
			cadd.setBackground(Color.yellow);
			
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
		  
		  
		if(e.getSource() == print) {
			
			PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.98,0.98);
                
               detail.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }

		}
		
	}

}
