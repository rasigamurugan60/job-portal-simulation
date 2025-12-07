package com.jobportal.dao;

import com.jobportal.model.Company;
import java.sql.*;


public class CompanyDAO {
public static boolean register(Company c) {
boolean result = false;
String sql = "INSERT INTO companies(name,password) VALUES(?,?)";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, c.getName());
ps.setString(2, c.getPassword());
int i = ps.executeUpdate();
result = i > 0;
} catch (Exception e) { e.printStackTrace(); }
return result;
}


public static Company login(String name, String password) {
Company c = null;
String sql = "SELECT * FROM companies WHERE name=? AND password=?";
try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, name);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
c = new Company();
c.setId(rs.getInt("id"));
c.setName(rs.getString("name"));
c.setPassword(rs.getString("password"));
}
} catch (Exception e) { e.printStackTrace(); }
return c;
}
}

