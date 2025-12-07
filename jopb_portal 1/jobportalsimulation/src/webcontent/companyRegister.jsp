<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h3>Company Register</h3>
<form action="CompanyRegisterServlet" method="post">
Company Name: <input type="text" name="name" required/><br/>
Password: <input type="password" name="password" required/><br/>
<input type="submit" value="Register"/>
</form>
<%@ include file="footer.jsp" %>