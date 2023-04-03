package lab3;

import javax.swing.*;

public class JSwingExtendJFrame extends JFrame {
	JFrame f;
	
	JSwingExtendJFrame() {
		JButton b = new JButton("submit");
		b.setBounds(130, 300, 20, 90);
		
		add(b);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JSwingExtendJFrame();
		
	}

}
