package com.khai.voroshylov.transaction;

import com.khai.voroshylov.connection.ConnectionDataBase;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j
public class TransactionManager {

    public static <T> T doInTransaction(TransactionCallback <T> callback) {

        T result = null;

        try (Connection connection = ConnectionDataBase.createConnection()) {

            connection.setAutoCommit(false);

            result = callback.execute(connection);
            connection.commit();
            log.info("Connection is committed");

        } catch (SQLException e) {

            log.info("TransactionManager had error");
            log.error(e.getMessage());
        }

        return result;
    }
}
