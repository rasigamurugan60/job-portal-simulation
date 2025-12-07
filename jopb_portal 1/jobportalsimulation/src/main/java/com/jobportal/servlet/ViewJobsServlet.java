package com.jobportal.servlet;


import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class ViewJobsServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Job> jobs = JobDAO.getAllJobs();
request.setAttribute("jobs", jobs);
request.getRequestDispatcher("viewJobs.jsp").forward(request, response);
}
}

