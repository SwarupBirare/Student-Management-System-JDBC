package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOimpl;
import com.model.Student;

@WebServlet("/StudentUpdateForm")
public class StudentUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;

	public StudentUpdateForm() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		dao = new StudentDAOimpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<head>");
		out.print("<link rel='stylesheet' href='./CSS/Form.css'>");
		out.print("</head>");
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = dao.getbyid(id);
		if (student != null) {
			out.print("<form action='update' method='get'>");
			out.print("ID:- <input type='text' name='id' value='" + student.getId() + "'readonly><br>");
			out.print("NAME:- <input type='text' name='name' value='" + student.getName() + "'><br>");
			out.print("MARKS:- <input type='text' name='marks' value='" + student.getMarks() + "'><br>");
			 out.print("DOB:- <input type='text' name='dob' value='" + student.getDob() +"'><br>");
			out.print("<input type='submit' value='UPDATE'>");
			out.print("</form>");

		} else {
			out.print("<h1>" + "Record Not Found " + "</h1>");
		}
	}
}
