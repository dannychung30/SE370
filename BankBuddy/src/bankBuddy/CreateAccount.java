package bankBuddy;
import javax.swing.*;

public class CreateAccount {
	
	JLabel username_label, password_label, confirm_password_label, email_label;
	JTextField username, password, confirm_password, email;
	JButton create_button;
	
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
		password = new JTextField("", 255);
		password.setBounds(150, 185, 200, 50);
		
		confirm_password_label = new JLabel("Confirm Password: ");
		confirm_password_label.setBounds(150, 230, 200, 50);
		confirm_password = new JTextField("", 255);
		confirm_password.setBounds(150, 260, 200, 50);
		
		create_button = new JButton("<html>Create<br>Account</html>");
		create_button.setBounds(200, 325, 100, 50);
	
		
		f.add(email_label);
		f.add(email);
		f.add(username);
		f.add(username_label);
		f.add(password);
		f.add(password_label);
		f.add(confirm_password_label);
		f.add(confirm_password);
		f.add(create_button);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CreateAccount();

	}

}
