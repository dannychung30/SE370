package lab3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionListenerExample implements ActionListner {
	JTextField t1, t2;
	JButton b;
	
	ActionListenerExample() {
		JFrame f = new JFrame();
		
		t1 = new JTextField();
		t1.setBounds(100,130,90,30);
		t2 = new JTextField();
		t2.setBounds(130,130,90,30);
		
		b = new JButton();
		b.setBounds(230,130,40,30);
		
		b.addActionListener((ActionListener) this);
		
		f.add(t1);
		f.add(t2);
		f.add(b);
		
		f.setSize(400,400);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
	}
	
	public static void main(String args[]) {
		ActionListenerExample();
	}

}

