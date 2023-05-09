package bankBuddy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePage {
	
	JLabel greeting, checking, saving;
	JMenuItem transfer, deposit, withdraw, sign_out;
	
	HomePage() {
		JFrame mainFrame = new JFrame("Welcome, ");
	
		JPanel mainPanel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu accountActions = new JMenu("Account Actions");
		
		JMenuItem transfer = new JMenuItem("Transfer");
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdraw = new JMenuItem("Withdraw");
		JMenuItem sign_out = new JMenuItem("Sign Out");
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(400, 400);
		
		mainPanel.setLayout(new GridBagLayout());
		
		menuBar.setLayout(new BorderLayout());
		menuBar.setPreferredSize(new Dimension(400, 50));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// checking account
		JLabel checking = new JLabel("<html><strong>Checking</strong></html>");
		gbc.gridx = 1;
		gbc.gridy = 1;
		mainPanel.add(checking, gbc);
		
		// saving account
		JLabel saving = new JLabel("<html><strong>Saving</strong></html>");
		gbc.gridx = 1;
		gbc.gridy = 2;
		mainPanel.add(saving, gbc);
		
		mainFrame.add(mainPanel, BorderLayout.NORTH);
		mainFrame.add(menuBar, BorderLayout.SOUTH);
		
		menuBar.add(accountActions, BorderLayout.WEST);
		menuBar.add(sign_out, BorderLayout.EAST);
		
		accountActions.add(transfer);
		accountActions.add(deposit);
		accountActions.add(withdraw);
		
		mainFrame.setVisible(true);	
		
		// go back to first page frame when clicking sign out
		sign_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FirstPage();
				mainFrame.dispose();
			}
		});
<<<<<<< Updated upstream
=======
		
		// going to transfer/withdraw frame
		
		
>>>>>>> Stashed changes
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}

}
