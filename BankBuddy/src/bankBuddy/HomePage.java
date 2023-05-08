package bankBuddy;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class HomePage {
	
	JLabel greeting, checking, saving;
	JButton sign_out;
	
	HomePage() {
		JFrame f = new JFrame("Welcome, ");
		GridBagConstraints gbc = new GridBagConstraints();
		
		f.setLayout(new GridBagLayout());
		f.setSize(500, 500);
			
		//JLabel greeting = new JLabel("Welcome, ");
		JLabel checking = new JLabel("Checking");
		f.add(checking, gbc);
		
		JLabel saving = new JLabel("Saving");
		f.add(saving, gbc);
		
		JButton sign_out = new JButton("Sign Out");
		f.add(sign_out, gbc);
		
		f.setVisible(true);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}

}
