package com.maven.vinccius.view;

import javax.swing.JOptionPane;

import com.maven.vinccius.controller.UserController;
import com.maven.vinccius.models.UserModels;

public class UserView {

  public UserModels createUser(UserModels user) {
    JOptionPane.showMessageDialog(null, "Creating a new user");
    user.setName(JOptionPane.showInputDialog("Enter your name"));
    user.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter your age")));
    user.setSex(Integer
        .parseInt(JOptionPane.showInputDialog("Enter your sexual orientation: \n 0 - Male\n 1 - Female\n 2 - Other")));
    JOptionPane.showMessageDialog(null, "User created successfully");

    return user;
  }

  public String listUsers() {
    JOptionPane.showMessageDialog(null, "Listing users");
    UserController userController = new UserController();
    JOptionPane.showMessageDialog(null, userController.listUsers());
    return "Users listed";
  }
}
