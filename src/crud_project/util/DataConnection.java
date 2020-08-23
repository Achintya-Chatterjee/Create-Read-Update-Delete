package crud_project.util;

import java.sql.*;
public class DataConnection {
	public static Connection getConnection() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
		return con;
	}
}
