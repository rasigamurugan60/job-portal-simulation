package com.jobportal.servlet;
import com.jobportal.dao.CandidateDAO;
import com.jobportal.model.Candidate;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class CandidateRegisterServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String password = request.getParameter("password");
String qualifications = request.getParameter("qualifications");
String skills = request.getParameter("skills");
int experience = Integer.parseInt(request.getParameter("experience"));


Candidate c = new Candidate();
c.setName(name);
c.setPassword(password);
c.setQualifications(qualifications);
c.setSkills(skills);
c.setExperienceYears(experience);


boolean ok = CandidateDAO.register(c);
if (ok) {
request.setAttribute("msg", "Registration successful. Please login.");
request.getRequestDispatcher("candidateLogin.jsp").forward(request, response);
} else {
request.setAttribute("error", "Registration failed. Try again.");
request.getRequestDispatcher("candidateRegister.jsp").forward(request, response);
}
}
}

