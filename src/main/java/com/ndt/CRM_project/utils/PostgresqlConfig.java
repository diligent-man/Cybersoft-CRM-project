package com.ndt.CRM_project.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class PostgresqlConfig {
    // simple code so I hard-coded my db info instead of reading from env !
    private static final String HOST = "db.lkjfegqyfdraiahoxzxs.supabase.co";
    private static final int PORT = 5432;
    private static final String DB = "crm";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "cl1PfOuuFPrCEWLX";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // String url = "jdbc:mysql://localhost:5432/crm";

            String url = String.format("jdbc:postgresql://%s:%s/%s",  HOST, PORT, DB);

            Class.forName("org.postgresql.Driver");
            // Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
