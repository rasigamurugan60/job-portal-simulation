package com.jobportal.servlet;
import com.jobportal.dao.CandidateDAO;
import com.jobportal.model.Candidate;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class CandidateLoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String password = request.getParameter("password");


Candidate c = CandidateDAO.login(name, password);
if (c != null) {
HttpSession session = request.getSession();
session.setAttribute("candidate", c);
response.sendRedirect("viewJobs.jsp");
} else {
request.setAttribute("error", "Invalid credentials");
request.getRequestDispatcher("candidateLogin.jsp").forward(request, response);
}
}
}
