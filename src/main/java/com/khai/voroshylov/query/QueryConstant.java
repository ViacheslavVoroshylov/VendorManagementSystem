package com.khai.voroshylov.query;

public final class QueryConstant {

    public static final String CUSTOMER_GET_BY_ID = "SELECT * FROM management_system.customer WHERE id = ?";
    public static final String CUSTOMER_GET_ALL = "SELECT * FROM management_system.customer";
    public static final String CUSTOMER_SAVE = "INSERT INTO management_system.customer (name, country, city," +
            " last_order_date, email, phone, order_count) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String CUSTOMER_UPDATE = "UPDATE management_system.customer SET name = ?, country = ?, " +
            "city = ?, last_order_date = ?, email = ?, phone = ?, order_count = ? WHERE id = ?";
    public static final String CUSTOMER_DELETE_BY_ID = "DELETE FROM management_system.customer WHERE id = ?";

    public static final String PRODUCT_GET_BY_ID = "SELECT * FROM management_system.product WHERE id = ?";
    public static final String PRODUCT_GET_ALL = "SELECT * FROM management_system.product";
    public static final String PRODUCT_SAVE = "INSERT INTO management_system.product (category, name, count, price," +
            " supplier) " + "VALUES (?, ?, ?, ?, ?)";
    public static final String PRODUCT_UPDATE = "UPDATE management_system.product SET category = ?, name = ?," +
            " count = ?, price = ?, supplier = ? WHERE id = ?";
    public static final String PRODUCT_DELETE_BY_ID = "DELETE FROM management_system.product WHERE id = ?";
}
