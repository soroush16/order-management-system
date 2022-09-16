package repository;

import java.sql.*;

public class DatabaseManager {
private static final DatabaseManager DatabaseManager_instance = new DatabaseManager();
private Connection connection;

public static DatabaseManager getInstance(){
    return DatabaseManager_instance;
}

private void setupDBConnection (){
    String host = "jdbc:mysql://localhost";
    String port = "3306";
    String databaseName = "order_management_database";
    String username = "soroush";
    String password = "khorshidcafe163";

    String connectionUrl = host + ":" + port + "/" + databaseName;

    try{
        this.connection = DriverManager.getConnection(connectionUrl,username,password);
    }catch(SQLException sqlException){
        System.out.println("unable to connect to database");
        sqlException.printStackTrace();
    }
}
public Connection getConnection ()throws SQLException{
    if(this.connection==null || this.connection.isClosed()){
        this.setupDBConnection();
    }
    return this.connection;

}
public void closeConnection (Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
    try{
        if(connection != null) connection.close();
        if(preparedStatement!=null) preparedStatement.close();
        if(resultSet!= null) resultSet.close();
    }catch(Exception exception){
        System.out.println(exception.getClass() + " : "+ exception.getMessage());
    }

}
}
