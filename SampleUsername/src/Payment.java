import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Payment implements ActionListener {
	
	JFrame frame;
	JLabel label,name,no,expiry,cvv;
	JTextField nofield,namefield,cvvfield;
	JDateChooser expiryfield;
	JButton button;
	

	public Payment() {
		frame = new JFrame();
		frame.setSize(1155,800);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
		label.setText("Payment");
		label.setBounds(30, 10, 180, 50);
		label.setFont(new Font("Candara",Font.TRUETYPE_FONT,40));
		label.setForeground(new Color(128,0,128));
		
		no = new JLabel();
		no.setText("CARD NUMBER:");
		no.setBounds(50, 100, 200, 40);
		no.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		no.setForeground(new Color(102,102,153));
		
		nofield = new JTextField();
		nofield.setBounds(220, 100, 280,35);
		nofield.setFont(null);
		nofield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		name = new JLabel();
		name.setText("CARD HOLDER NAME:");
		name.setBounds(50, 200, 250, 40);
		name.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		name.setForeground(new Color(102,102,153));
		
		namefield = new JTextField();
		namefield.setBounds(280, 200, 280,35);
		namefield.setFont(null);
		namefield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		expiry = new JLabel();
		expiry.setText("EXPIRY DATE:");
		expiry.setBounds(50, 300, 250, 40);
		expiry.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		expiry.setForeground(new Color(102,102,153));
		
		expiryfield = new JDateChooser();
		expiryfield.setBounds(210, 300, 280,35);
		expiryfield.setFont(null);
		expiryfield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		cvv = new JLabel();
		cvv.setText("CVV:");
		cvv.setBounds(50, 400, 250, 40);
		cvv.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		cvv.setForeground(new Color(102,102,153));
		
		cvvfield = new JTextField();
		cvvfield.setBounds(130, 400, 50,35);
		cvvfield.setFont(null);
		cvvfield.setFont(new Font("Segoe Ui",Font.TRUETYPE_FONT,18));
		
		button = new JButton("MAKE PAYMENT");
		button.setBounds(200, 500, 250, 40);
		button.setFont(new Font("RockWell",Font.TRUETYPE_FONT,20));
		button.setForeground(new Color(102,102,153));
		button.setBackground(new Color(204,204,255));
		button.addActionListener(this);
		
		frame.add(label);
		frame.add(name);
		frame.add(namefield);
		frame.add(no);
		frame.add(nofield);
		frame.add(expiry);
		frame.add(expiryfield);
		frame.add(cvv);
		frame.add(cvvfield);
		frame.add(button);
		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== button) {
		   new lastpage();
		}
		
	}
}
