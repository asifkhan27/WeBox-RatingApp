package com.asif.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class interactionJDBC extends jdbc {
	
	
	public interactionJDBC() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int insert(String name, String email, String password) throws ClassNotFoundException, SQLException
	{
		return Insert(name, email, password);
	}
	
	public boolean verifyLogin(String email,String password) throws ClassNotFoundException, SQLException
	{
		
		return check(email, password);
	}
	public String[] getsvalue(String email) throws SQLException
	{
		String[] str=getValue(email);
		return str;
	}
	public boolean update(String email,String name ,String Empid ,String deptid ,String phno ,String site ,String Address ,String bdate ,String gender,String Overview,String profileLoc) throws SQLException
	{
		return Update(email,name,Empid,deptid,phno,site,Address,bdate,gender,Overview,profileLoc);
		
	}
	public ResultSet SendQuery(String query) throws SQLException
	{	
		return getobject(query);	
	}
	public boolean checkEmail(String email) throws SQLException {
		
		return check(email);
		
	}
	public boolean changePassword(String email,String password) throws ClassNotFoundException, SQLException
	{	
		return Changepassword(email,password);
	}
	
 
}
