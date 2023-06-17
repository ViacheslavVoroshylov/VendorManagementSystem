package com.khai.voroshylov.connection;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class ConnectionDataBase {

    static {

        initDriver();
    }

    private static void initDriver() {

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }


    public static Connection createConnection() {

        Connection connection;

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendor_management_system", "postgres", "1234");
            log.info("Connection was created.");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return connection;
    }
}