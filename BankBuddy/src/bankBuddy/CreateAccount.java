package bankBuddy;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;

import com.mysql.cj.jdbc.Driver;

public class CreateAccount {
	
	JLabel username_label, password_label, confirm_password_label, email_label;
	JTextField username, email;
	JButton create_button, back_btn;
	JPasswordField password, confirm_password;
	
	CreateAccount() {
		
		JFrame f = new JFrame("Create Account");
				
		email_label = new JLabel("Email:");
		email_label.setBounds(150, 10, 200, 50);
		email = new JTextField("", 255);
		email.setBounds(150, 40, 200, 50);
		
		username_label = new JLabel("Username:");
		username_label.setBounds(150, 85, 200, 50);
		username = new JTextField("", 255);
		username.setBounds(150, 115, 200, 50);
		
		password_label = new JLabel("Password:");
		password_label.setBounds(150, 155, 200, 50);
		password = new JPasswordField("", 255);
		password.setBounds(150, 185, 200, 50);
		
		confirm_password_label = new JLabel("Confirm Password: ");
		confirm_password_label.setBounds(150, 230, 200, 50);
		confirm_password = new JPasswordField("", 255);
		confirm_password.setBounds(150, 260, 200, 50);
		
		create_button = new JButton("<html>Create<br>Account</html>");
		create_button.setBounds(200, 325, 100, 50);
		
		back_btn = new JButton("<- Back");
		back_btn.setBounds(10, 10, 75, 25);
	
		
		f.add(email_label);
		f.add(email);
		f.add(username);
		f.add(username_label);
		f.add(password);
		f.add(password_label);
		f.add(confirm_password_label);
		f.add(confirm_password);
		f.add(create_button);
		f.add(back_btn);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);

		// takes you back to the FirstPage frame
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				f.dispose();
			}
		});
		
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SE370", "root", "password30");
					Statement stmt = con.createStatement();	
					String query = "INSERT INTO users VALUES('"+username.getText()+"', '"+password.getText()+"', '"+email.getText()+"')";
					stmt.executeUpdate(query);
					System.out.println("Statement made");
					//ResultSet results = stmt.executeQuery(query);
//					
//					while (results.next()) {
//						String username = results.getString("username");
//						String password = results.getString("password");
//						String email = results.getString("email");
//						System.out.println(username + "   " + password + "   " + email);
//					}
				} catch(Exception e1) {
					System.out.print(e1);
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		new CreateAccount();
	}
}
