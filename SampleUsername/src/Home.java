

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;





public class Home implements ActionListener{

    JFrame frame;
    JLabel label,label1,heading,dome,fr,to,depart,returne,passengers,adcdp,valid;
    JPanel panel;
    JButton button1,search;
    JComboBox from,tobox,passengeradsbox,passengercdsbox;
    JDateChooser ddate,rdate;
    JRadioButton returntrip,roundtrip;
    
    
   
        
    public Home() {
    	
    	
    	
    	
        frame = new JFrame("Home");
		frame.setSize(1155,800);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		
                
                label = new JLabel();
                label.setText("FLY HIGH");
                label.setBounds(30, 30, 300, 65);
                label.setFont(new Font("Candara",Font.ROMAN_BASELINE,60));
                label.setForeground(Color.red);
                
                label1 = new JLabel();
                label1.setText("Online Flight Bookings");
                label1.setFont(new Font("RockWell",Font.TRUETYPE_FONT,35));
                label1.setBounds(290, 40, 380, 40);
                label1.setForeground(new Color(0,0,128));
                
                dome = new JLabel();
                dome.setText("(Domestic)");
                dome.setBounds(1020, 65, 100, 25);
                dome.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
                dome.setForeground(Color.red);
                
                fr = new JLabel();
                fr.setText("From");
                fr.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                fr.setBounds(30, 190, 70, 28);
                fr.setForeground(new Color(102,102,153));
                
                
                String[] arfrom = {" ","Agartala (IXA)",
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
                from = new JComboBox(arfrom);
                from.setBounds(30, 230, 300, 40);
                from.setBackground(Color.white);
                from.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                from.setFocusable(false);
                from.addActionListener(this);
               
                
                to = new JLabel();
                to.setText("To");
                to.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                to.setBounds(410, 190, 50, 30);
                to.setForeground(new Color(102,102,153));
                
                
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
                
                
                tobox = new JComboBox(arto);
                tobox.setBounds(410, 230, 300, 40);
                tobox.setBackground(Color.white);
                tobox.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                tobox.setFocusable(false);
                tobox.addActionListener(this);
               
                
                depart = new JLabel();
                depart.setText("Depart  Date");
                depart.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                depart.setBounds(30, 320, 158, 30);
                depart.setForeground(new Color(102,102,153));
                

                ddate = new JDateChooser();
                ddate.setBounds(30, 360, 300, 40);
                ddate.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                
                
                returne = new JLabel();
                returne.setText("Return  Date");
                returne.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                returne.setBounds(410, 320, 158, 30);
                returne.setForeground(new Color(102,102,153));
                
                
                rdate = new JDateChooser();
                rdate.setBounds(410, 360, 300, 40);
                rdate.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                rdate.setEnabled(false);
                
                passengers = new JLabel("Passengers");
                passengers.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                passengers.setBounds(30, 450, 158, 30);
                passengers.setForeground(new Color(102,102,153));             
                
                Integer[] stradarray = {0,1,2,3,4,5,6,7,8,9};
                
                passengeradsbox = new JComboBox(stradarray);
                passengeradsbox.setBounds(30, 540, 150, 40);
                passengeradsbox.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                passengeradsbox.setBackground(Color.white);
                passengeradsbox.setFocusable(false);
                
                Integer[] strcdarray = {0,1,2,3,4,5,6,7,8,9};
                
                passengercdsbox = new JComboBox(strcdarray);
                passengercdsbox.setBounds(230, 540, 150, 40);
                passengercdsbox.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
                passengercdsbox.setBackground(Color.white);
                passengercdsbox.setFocusable(false);
                
                adcdp = new JLabel("Child                      Adult");
                adcdp.setBounds(30, 500, 300, 30);
                adcdp.setFont(new Font("RockWell",Font.TRUETYPE_FONT,25));
                adcdp.setForeground(new Color(102,102,153));
                
                
                
                
                
               
               
                heading = new JLabel();
                heading.setText("SEARCH FLIGHTS");
                heading.setBounds(30, 130, 350, 45);
                heading.setFont(new Font("Candara",Font.BOLD,40));
                heading.setForeground(new Color(204,204,255));
                
               
                
                
                panel = new JPanel();
                panel.setBounds(0, 0, 1155, 100);
                panel.setBackground(Color.white);
                panel.setLayout(null);
                
                
                
               
                
                button1 = new JButton("Admin Sign in");
                button1.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
                button1.setBounds(955, 5, 170, 35);
                button1.setBackground(Color.DARK_GRAY);
                button1.setForeground(Color.white);
                button1.setFocusable(false);
                button1.addActionListener(this);
                
                search = new JButton("SEARCH FLIGHTS");
                search.setBounds(410,630, 300, 40);
                search.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
                search.setBackground(Color.white);
                search.setForeground(new Color(0,0,128));
                search.setFocusable(false);
                search.addActionListener(this);
              
                
                
                
                
                returntrip = new JRadioButton("Return");
                returntrip.setBounds(430, 130, 100, 30);
                returntrip.setBackground(Color.black);
                returntrip.setForeground(new Color(102,102,153));  
                returntrip.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
                returntrip.setFocusable(false);
                returntrip.addActionListener(this);
                
                roundtrip = new JRadioButton("One Way");
                roundtrip.setBounds(550, 130, 150, 30);
                roundtrip.setBackground(Color.black);
                roundtrip.setForeground(new Color(102,102,153));  
                roundtrip.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
                roundtrip.setFocusable(false);
                roundtrip.addActionListener(this);
                
                valid = new JLabel();
                valid.setBounds(600, 200, 200, 30);
                valid.setForeground(Color.red);
                //valid.setText("hii");
                
                ButtonGroup group = new ButtonGroup();
                group.add(returntrip);
                group.add(roundtrip);
                
                
                
                
                panel.add(button1);
                panel.add(dome);
               // panel.add(search);
                
                
                
                
               
               frame.add(label1);
               frame.add(label);
               frame.add(panel);
               frame.add(heading);
               frame.add(fr);
               frame.add(from);
               frame.add(to);
               frame.add(tobox);
               frame.add(depart);
               frame.add(returne);
               frame.add(ddate);
               frame.add(rdate);
               frame.add(passengers);
               frame.add(passengeradsbox);
               frame.add(passengercdsbox);
               frame.add(search);
               frame.add(adcdp);
               frame.add(returntrip);
               frame.add(roundtrip);
               frame.add(valid);
               
               
               
                
                
                
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
		
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String From = (String) from.getSelectedItem();
		String To = (String) tobox.getSelectedItem();
		String Side = null;
		
		
		
		
		
		
		if(e.getSource()== button1) {
			new AdminLogin();
		}
		
		
		
		if( returntrip.isSelected()){
			Side = "Return";
			
			
			rdate.setEnabled(true);
		}
		
		
		
		else if(roundtrip.isSelected()) {
			rdate.setEnabled(false);
			Side = "One Way";
		}
		
		if(e.getSource()== search) {
			
			
			
			
			
			
			    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strdDate= formatter.format(ddate.getDate());  
			
			    SimpleDateFormat formattter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strrDate= formattter.format(rdate.getDate());  
			
			
			Integer Adult = (Integer) passengeradsbox.getSelectedItem();
			
			Integer Child = (Integer) passengercdsbox.getSelectedItem();
			 
			Boolean flag= null;
		    
		     try {
		        	Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
		            String sql="insert into booking  values ('"+From+"','"+To+"','"+Side+"','"+strdDate+"','"+strrDate+"','"+Adult+"','"+Child+"')";             
		            Statement stmt=con.createStatement(); 
		            stmt.executeUpdate(sql);
		            flag= true;
		            
		            if(flag == true) {
		            	new UserName();
		            	
		            }
		            else
		            {
		            	
		            }
		          
		        }
		        	
		            catch(Exception e1)
			        {
			            //System.out.println("Error" + e1);
			           
			            
			        }
			
		
			
			
			 
		}
	}
    
    
    
}