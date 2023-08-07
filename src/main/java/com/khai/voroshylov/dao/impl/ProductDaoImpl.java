package com.khai.voroshylov.dao.impl;

import com.khai.voroshylov.dao.ProductDao;
import com.khai.voroshylov.dao.mapper.impl.ProductMapper;
import com.khai.voroshylov.exception.EntityNotFoundException;
import com.khai.voroshylov.model.Product;
import com.khai.voroshylov.query.QueryConstant;
import com.khai.voroshylov.transaction.TransactionManager;
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

        return TransactionManager.doInTransaction(connection1 -> {

            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.PRODUCT_GET_BY_ID)) {

                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery(QueryConstant.PRODUCT_GET_BY_ID);

                if (resultSet.next()) {
                    return productMapper.mapRow(resultSet);
                }

                LOGGER.info("Request get by id is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request get by id is failed. " + e.getMessage());
            }

            throw new EntityNotFoundException("Customer with id " + id + " not found");
        });
    }

    @Override
    public List<Product> getAll() {

        return TransactionManager.doInTransaction(connection1 -> {

            List<Product> products = new ArrayList<>();

            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery(QueryConstant.PRODUCT_GET_ALL);

                while (resultSet.next()) {

                    products.add(productMapper.mapRow(resultSet));
                }

                LOGGER.info("Request get all is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request get all is failed. " + e.getMessage());
            }

            return products;
        });
    }

    @Override
    public Product save(Product product) {

        return TransactionManager.doInTransaction(connection1 -> {

            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.PRODUCT_SAVE)) {

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

                LOGGER.error("Request save is failed. " + e.getMessage());
            }

            return product;
        });
    }

    @Override
    public Product update(Product product) {

        return TransactionManager.doInTransaction(connection1 -> {

            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.PRODUCT_UPDATE)) {

                statement.setObject(1, product.getCategory());
                statement.setString(2, product.getName());
                statement.setInt(3, product.getCount());
                statement.setDouble(4, product.getPrice());
                statement.setString(5, product.getSupplier());
                statement.setLong(6, product.getId());

                statement.executeUpdate();

                LOGGER.info("Request update is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request update is failed. " + e.getMessage());
            }

            return product;
        });
    }

    @Override
    public void deleteById(Long id) {

        TransactionManager.doInTransaction(connection1 -> {

            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.PRODUCT_DELETE_BY_ID)) {

                statement.setLong(1, id);
                statement.executeUpdate();

                LOGGER.info("Request delete by id is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request delete by id is failed. " + e.getMessage());
            }

            return true;
        });
    }

}
