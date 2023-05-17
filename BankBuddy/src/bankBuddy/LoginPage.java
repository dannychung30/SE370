package bankBuddy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {
	
	JLabel username_label, password_label, welcome_msg;
	JTextField username;
	JPasswordField password;
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
		password = new JPasswordField("", 255);
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
		
		// logs user into their account when pressing login button
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// connecting to database
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SE370", "root", "password30");
					Statement stmt = con.createStatement();	
					String get_user_info_query = "SELECT * FROM users WHERE username = '"+username.getText()+"' AND password = '"+password.getText().toString()+"'";
					ResultSet user = stmt.executeQuery(get_user_info_query);
					
					String get_balance = "SELECT accounts.account_type, accounts.balance FROM accounts, users WHERE users.username = accounts.user AND accounts.user = '"+username.getText()+"'";
				
					// checking if username and password are in the database
					if (user.next()) {
						ResultSet user_balance = stmt.executeQuery(get_balance);
						
						Map <String, String> d = new HashMap<>();
					    
						while (user_balance.next()) {
							// getting account type and balance from query result
							String account_type = user_balance.getString("account_type");
							String balance = user_balance.getString("balance");
							
							// adding query result into dictionary with account type 
							// as the key and balance as its value
							d.put(account_type, balance);
						}
						// creating new home page frame and passing in the 
						// hashmap we just made of the account balances
						new HomePage(d);
						f.dispose();
					} else {
						JOptionPane.showMessageDialog(f, "Username or Password are incorrect");
					}
				} catch(Exception error) {
					System.out.print(error);
				}
			}
		});
		
		// taking you to create new account frame
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount();
				f.dispose();
			}
		});	
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		Class.forName("com.mysql.cj.jdbc.Driver");
		new LoginPage();
	}
}
