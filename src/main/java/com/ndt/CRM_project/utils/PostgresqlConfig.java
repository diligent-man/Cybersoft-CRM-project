package com.ndt.CRM_project.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class PostgresqlConfig {
    // simple code so I hard-coded my db info instead of reading from env !
    private static final String PROJECT_REGION = "aws-0-ap-northeast-1";
    private static final String HOST = PROJECT_REGION + ".pooler.supabase.com";
    private static final int PORT = 5432;
    private static final String DB = "crm";
    private static final String USERNAME = "postgres.lkjfegqyfdraiahoxzxs";
    private static final String PASSWORD = "cl1PfOuuFPrCEWLX";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            String url = String.format("jdbc:postgresql://%s:%s/%s?sslmode=require",  HOST, PORT, DB);
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
