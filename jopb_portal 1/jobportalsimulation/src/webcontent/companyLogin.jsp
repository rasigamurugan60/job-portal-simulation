<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h3>Company Login</h3>
<form action="CompanyLoginServlet" method="post">
Company Name: <input type="text" name="name" required/><br/>
Password: <input type="password" name="password" required/><br/>
<input type="submit" value="Login"/>
</form>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<%@ include file="footer.jsp" %>