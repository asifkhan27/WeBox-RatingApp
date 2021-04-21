package com.asif.codes;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class wait {
	private JTextField txtWait;

	public JWindow waiting() throws IOException
	{
		JWindow jw=new JWindow();
		jw.setSize(180,130);
		jw.setAlwaysOnTop(true);
		jw.setLocationRelativeTo(null);
		jw.getContentPane().setLayout(null);
		
		JLabel jl=new JLabel(new ImageIcon(wait.class.getResource("/images/spinner3.gif")));
		jl.setLocation(0, 0);
		jl.setBorder(new LineBorder(Color.BLUE, 1, true));
		jl.setSize(180,130);
		jw.getContentPane().add(jl);
		
		txtWait = new JTextField();
		txtWait.setForeground(Color.BLUE);
		txtWait.setBorder(null);
		txtWait.setHorizontalAlignment(SwingConstants.CENTER);
		txtWait.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtWait.setText("Please Wait...");
		txtWait.setBounds(18,90, 139,25);
		txtWait.setColumns(10);
		jl.add(txtWait);
		
		jw.setVisible(true);
		return jw;
	
	}
public static void main(String[] args) {
	try {
		new wait().waiting();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
