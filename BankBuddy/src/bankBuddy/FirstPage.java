package bankBuddy;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class FirstPage {
	
	JButton login_btn, signup_btn;
	JLabel welcome_msg;
	
	FirstPage() {	
		
		JFrame f = new JFrame("Bank Buddy");
		login_btn = new JButton("Login");
		signup_btn = new JButton("Create New Account");
		
		welcome_msg = new JLabel("<html>Welcome to DCA Bank Buddy!<br>Please select from the following options.</html>");
		welcome_msg.setHorizontalAlignment(JLabel.CENTER);
		
		f.add(welcome_msg);
		f.add(login_btn);
		f.add(signup_btn);
		f.setVisible(true);
		f.setLayout(new GridBagLayout());
		f.setSize(500, 500);
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FirstPage();

	}

}
