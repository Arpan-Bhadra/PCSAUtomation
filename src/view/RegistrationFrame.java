package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationFrame extends JFrame{

	Container container=null;
	public RegistrationFrame() {
		container=getContentPane();
		
		
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
