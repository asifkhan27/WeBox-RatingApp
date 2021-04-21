package com.asif.codes;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GetImageLoc{
	
	public String getpath() {
	
		JFileChooser jfc=new JFileChooser();
		
		FileNameExtensionFilter imagefilter=new FileNameExtensionFilter("Image Files",ImageIO.getReaderFileSuffixes());
		jfc.setFileFilter(imagefilter);
		
		int returnval=jfc.showOpenDialog(jfc);
		
		String path=null;
		
		if(returnval==JFileChooser.APPROVE_OPTION)
		{
			path=jfc.getSelectedFile().getAbsolutePath();
			return path;
		}
		else
		{
			return "";
		}
		

	}

}
