package com.khai.voroshylov.dao.impl;

import com.khai.voroshylov.dao.CustomerDao;
import com.khai.voroshylov.dao.mapper.impl.CustomerMapper;
import com.khai.voroshylov.exception.EntityNotFoundException;
import com.khai.voroshylov.model.Customer;
import com.khai.voroshylov.query.QueryConstant;
import com.khai.voroshylov.transaction.TransactionManager;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    final static Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class);

    CustomerMapper customerMapper = new CustomerMapper();


    @Override
    public Customer getById(Long id) {

        return TransactionManager.doInTransaction( connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.CUSTOMER_GET_BY_ID)) {

                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery(QueryConstant.CUSTOMER_GET_BY_ID);

                if (resultSet.next()) {
                    return customerMapper.mapRow(resultSet);
                }

                LOGGER.info("Request get by id is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request get by id is failed. " + e.getMessage());
            }

            throw new EntityNotFoundException("Customer with id " + id + " not found");
        });

    }

    @Override
    public List<Customer> getAll() {

        return TransactionManager.doInTransaction(connection -> {

            List<Customer> customers = new ArrayList<>();

            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery(QueryConstant.CUSTOMER_GET_ALL);

                while (resultSet.next()) {

                    customers.add(customerMapper.mapRow(resultSet));
                }

                LOGGER.info("Request get all is succeeded.");

            } catch (SQLException e) {

                LOGGER.error("Request get all is failed. " + e.getMessage());
            }

            return customers;
        });
    }

    @Override
    public Customer save(Customer customer) {

        return TransactionManager.doInTransaction(connection -> {

            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.CUSTOMER_SAVE)) {
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

                LOGGER.error("Request save is failed. " + e.getMessage());
            }

            return customer;
        });
    }

    @Override
    public Customer update(Customer customer) {

        return TransactionManager.doInTransaction(connection -> {
            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.CUSTOMER_UPDATE)) {

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

                LOGGER.error("Request update is failed. " + e.getMessage());
            }

            return customer;
        });
    }

    @Override
    public void deleteById(Long id) {

        TransactionManager.doInTransaction(connection -> {
            try (PreparedStatement statement = connection.prepareStatement(QueryConstant.CUSTOMER_DELETE_BY_ID)) {

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
