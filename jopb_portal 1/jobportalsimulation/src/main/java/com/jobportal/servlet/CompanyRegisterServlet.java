package com.jobportal.servlet;

import com.jobportal.dao.CompanyDAO;
import com.jobportal.model.Company;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class CompanyRegisterServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String password = request.getParameter("password");
Company c = new Company();
c.setName(name);
c.setPassword(password);
boolean ok = CompanyDAO.register(c);
if (ok) {
request.setAttribute("msg", "Company registered. Please login.");
request.getRequestDispatcher("companyLogin.jsp").forward(request, response);
} else {
request.setAttribute("error", "Registration failed.");
request.getRequestDispatcher("companyRegister.jsp").forward(request, response);
}
}
}

