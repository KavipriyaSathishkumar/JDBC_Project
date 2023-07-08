package connectionManager;

import java.sql.*;

public class ConnectionManager 
{
	Connection con=null;
	public Connection establishConnection() throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create connection:
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","kavi");
		return con;
	}
  public void closeConnection() throws SQLException
  {
	  con.close();
  }
}
