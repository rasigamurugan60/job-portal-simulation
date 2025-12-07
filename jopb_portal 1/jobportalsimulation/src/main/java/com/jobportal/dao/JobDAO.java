package com.jobportal.dao;

import com.jobportal.model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JobDAO {
public static boolean postJob(Job j) {
boolean result = false;
String sql = "INSERT INTO jobs(company_id,title,description,requirements) VALUES(?,?,?,?)";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, j.getCompanyId());
ps.setString(2, j.getTitle());
ps.setString(3, j.getDescription());
ps.setString(4, j.getRequirements());
int i = ps.executeUpdate();
result = i > 0;
} catch (Exception e) { e.printStackTrace(); }
return result;
}


public static List<Job> getAllJobs() {
List<Job> list = new ArrayList<>();
String sql = "SELECT * FROM jobs ORDER BY posted_on DESC";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Job j = new Job();
j.setId(rs.getInt("id"));
j.setCompanyId(rs.getInt("company_id"));
j.setTitle(rs.getString("title"));
j.setDescription(rs.getString("description"));
j.setRequirements(rs.getString("requirements"));
j.setPostedOn(rs.getTimestamp("posted_on"));
list.add(j);
}
} catch (Exception e) { e.printStackTrace(); }
return list;
}
}


