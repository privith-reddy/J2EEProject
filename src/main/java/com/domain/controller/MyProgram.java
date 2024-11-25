package com.domain.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.dao.AdminDao;
import com.domain.model.Student;
import com.domain.model.Admin;

@WebServlet("/")
public class MyProgram extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		switch(path) 
		{
		case "/addstud":
			insertStudent(request, response);
			break;
		case "/home":
			displayHomePage(request,response);
			break;
		case "/show":
			showPage(request, response);
			break;
		case "/insert":
			displayInsertPage(request, response);
			break;
		case "/validate":
			validateAdmin(request,response);
			break;
		default:
		    displayAdminPage(request, response);
		    break;
		
		}
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the student data given by admindao:
		String n = request.getParameter("tbName");
		String s = request.getParameter("tbSub");
		String g = request.getParameter("rdGender");
		String e = request.getParameter("tbEmail");
		String ed = request.getParameter("tbEdu");
		
		// Store the above data in student object: [By calling the constructor]
		Student stud = new Student(n, s, g, e, ed);
		
		// Call the addStudent method in DAO a pass above object to it;
		AdminDao.addStudent(stud);
	}

	private void displayHomePage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response) 
	{
		ArrayList<Student> alS = AdminDao.getAllStudents();
		request.setAttribute("stud", alS);
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	
	private void displayInsertPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}

	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the data from control to validate:
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPass");
		
		ArrayList<Admin> al = AdminDao.getAdminDetails();
		
		boolean validate = false;
		for(Admin a : al) 
		{
			if(a.getEmail().equals(e) && a.getPw().equals(p)) 
			{
				validate = true;
			}	
		}
		if(validate) 
		{
			
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		else 
		{
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}	
		}
	}

	private void displayAdminPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
