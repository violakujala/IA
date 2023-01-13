package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends GUI implements ActionListener {
    public HomeView(Controller controller) {

        this.controller = controller;
        HomeView = new JFrame("HomeView");
        HomeView.setLayout(null);
        HomeView.setSize(2000, 2000);
        HomeView.setBackground(Color.cyan);


        NewEventButton = new JButton("New Event");
        NewEventButton.setBounds(1400, 150, 100, 30);
        NewEventButton.addActionListener(this);
        HomeView.add(NewEventButton);

        NextButton = new JButton("-->");
        NextButton.setBounds(1400, 200, 100, 30);
        NextButton.addActionListener(this);
        HomeView.add(NextButton);

        PreviousButton = new JButton("<--");
        PreviousButton.setBounds(30, 200, 100, 30);
        PreviousButton.addActionListener(this);
        HomeView.add(PreviousButton);

        emptyCorner = new JLabel();
        emptyCorner.setBackground(Color.CYAN);
        emptyCorner.setOpaque(true);
        emptyCorner.setBounds(0, 300, 200, 50);
        HomeView.add(emptyCorner);

        times1 = new JLabel("                           8.00");
        times1.setBackground(Color.CYAN);
        times1.setOpaque(true);
        times1.setBounds(0, 350, 200, 50);
        HomeView.add(times1);

        times2 = new JLabel("                           9.00");
        times2.setBackground(Color.CYAN);
        times2.setOpaque(true);
        times2.setBounds(0, 400, 200, 50);
        HomeView.add(times2);

        times3 = new JLabel("                           10.00");
        times3.setBackground(Color.CYAN);
        times3.setOpaque(true);
        times3.setBounds(0, 450, 200, 50);
        HomeView.add(times3);

        times4 = new JLabel("                           11.00");
        times4.setBackground(Color.CYAN);
        times4.setOpaque(true);
        times4.setBounds(0, 500, 200, 50);
        HomeView.add(times4);

        times5 = new JLabel("                           12.00");
        times5.setBackground(Color.CYAN);
        times5.setOpaque(true);
        times5.setBounds(0, 550, 200, 50);
        HomeView.add(times5);

        times6 = new JLabel("                           13.00");
        times6.setBackground(Color.CYAN);
        times6.setOpaque(true);
        times6.setBounds(0, 600, 200, 50);
        HomeView.add(times6);

        times7 = new JLabel("                           14.00");
        times7.setBackground(Color.CYAN);
        times7.setOpaque(true);
        times7.setBounds(0, 650, 200, 50);
        HomeView.add(times7);

        times8 = new JLabel("                           15.00");
        times8.setBackground(Color.CYAN);
        times8.setOpaque(true);
        times8.setBounds(0, 700, 200, 50);
        HomeView.add(times8);

        times9 = new JLabel("                           16.00");
        times9.setBackground(Color.CYAN);
        times9.setOpaque(true);
        times9.setBounds(0, 750, 200, 50);
        HomeView.add(times9);

        datesShown1 = new JLabel();
        datesShown1.setBackground(Color.CYAN);
        datesShown1.setOpaque(true);
        datesShown1.setBounds(200, 300, 200, 50);
        HomeView.add(datesShown1);

        datesShown2 = new JLabel();
        datesShown2.setBackground(Color.CYAN);
        datesShown2.setOpaque(true);
        datesShown2.setBounds(400, 300, 200, 50);
        HomeView.add(datesShown2);

        datesShown3 = new JLabel();
        datesShown3.setBackground(Color.CYAN);
        datesShown3.setOpaque(true);
        datesShown3.setBounds(600, 300, 200, 50);
        HomeView.add(datesShown3);

        datesShown4 = new JLabel();
        datesShown4.setBackground(Color.CYAN);
        datesShown4.setOpaque(true);
        datesShown4.setBounds(800, 300, 200, 50);
        HomeView.add(datesShown4);

        datesShown5 = new JLabel();
        datesShown5.setBackground(Color.CYAN);
        datesShown5.setOpaque(true);
        datesShown5.setBounds(1000, 300, 200, 50);
        HomeView.add(datesShown5);

        datesShown6 = new JLabel();
        datesShown6.setBackground(Color.CYAN);
        datesShown6.setOpaque(true);
        datesShown6.setBounds(1200, 300, 200, 50);
        HomeView.add(datesShown6);

        datesShown7 = new JLabel();
        datesShown7.setBackground(Color.CYAN);
        datesShown7.setOpaque(true);
        datesShown7.setBounds(1400, 300, 200, 50);
        HomeView.add(datesShown7);

        weekView = new JTable(9,7);
        weekView.setRowHeight(50);
        weekView.setBounds(200, 350, 1400, 600);
        weekView.setAutoResizeMode(200);
        HomeView.add(weekView);

        /*time = new JLabel();
        controller.Time ();
        HomeView.add(time);*/

        HomeView.setLocationRelativeTo(null);
        HomeView.setVisible(false);

    }

    private JFrame HomeView;
    private JButton NewEventButton, NextButton, PreviousButton;
    public JLabel emptyCorner, datesShown1, datesShown2, datesShown3,datesShown4,datesShown5,datesShown6,datesShown7,
            times1, times2, times3, times4, times5, times6, times7, times8, times9;
    private Controller controller;
    public JLabel time;
    public JTable weekView;


    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("New Event")) {
            controller.NewEvent();
            controller.createJComboBoxTimes();
            controller.createJComboBoxDays();
        }
        if (event.getActionCommand().equals("-->"))
        {
            controller.changeDatesForvard();
        }
        if (event.getActionCommand().equals("<--"))
        {
            controller.changeDatesBackwards();
        }
    }
    public void setHomeViewVisible (boolean isVisible)
    {
        HomeView.setVisible(isVisible);
    }
    public void disposeHomeView()
    {
        HomeView.dispose();
    }
    public JTable getWeekView()
    {
        return this.weekView;
    }
}
       /* time = new JLabel();
        showTime ();
        add(time);
    }
    public void showTime () {
        LocalTime now = LocalTime.now();
        int hours = now.getHour(), minutes = now.getMinute(), seconds = now.getSecond();
        time.setText(formatInt(hours)+ ":" + formatInt(minutes) + ":" + formatInt(seconds));

    }
    private String formatInt (int i){
        return String.format("%02d", i);

        import java.time.LocalTime;
        import java.io.*;
    }*/

