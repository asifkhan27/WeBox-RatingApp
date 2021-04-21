package com.asif.ui;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.border.LineBorder;

import com.asif.codes.FileManagement;

import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;


public class jjwindow {

	public static void main(String [] args) throws InterruptedException
	{
		JWindow w=new JWindow();
		w.setSize(400,250);
		w.setLocationRelativeTo(null);
		
		Icon ic = new ImageIcon(jjwindow.class.getResource("/images/splashScreen.jpg"));
		w.getContentPane().setLayout(null);
		JLabel l =new JLabel(ic);
		l.setBounds(0, 20, 400, 220);
		w.getContentPane().add(l);
		
		JProgressBar p= new JProgressBar();
		p.setLocation(0, 240);
		p.setPreferredSize(new Dimension(146, 10));
		p.setIndeterminate(true);
		p.setStringPainted(true);
		p.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		p.setBorder(new LineBorder(new Color(0, 0, 0)));
		p.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN,12));
		p.setMaximum(100);
		p.setBackground(Color.LIGHT_GRAY);
		p.setSize(400, 10);
		p.setForeground(new Color(0, 128, 128));
		w.getContentPane().add(p);
		
		JFormattedTextField frmtdtxtfldStarting = new JFormattedTextField();
		frmtdtxtfldStarting.setBounds(0, 0, 400, 20);
		frmtdtxtfldStarting.setMinimumSize(new Dimension(3, 19));
		frmtdtxtfldStarting.setSelectionColor(new Color(0, 0, 0));
		frmtdtxtfldStarting.setHorizontalAlignment(SwingConstants.LEFT);
		frmtdtxtfldStarting.setForeground(new Color(245, 255, 250));
		frmtdtxtfldStarting.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 12));
		frmtdtxtfldStarting.setBackground(new Color(72, 209, 204));
		frmtdtxtfldStarting.setEditable(false);
		frmtdtxtfldStarting.setText("WeBox_Starting.....");
		w.getContentPane().add(frmtdtxtfldStarting);
		
		URL SplashLogo=jjwindow.class.getResource("/images/SplashLogo.png");
		JLabel lblNewLabel;
		try {
			
			try {
				lblNewLabel = new JLabel(new ImageIcon(ImageIO.read(new File(SplashLogo.toURI()))
				        .getScaledInstance(200,200, Image.SCALE_SMOOTH)));
				lblNewLabel.setBounds(0, 30, 200,200);
				l.add(lblNewLabel);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		w.setVisible(true);
		String dots="";
		for(int i=0;i<=100;i=i+5)
		{	if(i%6!=0)dots=dots+" .";
			else dots="";
		frmtdtxtfldStarting.setText(" WeBox_Starting"+dots);
			
			p.setValue(i);
			Thread.sleep(200);
		}
		
		if(p.getValue()==100)
		{
			w.dispose();
			new loginpage();
			new FileManagement();
		}
		
		
		
		
	

	}

}