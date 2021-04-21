package com.asif.database;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asif.codes.FileManagement;



abstract class jdbc {
	
	private Connection con;
	private String str;
	
	 jdbc() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		
		PreparedStatement ps=con.prepareStatement("create database IF NOT EXISTS weboxdatabase");
		ps.execute();
		ps=con.prepareStatement("use weboxdatabase");
		ps.execute();
		
		str="create table IF NOT EXISTS userAccounts(email varchar(100) primary key, password varchar(50))";
		PreparedStatement smt= con.prepareStatement(str);
		smt.execute();
		
		str="create table IF NOT EXISTS userDetails(email varchar(50) primary key ,name varchar(20),Empid varchar(20),deptid varchar(20),phno varchar(15),site varchar(20),Address varchar(200),bdate varchar(15),gender varchar(6),Overview varchar(400),profileLoc varchar(200))";
		smt= con.prepareStatement(str);
		smt.execute();
		
		}
		
	
	
int Insert( String name ,String email,String password) throws ClassNotFoundException, SQLException
	{	
		boolean flaginsert=check(email);
		if(flaginsert==false)
		{
		
		str="insert into userAccounts values(?,?)";
		PreparedStatement smt= con.prepareStatement(str);
		smt.setString(1,email);
		smt.setString(2,password);
		smt.execute();
		
		str="insert into userdetails(email,name,profileLoc) values(?,?,?)";
		smt= con.prepareStatement(str);
		smt.setString(1,email);
		smt.setString(2,name);
		
		
		try {
			URL Default_Profile=jdbc.class.getResource("/images/Default_Profile.jpg");
			File FDefault_Profile = new File(Default_Profile.toURI());
			String SDefault_Profile=FDefault_Profile.toString();
			SDefault_Profile=SDefault_Profile.replace("\\","\\\\");
			smt.setString(3,SDefault_Profile);
			smt.execute();
		} catch (URISyntaxException e1) {
			System.out.print("Line no 68 "+e1);
			e1.printStackTrace();
		}
		
		
		
		File RatingData=new File(new FileManagement().ratingDataLocation,email+".txt");
		try {
			RatingData.createNewFile();
		} catch (IOException e) {
			System.out.print("Unable to create TextFile");
		}
	
		
		return 1;
		}
		else {
			
			return 2;
		}
		
	}
boolean check(String email) throws SQLException
	{	
		boolean flagcheck=false;
		PreparedStatement smt= con.prepareStatement("select*from userAccounts where email=?");
		smt.setString(1, email);
		ResultSet rst= smt.executeQuery();
		if(rst.next())
		{
			flagcheck=true;
		}
		
		return flagcheck;
	}
boolean check(String email,String password) throws SQLException   //use overloading 
	{
		
		boolean flagcheck=false;
		PreparedStatement smt= con.prepareStatement("select*from userAccounts where email=? and password=?");
		smt.setString(1, email);
		smt.setString(2, password);
		ResultSet rst= smt.executeQuery();
		if(rst.next())
		{	
			if(rst.getString(2).equals(password))
			flagcheck=true;
		}
		return flagcheck;
		
	}
	
String[] getValue(String email) throws SQLException
	{	String [] values = new String[11];
		
	 PreparedStatement smt=con.prepareStatement("select*from userdetails where email=?");
	 smt.setString(1,email);
	 ResultSet rst= smt.executeQuery();
		if(rst.next())
		{
			for(int i=1;i<12;i++)
			{	
			values[i-1]=rst.getString(i);
			}
		}
		
		return values;
	}
	
boolean Update(String email,String name ,String Empid ,String deptid ,String phno ,String site ,String Address ,String bdate ,String gender,String Overview,String profileLoc ) throws SQLException
	{
		
	 PreparedStatement smt=con.prepareStatement("update userdetails set name=?,Empid=?,deptid=?,phno=?,site=?,Address=?,bdate=?,gender=?,Overview=?,profileLoc=? where email=?");
	 smt.setString(1,name);smt.setString(2,Empid);smt.setString(3,deptid);smt.setString(4,phno);smt.setString(5,site);smt.setString(6,Address);smt.setString(7,bdate);smt.setString(8,gender);smt.setString(9,Overview);smt.setString(10,profileLoc);smt.setString(11,email);
	 smt.execute();	
	 return true;
		
	}
ResultSet getobject(String query) throws SQLException
{	
	 PreparedStatement smt=con.prepareStatement(query);
	 ResultSet result= smt.executeQuery();
	return result;
	
}
boolean Changepassword(String email,String password) throws SQLException {
	PreparedStatement smt=con.prepareStatement("update useraccounts set password =? where email=?");
	smt.setString(1,password);
	smt.setString(2,email);
	smt.execute();
	return true;
	
}

	
}
