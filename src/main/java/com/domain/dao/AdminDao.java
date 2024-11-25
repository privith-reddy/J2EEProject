package com.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.model.Admin;
import com.domain.model.Student;

public class AdminDao 
{
	public static ArrayList<Admin> getAdminDetails() 
	{
		//JDBC code:
		ArrayList<Admin> alAdmin = new ArrayList<Admin>();
		Connection cn = null;
		Statement stm = null;
		try 
		{
			
			//Step 1: Load driver class:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//	Step 2: Establish the connection:
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_project", "root", "sadhu");
			//Step 3: Prepare sql statement:
			stm = cn.createStatement();
			//Step 4: Exceute the staement:
			ResultSet rs = stm.executeQuery("select*from admin");
			//Step 5: Read/process the data coming from the datebase:
			while(rs.next()) 
			{
				String e = rs.getString(1);
				String p = rs.getString(2);
				Admin a = new Admin(e,p);
				alAdmin.add(a);
			}
		}
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stm.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return alAdmin;
		
	}
	public static void addStudent(Student s) 
	{
		Connection cn = null;
		PreparedStatement ps = null;
		try 
		{
			
			//Step 1: Load driver class:
			Class.forName("com.mysql.cj.jdbc.Driver");
			//	Step 2: Establish the connection:
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_project", "root", "sadhu");
			//Step 3: Prepare sql statement:
			ps = cn.prepareStatement("insert into student(sname,sub,gender,email,education) values(?,?,?,?,?)");
			ps.setString(1, s.getSname());
			ps.setString(2, s.getSub());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getEducation());
			//Step 4: Exceute the staement:
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}	
	}
	public static  ArrayList<Student> getAllStudents() 
	{
		//JDBC code:
		        ArrayList<Student> alStud = new ArrayList<Student>();
				Connection cn = null;
				Statement stm = null;
				try 
				{
					
					//Step 1: Load driver class:
					Class.forName("com.mysql.cj.jdbc.Driver");
					//	Step 2: Establish the connection:
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_project", "root", "sadhu");
					//Step 3: Prepare sql statement:
					stm = cn.createStatement();
					//Step 4: Exceute the staement:
					ResultSet rs = stm.executeQuery("select*from student");
					//Step 5: Read/process the data coming from the datebase:
					while(rs.next()) 
					{
						int sno = rs.getInt(1);
						String sname = rs.getString(2);
						String sub = rs.getString(3);
						String gender = rs.getString(4);
						String email = rs.getString(5);
						String education = rs.getString(6);
						
						Student s = new Student(sno,sname,sub,gender,email,education);
						alStud.add(s);
					}
				}
				catch (ClassNotFoundException e) 
				{			
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				finally 
				{
					try 
					{
						stm.close();
						cn.close();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
				}
				return alStud;
				
	}

}
