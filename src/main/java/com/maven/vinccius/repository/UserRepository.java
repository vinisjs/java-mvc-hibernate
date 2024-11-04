package com.maven.vinccius.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maven.vinccius.models.UserModels;

public class UserRepository {
  private SessionFactory factory;

  public UserRepository() {
    try {
      factory = new Configuration().configure().buildSessionFactory();
      System.out.println("Configuration loaded successfully.");
    } catch (Throwable e) {
      System.err.println("Failed to load configuration: " + e.getMessage());
      throw new ExceptionInInitializerError(e);
    }
  }

  public String SaveUser(UserModels user) {
    StringBuilder data = new StringBuilder();
    data.append("Name: ").append(user.getName()).append("\n");
    data.append("Age: ").append(user.getAge()).append("\n");
    if (user.getSex() == 0) {
      data.append("Sexual orientation: Male\n");
    } else if (user.getSex() == 1) {
      data.append("Sexual orientation: Female\n");
    } else {
      data.append("Sexual orientation: Other\n");
    }

    System.out.println("User Data:\n" + data);
    System.out.println("Saving user in database...");

    Transaction transaction = null;
    try (Session session = factory.openSession()) {
      System.out.println("Session opened successfully.");
      transaction = session.beginTransaction();
      System.out.println("Try Save");
      System.out.println("data:" + data);
      System.out.println(user);
      session.save(user);
      System.out.println("Try Commit");
      transaction.commit();
      System.out.println("User saved successfully.");
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace(); // Handle the exception
      return "Failed to save user: " + e.getMessage();

    }

    return "User saved successfully\n" + data;
  }

  public List<UserModels> ListUsers() {
    List<UserModels> users;
    try (Session session = factory.openSession()) {
      users = session.createQuery("from UserModels", UserModels.class).list(); // Certifique-se de que o nome da classe
                                                                               // está correto
    }
    return users;
  }
}
