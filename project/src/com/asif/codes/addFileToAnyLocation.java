package com.asif.codes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class addFileToAnyLocation {

	public void addFile(String addFrom, String addTo) throws IOException
	{
			FileInputStream fis=new FileInputStream(addFrom);	
			FileOutputStream fos=new FileOutputStream(addTo); 
			
			byte [] buffer=new byte[1024];
			int i=0;
			while((i=fis.read(buffer))!=-1)
			{
				fos.write(buffer,0,i);
				fos.flush();
			}
			fis.close();
			fos.close();
			
	}

}
