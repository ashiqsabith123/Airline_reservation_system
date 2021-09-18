import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lastpage implements ActionListener{

	JFrame frame;
	JLabel label,pay,ticket,enjoy;
	JPanel panel;
	JButton button;
	
	public lastpage() {
		

		frame = new JFrame();
		frame.setSize(1155,800);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setBackground(Color.WHITE);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
        label.setText("FLY HIGH");
        label.setBounds(30, 30, 300, 65);
        label.setFont(new Font("Candara",Font.ROMAN_BASELINE,60));
        label.setForeground(Color.red);
        
		
		pay = new JLabel();
		pay.setText("PAYMENT COMPLETED");
		pay.setBounds(30, 150, 400, 65);
		pay.setFont(new Font("Candara",Font.ROMAN_BASELINE,40));
		pay.setForeground(new Color(255,102,0));
		
		ticket = new JLabel();
		ticket.setText("TICKET BOOKED SUCCESFULLY");
		ticket.setBounds(30, 250, 600, 65);
		ticket.setFont(new Font("Candara",Font.ROMAN_BASELINE,40));
		ticket.setForeground(new Color(255,102,0));
		
		enjoy = new JLabel();
		enjoy.setText("ENJOY JOURNEY");
		enjoy.setBounds(30, 350, 600, 65);
		enjoy.setFont(new Font("Candara",Font.ROMAN_BASELINE,40));
		enjoy.setForeground(new Color(255,102,0));
        
        panel = new JPanel();
        panel.setBounds(0, 0, 1155, 100);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.add(label);
        
        button = new JButton("HOME");
        button.setBounds(200, 500, 300, 40);
        button.setFont(new Font("Rockwell",Font.ROMAN_BASELINE,20));
        button.setForeground(Color.white);
        button.setBackground(Color.gray);
        button.setFocusable(false);
        button.addActionListener(this);
        
        frame.setVisible(true);
        frame.add(panel);
        frame.add(pay);
        frame.add(ticket);
        frame.add(enjoy);
        frame.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== button) {
			new Home();
		}
		
	}
}
