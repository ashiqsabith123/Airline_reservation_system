import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Showbooking implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JTable table;
	JScrollPane pane;
	JButton back;
	
	DefaultTableModel model = new DefaultTableModel(); 

	
	 public Showbooking() {
		 
		 frame = new JFrame();
			frame.setSize(1155,800);
			frame.setLayout(null);
			
			frame.getContentPane().setBackground(Color.white);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
		 table = new JTable();
         Object [] coloumns = {"From","To","Side","Depart","Return","Adult","Child"};
             
        
         model.setColumnIdentifiers(coloumns);
         table.setModel(model);
         
         table.setForeground(Color.black);
         table.setBackground(Color.white);
         table.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
         table.setRowHeight(30);
         table.setAutoCreateRowSorter(true);
         
        
         
         pane = new JScrollPane(table);
         pane.setBounds(10,100,1100,450);
         frame.add(pane);
         Object[] row =new Object[50];
		 
		 
		 try{
	            
	         Class.forName("com.mysql.jdbc.Driver");
	            
	           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root",""); 
	                 
	           String sql="select * from booking ";
	           Statement stmt=con.createStatement();  
	            ResultSet rs = stmt.executeQuery(sql);      
	                 
	                 DefaultTableModel dl=(DefaultTableModel)table.getModel();
	                 dl.setRowCount(0);
	                 while(rs.next())
	                 {
	                     Vector v2=new Vector();
	                     
	                         v2.add(rs.getString("from"));
	                         v2.add(rs.getString("to"));
	                         v2.add(rs.getString("side"));
	                         v2.add(rs.getString("depart"));
	                         v2.add(rs.getString("return"));
	                         v2.add(rs.getString("adult"));
	                         v2.add(rs.getString("child"));

	                     
	                     dl.addRow(v2);
	                 }                          
	        }
	        catch( Exception ex){
	            System.out.println(ex);
	        }  
		 
		 
		 
			
			label = new JLabel();
			label.setText("Bookings");
			label.setBounds(30, 10, 180, 80);
			label.setFont(new Font("Candara",Font.TRUETYPE_FONT,40));
			label.setForeground(new Color(128,0,128));
			
			 
            panel = new JPanel();
            panel.setBounds(0, 0, 1155, 100);
            panel.setBackground(Color.white);
            panel.setLayout(null);
            panel.add(label);
            
            back = new JButton("Back");
            back.setFocusable(false);
            back.setBounds(150, 700, 200, 35);
            back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
            back.setBackground(Color.DARK_GRAY);
            back.setForeground(Color.white);
            back.addActionListener(this);
            
            
           
			
			
			frame.add(panel);
			frame.add(back);
			frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== back) {
			new AdminPage();
		}
	}
}
