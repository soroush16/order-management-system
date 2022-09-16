package controller;

import javax.swing.*;

public class OrderManagementMenuController {
    private final ClientController clientController = new ClientController();
    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();

    public void start(){
        this.showOptions();
        this.handleUserChoice();

    }

    private void showOptions(){
        System.out.println(" Welcome to order management System." +
                "\n please choose what you would like to do " +
                "\n 1. create client" +
                "\n 2. create new product" +
                "\n 3. create new order " +
                "\n 4.find orders by order submission date " +
                "\n 5. Exit the system ");
    }

    private void handleUserChoice (){
        String userchoice = JOptionPane.showInputDialog("choose from above menu");

        switch (userchoice){
            case "1":
                this.clientController.addClient();
                break;
            case "2":
                this.productController.addProduct();
                break;
            case "3":
                this.orderController.addOrder();
                break;
            case "4":
                this.orderController.displayOrdersByDate();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("please choose from menu options");

        }
        start();

    }


}
