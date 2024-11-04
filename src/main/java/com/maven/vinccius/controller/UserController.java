package com.maven.vinccius.controller;

import java.util.ArrayList;
import java.util.List;

import com.maven.vinccius.models.UserModels;
import com.maven.vinccius.repository.*;

public class UserController {

  public String createUser(UserModels user) {
    System.out.println("Creating user...");
    return new UserRepository().SaveUser(user);
  }

  public String listUsers() {
    List<UserModels> users = new ArrayList<UserModels>();
    StringBuilder data = new StringBuilder();
    for (UserModels u : users) {
      data.append("Name: ").append(u.getName()).append("\n");
      data.append("Age: ").append(u.getAge()).append("\n");
      if (u.getSex() == 0) {
        data.append("Sexual orientation: Male\n");
      } else if (u.getSex() == 1) {
        data.append(" Sexual orientation: Female\n");
      } else {
        data.append(" Sexual orientation: Other\n");
      }
    }
    return data.toString();
  }
}