package controller;

import entity.Order;
import entity.OrderLine;
import repository.OrderLineRepository;
import repository.OrderRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderController {
    OrderRepository orderRepository = new OrderRepository();
    OrderLineController orderLineController = new OrderLineController();
    OrderLineRepository orderLineRepository = new OrderLineRepository();
    ClientController clientController= new ClientController();

    public void addOrder (){
        try{
            orderRepository.addOrderToRepository(this.CollectInfoForOrder());
            System.out.println("order added to database");
        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass() + " : "+ sqlException.getMessage());

        }

    }

    public Order CollectInfoForOrder () {
        Order order = new Order();
        OrderLine orderLine = orderLineController.collectInfoForOrderLine();
        try {
            OrderLine newOrderLine = orderLineRepository.addOrderLineToRepository(orderLine);
            order.setOrderLine(newOrderLine.getId());
            clientController.displayAllClients();
            order.setClient_id(Long.valueOf(this.getUserInput("please choose from client list")));
            order.setDateOfSubmission(Date.valueOf(this.getUserInput("enter date in the following format 2022-05-03")));
        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass()+ " : "+ sqlException.getMessage());
        }
        return order;
    }

    public void displayOrdersByDate() {
        try {
            ArrayList<Order> ordersFound = orderRepository.findOrdersByDate(Date.valueOf(this.getUserInput("please enter desired date in following order 2022-01-01")));
            if (ordersFound.isEmpty()) System.out.println("no orders found for selected date");
            for(Order o : ordersFound){
                System.out.println(o+ "\n");
            }
        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass() + " : "+ sqlException.getMessage());
        }
    }

    public String getUserInput (String message){
        return JOptionPane.showInputDialog(message);
    }

    
}
