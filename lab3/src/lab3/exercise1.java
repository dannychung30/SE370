package lab3;

import javax.swing.*;

public class exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame("Exercise 1");
		
		// creating all UI elements
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JButton button = new JButton("Login");
		
		// layout for UI elements
		t1.setBounds(150, 200, 90, 30);
		t2.setBounds(150, 295, 90, 30);
		button.setBounds(200, 20, 90, 30);
		
		// adding all UI elements to the frame
		f.add(t1);
		f.add(t2);
		f.add(button);
		
		f.setSize(400, 400);
		f.setVisible(true);
		
	}

}
