package crud_project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_project.bean.Student;

@WebServlet(urlPatterns={"/addStud","/delStud","/updStud"})
public class StudentServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String url=req.getRequestURL().toString();
		url=url.substring(url.lastIndexOf("/")+1);
		
		String msg="";
		String redirectPage="index.jsp";
		try{
			Student stud=new Student();
			
			switch(url){
				case "addStud":					
					stud.setRollno(Integer.parseInt(req.getParameter("rollno")));
					stud.setName(req.getParameter("name"));
					stud.setEmailid(req.getParameter("emailid"));
					
					boolean added=stud.addStudent();
					if(added){
						msg="Student details added successfully...";
					}
					break;
				case "delStud":					
					stud.setRollno(Integer.parseInt(req.getParameter("rollno")));
					stud.removeStudent();
					break;
				case "updStud":
					stud.setRollno(Integer.parseInt(req.getParameter("rollno")));
					stud.setName(req.getParameter("name"));
					stud.setEmailid(req.getParameter("emailid"));
					
					stud.updateStudent();
					break;	
			}
			
		}catch(Exception ex){
			msg=ex.getMessage();
		}
		
		//req.setAttribute("msg", msg);
		//req.getRequestDispatcher(redirectPage).forward(req, resp);
		
		resp.sendRedirect(redirectPage);
	}
}

