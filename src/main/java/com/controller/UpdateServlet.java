package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOimpl;
import com.model.Student;

import java.util.Date;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double marks = Double.parseDouble(request.getParameter("marks"));

			String dobString = request.getParameter("dob");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			Date dob = dateFormat.parse(dobString);

			Student student = new Student(id, name, marks, dob);
			StudentDAO dao = new StudentDAOimpl();

			int res = dao.update(student);
			if (res > 0) {
				out.print("<h1>UPDATE SUCCESSFULL</h1>");
			} else {
				out.print("<h1>UPDATE FAILED</h1>");
			}
			RequestDispatcher rd = request.getRequestDispatcher("read");
			rd.include(request, response);
		} catch (Exception e) {
			out.print("<h1>Error: UpdateServlet: </h1>" + e);
			e.printStackTrace();
		}
	}

}
