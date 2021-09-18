import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Addflight implements ActionListener{
	JFrame frame1;
	JLabel heading,fname,fnumber,depart,arraiavaldae,departtime,returntime,departlabel,arraivale;
	JTextField name,number,ddepart,dtime,atime,rdate;
	JDateChooser date;
	JButton button,back;
	JComboBox departe,arraival;

	
	
	public Addflight() {
		frame1 = new JFrame();
		frame1.setSize(1155,800);
		frame1.setLayout(null);
		frame1.getContentPane().setBackground(Color.white);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		heading = new JLabel("ADD FLIGHT");
		heading.setBounds(30, 10, 250, 80);
		heading.setFont(new Font("Candara",Font.TRUETYPE_FONT,40));
		heading.setForeground(new Color(128,0,128));
		
		fname = new JLabel("Flight name:");
		fname.setBounds(30, 100, 150, 30);
		fname.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		fname.setForeground(new Color(0,0,0));
		
		fnumber = new JLabel("Flight number:");
		fnumber.setBounds(530, 100, 180, 30);
		fnumber.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		fnumber.setForeground(new Color(0,0,0));
		
		depart = new JLabel("Depart date:");
		depart.setBounds(30, 200, 180, 30);
		depart.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		depart.setForeground(new Color(0,0,0));
		
		date = new JDateChooser();
		date.setBounds(200, 200, 280,40);
		date.setFont(null);
		date.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		arraiavaldae = new JLabel("Price:");
		arraiavaldae.setBounds(530, 200, 180, 30);
		arraiavaldae.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		arraiavaldae.setForeground(new Color(0,0,0));
		
		rdate = new JTextField();
		rdate.setBounds(730, 200, 280,40);
		rdate.setFont(null);
		rdate.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		departtime = new JLabel("Depart time:");
		departtime.setBounds(30, 300, 180, 30);
		departtime.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		departtime.setForeground(new Color(0,0,0));
		
		dtime = new JTextField();
		dtime.setBounds(200, 300, 280,40);
		dtime.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		returntime = new JLabel("Arraival time:");
		returntime.setBounds(530, 300, 180, 30);
		returntime.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		returntime.setForeground(new Color(0,0,0));
		
		atime = new JTextField();
		atime.setBounds(730, 300, 280,40);
		atime.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		number = new JTextField();
		number.setBounds(730, 100, 280,40);
		number.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		departlabel = new JLabel("Depart:");
		departlabel.setBounds(30, 400, 180, 30);
		departlabel.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		departlabel.setForeground(new Color(0,0,0));
		
		
		
		arraivale = new JLabel("Arraival:");
		arraivale.setBounds(530, 400, 180, 30);
		arraivale.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		arraivale.setForeground(new Color(0,0,0));
		
	    
		
		name = new JTextField();
		name.setBounds(200, 100, 280,40);
		name.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18)); 
		
		
		button = new JButton("ADD FLIGHT");
		button.setBounds(800, 500, 200, 40);
		button.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,18)); 
		button.setFocusable(false);
		button.setBackground(new Color(0,0,0));
		button.setForeground(Color.white);
		button.addActionListener(this);
		
		back = new JButton("BACK");
		back.setBounds(30, 700, 150, 40);
		back.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,18)); 
		back.setFocusable(false);
		back.setBackground(new Color(153,204,255));
		back.addActionListener(this);
		
		String[] arto = {" ","Agartala (IXA)",
          		 "Agatti (AGX)",
          		 "Agra (AGR)",
          	     "Ahmedabad (AMD)",
          	     "Aizawl (AJL)",
                   "Allahabad (IXD)",
          		 "Amritsar (ATQ)",
          		 "Aurangabad (IXU)",
          		 "Bagdogra (IXB)",
          		 "Bareilly (BEK)",
          	     "Belagavi (IXG)",
          		 "Bengaluru (BLR)",
          		 "Bhatinda (BUP)",
          		 "Bhavnagar (BHU)",
          		 "Bhopal (BHO)",
          		 "Bhubaneswar (BBI)",
          		 "Bhuj (BHJ)",
          		 "Bikaner (BKB)",
          		 "Bilaspur (PAB)",
          		 "Chandigarh (IXC)",
          	     "Chennai (MAA)" ,
          		 "Coimbatore (CJB)",
          		 "Dehra Dun (DED)",
          		 "Delhi (DEL)",
          		 "Dharamshala (DHM)",
          		 "Dibrugarh (DIB)",
          		 "Dimapur (DMU)",
          		 "DIU (DIU)",
          		 "Durgapur (RDP)",
          		 "Gaya (GAY)",
          		 "Goa (GOI)",
          		 "Gorakhpur (GOP)",
          		 "Gulbarga (GBI)",
          		 "Guwahati (GAU)",
          		 "Gwalior (GWL)",
          		 "Hubli (HBX)",
          		 "Hyderabad (HYD)",
          		 "Imphal (IMF)",
          		 "Indore (IDR)",
          		 "Jabalpur (JLR)",
          		 "Jagdalpur (JGB)",
          		 "Jaipur (JAI)",
          	     "Jammu (IXJ)",
          		 "Jamnagar (JGA)",
          		 "Jharsuguda (JRG)",
          		 "Jodhpur (JDH)",
          		 "Jorhat (JRH)",
          		 "Kandla (IXY)",
          		 "Kannur (CNN)",
          		 "Kanpur (KNU)",
          		 "Khajuraho (HJR)",
          		 "Kochi (COK)",
          		 "Kolhapur (KLH)",
          		 "Kolkata (CCU)",
          		 "Kozhikode (CCJ)",
          		 "Kullu (KUU)",
          		 "Leh (IXL)",
          		 "Lilabari (IXI)",
          		 "Lucknow (LKO)",
          		 "Ludhiana (LUH)",
          		 "Madurai (IXM)",
          		 "Mangalore (IXE)",
          		 "Mumbai (BOM)n",
          		 "Mysore (MYQ)\r\n",
          		 "Nagpur (NAG)\r\n",
          		 "Nanded (NDC)\r\n",
          		 "Nasik (ISK)\r\n",
          		 "Pantnagar (PGH)\r\n",
          		 "Pasighat (IXT)\r\n",
          		 "Pathankot (IXP)\r\n",
          		 "Patna (PAT)\r\n",
          		 "Port Blair (IXZ)\r\n",
          		 "Puducherry (PNY)\r\n",
          	     "Pune (PNQ)\r\n",
          		 "Raipur (RPR)\r\n",
          		 "Rajkot (RAJ)\r\n",
          		 "Ranchi (IXR)\r\n",
          	     "Shillong (SHL)\r\n",
          		 "Shimla (SLV)\r\n",
          		 "Shirdi (SAG)\r\n",
          		 "Silchar (IXS)\r\n",
          		 "Srinagar (SXR)\r\n",
          		 "Surat (STV)\r\n",
          		 "Tezpur (TEZ)\r\n",
          		 "Thiruvananthapuram (TRV)\r\n",
          		 "Tiruchirapalli (TRZ)\r\n",
          		 "Tirupati (TIR)\r\n",
          		 "Udaipur (UDR)\r\n",
          		 "Vadodara (BDQ)\r\n",
          		 "Varanasi (VNS)\r\n",
          		 "Vijayawada (VGA)\r\n",
          		 "Visakhapatnam (VTZ)"};
		
		departe = new JComboBox(arto);
		departe.setBounds(200, 400, 280,40);
		departe.setBackground(Color.white);
		departe.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
		
		arraival = new JComboBox(arto);
		arraival.setBounds(730, 400, 280,40);
		arraival.setBackground(Color.white);
		arraival.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
		
		
		
		
		
		
		frame1.add(heading);
		frame1.add(name);
		frame1.add(fname);
		frame1.add(fnumber);
		frame1.add(number);
		frame1.add(depart);
		frame1.add(date);
		frame1.add(arraiavaldae);
		frame1.add(rdate);
		frame1.add(departtime);
		frame1.add(dtime);
		frame1.add(returntime);
		frame1.add(atime);
		
		frame1.add(button);
		frame1.add(back);
		frame1.add(departe);
		frame1.add(departlabel);
		frame1.add(arraivale);
		frame1.add(arraival);
		frame1.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		

    	
		
		if(e.getSource()== back) {
			new AdminPage();
		}
		
		if(e.getSource() == button) {
			
			String Fno = number.getText();
	    	
	    	String Fname = name.getText();
	    	
	    	String detime = dtime.getText();
	    	
	    	String attime = atime.getText();
	    	
	    	String fare = rdate.getText();
	    	
	    	
	    	
	    	String depart = (String) departe.getSelectedItem();
	    	
	    	String arra = (String) arraival.getSelectedItem();
	    	
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strdDate= formatter.format(date.getDate());  
		
		    
			
			 try {
		        	Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
		            String sql="INSERT INTO flightdetails (flightno,flightname,departtime,arraivaltime,price,depart,arraival,departdate) VALUES ('"+Fno+"','"+Fname+"','"+detime+"','"+attime+"','"+fare+"','"+depart+"','"+arra+"','"+strdDate+"')";             
		            Statement stmt=con.createStatement(); 
		            stmt.executeUpdate(sql);
		            
		            JOptionPane.showMessageDialog(null, "Flight Added Succesfully");
		            new AdminPage();
		            
		          
		        }
		        	
		            catch(Exception e1)
			        {
			            System.out.println("Error" + e1);
			        }
	            
	            
	        }
	        
		}
		
	}

