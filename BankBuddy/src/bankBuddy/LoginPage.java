package bankBuddy;
import javax.swing.*;

public class LoginPage {
	
	JLabel username_label, password_label;
	JTextField username, password;
	JButton login_button, createAcc_button;
	
	LoginPage() {
		JFrame f = new JFrame("Login");
		
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
		
		// create account
		createAcc_button = new JButton("Create Account");
		createAcc_button.setBounds(180, 350, 150, 50);
		
		f.add(username);
		f.add(username_label);
		f.add(password);
		f.add(password_label);
		f.add(login_button);
		f.add(createAcc_button);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();
	}

}
