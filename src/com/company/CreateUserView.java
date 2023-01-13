package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateUserView extends JFrame implements ActionListener {
    public CreateUserView(Controller controller) {
        this.createdUserName = null;
        this.createdPassword = null;
        this.controller = controller;

        CreateUserView = new JFrame("CreateUserView");
        CreateUserView.setSize(500, 400);
        CreateUserView.setLayout(null);

        CreateUserButton = new JButton("Create User");
        CreateUserButton.addActionListener(this);
        CreateUserButton.setBounds(200, 275, 100, 40);
        CreateUserView.add(CreateUserButton);

        BackButton = new JButton("Back");
        BackButton.addActionListener(this);
        BackButton.setBounds(200, 325, 100, 40);
        CreateUserView.add(BackButton);

        CreateUserName = new JTextField("CreateUserName", 1);
        CreateUserName.setBounds(100, 100, 200, 30);
        CreateUserView.add(CreateUserName);

        CreatePassword = new JTextField("CreatePassword", 1);
        CreatePassword.setBounds(100, 150, 200, 30);
        CreateUserView.add(CreatePassword);

        CreateUserView.setDefaultCloseOperation(LoginView.EXIT_ON_CLOSE);
        CreateUserView.setLocationRelativeTo(null);
        CreateUserView.setVisible(false);
    }


    public JFrame CreateUserView;
    private JButton CreateUserButton;
    private JButton BackButton;
    private JTextField CreateUserName;
    private JTextField CreatePassword;
    public String createdUserName;
    public String createdPassword;
    private Controller controller;


    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Create User")) {
            createdUserName = CreateUserName.getText();
            System.out.println(createdUserName);
            createdPassword = CreatePassword.getText();
            System.out.println(createdPassword);
            controller.CreateNewUser();
            controller.saveUsers();
            controller.createEventList();
            }
        if(event.getActionCommand().equals("Back"))
        {
            controller.BackFromCreateUserView();

        }

    }

    public String getCreatedUserName() {
        return this.createdUserName;
    }

    public String getCreatedPassword() {
        return this.createdPassword;
    }

    public void setCreateUserViewVisible(boolean isVisible) {
        CreateUserView.setVisible(isVisible);
    }

    public void disposeCreateUserView(){
        CreateUserView.dispose();
    }
}

