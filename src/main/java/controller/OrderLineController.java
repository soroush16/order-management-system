package controller;

import entity.OrderLine;
import repository.OrderLineRepository;
import repository.ProductRepository;

import javax.swing.*;
import java.sql.SQLException;

public class OrderLineController {
    OrderLineRepository orderLineRepository = new OrderLineRepository();
    ProductRepository productRepository = new ProductRepository();

    public OrderLine collectInfoForOrderLine () {
        OrderLine orderLine = new OrderLine();
        try {
            System.out.println(productRepository.getAllProductsFromDB());

        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass()+ " : "+ sqlException.getMessage());
        }
        orderLine.setProduct_id(Long.valueOf(this.getUserInput("please choose from displayed product list")));
        orderLine.setQuantity(Long.valueOf(this.getUserInput("please specify the quantity")));
        return orderLine;
    }

    public String getUserInput (String message){
        return JOptionPane.showInputDialog(message);
    }

}
