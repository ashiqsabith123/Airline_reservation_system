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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Updateflight implements ActionListener,MouseListener {
	
	DefaultTableModel model = new DefaultTableModel(); 

	JFrame frame1;
	
	JTextField field,flightname,flightd,flighta,flightp,flightdp,flightap,flightdd;
	JLabel update,flightnumber;
	JButton button,updatee,back;
	JTable table;
	JScrollPane pane;
	String no;
	public Updateflight() {
		
		frame1 = new JFrame();
		frame1.setSize(1155,800);
		frame1.setLayout(null);
		frame1.getContentPane().setBackground(Color.white);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		update = new JLabel();
		update.setText("Update Flight");
		update.setBounds(30, 10, 259, 80);
		update.setFont(new Font("Candara",Font.TRUETYPE_FONT,40));
		update.setForeground(new Color(128,0,128));
		
		flightnumber = new JLabel();
		flightnumber.setText("Enter Flight Number:");
		flightnumber.setBounds(30, 70, 259, 80);
		flightnumber.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		flightnumber.setForeground( Color.black);
		
		field = new JTextField();
		field.setBounds(280, 95, 250, 40);
		field.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		button = new JButton("Submit");
		button.setBounds(570, 95, 150, 40);
		button.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,25));
		button.setForeground(new Color(128,0,128));
		button.setFocusable(false);
		button.addActionListener(this);
		
		table = new JTable();
        Object [] coloumns = {"FLIGHT NAME","DEPARTURE TIME","ARRAIVAL TIME","PRICE","DEPARTURE","ARRAIVAL","DEPART DATE"};
            
       
        model.setColumnIdentifiers(coloumns);
        table.setModel(model);
        
        table.setForeground(Color.black);
        table.setBackground(Color.white);
        table.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,14));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        table.addMouseListener(this);
        
      
        pane = new JScrollPane(table);
        pane.setBounds(10,180,1100,50);
        frame1.add(pane);
        Object[] row =new Object[50];
        
		
		flightname = new JTextField();
		flightname.setBounds(10, 250, 150, 30);
		flightname.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flightd = new JTextField();
		flightd.setBounds(170, 250, 150, 30);
		flightd.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flighta = new JTextField();
		flighta.setBounds(330, 250, 150, 30);
		flighta.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flightp = new JTextField();
		flightp.setBounds(490, 250, 150, 30);
		flightp.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flightdp = new JTextField();
		flightdp.setBounds(650, 250, 150, 30);
		flightdp.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flightap = new JTextField();
		flightap.setBounds(810, 250, 150, 30);
		flightap.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		flightdd = new JTextField();
		flightdd.setBounds(970, 250, 150, 30);
		flightdd.setFont(new Font("Rockwell",Font.TRUETYPE_FONT,20));
		
		 updatee = new JButton("Update");
         updatee.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
         updatee.setBounds(420, 350,200, 35);
         updatee.setBackground(Color.DARK_GRAY);
         updatee.setForeground(Color.white);
         updatee.setFocusable(false);
         updatee.addActionListener(this);
		
         back = new JButton("Back");
         back.setFocusable(false);
         back.setBounds(150, 700, 200, 35);
         back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
         back.setBackground(Color.DARK_GRAY);
         back.setForeground(Color.white);
         back.addActionListener(this);
		
		
		
		
		frame1.add(field);
		frame1.add(update);
		frame1.add(flightnumber);
		frame1.add(button);
		frame1.add(flightname);
		frame1.add(flightd);
		frame1.add(flighta);
		frame1.add(flightp);
		frame1.add(flightdp);
		frame1.add(flightap);
		frame1.add(flightdd);
		frame1.add(updatee);
		frame1.add(back);
		
		frame1.setVisible(true);
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
		if(e.getSource() == table) {
		
		int selctedRowIndex = table.getSelectedRow();
		
		flightname.setText(model.getValueAt(selctedRowIndex,0).toString());
		flightd.setText(model.getValueAt(selctedRowIndex,1).toString());
		flighta.setText(model.getValueAt(selctedRowIndex,2).toString());
		flightp.setText(model.getValueAt(selctedRowIndex,3).toString());
		flightdp.setText(model.getValueAt(selctedRowIndex,4).toString());
		flightap.setText(model.getValueAt(selctedRowIndex,5).toString());
		flightdd.setText(model.getValueAt(selctedRowIndex,6).toString());
		
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== button) {
			
			
			
			 no = field.getText();
			 Boolean flag = null;
		        
		        try{
		            
			         Class.forName("com.mysql.jdbc.Driver");
			            
			           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root",""); 
			                 
			           String sql="select * from flightdetails WHERE flightno='"+no+"'";
			           Statement stmt=con.createStatement();  
			            ResultSet rs = stmt.executeQuery(sql);      
			                 
			                 DefaultTableModel dl=(DefaultTableModel)table.getModel();
			                 dl.setRowCount(0);
			                 while(rs.next())
			                 {
			                     Vector v2=new Vector();
			                     
			                         
			                         v2.add(rs.getString("flightname"));
			                         v2.add(rs.getString("departtime"));
			                         v2.add(rs.getString("arraivaltime"));
			                         v2.add(rs.getString("price"));
			                         v2.add(rs.getString("depart"));
			                         v2.add(rs.getString("arraival"));
			                         v2.add(rs.getString("departdate"));
			                         
			                         dl.addRow(v2);
			                         
			                         no = rs.getString("flightno");
			 		                

			 		                if(no.equals(no) ){
			 		                    flag = true;
			 		                }
			 		              
			 		            }
			 		            
			 		            if(flag == true)
			 		            {
			 		                   
			 		                   
			 		                   
			 		            }
			 		            else
			 		            {
			 		                JOptionPane.showMessageDialog(null, "Invalid Flight Number");
			 		               
			 		                

			                     
			                     
			                 }                          
			        }
			        catch( Exception ex){
			            System.out.println(ex);
			            
						
							 JOptionPane.showMessageDialog(null, "Invalid Flight Number");
							 
						 
			        }  
		    
		       
		}
		        
		   if(e.getSource()== updatee) {
			   String a,b,c,d,h,f,g;
			   a = flightname.getText();
			   b = flightd.getText();
			   c = flighta.getText();
			   d = flightp.getText();
			   h = flightdp.getText();
			   f = flightap.getText();
			   g = flightdd.getText();
			   Boolean flag;
			   
			  

				 try {
			        	Class.forName("com.mysql.jdbc.Driver");
			            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
			            String sql="update flightdetails set flightname='"+a+"', departtime='"+b+"', arraivaltime='"+c+"', price='"+d+"', depart= '"+h+"', arraival='"+f+"', departdate='"+g+"' where flightno='"+no+"'";             
			            Statement stmt=con.createStatement(); 
			            stmt.executeUpdate(sql);
			            flag = true;
			        
				     
				 if(flag== true){
					 JOptionPane.showMessageDialog(null, "Updated Successfully");
					 
				 }
				 }
				 
			        	
			            catch(Exception e1)
				        {
				            System.out.println("Error" + e1);
				        }
			   
			   
		   }
		   
		   if(e.getSource()== back) {
	        	new AdminPage();
	        }
		        
		        
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
