package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOimpl;
import com.model.Student;

public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            int res = dao.add(student);
            

            
    		if (res > 0) {
                out.print("<h1>SUCCESS ADD!!!</h1>");
            } else {
                out.print("<h1>FAILED TO ADD!!!</h1>");
            }
            RequestDispatcher rd=request.getRequestDispatcher("read");
    		rd.include(request, response);
        } catch (Exception e) {
            out.print("<h1>Error: AddServlet: </h1>"+e);
            e.printStackTrace();
        }
    }
}
