package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends GUI implements ActionListener {

    public LoginView(Controller controller) {
        this.userName = null;
        this.password = null;
        this.controller = controller;

        LoginView = new JFrame("LoginView");
        LoginView.setSize(500, 400);
        LoginView.setLayout(null);


        UserName = new JTextField("UserName", 1);
        UserName.setBounds(100, 100, 200, 30);
        LoginView.add(UserName);

        Password = new JTextField("Password", 1);
        Password.setBounds(100, 150, 200, 30);
        LoginView.add(Password);

        LoginButton = new JButton("Login");
        LoginButton.addActionListener(this);
        LoginButton.setBounds(200, 225, 100, 40);
        LoginView.add(LoginButton);

        CreateUserButton = new JButton("Create new user");
        CreateUserButton.addActionListener(this);
        CreateUserButton.setBounds(200, 275, 100, 40);
        LoginView.add(CreateUserButton);


        LoginView.setDefaultCloseOperation(LoginView.EXIT_ON_CLOSE);
        LoginView.setLocationRelativeTo(null);
        LoginView.setVisible(false);
    }

    private JFrame LoginView;
    private JButton LoginButton;
    public JTextField UserName;
    public JTextField Password;
    private JButton CreateUserButton;
    public String userName;
    public String password;
    public Controller controller;

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Login")) {
            userName = UserName.getText();
            password = Password.getText();
            controller.getUsers();
            controller.dates();
            controller.addDates();
            if (controller.LoginIsValid()) {
                controller.Login();
            } else {
                System.out.println("error");
            }
            controller.illustrateEvents();
        }
        if (event.getActionCommand().equals("Create new user")) {
            controller.CreatingNewUser();
        }
    }

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }


    public void setLoginViewVisible(boolean isVisible) {
        LoginView.setVisible(isVisible);
    }

    public void disposeLoginView() {
        LoginView.dispose();
    }
}

