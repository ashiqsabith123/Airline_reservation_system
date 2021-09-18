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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserName implements ActionListener{
	
	JFrame frame;
	JTextField field;
	JPasswordField field2;
	JLabel label,label2,label3,label4,label5;
	JButton login,register,forgot,back;
	JPanel panel;
	
	public UserName (){
	
		frame = new JFrame();
		frame.setSize(1155,800);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		field = new JTextField();
		field.setBounds(480, 250, 280, 40);
		field.setFont(new Font("Candara",Font.TRUETYPE_FONT,20));
		
		field2 = new JPasswordField();
		field2.setBounds(480, 320, 280, 40);
		field2.setFont(new Font("Candara",Font.TRUETYPE_FONT,20));
		
		label = new JLabel();
		label.setText("USERNAME:");
		label.setBounds(350, 255, 150, 20);
		label.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		label.setBackground(Color.white);
		label.setForeground(new Color(128,0,128));
		
		
		label2 = new JLabel();
		label2.setText("PASSWORD:");
		label2.setBounds(350, 330, 150, 20);
		label2.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		label2.setForeground(new Color(128,0,128));
		
		label3 = new JLabel();
		label3.setText("User Sign in");
		label3.setBounds(450, 100, 300, 100);
		label3.setForeground(new Color(0,0,128));
		label.setOpaque(true);
		label3.setFont(new Font("RockWell",Font.TRUETYPE_FONT,40));
		
		label4 = new JLabel();
		label4.setText("Don't have an account?");
		label4.setBounds(430, 510, 280, 35);
		label4.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		label4.setForeground(new Color(102,102,153));
		
		label5 = new JLabel();
		label5.setText("Forgot Password?");
		label5.setBounds(430, 550, 280, 35);
		label5.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		label5.setForeground(new Color(102,102,153));
		
		
		login = new JButton("Sign In");
		login.setFocusable(false);
		login.setBounds(480, 400, 280, 35);
		login.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		login.setBackground(new Color(102,0,102));
		login.setForeground(Color.white);
		login.addActionListener(this);
		
		register = new JButton("Sign Up");
		register.setFocusable(false);
		register.setBounds(660, 510, 100, 30);
		register.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
		register.setBackground(Color.white);
		register.addActionListener(this);
		
		forgot = new JButton("Find Account");
		forgot.setFocusable(false);
		forgot.setBounds(610, 550, 150, 30);
		forgot.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
		forgot.setBackground(Color.white);
        forgot.addActionListener(this);
        
        back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(350, 650, 150, 30);
        back.setFont(new Font("RockWell",Font.TRUETYPE_FONT,15));
        back.setBackground( Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        
       
        
		
		frame.add(label);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(field);
		frame.add(field2);
		frame.add(login);
		frame.add(register);
		frame.add(forgot);
		frame.add(back);
		
	    
		frame.setVisible(true);
		
		
	}
	
public static void main(String[] args) {
	//new UserName();
	//new registerPage();
        //new FindAccount();
     new Home();
	//new AdminLogin();
	//new AdminPage();
	//new FlightList();
	//new Addflight();
  //new Bookflight();
	//new Updateflight();
	//new Showbooking();
	//new Showusers();
	//new Deleteflight();
	//new Payment();
	//new lastpage();
	//new showflights();
	
}


public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()== register){
		
            
		new registerPage();
                
	}
	
	if(e.getSource()== login){
		
	       
	        String Username = field.getText();
	       
	        String Password = field2.getText();
	        
	        String dbUsername, dbPassword;
	        Boolean flag = false;

	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
	            String sql="select username,password from signuptable";
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
	                    new FlightList();
	                   
	                   
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
	

	
	 if(e.getSource()== forgot){
             FindAccount find = new FindAccount();
         }
		
	 if(e.getSource()== back) {
		 new Home();
	 }
	 
	}

}