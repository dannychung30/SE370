package bankBuddy;
import javax.swing.*;
import java.awt.event.*;

public class MoneyTransfer implements ActionListener {
	
	JFrame f;
	JLabel l1, l2, l3, l4;
	JButton submit;
	JTextField amount;
	JComboBox<String> cb1, cb2, cb3;
	
	String[] choices1 = { "Transfer", "Withdraw"};
	String[] choices2 = { "Checkings", "Savings"};
	
	
	MoneyTransfer() {
		f = new JFrame("Transfer/Withdraw Money");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
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
		
		
		f.add(l1);
		f.add(cb1);
		f.add(l2);
		f.add(cb2);
		f.add(l3);
		f.add(cb3);
		f.add(l4);
		f.add(amount);
		f.add(submit);
		
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
		String fromAcc = (String) cb2.getSelectedItem();
		
		// if user chooses to withdraw money:
	    if(action.equals("Withdraw")) {
	    	// remove JComboBox to account
	    	f.remove(cb3);
	    	f.revalidate();
	    	f.repaint();
	    } 
	    // if user chooses to transfer money:
	    if(action.equals("Transfer")) {
	    	// keep to account
	    	f.add(cb3);
	    	
	    	// once user chooses from account remove other option on to account
	    	if(fromAcc.equals("Savings")) {
		    	cb3.setSelectedItem("Checkings");
		    	//f.add(cb3);
		    	
		    }
	    	if(fromAcc.equals("Checkings")) {
	    		cb3.setSelectedItem("Savings");
		    	//f.add(cb3);
	    	}
	    	
	    }
	   
	}

}
