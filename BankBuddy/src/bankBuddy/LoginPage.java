package bankBuddy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {
	
	JLabel username_label, password_label;
	JTextField username, password;
	JButton login_button, back_btn;
	
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
		back_btn = new JButton("<- Back");
		back_btn.setBounds(10, 10, 75, 25);
		
		f.add(username);
		f.add(username_label);
		f.add(password);
		f.add(password_label);
		f.add(login_button);
		f.add(back_btn);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		// takes you back to the FirstPage frame
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FirstPage();
				f.dispose();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();
	}

}
