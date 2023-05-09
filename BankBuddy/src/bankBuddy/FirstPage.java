package bankBuddy;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage {
	
	JButton login_btn, signup_btn;
	JLabel welcome_msg;
	
	FirstPage() {	

		GridBagConstraints gbc = new GridBagConstraints();
		
		JFrame f = new JFrame("Bank Buddy");

		f.setLayout(new GridBagLayout());
		f.setSize(500, 200);
		
		//// FIRST COLUMN ////
		welcome_msg = new JLabel("<html>Welcome to DCA Bank Buddy!</html>");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 5;
		f.add(welcome_msg, gbc);
		
		login_btn = new JButton("Login");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0;
		f.add(login_btn, gbc);
		
		signup_btn = new JButton("Create New Account");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 2;
		f.add(signup_btn, gbc);
		
		f.setVisible(true);
		
		// making login button take you to Login Page frame
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				f.dispose();
			}
		});
		
		 //making create account button take you to Create Account frame
		signup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount();
				f.dispose();
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FirstPage();

	}

}
