package com.asif.codes;

import java.io.File;
import java.io.IOException;

public class FileManagement {
	public File profilePicLocation;
	public File ratingDataLocation;

	public FileManagement() 
	{
		File [] GetRoots=File.listRoots();
		File Root;
		
		if(GetRoots.length>1)
		{
			Root=GetRoots[1];
		}
		else 
		{
			Root=GetRoots[0];
		}
		profilePicLocation(Root);
		ratingDataLocation(Root);
		
		
	}
	
	public void profilePicLocation(File Root)
	{
		profilePicLocation=new File(Root,"Webox\\data\\Profile Pictures");
		if(!profilePicLocation.exists())
		{
		profilePicLocation.mkdirs();
		}
	
	}
	
	public void ratingDataLocation(File Root)
	{
		ratingDataLocation=new File(Root,"Webox\\data\\Rating data");
		if(!ratingDataLocation.exists())
		{
		ratingDataLocation.mkdirs();
		}
		
	}
}
