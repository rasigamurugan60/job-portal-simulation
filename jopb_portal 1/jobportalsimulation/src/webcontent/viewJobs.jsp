<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%
// Acquire jobs list - either use servlet to forward or call DAO here (we used servlet ViewJobsServlet recommended)
List<Job> jobs = (List<Job>) request.getAttribute("jobs");
%>
<h3>Available Jobs</h3>
<% if (jobs == null) { %>
<p>No jobs to show. <a href="ViewJobsServlet">Refresh</a></p>
<% } else { %>
<ul>
<% for (Job j : jobs) { %>
<li>
<strong><%= j.getTitle() %></strong> - <%= j.getRequirements() %><br/>
<small>Posted on: <%= j.getPostedOn() %></small>
<p><%= j.getDescription() %></p>
</li>
<% } %>
</ul>
<% } %>
<%@ include file="footer.jsp" %>

