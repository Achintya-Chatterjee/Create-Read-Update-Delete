package crud_project.bean;

import java.sql.*;
import java.util.ArrayList;

import crud_project.util.DataConnection;


public class Student {
	private int rollno;
        private String name;
	
	private String emailid;
	private Connection con;
	
	public Student() throws SQLException{
		con=DataConnection.getConnection();
	}
	
	public void closeConnection() throws SQLException{
		con.close();
	}
	
	public boolean addStudent() throws SQLException{
		String sql="insert into stud_records(rollno,name,emailid) values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, rollno);
		ps.setString(2, name);
		ps.setString(3, emailid);
		
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	public boolean removeStudent() throws SQLException{
		String sql="delete from stud_records where rollno=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, rollno);
		
		
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	public boolean updateStudent() throws SQLException{
		String sql="update stud_records set name=?,emailid=? where rollno=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, emailid);
		ps.setInt(3, rollno);
		
		int xx=ps.executeUpdate();
		
		return xx>0;
		
	}
	
	public ArrayList<Student> getAllStudents() throws SQLException{
		String sql="select * from stud_records";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		ArrayList<Student> studs=new ArrayList<Student>();
		
		while(rs.next()){
			Student stud=new Student();
			stud.setRollno(rs.getInt("rollno"));
			stud.setName(rs.getString("name"));
			stud.setEmailid(rs.getString("emailid"));
			
			studs.add(stud);
		}
		return studs;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

}
