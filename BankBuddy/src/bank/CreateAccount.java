package bank;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;

import com.mysql.cj.jdbc.Driver;

public class CreateAccount {
	
	JLabel username_label, password_label, confirm_password_label, email_label, stmt_complete_msg;
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
		
		stmt_complete_msg = new JLabel("Account created!\nGo back to login.");
		stmt_complete_msg.setBounds(140, 325, 250, 50);
		stmt_complete_msg.setVisible(false);
		
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
		f.add(stmt_complete_msg);		
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
					// connecting to database
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SE370", "root", "password30");
					Statement stmt = con.createStatement();	
					String create_new_account_query = "INSERT INTO users VALUES('"+username.getText()+"', '"+password.getText()+"', '"+email.getText()+"')";
					String create_checking = "INSERT INTO accounts(account_type,user,balance) VALUES('CHECKING','"+username.getText()+"',0.00)";
					String create_saving = "INSERT INTO accounts(account_type,user,balance) VALUES('SAVING','"+username.getText()+"',0.00)";
					// checking if all fields of form are empty 
					if (username.getText().isEmpty() == true || email.getText().isEmpty() == true || password.getText().isEmpty() == true) {
						String error = "Please fill out all fields of the form";
						JOptionPane.showMessageDialog(f, error, "", JOptionPane.ERROR_MESSAGE);
					} else {
						// checking if password and confirm passwords are equal
						if (Arrays.equals(password.getPassword(), confirm_password.getPassword())) {
							stmt.executeUpdate(create_new_account_query);
							stmt.executeUpdate(create_checking);
							stmt.executeUpdate(create_saving);
							create_button.setVisible(false);
							stmt_complete_msg.setVisible(true);
							email.setText(null);
							username.setText(null);
							password.setText(null);
							confirm_password.setText(null);
						} else {
							String pswd_no_match = "Passwords do not match";
							JOptionPane.showMessageDialog(f, pswd_no_match, "", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch(Exception error) {
					System.out.print(error);
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