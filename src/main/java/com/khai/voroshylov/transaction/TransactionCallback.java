package com.khai.voroshylov.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionCallback <T>{
    T execute(Connection connection) throws SQLException;
}
