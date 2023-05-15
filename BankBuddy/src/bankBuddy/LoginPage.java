package bankBuddy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Properties;

public class LoginPage {
	
	JLabel username_label, password_label, welcome_msg;
	JTextField username, password;
	JButton login_button, create_account;
	
	LoginPage() {
		JFrame f = new JFrame("Welcome to DCA Bank Buddy!");
		
		welcome_msg = new JLabel("Login");
		welcome_msg.setBounds(230, 30, 200, 40);
		username_label = new JLabel("Username:");
		username_label.setBounds(150, 70, 200, 50);
		username = new JTextField("", 255);
		username.setBounds(150, 100, 200, 50);
		password_label = new JLabel("Password:");
		password_label.setBounds(150, 145, 200, 50);
		password = new JTextField("", 255);
		password.setBounds(150, 175, 200, 50);
		login_button = new JButton("Login");
		login_button.setBounds(200, 250, 100, 50);
		create_account = new JButton("<html><u>Create Account</u></html>");
		create_account.setBorderPainted(false);
		create_account.setBounds(150, 350, 200, 50);
		
		f.add(username);
		f.add(username_label);
		f.add(password);
		f.add(password_label);
		f.add(login_button);
		f.add(create_account);
		f.add(welcome_msg);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount();
				f.dispose();
			}
		});	
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		new LoginPage();
		
	}

}
