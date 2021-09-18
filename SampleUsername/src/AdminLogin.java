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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin implements ActionListener{
	
	JFrame frame;
	JLabel label,label1,label2;
	JTextField field,field2;
	JButton login,back;
	
	public AdminLogin() {
		
		frame =  new JFrame();
		frame.setSize(1155,800);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.white);
		
		label = new JLabel();
		label.setText("Admin Sign in");
		label.setBounds(450, 100, 300, 100);
		label.setForeground(Color.ORANGE);
		label.setBackground(Color.white);
		label.setOpaque(true);
		label.setFont(new Font("RockWell",Font.TRUETYPE_FONT,40));
	
		

		label1 = new JLabel();
		label1.setText("Admin Id:");
		label1.setBounds(350, 255, 150, 20);
		label1.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		//label1.setBackground(Color.white);
		label1.setForeground(Color.black);
		

		field = new JTextField();
		field.setBounds(480, 250, 280, 40);
		field.setFont(new Font("Candara",Font.TRUETYPE_FONT,20));
		
		label2 = new JLabel();
		label2.setText("Password:");
		label2.setBounds(350, 330, 150, 20);
		label2.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		label2.setForeground(Color.black);
		
		
		field2 = new JPasswordField();
		field2.setBounds(480, 320, 280, 40);
		field2.setFont(new Font("Candara",Font.TRUETYPE_FONT,20));
		
		login = new JButton("Sign In");
		login.setFocusable(false);
		login.setBounds(480, 400, 280, 35);
		login.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		login.setBackground(Color.lightGray);
		login.setForeground(Color.red);
		login.addActionListener(this);
		
		 back = new JButton("Back");
	     back.setFocusable(false);
	     back.setBounds(350, 650, 150, 35);
         back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
         back.setBackground(Color.black);
	     back.setForeground(Color.white);
	     back.addActionListener(this);
		
		
		
		frame.add(label);
		frame.add(label1);
		frame.add(field);
		frame.add(label2);
		frame.add(field2);
		frame.add(login);
		frame.add(back);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== back) {
			new Home();
		}
		
		if(e.getSource()== login) {
			String Username = field.getText();
		       
	        String Password = field2.getText();
	        
	        
	        
	        String dbUsername, dbPassword;
	        Boolean flag = false;

	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
	            String sql="select username,password from adminlogin";
	            Statement stmt=con.createStatement();  
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            while(rs.next())
	            {
	                dbUsername = rs.getString("username");
	                dbPassword = rs.getString("password");

	                if(dbUsername.equals(Username) && dbPassword.equals(Password)){
	                    flag = true;
	                }
	              
	            }
	            if(flag == true)
	            {
	                    JOptionPane.showMessageDialog(null, "Login Successful");
	                    new AdminPage();
	                   
	                   
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
	                field.setText("");
	                field2.setText("");
	                
	            }
	            
	        }
	        catch(Exception e1)
	        {
	            System.out.println("Error" + e1);
	        }
			
		}
		
	}

	private void AdminPage(String username) {
		// TODO Auto-generated method stub
		
	}
	
	

}
