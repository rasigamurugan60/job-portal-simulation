package com.jobportal.dao;



import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
private static Connection conn = null;


public static Connection getConnection() {
try {
if (conn == null || conn.isClosed()) {
Class.forName("com.mysql.cj.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/jobportalsimulation";
conn = DriverManager.getConnection(url, "root", "12345678");
}
} catch (Exception e) {
e.printStackTrace();
}
return conn;
}
}
