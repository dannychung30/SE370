package bankBuddy;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class MoneyTransfer implements ActionListener {
	
	JFrame f;
	JLabel l1, l2, l3, l4;
	JButton submit, back_btn;
	JTextField amount;
	JComboBox<String> cb1, cb2, cb3;
	
	String[] choices1 = { "Transfer", "Withdraw", "Deposit"};
	String[] choices2 = { "CHECKING", "SAVING"};
	
	private String user;
	private HashMap account;
	
	MoneyTransfer(Map<String, String> account, String user) {
		this.account = (HashMap) account;
		this.user = user;
		
		// getting double values of current checking and saving account balance
		Double checking_balance = Double.parseDouble(account.get("CHECKING"));
		Double saving_balance = Double.parseDouble(account.get("SAVING"));
		
		f = new JFrame("Transfer/Withdraw/Deposit Money");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// test
			
		// choose action
		l1 = new JLabel("Choose Action: ");
		l1.setBounds(100, 50, 150, 50);
		cb1 = new JComboBox<String>(choices1);
		cb1.setBounds(250, 50, 200, 50);
		cb1.setSelectedIndex(-1);
		cb1.addActionListener(this);
		
		// from account
		l2 = new JLabel("From Account: ");
		l2.setBounds(100, 100, 150, 50);
		cb2 = new JComboBox<String>(choices2);
		cb2.setBounds(250, 100, 200, 50);
		cb2.setSelectedIndex(-1);
		cb2.addActionListener(this);

		// to account
		l3 = new JLabel("To Account: ");
		l3.setBounds(100, 150, 150, 50);
		cb3 = new JComboBox<String>(choices2);
		cb3.setBounds(250, 150, 200, 50);
		cb3.setSelectedIndex(-1);
		cb3.addActionListener(this);
		
		// enter amount
		l4 = new JLabel("Amount: $");
		l4.setBounds(100, 250, 150, 50);
		amount = new JTextField("", 255);
		amount.setBounds(170, 250, 200, 50);
		
		// submit button
		submit = new JButton("Submit");
		submit.setBounds(120, 370, 250, 50);
		
		//back button 
		back_btn = new JButton("<- Back");
		back_btn.setBounds(10, 10, 75, 25);
		
		
		f.add(l1);
		f.add(cb1);
		f.add(l2);
		f.add(cb2);
		f.add(l3);
		f.add(cb3);
		f.add(l4);
		f.add(amount);
		f.add(submit);
		f.add(back_btn);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage(account, user);
				f.dispose();
			}
		});
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double new_balance = 0.00;
				
		    	try {
		    		String action = (String) cb1.getSelectedItem();
		    		String fromAcc = (String) cb2.getSelectedItem();
		    		String toAcc = (String) cb3.getSelectedItem();
					// connecting to database
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SE370", "root", "password30");
					Statement stmt = con.createStatement();	
					
					if (action.equals("Deposit")) {
						if (toAcc == "CHECKING") {
							new_balance += Double.parseDouble(amount.getText()) + checking_balance;
							
							String deposit_withdraw_query = "UPDATE accounts SET balance = '"+new_balance+"' WHERE accounts.account_type = '"+toAcc+"' AND accounts.user = '"+user+"'";
							stmt.executeUpdate(deposit_withdraw_query);
							
							String t1 = "";
							
							JOptionPane.showMessageDialog(f, "Deposit complete!");
							
							account.replace("CHECKING", String.valueOf(new_balance));
							
							new HomePage(account, user);
							f.dispose();
						} else if (toAcc == "SAVING") {
							new_balance += Double.parseDouble(amount.getText()) + saving_balance;
							String deposit_withdraw_query = "UPDATE accounts SET balance = '"+new_balance+"' WHERE accounts.account_type = '"+toAcc+"' AND accounts.user = '"+user+"'";
							stmt.executeUpdate(deposit_withdraw_query);
							
							JOptionPane.showMessageDialog(f, "Deposit complete!");
							
							account.replace("SAVING", String.valueOf(new_balance));
							
							new HomePage(account, user);
							f.dispose();
						}
				    } 
				   if (action.equals("Withdraw")) {
						if (fromAcc == "CHECKING") {
							new_balance += checking_balance - Double.parseDouble(amount.getText());
							String deposit_withdraw_query = "UPDATE accounts SET balance = '"+new_balance+"' WHERE accounts.account_type = '"+fromAcc+"' AND accounts.user = '"+user+"'";
							stmt.executeUpdate(deposit_withdraw_query);
							
							JOptionPane.showMessageDialog(f, "Withdrawal complete!");
							
							account.replace("CHECKING", String.valueOf(new_balance));
							
							new HomePage(account, user);
							f.dispose();
						} else if (fromAcc == "SAVING") {
							new_balance += saving_balance - Double.parseDouble(amount.getText()); 
							String deposit_withdraw_query = "UPDATE accounts SET balance = '"+new_balance+"' WHERE accounts.account_type = '"+fromAcc+"' AND accounts.user = '"+user+"'";
							stmt.executeUpdate(deposit_withdraw_query);
							
							JOptionPane.showMessageDialog(f, "Withdrawal complete!");
							
							account.replace("SAVING", String.valueOf(new_balance));
							
							new HomePage(account, user);
							f.dispose();
						}
					} 
				   if (action.equals("Transfer")) {
					   if (fromAcc == "CHECKING" && toAcc == "SAVING") {
						   // subtract money from checking account
						   Double new_balance_checking = checking_balance - Double.parseDouble(amount.getText());
						   // add money to saving account
						   Double new_balance_saving = saving_balance + Double.parseDouble(amount.getText());
						   
						   String update_checking_query = "UPDATE accounts SET balance = '"+new_balance_checking+"' WHERE user = '"+user+"' AND account_type = '"+fromAcc+"'";
						   String update_saving_query = "UPDATE accounts SET balance = '"+new_balance_saving+"' WHERE user = '"+user+"' AND account_type = '"+toAcc+"'";
						   
						   stmt.executeUpdate(update_checking_query);
						   stmt.executeUpdate(update_saving_query);
						   
							JOptionPane.showMessageDialog(f, "Transfer complete!");
							
							account.replace("CHECKING", String.valueOf(new_balance_checking));
							account.replace("SAVING", String.valueOf(new_balance_saving));
							
							new HomePage(account, user);
							f.dispose();
						   
					   } else if (fromAcc == "SAVING" && toAcc == "CHECKING") {
						   // subtract money from saving account
						   Double new_balance_saving = saving_balance - Double.parseDouble(amount.getText());
						   // add money to checking account
						   Double new_balance_checking = checking_balance + Double.parseDouble(amount.getText());
						   
						   String update_checking_query = "UPDATE accounts SET balance = '"+new_balance_checking+"' WHERE user = '"+user+"' AND account_type = '"+toAcc+"'";
						   String update_saving_query = "UPDATE accounts SET balance = '"+new_balance_saving+"' WHERE user = '"+user+"' AND account_type = '"+fromAcc+"'";
						   
						   stmt.executeUpdate(update_checking_query);
						   stmt.executeUpdate(update_saving_query);
						   
							JOptionPane.showMessageDialog(f, "Transfer complete!");
							
							account.replace("CHECKING", String.valueOf(new_balance_checking));
							account.replace("SAVING", String.valueOf(new_balance_saving));
							
							new HomePage(account, user);
							f.dispose();
						   
					   }
						
					}
				} catch(Exception error) {
					System.out.print(error);
				}
			}
		});
	
	}

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//new MoneyTransfer();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = (String) cb1.getSelectedItem();
		String fromAcc = (String) cb2.getSelectedItem();
		String toAcc = (String) cb3.getSelectedItem();
		
		// if user chooses to deposit money:
		if(action.equals("Deposit")) {
			// remove JComboBox from account
			f.add(cb3);
			f.remove(cb2);
			f.revalidate();
	    	f.repaint();
		}
		
		// if user chooses to withdraw money:
	    if(action.equals("Withdraw")) {
	    	// remove JComboBox to account
	    	f.add(cb2);
	    	f.remove(cb3);
	    	f.revalidate();
	    	f.repaint();
	    } 
	    // if user chooses to transfer money:
	    if(action.equals("Transfer")) {
	    	// keep to account
	    	f.add(cb3);
	    	f.add(cb2);
	    } 
	    
	    // once user chooses from account remove other option on to account
	    if(action.equals("Transfer") && fromAcc == "CHECKING") {
	    	cb3.setSelectedItem("SAVING");
	    }
	    if(action.equals("Transfer") && fromAcc == "SAVING") {
	    	cb3.setSelectedItem("CHECKING");
	    }
	    
	    
	}
	    	
	    
	   
	}
