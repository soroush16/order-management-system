package repository;

import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository {
    public void addOrderToRepository(Order order) throws SQLException {
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "INSERT INTO orders (client_id,orderLine_id,date_of_submission)" +
                "VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, order.getClient_id());
        statement.setLong(2, order.getOrderLine_id());
        statement.setDate(3, order.getDateOfSubmission());
        if (statement.executeUpdate() == 0) {
            throw new SQLException("failed to save the order in database");
        }

        DatabaseManager.getInstance().closeConnection(connection, statement, null);
    }

    public ArrayList<Order> findOrdersByDate(Date date) throws SQLException {
        ArrayList<Order> allOrdersFoundByDate = new ArrayList<>();
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "SELECT * FROM orders WHERE date_of_submission = '" + date+"'";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            while (result.next()) {
                Order order = new Order(
                        result.getLong("id"),
                        result.getLong("client_id"),
                        result.getLong("orderLine_id"),
                        result.getDate("date_of_submission")
                );
                allOrdersFoundByDate.add(order);
            }
            DatabaseManager.getInstance().closeConnection(connection, statement, result);
            return allOrdersFoundByDate;
        }

    }

