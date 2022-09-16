package repository;

import entity.OrderLine;

import java.sql.*;

public class OrderLineRepository {
    public OrderLine addOrderLineToRepository(OrderLine orderLine) throws SQLException {
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "INSERT INTO orderLine (product_id,quantity)"+
                 "VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setLong(1,orderLine.getProduct_id());
        statement.setLong(2,orderLine.getQuantity());
        if(statement.executeUpdate()==0){
            throw new SQLException("failed to add the orderLine to database");
        }
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()){
            orderLine.setId(generatedKeys.getLong(1));
        }

        DatabaseManager.getInstance().closeConnection(connection,statement,null);
        return orderLine;
    }

}
