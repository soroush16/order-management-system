package controller;

import entity.Product;
import repository.ProductRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductRepository productRepository = new ProductRepository();

    public void addProduct() {
        try {
            productRepository.addProductToRepository(this.collectInfoForProduct());
            System.out.println("product added to Database");
        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass() + " : "+ sqlException.getMessage());
        }
    }

    public Product collectInfoForProduct(){
        Product product = new Product();
        product.setName(this.getUserInput("please enter product name"));
        product.setSkuCode(Integer.parseInt(this.getUserInput("enter product SKU code")));
        product.setPrice(Double.valueOf(this.getUserInput("enter product price per unit")));
        return product;
    }

    public void displayAllAvailableProducts (){
        try{
            ArrayList<Product> allAvailableProduct = productRepository.getAllProductsFromDB();
            for(Product p: allAvailableProduct){
                System.out.println(p);
            }
        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass() +" : "+ sqlException.getMessage());
        }
    }

    public String getUserInput (String message){
        return JOptionPane.showInputDialog(message);
    }


}
