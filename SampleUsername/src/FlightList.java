import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.ComponentOrientation;

public class FlightList extends Home implements ActionListener,MouseListener {

	JFrame frame;
	JPanel panel,panel1,panel2;
	JLabel label,label2,label3,label4,label5,label6,label7,label8;
	JTextField fromfield,tripfield,tofield,departfield,returnfield,passengerfield,bookflight;
	JTable table;
	JScrollPane pane;
	JButton button,back;
	
	DefaultTableModel model = new DefaultTableModel(); 
	
	
	public FlightList() {
		
		
		
		 
		 
		 
		  

		 
		 String from = null,to = null,side = null,depart = null,returne = null,adult = null,child = null;
			
		 try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
	            String sql="select * from booking";
	            Statement stmt=con.createStatement();  
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next())
	            {
	                from = rs.getString("from");
	                to = rs.getString("to");
	                side = rs.getString("side");
	                depart = rs.getString("depart");
	                returne = rs.getString("return");
	                adult = rs.getString("adult");
	                child = rs.getString("child");

	         }
	        }
	        catch(Exception e1)
	        {
	            System.out.println("Error" + e1);
	        }
		 
		
		
		frame = new JFrame();
		frame.setSize(1155,800);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setBackground(Color.WHITE);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
        label.setText("FLY HIGH");
        label.setBounds(20, 20, 300, 65);
        label.setFont(new Font("Candara",Font.ROMAN_BASELINE,60));
        label.setForeground(Color.red);
		
        label2 = new JLabel();
       
        label2.setText("TRIP TYPE");
        label2.setBounds(25, 30, 150, 25);
        label2.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label2.setForeground(Color.white);
        
        label3 = new JLabel();
        label3.setText("FROM");
        label3.setBounds(170, 30, 100, 25);
        label3.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label3.setForeground(Color.white);
        
        label4 = new JLabel();
        label4.setText("TO");
        label4.setBounds(330, 30, 100, 25);
        label4.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label4.setForeground(Color.white);
        
        label5 = new JLabel();
        label5.setText("DEPART");
        label5.setBounds(490, 30, 100, 25);
        label5.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label5.setForeground(Color.white);
        
        label6 = new JLabel();
        label6.setText("RETURN");
        label6.setBounds(650, 30, 100, 25);
        label6.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label6.setForeground(Color.white);
		
        label7 = new JLabel();
        label7.setText("PASSENGERS");
        label7.setBounds(810, 30, 150, 25);
        label7.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label7.setForeground(Color.white);
       
        label8 = new JLabel();
        
        label8.setBounds(25, 50, 150, 25);
        //label8.setText(a);
        label8.setFont(new Font("Sweet Sans",Font.TRUETYPE_FONT,20));
        label8.setForeground(Color.white);
        
        
        
        fromfield = new JTextField();
        fromfield.setBounds(170, 60, 145, 30);
        fromfield.setText(from);
        fromfield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        fromfield.setBackground(new Color(204,204,255));
        fromfield.setEditable(false);
        
        tofield = new JTextField();
        tofield.setBounds(330, 60, 145, 30);
        tofield.setText(to);
        tofield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        tofield.setBackground(new Color(204,204,255));
        tofield.setEditable(false);
        
        tripfield = new JTextField();
        tripfield.setBounds(25, 60, 110, 30);
        tripfield.setText(side);
        tripfield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        tripfield.setBackground(new Color(204,204,255));
        tripfield.setEditable(false);
        
        departfield = new JTextField();
        departfield.setBounds(490, 60, 130, 30);
        departfield.setText(depart);
        departfield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        departfield.setBackground(new Color(204,204,255));
        departfield.setEditable(false);
        
      
        returnfield = new JTextField();
        returnfield.setBounds(650, 60, 130, 30);
        returnfield.setText(returne);
        returnfield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        returnfield.setBackground(new Color(204,204,255));
        returnfield.setEditable(false);
        
        passengerfield = new JTextField();
        passengerfield.setBounds(810, 60, 160, 30);
        passengerfield.setText(adult + " Adult  " + child + " Child");
        passengerfield.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        passengerfield.setBackground(new Color(204,204,255));
        passengerfield.setEditable(false);
        
        bookflight = new JTextField();
        bookflight.setBounds(680, 700, 250, 40);
        
        bookflight.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
        //bookflight.setBackground(new Color(204,204,255));
        
        
        
        button = new JButton("BOOK FLIGHT");
        button.setBounds(960, 700, 150, 40);
        button.setFocusable(false);
        button.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,16));
        button.setBackground(new Color(204,204,255));
        button.addActionListener(this);
        
        back = new JButton("SIGN OUT");
        back.setFocusable(false);
        back.setBounds(150, 700, 200, 35);
        back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        back.addActionListener(this);
        
       
        
        table = new JTable();
        Object [] coloumns = {"FLIGHT NUMBER","FLIGHT NAME","DEPARTURE","ARRAIVAL","PRICE"};
            
       
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        
        table.setForeground(Color.black);
        table.setBackground(Color.white);
        table.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        
       
        
        pane = new JScrollPane(table);
        pane.setBounds(10,230,1100,450);
        frame.add(pane);
        Object[] row =new Object[50];
        
        
        try{
            
	         Class.forName("com.mysql.jdbc.Driver");
	            
	           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root",""); 
	                 
	           String sql="select * from flightdetails WHERE (depart='"+from+"' AND arraival='"+to+"')";
	           Statement stmt=con.createStatement();  
	            ResultSet rs = stmt.executeQuery(sql);      
	                 
	                 DefaultTableModel dl=(DefaultTableModel)table.getModel();
	                 dl.setRowCount(0);
	                 while(rs.next())
	                 {
	                     Vector v2=new Vector();
	                     
	                         v2.add(rs.getString("flightno"));
	                         v2.add(rs.getString("flightname"));
	                         v2.add(rs.getString("departtime"));
	                         v2.add(rs.getString("arraivaltime"));
	                         v2.add(rs.getString("price"));

	                     
	                     dl.addRow(v2);
	                 }                          
	        }
	        catch( Exception ex){
	            System.out.println(ex);
	        }  
        
        
                
		panel = new JPanel();
		panel.setBounds(0, 70, 1155, 150);
		panel.setBackground(new Color(204,204,255));
		panel.setLayout(null);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(fromfield);
		panel.add(tripfield);
		panel.add(tofield);
		panel.add(departfield);
		panel.add(returnfield);
		panel.add(passengerfield);
		
		
		
		panel1 = new JPanel();
		panel1.setBounds(0, 270, 1000, 650);
		panel1.setBackground(Color.white);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 1155, 70);
		panel2.setBackground(new Color(204,204,255));
		panel2.add(label);
		panel2.setLayout(null);
		
		frame.add(panel);
		frame.add(panel2);
		frame.add(bookflight);
		frame.add(button);
		frame.add(back);
		
		
		
		
		frame.setVisible(true);
		
		
		
	    }
	
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== back) {
			new UserName();
		}
		
		if(e.getSource()== button) {
			String flight = bookflight.getText();
		       
	        String name = null,no = null,timed = null,timea = null,price = null;
	        Boolean flag = false;
	        
	       
			
			 try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");
		            System.out.println(flight);
		            String sql="select * from flightdetails where flightno='"+flight+"'";
		            Statement stmt=con.createStatement();  
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            while(rs.next())
		            {
		                no = rs.getString("flightno");
		                

		                if(no.equals(flight) ){
		                    flag = true;
		                }
		              
		            }
		            
		            if(flag == true)
		            {
		                    new Bookflight(flight);
		                   
		                   
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(null, "Invalid Flight Number");
		               
		                
		            }
		            
		        }
		        catch(Exception e1)
		        {
		            System.out.println("Error" + e1);
		            //JOptionPane.showMessageDialog(null, "Invalid Flight Number");
		        }
		        
			 
			
			
			
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
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
