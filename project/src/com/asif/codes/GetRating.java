package com.asif.codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetRating {
	private String Line;
	private String[] temp;
	private int arr[]=new int[2];
	private int sum=0,counter=0;
	
public int[] getValue(String UserEmail){
	File  path=new File(new FileManagement().ratingDataLocation,UserEmail+".txt"); 
	try(BufferedReader bfr=new BufferedReader(new FileReader(path))) {
	
				
	
				while((Line=bfr.readLine())!=null)
				{
					temp=Line.split(" ");
					sum=sum+Integer.parseInt(temp[1]);
					counter++;
					
				}
				arr[0]=sum;
				arr[1]=counter;
				
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return arr;
	}
}
