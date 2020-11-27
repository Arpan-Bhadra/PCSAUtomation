package view;

import java.awt.*;

import javax.swing.*;

public class SetActivateFrame extends JFrame{

	Container container=null;
	public SetActivateFrame() {
		container=getContentPane();
		
		
		this.setTitle("Activate User Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
