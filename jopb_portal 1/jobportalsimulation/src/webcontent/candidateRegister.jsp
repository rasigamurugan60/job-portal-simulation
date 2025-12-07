<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h3>Candidate Register</h3>
<form action="CandidateRegisterServlet" method="post">
Name: <input type="text" name="name" required/><br/>
Password: <input type="password" name="password" required/><br/>
Qualifications: <input type="text" name="qualifications"/><br/>
Skills: <input type="text" name="skills"/><br/>
Experience (years): <input type="number" name="experience" min="0" value="0"/><br/>
<input type="submit" value="Register"/>
</form>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<c:if test="${not empty msg}"><div style="color:green">${msg}</div></c:if>
<%@ include file="footer.jsp" %>