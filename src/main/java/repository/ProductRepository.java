package repository;

import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {

    public void addProductToRepository(Product product) throws SQLException {
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query ="INSERT INTO product (name,skuCode,price) "+
                "VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,product.getName());
        statement.setInt(2,product.getSkuCode());
        statement.setDouble(3,product.getPrice());

        if(statement.executeUpdate()==0){
            throw new SQLException(" failed to insert product into database");
        }

        DatabaseManager.getInstance().closeConnection(connection,statement,null);

    }


    public ArrayList<Product> getAllProductsFromDB ()throws SQLException{
        Connection connection = DatabaseManager.getInstance().getConnection();
        ArrayList<Product> allProducts = new ArrayList<>();
        String query = "SELECT name,id FROM product";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            Product currentProduct = new Product(
                    resultSet.getLong("id"),
                    resultSet.getString("name")
            );
            allProducts.add(currentProduct);

        }
        DatabaseManager.getInstance().closeConnection(connection,statement,resultSet);
        return allProducts;



    }
}
