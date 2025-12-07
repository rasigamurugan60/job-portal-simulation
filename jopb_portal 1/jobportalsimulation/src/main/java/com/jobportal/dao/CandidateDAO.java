package com.jobportal.dao;
import com.jobportal.model.Candidate;
import java.sql.*;


public class CandidateDAO {
public static boolean register(Candidate c) {
boolean result = false;
String sql = "INSERT INTO candidates(name,password,qualifications,skills,experience_years) VALUES(?,?,?,?,?)";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, c.getName());
ps.setString(2, c.getPassword());
ps.setString(3, c.getQualifications());
ps.setString(4, c.getSkills());
ps.setInt(5, c.getExperienceYears());
int i = ps.executeUpdate();
result = i > 0;
} catch (Exception e) { e.printStackTrace(); }
return result;
}


public static Candidate login(String name, String password) {
Candidate c = null;
String sql = "SELECT * FROM candidates WHERE name=? AND password=?";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, name);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
c = new Candidate();
c.setId(rs.getInt("id"));
c.setName(rs.getString("name"));
c.setPassword(rs.getString("password"));
c.setQualifications(rs.getString("qualifications"));
c.setSkills(rs.getString("skills"));
c.setExperienceYears(rs.getInt("experience_years"));
}
} catch (Exception e) { e.printStackTrace(); }
return c;
}


}
