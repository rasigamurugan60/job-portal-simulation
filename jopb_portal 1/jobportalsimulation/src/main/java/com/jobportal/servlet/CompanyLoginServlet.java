package com.jobportal.servlet;


import com.jobportal.dao.CompanyDAO;
import com.jobportal.model.Company;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class CompanyLoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String password = request.getParameter("password");
Company c = CompanyDAO.login(name, password);
if (c != null) {
HttpSession session = request.getSession();
session.setAttribute("company", c);
response.sendRedirect("postJob.jsp");
} else {
request.setAttribute("error", "Invalid credentials");
request.getRequestDispatcher("companyLogin.jsp").forward(request, response);
}
}
}

