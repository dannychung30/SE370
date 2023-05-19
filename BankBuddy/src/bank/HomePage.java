package bank;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class HomePage {
	
	JLabel greeting, checking, saving;
	JMenuItem transfer_withdraw_deposit, statements, sign_out;
	private HashMap account;
	private String username;
	
	HomePage(Map<String, String> account, String username) {
		
		this.account = (HashMap) account;
		this.username = username;
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		// grabbing the checking's and saving's account balances from
		// the account hashmap and setting them to separate variables
		String checking_balance = account.get("CHECKING");
		String saving_balance = account.get("SAVING");
		
		JFrame mainFrame = new JFrame("Welcome, '"+username+"'");
	
		JPanel mainPanel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu accountActions = new JMenu("Account Actions");
		
		transfer_withdraw_deposit = new JMenuItem("Transfer/Withdraw/Deposit");
		sign_out = new JMenuItem("Sign Out");
		statements = new JMenuItem("View Statements");
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(500, 500);
		
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setSize(500, 400);
		
		menuBar.setLayout(new BorderLayout());
		menuBar.setPreferredSize(new Dimension(400, 50));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// checking account
		JLabel checking = new JLabel("<html><strong>Checking: </strong>'"+df.format(Double.parseDouble(checking_balance))+"'</html>");
		checking.setFont(new Font("Arial", Font.PLAIN, 40));
		gbc.gridx = 1;
		gbc.gridy = 1;
		mainPanel.add(checking, gbc);
		
		// saving account
		JLabel saving = new JLabel("<html><strong>Saving: </strong>'"+df.format(Double.parseDouble(saving_balance))+"'</html>");
		saving.setFont(new Font("Arial", Font.PLAIN, 40));
		gbc.gridx = 1;
		gbc.gridy = 2;
		mainPanel.add(saving, gbc);
		
		mainFrame.add(mainPanel, BorderLayout.NORTH);
		mainFrame.add(menuBar, BorderLayout.SOUTH);
		
		menuBar.add(accountActions, BorderLayout.WEST);
		menuBar.add(sign_out, BorderLayout.EAST);
		
		accountActions.add(transfer_withdraw_deposit);
		accountActions.add(statements);
		
		//mainPanel.setBackground(Color.BLUE);
		
		mainFrame.setVisible(true);	
		
		// go back to login page frame when clicking sign out
		sign_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				mainFrame.dispose();
			}
		});
		
		// going to transfer/withdraw frame 
		transfer_withdraw_deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoneyTransfer(account, username);
				mainFrame.dispose();
			}
		});
		
		// going to view statements frame
		statements.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//new MonthlyStatements();
				mainFrame.dispose();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new HomePage();
	}
}