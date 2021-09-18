import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class registerPage implements ActionListener{
	
	JFrame frame1;
	JTextField firstnamefield,lastnamefield,emailfield,phonefield,usernamefield;
    JPasswordField passwordfield;
	JLabel firstname,lastname,email,signup,phone,gender,username,password,dob;
	JRadioButton male,female,others;
    JButton save,cancel;
    TextArea show;
    JDateChooser date;
    JPanel panel;
    
	
	
	public registerPage() {
		
		frame1 = new JFrame();
		frame1.setSize(1155,800);
		frame1.setLayout(null);
		frame1.getContentPane().setBackground(Color.white);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		signup = new JLabel();
		signup.setText("Sign Up");
		signup.setBounds(30, 10, 180, 80);
		signup.setFont(new Font("Candara",Font.TRUETYPE_FONT,40));
		signup.setForeground(new Color(128,0,128));
		
		firstname = new JLabel();
		firstname.setText("First Name:");
		firstname.setBounds(50, 100, 150, 40);
		firstname.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		firstname.setForeground(new Color(102,102,153));
		
		
	    lastname = new JLabel();
		lastname.setText("Last Name:");
		lastname.setBounds(500, 110, 150, 20);
		lastname.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		lastname.setForeground(new Color(102,102,153));
		
		email = new JLabel();
		email.setText("Email:");
		email.setBounds(50, 180, 80, 20);
		email.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		email.setForeground(new Color(102,102,153));

		
		
		dob = new JLabel();
		dob.setText("Dob:");
		dob.setBounds(600, 180, 80, 25);
		dob.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		dob.setForeground(new Color(102,102,153));
		
	    date = new JDateChooser();
        date.setBounds(670, 170, 300, 40);
        date.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,16));
        date.setForeground(new Color(102,102,153));
		
		
                
        phone = new JLabel();
        phone.setText("Phone No:");
        phone.setBounds(50, 220, 120, 80);
        phone.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
        phone.setForeground(new Color(102,102,153));
                
        gender = new JLabel();
        gender.setText("Gender:");
        gender.setBounds(500, 220, 100, 80);
        gender.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
        gender.setForeground(new Color(102,102,153));
                
        username = new JLabel();
		username.setText("Username:");
		username.setBounds(50, 300, 120, 80);
		username.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		username.setForeground(new Color(102,102,153));
                
        password = new JLabel();
		password.setText("Password:");
		password.setBounds(500, 300, 120, 80);
		password.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		password.setForeground(new Color(102,102,153));
                
        show = new TextArea();
		show.setBounds(1250, 50, 100, 80);
        show.setFont(new Font("RockWell",Font.TRUETYPE_FONT,30));
                
                
                
        male = new JRadioButton("Male");
        male.setBounds(600,245,80,30);
        male.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,20));
        male.setForeground(new Color(102,102,153));
        male.setBackground(Color.white);
        male.setFocusable(false);
                
                
        female = new JRadioButton("Female");
        female.setBounds(690,245,100,30);
        female.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,20));
        female.setForeground(new Color(102,102,153));
        female.setBackground(Color.white);
        female.setFocusable(false);
                
                 
        others = new JRadioButton("Others");
        others.setBounds(810,245,100,30);
        others.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,20));
        others.setForeground(new Color(102,102,153));
        others.setBackground(Color.white);
        others.setFocusable(false);
                
                
		firstnamefield = new JTextField();
		firstnamefield.setBounds(180, 100, 280,40);
		firstnamefield.setFont(null);
		firstnamefield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		lastnamefield = new JTextField();
		lastnamefield.setBounds(630, 100, 280, 40);
		lastnamefield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		emailfield = new JTextField();
		emailfield.setBounds(180, 170, 380, 40);
		emailfield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
                
        phonefield = new JTextField();
        phonefield.setBounds(180, 240, 280, 40);
        phonefield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
                
        usernamefield = new JTextField();
		usernamefield.setBounds(180, 320, 280, 40);
		usernamefield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
                
        passwordfield = new JPasswordField();
        passwordfield.setBounds(630, 320,280, 40);
        passwordfield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
                
		
		
		 
                 
		 cancel = new JButton();
		 cancel.setText("Cancel");
		 cancel.setBounds(200, 400, 200, 40);
		 cancel.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		 cancel.setBackground(new Color(102,102,153));
		 cancel.setForeground(new Color(204,255,255));
		 cancel.setFocusable(false);
		 cancel.addActionListener(this);
		 
                 
         save = new JButton();
         save.setText("Save");
         save.setBounds(500, 400, 200, 40);
         save.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
         save.setBackground(new Color(102,102,153));
         save.setForeground(new Color(204,255,255));
         save.setFocusable(false);
         save.addActionListener(this);
         
         panel = new JPanel();
         panel.setBounds(0, 0, 1155, 80);
         panel.setBackground(Color.black);
         
         ButtonGroup group = new ButtonGroup();
         group.add(others);
         group.add(female);
         group.add(male);
		
		frame1.add(signup);
		frame1.add(lastname);
		frame1.add(firstname);
		frame1.add(email);
		frame1.add(dob);
		frame1.add(phone);
        frame1.add(gender);
        frame1.add(username);
        frame1.add(password);
        //frame1.add(panel);
		frame1.add(lastnamefield);		
		frame1.add(firstnamefield);
		frame1.add(emailfield);
        frame1.add(phonefield);
        frame1.add(usernamefield);
        frame1.add(passwordfield);
		
        frame1.add(male);
        frame1.add(female);
        frame1.add(others);
        frame1.add(save);
        frame1.add(cancel);
        frame1.add(date);
		
		
		frame1.setVisible(true);
		
	}

    
    public void actionPerformed(ActionEvent ae) {
    	String Gender;
    	if(male.isSelected()) {
    		Gender="male";
        	
        }
        else if(female.isSelected()){
        	Gender="Female";
        	
        }
        else {
        	Gender="Others";
        }
        
        if(ae.getSource()== save){
        	
        	String Fname = firstnamefield.getText();
        	
        	String Lname = lastnamefield.getText();
        	
        	String Email = emailfield.getText();
        	
        	String Ph = phonefield.getText();
        	
          
        	 
			
			    SimpleDateFormat formattter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strrDate= formattter.format(date.getDate()); 
        	
          
           
	        String Username = usernamefield.getText();
	        
	        String Password = passwordfield.getText();
	       
	        
           
	        
	     try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","");  
	            String sql="INSERT INTO signuptable (fname,lname,email,phnumber,dob,username,password,gender) VALUES ('"+Fname+"','"+Lname+"','"+Email+"','"+Ph+"','"+strrDate+"','"+Username+"','"+Password+"','"+Gender+"')";             
	            Statement stmt=con.createStatement(); 
	            stmt.executeUpdate(sql);
	            
	            JOptionPane.showMessageDialog(null, "Accout Created Succesfully");
	            new UserName();
	          
	        }
	        	
	            catch(Exception e1)
		        {
		            System.out.println("Error" + e1);
		        }
            
            
        }
        
        if(ae.getSource()== cancel){
            
            new UserName();
            
            
        }
        
        
        
        
    }

}