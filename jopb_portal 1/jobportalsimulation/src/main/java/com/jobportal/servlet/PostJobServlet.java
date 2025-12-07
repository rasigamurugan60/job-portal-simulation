package com.jobportal.servlet;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.Company;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class PostJobServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(false);
Company comp = (Company) session.getAttribute("company");
if (comp == null) {
response.sendRedirect("companyLogin.jsp");
return;
}
String title = request.getParameter("title");
String description = request.getParameter("description");
String requirements = request.getParameter("requirements");
Job j = new Job();
j.setCompanyId(comp.getId());
j.setTitle(title);
j.setDescription(description);
j.setRequirements(requirements);
boolean ok = JobDAO.postJob(j);
if (ok) {
request.setAttribute("msg", "Job posted successfully.");
request.getRequestDispatcher("postJob.jsp").forward(request, response);
} else {
request.setAttribute("error", "Failed to post job.");
request.getRequestDispatcher("postJob.jsp").forward(request, response);
}
}
}

