package controller;

import entity.Client;
import repository.ClientRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController {
    ClientRepository clientRepository = new ClientRepository();

    public void addClient() {
        try {
            clientRepository.addClientToDB(this.collectInfoForClient());
            System.out.println("client added successfully");

        }catch (SQLException sqlException){
            System.out.println(sqlException.getClass() +" : "+ sqlException.getMessage());
        }
    }


    public Client collectInfoForClient (){
        Client client = new Client();
        client.setName(this.getUserInput("please enter client name"));
        client.setAddress(this.getUserInput("please enter you address in the following order :  Country, city, street, building number, flat number, postcode"));
        client.setEmail(this.getUserInput("please enter your email "));
        return client;
    }

    public void displayAllClients () {
        try {
            ArrayList<Client> listOfClients = clientRepository.getAllClientsFromDB();
            for(Client c : listOfClients){
                System.out.println(c);
            }

        }catch(SQLException sqlException){
            System.out.println(sqlException.getClass() +" : "+ sqlException.getMessage());
        }
    }



    public String getUserInput (String message){
        return JOptionPane.showInputDialog(message);
    }
}
