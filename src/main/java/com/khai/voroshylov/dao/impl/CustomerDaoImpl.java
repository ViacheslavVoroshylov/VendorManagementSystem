package com.khai.voroshylov.dao.impl;

import com.khai.voroshylov.dao.CustomerDao;
import com.khai.voroshylov.dao.mapper.impl.CustomerMapper;
import com.khai.voroshylov.model.Customer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao {

    final static Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class);
    private Connection connection;

    CustomerMapper customerMapper = new CustomerMapper();


    @Override
    public Customer getById(Long id) {



        Customer customer = null;
        String sql = "SELECT * FROM management_system.customer WHERE id = " + id;

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                customer = customerMapper.mapRow(resultSet);
            }

            LOGGER.info("Request get by id is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request get by id is failed. " + e);
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() {

        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM management_system.customer";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                customers.add(customerMapper.mapRow(resultSet));
            }

            LOGGER.info("Request get all is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request get all is failed. " + e);
        }

        return customers;
    }

    @Override
    public Customer save(Customer customer) {

        String sql = "INSERT INTO management_system.customer (name, country, city, last_order_date, email, phone, order_count) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCountry());
            statement.setString(3, customer.getCity());
            statement.setDate(4, (Date) customer.getLastOrderDate());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPhone());
            statement.setInt(7, customer.getOrderCount());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {

                customer.setId(generatedKeys.getLong(1));
            }

            LOGGER.info("Request save is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request save is failed. " + e);
        }

        return customer;
    }

    @Override
    public Customer update(Customer customer) {

        String sql = "UPDATE management_system.customer SET name = ?, country = ?, city = ?, last_order_date = ?, email = ?, phone = ?, order_count = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCountry());
            statement.setString(3, customer.getCity());
            statement.setDate(4, (Date) customer.getLastOrderDate());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPhone());
            statement.setInt(7, customer.getOrderCount());
            statement.setLong(8, customer.getId());

            statement.executeUpdate();

            LOGGER.info("Request update is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request update is failed. " + e);
        }

        return customer;
    }

    @Override
    public void deleteById(Long id) {

        String sql = "DELETE FROM management_system.customer WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

            LOGGER.info("Request delete by id is succeeded.");

        } catch (SQLException e) {

            LOGGER.error("Request delete by id is failed. " + e);
        }
    }
}
