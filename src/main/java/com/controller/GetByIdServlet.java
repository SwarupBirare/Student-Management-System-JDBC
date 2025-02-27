package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.dao.*;

public class GetByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetByIdServlet() {
        super();
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter();
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDAO dao=new StudentDAOimpl ();
		Student res=dao.getbyid(id);
		try {
		if(res!=null) {
			out.print("<h1>STUDENT FOUND</h1>");
			out.print("<h1>"+res.getId()+"</h1>");
			out.print("<h1>"+res.getName()+"</h1>");
			out.print("<h1>"+res.getMarks()+"</h1>");
			out.print("<h1>"+res.getDob()+"</h1>");
		}
		else {
			out.print("STUDENT NOT FOUND");
		}
		}
		catch(Exception e) {
			out.print("<h1>Error: GetByIdServlet "+e);
			e.printStackTrace();
		}
	}

}
