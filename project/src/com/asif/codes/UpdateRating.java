package com.asif.codes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JRadioButton;

public class UpdateRating {
	private int value;
	private String UserEmail;
	
	public void UpdateValues(String email,JRadioButton [][] Rbutton,String[] useremails)
	{
		for(int i=0;i<Rbutton.length;i++)
		{
			if(Rbutton[i][4].isSelected())
			{
				value=100;
				UserEmail=useremails[i];
				EditValue(email);
				
			}
			else if(Rbutton[i][3].isSelected())
			{
				value=80;
				UserEmail=useremails[i];
				EditValue(email);
			}
			else if(Rbutton[i][2].isSelected())
			{
				value=60;
				UserEmail=useremails[i];
				EditValue(email);
			}
			else if(Rbutton[i][1].isSelected())
			{
				value=40;
				UserEmail=useremails[i];
				EditValue(email);
			}
			else if(Rbutton[i][0].isSelected())
			{
				value=20;
				UserEmail=useremails[i];
				EditValue(email);
			}
			
			
		}
	}
	
	public void EditValue(String email)
	{	boolean flag=false;
		
		File path=new File(new FileManagement().ratingDataLocation,UserEmail+".txt");
		try(BufferedReader bfr=new BufferedReader(new FileReader(path))) {
			StringBuffer sb=new StringBuffer();
			String Line;
			
			while((Line=bfr.readLine())!=null)
			{
				String temp[]=Line.split(" ");
				
				if(temp[0].equals(email)) 
				{
					Line=email+" "+value;
					flag=true;
				}
				sb.append(Line);
				sb.append("\n");
			}
			if(flag==true)
			{
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(sb.toString().getBytes());
				fos.close();
			}
			if(flag==false)
			{
				BufferedWriter bfw=new BufferedWriter(new FileWriter(path,true));
				bfw.write(email+" "+value);
				bfw.newLine();
				bfw.close();
			}
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
