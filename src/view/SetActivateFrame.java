package view;

import java.awt.*;

import javax.swing.*;

public class SetActivateFrame extends JFrame{

	Container container=null;
	JFrame f;
	public SetActivateFrame() {
		container=getContentPane();
		f=new JFrame();
		JOptionPane.showMessageDialog(f,"User Activated");
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}