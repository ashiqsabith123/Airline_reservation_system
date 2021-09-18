import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class AdminPage implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JLabel heading,heading2,heading3;
	JButton addflight,updateflight,showbookings,showusers,logout,deleteflight,showflights;
	

	
	public AdminPage() {
		
		frame = new JFrame();
		frame.setSize(1155,800);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		
		heading = new JLabel();
		heading.setText("FLY HIGH");
		heading.setBounds(30, 30, 300, 65);
		heading.setFont(new Font("Candara",Font.ROMAN_BASELINE,60));
		heading.setForeground(Color.white);
		
		heading2 = new JLabel();
		heading2.setText("Admin Page");
		heading2.setFont(new Font("RockWell",Font.TRUETYPE_FONT,35));
		heading2.setBounds(930, 5, 200, 40);
		heading2.setForeground(new Color(0,0,0));
		
		heading3 = new JLabel();
		heading3.setText("WELCOME");
		heading3.setBounds(30, 130, 350, 45);
		heading3.setFont(new Font("Candara",Font.BOLD,40));
		heading3.setForeground(new Color(102,0,102));
		
		
		
		

		addflight = new JButton("Add Flight");
		addflight.setFocusable(false);
		addflight.setBounds(50, 400, 280, 35);
		addflight.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		addflight.setBackground(Color.lightGray);
		addflight.setForeground(Color.red);
		addflight.addActionListener(this);
		
		updateflight = new JButton("Update Flight");
		updateflight.setFocusable(false);
		updateflight.setBounds(400, 400, 280, 35);
		updateflight.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		updateflight.setBackground(Color.lightGray);
		updateflight.setForeground(Color.red);
		updateflight.addActionListener(this);
		
		showflights = new JButton("Show Flights");
		showflights.setFocusable(false);
		showflights.setBounds(400, 500, 280, 35);
		showflights.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		showflights.setBackground(Color.lightGray);
		showflights.setForeground(Color.red);
		showflights.addActionListener(this);
		
		logout = new JButton("Log out");
		logout.setFocusable(false);
		logout.setBounds(50, 700, 150, 35);
		logout.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		 
		showbookings = new JButton("Show Bookings");
		showbookings.setFocusable(false);
		showbookings.setBounds(750, 400, 280, 35);
		showbookings.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		showbookings.setBackground(Color.lightGray);
		showbookings.setForeground(Color.red);
		showbookings.addActionListener(this);
		
		showusers = new JButton("Show Users");
		showusers.setFocusable(false);
		showusers.setBounds(50, 500, 280, 35);
		showusers.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		showusers.setBackground(Color.lightGray);
		showusers.setForeground(Color.red);
		showusers.addActionListener(this);
		
		deleteflight = new JButton("Delete Flight");
		deleteflight.setFocusable(false);
		deleteflight.setBounds(750, 500, 280, 35);
		deleteflight.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		deleteflight.setBackground(Color.lightGray);
		deleteflight.setForeground(Color.red);
		deleteflight.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1155, 100);
		panel.setBackground(new Color(153,204,255));
		panel.setLayout(null);
		
		panel.add(heading);
		panel.add(heading2);
		
		
		
	   
		frame.add(heading3);
		frame.add(panel);
		frame.add(addflight);
		frame.add(updateflight);
		frame.add(showbookings);
		frame.add(showusers);
		frame.add(logout);
		frame.add(deleteflight);
		frame.add(showflights);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== addflight) {
			new Addflight();
		}
		
		if(e.getSource()==updateflight) {
			new Updateflight();
		}
		
		if(e.getSource()== logout) {
			new AdminLogin();
		}
		
		if(e.getSource()== showbookings) {
			new Showbooking();
		}
		
		if(e.getSource()== showusers) {
			new Showusers();
		}
		
		if(e.getSource()== deleteflight) {
			new Deleteflight();
		}
		
		if(e.getSource()== showflights) {
			new showflights();
		}
		
		
		
	}
}
