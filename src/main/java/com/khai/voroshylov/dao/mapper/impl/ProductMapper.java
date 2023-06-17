package com.khai.voroshylov.dao.mapper.impl;

import com.khai.voroshylov.dao.mapper.RowMapper;
import com.khai.voroshylov.model.Product;
import com.khai.voroshylov.model.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet) throws SQLException {

        return Product.builder()
                .id(resultSet.getLong("id"))
                .category((ProductCategory) resultSet.getObject("category"))
                .name(resultSet.getString("name"))
                .count(resultSet.getInt("count"))
                .price(resultSet.getDouble("price"))
                .supplier(resultSet.getString("supplier"))
                .build();
    }
}
