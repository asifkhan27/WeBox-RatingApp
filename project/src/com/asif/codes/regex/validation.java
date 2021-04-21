package com.asif.codes.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {

	
	public boolean EmailValidation(String email)
	{
		String regex = "^(.+)@(.+)$";
		return match(regex,email);
		
	}
	
	public boolean PasswordValidation(String password)
	{
		String regex = "(?=^.{6,12}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";
		return match(regex,password);
		
	}
	private boolean match(String regex, String value )
	{
		Pattern pattern = Pattern.compile(regex);
		
	    Matcher matcher = pattern.matcher(value);
	    
	return matcher.matches();
		
	}
	
	
	

}
