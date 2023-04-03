package lab3;

import javax.swing.*;

public class lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame("JFrame Example");
		JButton b = new JButton("submit");
		
		// text field example
		JTextField t1, t2;
		
		t1 = new JTextField();
		t1.setBounds(0,130,90,30);
		t2 = new JTextField();
		t2.setBounds(140,130,90,30);
		
		b.setBounds(200,130,90,30);
		
		f.add(b);
		f.add(t1);
		f.add(t2);
		
		f.setSize(400,400);
		f.setVisible(true);
		
	}

}
