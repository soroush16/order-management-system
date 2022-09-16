package repository;

import entity.Client;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository {

    public void addClientToDB(Client client) throws SQLException {
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "INSERT INTO client (name,email,address) "+
                "VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,client.getName());
        statement.setString(2,client.getEmail());
        statement.setString(3,client.getAddress());

        if(statement.executeUpdate()==0){
            throw new SQLException("failed to insert new client"+ client.getName());
        }
        DatabaseManager.getInstance().closeConnection(connection,statement,null);

    }

    public ArrayList<Client> getAllClientsFromDB ()throws SQLException{
        Connection connection = DatabaseManager.getInstance().getConnection();
        ArrayList<Client> allClients = new ArrayList<>();
        String query = "SELECT id,name FROM client";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            Client currentclient = new Client(
                    resultSet.getLong("id"),
                    resultSet.getString("name")
            );
            allClients.add(currentclient);

        }
        DatabaseManager.getInstance().closeConnection(connection,statement,resultSet);
        return allClients;



    }



}
