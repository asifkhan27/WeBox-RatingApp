package com.asif.database.Sendmail;

public class interactionEmail extends SendEmail{
	
	private String subject;
	private String body;
	
	public void createAccount(String email,String name)
	{
		
		
		subject="Welcome to WeBox!";
		body=" \r\n" + 
				"Hello "+ name+"\r\n" + 
				"Your account has been successfully created on WeBox. \r\n" + 
				"Hope you enjoy our service. \r\n" + 
				"For any clarifications or to know more about WeBox, please contact us on weboxservices06@gmail.com, and a relationship manager will be glad to assist you. " + 
				" \r\n" + 
				"Regards,\r\n" + 
				"WeBox Admin.\r\n" + 
				"The WeBox Team.\r\n" + 
				"";
	start(email,subject,body);
		}
	
	public String recoverPassword(String email)
	{	
		int temp=(int)(Math.random()*(10000-1000+1)+1000);
		subject="WeBox Password Recovery";
		body=" \r\n" + 
				"Hello \r\n" + 
				"We've received a request to reset your password. \r\n" + 
				"If you didn't make the request ,just ignore this mail.\r\n" + 
				"Otherwise, you can reset your password using the OTP provided below \r\n" +"\t\t\t\t\t\t'"+ 
				temp+
				"' \r\n" + 
				"Thanks,\r\n" + 
				"The WeBox Team.\r\n" + 
				"";
		boolean flag =start(email,subject,body);
		if(flag==true) return String.valueOf(temp);
		else return null;
		
																				
	
	}

}

