package com.ndt.CRM_project.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConfig {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/crm";
            String user = "root";
            String password = "Root123!";

            Class.forName("com.mysql.cj.jdbc.Driver");
            // Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            // Hot-fix for using free hosting service from Supabase !
            try {
                conn = PostgresqlConfig.getConnection();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
        return conn;
    }
}
