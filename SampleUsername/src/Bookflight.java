import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bookflight  implements ActionListener{
	
	
	JFrame  frame;
	JPanel panel;
	JLabel flyhigh,fromlabel,tolabel,tpyelabel,departlabel,arraivallabel,departdlabel,flightnolabel,flightnamelabel,pricelabel,passengerlabel;
	JTextField fromfield,tofield,typefield,departfield,arraivalfield,departdfield,flightnofield,flightnamefield,pricefield,passengerfield;
	JButton button,back;
	public Bookflight(String flight) {
		
		 String side = null,  from = null, to = null, ddate = null, adult = null, child = null;
		
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
	                ddate = rs.getString("depart");
	                adult = rs.getString("adult");
	                child = rs.getString("child");
	                

	             }
	            
	            
	            
	        }
	       catch(Exception e1)
	        {
	            System.out.println("Error" + e1);
	            //JOptionPane.showMessageDialog(null, "Invalid Flight Number");
	        }
		 
		 String fno = null , fname = null, atime = null, dtime = null, price = null;
		    
		 
		 try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");
	            String sql="select * from flightdetails where flightno='"+flight+"'";
	            Statement stmt=con.createStatement();  
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next())
	            {
	                fno = rs.getString("flightno");
	                fname = rs.getString("flightname");
	                atime = rs.getString("arraivaltime");
	                dtime = rs.getString("departtime");
	                price = rs.getString("price");
	                
	                

	             }
	            
	            
	            
	        }
	       catch(Exception e1)
	        {
	            System.out.println("Error" + e1);
	            //JOptionPane.showMessageDialog(null, "Invalid Flight Number");
	        }
		       
		 
		       
		
		
		frame = new JFrame();
		frame.setSize(1155,800);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0,51,102));
		
		flyhigh = new JLabel("BOOK FLIGHT");
		flyhigh.setBounds(30, 30, 300, 65);
		flyhigh.setFont(new Font("Candara",Font.ROMAN_BASELINE,50));
		flyhigh.setForeground(Color.red);
		
		fromlabel = new JLabel("From:");
		fromlabel.setBounds(30, 150, 100, 25);
		fromlabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		fromlabel.setForeground(Color.white);
		
		fromfield = new JTextField();
		fromfield.setBounds(110, 150, 260, 30);
		fromfield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		fromfield.setText(from);
		fromfield.setBackground(new Color(0,51,102));
		fromfield.setForeground(Color.white);
		fromfield.setEditable(false);
		fromfield.setFocusable(false);
		fromfield.setBorder(null);
		
		tolabel = new JLabel("To:");
		tolabel.setBounds(400, 150, 100, 25);
		tolabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		tolabel.setForeground(Color.white);
		
		tofield = new JTextField();
		tofield.setBounds(450, 150, 260, 30);
		tofield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		tofield.setText(to);
		tofield.setBackground(new Color(0,51,102));
		tofield.setForeground(Color.white);
		tofield.setEditable(false);
		tofield.setFocusable(false);
		tofield.setBorder(null);
		
		tpyelabel = new JLabel("Trip Type:");
		tpyelabel.setBounds(735, 150, 180, 25);
		tpyelabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		tpyelabel.setForeground(Color.white);
		
		typefield = new JTextField();
		typefield.setBounds(870, 150, 260, 30);
		typefield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		typefield.setText(side);
		typefield.setBackground(new Color(0,51,102));
		typefield.setForeground(Color.white);
		typefield.setEditable(false);
		typefield.setFocusable(false);
		typefield.setBorder(null);
		
		departlabel = new JLabel("Depart:");
		departlabel.setBounds(30, 250, 100, 25);
		departlabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		departlabel.setForeground(Color.white);
		

		departfield = new JTextField();
		departfield.setBounds(130, 250, 100, 30);
		departfield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		departfield.setText("10:00 AM");
		departfield.setBackground(new Color(0,51,102));
		departfield.setForeground(Color.white);
		departfield.setEditable(false);
		departfield.setFocusable(false);
		departfield.setBorder(null);
		
		arraivallabel = new JLabel("Arraival:");
		arraivallabel.setBounds(300, 250, 100, 25);
		arraivallabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		arraivallabel.setForeground(Color.white);
		
		arraivalfield = new JTextField();
		arraivalfield.setBounds(410, 250, 100, 30);
		arraivalfield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		arraivalfield.setText(atime);
		arraivalfield.setBackground(new Color(0,51,102));
		arraivalfield.setForeground(Color.white);
		arraivalfield.setEditable(false);
		arraivalfield.setFocusable(false);
		arraivalfield.setBorder(null);
		
		departdlabel = new JLabel("Depart Date:");
		departdlabel.setBounds(570, 250, 180, 25);
		departdlabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		departdlabel.setForeground(Color.white);
		
		departdfield = new JTextField();
		departdfield.setBounds(730, 250, 150, 30);
		departdfield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		departdfield.setText(ddate);
		departdfield.setBackground(new Color(0,51,102));
		departdfield.setForeground(Color.white);
		departdfield.setEditable(false);
		departdfield.setFocusable(false);
		departdfield.setBorder(null);
		
		flightnolabel = new JLabel("Flight No:");
		flightnolabel.setBounds(30, 350, 150, 25);
		flightnolabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		flightnolabel.setForeground(Color.white);
		
		flightnofield = new JTextField();
		flightnofield.setBounds(160, 350, 70, 30);
		flightnofield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		flightnofield.setText(fno);
		flightnofield.setBackground(new Color(0,51,102));
		flightnofield.setForeground(Color.white);
		flightnofield.setEditable(false);
		flightnofield.setFocusable(false);
		flightnofield.setBorder(null);
		
		flightnamelabel = new JLabel("Flight Name:");
		flightnamelabel.setBounds(300, 350, 150, 25);
		flightnamelabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		flightnamelabel.setForeground(Color.white);
		
		flightnamefield = new JTextField();
		flightnamefield.setBounds(470, 350, 130, 30);
		flightnamefield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		flightnamefield.setText(fname);
		flightnamefield.setBackground(new Color(0,51,102));
		flightnamefield.setForeground(Color.white);
		flightnamefield.setEditable(false);
		flightnamefield.setFocusable(false);
		flightnamefield.setBorder(null);
		
		pricelabel = new JLabel("Price:");
		pricelabel.setBounds(610, 350, 110, 25);
		pricelabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		pricelabel.setForeground(Color.white);
		
		pricefield = new JTextField();
		pricefield.setBounds(690, 350, 100, 30);
		pricefield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		pricefield.setText(price);
		pricefield.setBackground(new Color(0,51,102));
		pricefield.setForeground(Color.white);
		pricefield.setEditable(false);
		pricefield.setFocusable(false);
		pricefield.setBorder(null);
		
		button = new JButton("MAKE PAYMENT");
		button.setBounds(410,630, 300, 40);
		button.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		button.setBackground(Color.white);
		button.setForeground(new Color(0,0,128));
		button.setFocusable(false);
		button.addActionListener(this);
		
		passengerlabel = new JLabel("Passengers:");
		passengerlabel.setBounds(30, 450, 150, 25);
		passengerlabel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
		passengerlabel.setForeground(Color.white);
		
		passengerfield = new JTextField();
		passengerfield.setBounds(190, 450, 150, 30);
		passengerfield.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		passengerfield.setText(adult+"  Adult" + child +"  Child");
		passengerfield.setBackground(new Color(0,51,102));
		passengerfield.setForeground(Color.white);
		passengerfield.setEditable(false);
		passengerfield.setFocusable(false);
		passengerfield.setBorder(null);
		
		
		back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(100, 650, 150, 30);
        back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
        back.setBackground( Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1155, 100);
		panel.setBackground(new Color(153,204,255));
		panel.setLayout(null);
		
		panel.add(flyhigh);
		
		frame.add(panel);
		frame.add(fromlabel);
		frame.add(fromfield);
		frame.add(tolabel);
		frame.add(tofield);
		frame.add(tpyelabel);
		frame.add(typefield);
		frame.add(departlabel);
		frame.add(departfield);
		frame.add(arraivallabel);
		frame.add(arraivalfield);
		frame.add(departdlabel);
		frame.add(departdfield);
		frame.add(flightnolabel);
		frame.add(flightnofield);
		frame.add(flightnamelabel);
		frame.add(flightnamefield);
		frame.add(pricelabel);
		frame.add(pricefield);
		frame.add(button);
		frame.add(passengerlabel);
		frame.add(passengerfield);
		frame.add(back);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== back) {
			new FlightList();
		}
		
		if(e.getSource()== button) {
			
			new Payment();
		}
		
	}
}