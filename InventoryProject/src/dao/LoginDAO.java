package dao;

import model.Login;
import java.sql.*;
import connectionManager.ConnectionManager;

public class LoginDAO
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException  {
		//1. store user input
		String username = login.getUsername();
		String password = login.getPassword();
		
		//connect java and jdbc
		ConnectionManager conm=new ConnectionManager();
		Connection con= conm.establishConnection();
		
        //Statement class:
		Statement st=con.createStatement();
		
		//ResultSet class
		ResultSet rt = st.executeQuery("select * from Login");
		while(rt.next())
		{
		    if(username.equals(rt.getString("username")) && password.equals(rt.getString("password"))){
		    		conm.closeConnection();
			   return true;
		}
		}
		
			conm.closeConnection();
			return false;
    }
}