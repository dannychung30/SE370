package bankBuddy;
import javax.swing.*;
import java.awt.event.*;

public class MoneyTransfer implements ActionListener {
	
	JLabel l1, l2, l3, l4;
	JTextField amount;
	JComboBox<String> cb1, cb2, cb3;
	
	
	MoneyTransfer() {
		JFrame f = new JFrame("Transfer/Withdraw Money");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String[] choices1 = { "Transfer", "Withdraw"};
		String[] choices2 = {"Checkings", "Savings"};
		
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

		// to account
		l3 = new JLabel("To Account: ");
		l3.setBounds(100, 150, 150, 50);
		cb3 = new JComboBox<String>(choices2);
		cb3.setBounds(250, 150, 200, 50);
		cb3.setSelectedIndex(-1);
		
		// enter amount
		l4 = new JLabel("Amount: $");
		l4.setBounds(100, 250, 150, 50);
		amount = new JTextField("", 255);
		amount.setBounds(170, 250, 200, 50);
		
		
		f.add(l1);
		f.add(cb1);
		f.add(l2);
		f.add(cb2);
		f.add(l3);
		f.add(cb3);
		f.add(l4);
		f.add(amount);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
	
	}

	public static void main(String[] args) {
		
		new MoneyTransfer();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = (String) cb1.getSelectedItem();
	    System.out.println(action);
		
	}

}
