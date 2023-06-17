package com.khai.voroshylov.dao.impl;

import com.khai.voroshylov.dao.ProductDao;
import com.khai.voroshylov.dao.mapper.impl.ProductMapper;
import com.khai.voroshylov.model.Product;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    final static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
    private Connection connection;

    ProductMapper productMapper = new ProductMapper();

    public ProductDaoImpl() {

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendor_management_system",
                    "postgres", "1234");

            LOGGER.info("Connection to database is done.");

        } catch (ClassNotFoundException | SQLException e) {

            LOGGER.error("Connection to database is failure. " + e);
        }
    }

    @Override
    public Product getById(Long id) {

        Product product = null;
        String sql = "SELECT * FROM management_system.product WHERE id = " + id;

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                product = productMapper.mapRow(resultSet);
            }

            LOGGER.info("Request get by id is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request get by id is failed. " + e);
        }

        return product;
    }

    @Override
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM management_system.product";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                products.add(productMapper.mapRow(resultSet));
            }

            LOGGER.info("Request get all is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request get all is failed. " + e);
        }
        return products;
    }

    @Override
    public Product save(Product product) {

        String sql = "INSERT INTO management_system.product (category, name, count, price, supplier) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, product.getCategory());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getCount());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getSupplier());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {

                product.setId(generatedKeys.getLong(1));
            }

            LOGGER.info("Request save is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request save is failed. " + e);
        }

        return product;
    }

    @Override
    public Product update(Product product) {

        String sql = "UPDATE management_system.product SET category = ?, name = ?, count = ?, price = ?, supplier = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, product.getCategory());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getCount());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getSupplier());
            statement.setLong(6, product.getId());

            statement.executeUpdate();

            LOGGER.info("Request update is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request update is failed. " + e);
        }

        return product;
    }

    @Override
    public void deleteById(Long id) {

        String sql = "DELETE FROM management_system.product WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

            LOGGER.info("Request delete by id is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request delete by id is failed. " + e);
        }

    }

}
