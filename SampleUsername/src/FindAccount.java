


	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;


	public class FindAccount implements ActionListener{
	    
	    JFrame frame;
	    JLabel label,label1;
	    JPanel panel; 
	    JTextField forgot;
	    JButton button,button1;

	    public FindAccount() {
	        
	        frame = new JFrame();
	        frame.setSize(1155,800);
	        frame.setLayout(null);
		    frame.getContentPane().setBackground(Color.WHITE);
	        
	        label = new JLabel();
	        label.setText("Find Your Account");
	        label.setBounds(30,20,350,50);
	        label.setFont(new Font("Candara",Font.BOLD,40));
	        
	        label1 = new JLabel();
	        label1.setText("Please enter your email adress or phone number");
	        label1.setBounds(100,100,800,30);
	        label1.setFont(new Font("RockWell",Font.ITALIC,25));
	        
	        button = new JButton("Search");
	        button.setBounds(530,160,150,35);
	        button.setBackground(Color.white);
	        button.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
	        button.setFocusable(false);
	        button.setContentAreaFilled(false);
	        
	        
	        
	        button1 = new JButton("Cancel");
	        button1.setBounds(100,250,150,30);
	        button1.setBackground(Color.white);
	        button1.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
	        button1.setFocusable(false);
	        button1.addActionListener(this);
	        button1.setContentAreaFilled(false);
	      
	        
	        
	        forgot = new JTextField();
	        forgot.setBounds(100, 160, 400, 35);
	        forgot.setFont(new Font("RockWell",Font.TRUETYPE_FONT,18));
	        
	        
	        
	        frame.add(forgot);
	        frame.add(label);
	        frame.add(label1);
	        frame.add(button);
	        frame.add(button1);
	        
	        
	        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	        
	    }

	    @Override
	    public void actionPerformed(ActionEvent ae) {
	       if(ae.getSource()== button1){
	           
	          new UserName();
	       }
	    }
	    
	    
	    
	}
	

