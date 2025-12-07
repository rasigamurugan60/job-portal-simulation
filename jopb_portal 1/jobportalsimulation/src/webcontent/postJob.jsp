<%@ page import="com.jobportal.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>



<%
    // Get the company object from session
    Company comp = (Company) session.getAttribute("company");

    // If not logged in → redirect to login page
    if (comp == null) {
        response.sendRedirect("companyLogin.jsp");
        return;
    }
%>

<h3>Post Job (Company: <%= comp.getName() %>)</h3>

<form action="PostJobServlet" method="post">

    Job Title: <input type="text" name="title" required><br><br>

    Description:<br>
    <textarea name="description" rows="4" cols="40" required></textarea><br><br>

    Requirements: <input type="text" name="requirements" required><br><br>

    <input type="submit" value="Post Job">
</form>

<!-- Success message -->
<c:if test="${not empty msg}">
    <div style="color:green;">${msg}</div>
</c:if>

<!-- Error message -->
<c:if test="${not empty error}">
    <div style="color:red;">${error}</div>
</c:if>

<%@ include file="footer.jsp" %>