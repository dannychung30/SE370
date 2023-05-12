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
	JMenuItem transfer_withdraw_deposit, statements, sign_out;
	
	HomePage() {
		JFrame mainFrame = new JFrame("Welcome, ");
	
		JPanel mainPanel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu accountActions = new JMenu("Account Actions");
		
		transfer_withdraw_deposit = new JMenuItem("Transfer/Withdraw/Deposit");
		sign_out = new JMenuItem("Sign Out");
		statements = new JMenuItem("View Statements");
		
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
		
		accountActions.add(transfer_withdraw_deposit);
		accountActions.add(statements);
		
		mainFrame.setVisible(true);	
		
		// go back to login page frame when clicking sign out
		sign_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				mainFrame.dispose();
			}
		});
		
		transfer_withdraw_deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoneyTransfer();
				mainFrame.dispose();
			}
		});
		
		// going to transfer/withdraw frame 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}

}
