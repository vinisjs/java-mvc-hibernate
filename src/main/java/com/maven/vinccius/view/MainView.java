package com.maven.vinccius.view;

import javax.swing.JOptionPane;

import com.maven.vinccius.controller.UserController;
import com.maven.vinccius.models.UserModels;

public class MainView {
  UserModels user = new UserModels();
  UserView userView = new UserView();
  UserController userController = new UserController();

  public void Start() {

    int option;

    System.out.println("Main started");
    do {
      option = Integer
          .parseInt(JOptionPane.showInputDialog("Choose an option: \n 1 - Create user \n 2 - List users \n 3 - Exit"));
      switch (option) {
        case 1:
          UserModels data = userView.createUser(user);
          String process = userController.createUser(data);
          System.out.println(process);
          JOptionPane.showMessageDialog(null, process);
          break;
        case 2:
          JOptionPane.showMessageDialog(null, userView.listUsers());
          break;
        case 3:
          JOptionPane.showMessageDialog(null, "Exiting...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option");
          break;
      }
    } while (option != 3);
  }
}
