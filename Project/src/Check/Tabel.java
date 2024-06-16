package Check;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabel extends JFrame {
	
	public Tabel() {
		setSize(500,300);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		Object[][]data= {{101,"Jay",21},{102,"AJay",23},{103,"Om",21}};
		
		String[] col = {"Roll No.","Name","Age"};
		
//		
//		Vector d= new Vector();
//		Vector c =new Vector();
//		c.addElement("Name");
//		c.addElement("Age");
//		
//		
//		DefaultTableModel m =new DefaultTableModel(d,c);

		
	
		
		
		JTable  tabel =new JTable(data,col);
		tabel.setBounds(30, 40, 200, 300);
		
//		JScrollPane sp = new JScrollPane(tabel);
//		add(sp);
		add(tabel);
		
		
		
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new Tabel();

	}

}
