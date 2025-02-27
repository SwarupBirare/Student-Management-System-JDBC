package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOimpl;
import com.model.Student;

public class SortByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SortByIdServlet() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		StudentDAO dao=new StudentDAOimpl ();
		List<Student>list=dao.sortById();
		Iterator<Student>itr=list.iterator();
		out.print("<head>");
		out.print("<link rel='stylesheet' href='./CSS/Read.css'>");
		out.print("</head>");
		out.print("<table id='customers' >");
		out.print("<tr>");
		out.print("<th>id</th>");
		out.print("<th>name</th>");	
		out.print("<th>marks</th>");
		out.print("<th>dob</th>");
		out.print("</tr>");
		while(itr.hasNext())
		{
			Student student=(Student)itr.next();
			out.print("<tr>");
			out.print("<td>"+student.getId()+"</td>");
			out.print("<td>"+student.getName()+"</td>");
			out.print("<td>"+student.getMarks()+"</td>");
			out.print("<td>"+student.getDob()+"</td>");
			out.print("</td>");
		}
		out.print("</table>");
	}

}
