package com.khai.voroshylov.dao.mapper.impl;

import com.khai.voroshylov.dao.mapper.RowMapper;
import com.khai.voroshylov.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet resultSet) throws SQLException {

            return Customer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .country(resultSet.getString("country"))
                    .city(resultSet.getString("city"))
                    .lastOrderDate(resultSet.getDate("last order date"))
                    .email(resultSet.getString("email"))
                    .phone(resultSet.getString("phone"))
                    .orderCount(resultSet.getInt("order count"))
                    .build();
    }

}
