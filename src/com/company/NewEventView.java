package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEventView extends GUI implements ActionListener {
    public NewEventView (Controller controller){

        this.controller = controller;
        NewEventView = new JFrame("NewEventView");
        NewEventView.setLayout(null);
        NewEventView.setSize(750,750);
        NewEventView.setLocationRelativeTo(null);

        BackButton = new JButton("Back");
        BackButton.addActionListener(this);
        BackButton.setBounds(500, 500, 100, 50);
        NewEventView.add(BackButton);

        SaveButton = new JButton("Save event");
        SaveButton.addActionListener(this);
        SaveButton.setBounds(500, 400, 100, 50);
        NewEventView.add(SaveButton);

        eventName = new JTextField("name", 1);
        eventName.setBounds(100, 100, 200, 30);
        NewEventView.add(eventName);

        eventDescription = new JTextField("description", 1);
        eventDescription.setBounds(100, 150, 200, 30);
        NewEventView.add(eventDescription);

        eventDate = new JTextField("date", 1);
        eventDate.setBounds(100, 100, 200, 30);
        NewEventView.add(eventDate);

        eventLength = new JTextField("length", 1);
        eventLength.setBounds(100, 300, 200, 30);
        NewEventView.add(eventLength);


        eventTime = new JComboBox();
        eventTime.setBounds(100, 400, 200, 30);
        NewEventView.add(eventTime);

        eventDay = new JComboBox();

        eventDay.setBounds(100, 500, 200, 30);
        NewEventView.add(eventDay);

        String[] months = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" };
        eventMonth = new JComboBox(months);
        eventMonth.setBounds(100, 600, 200, 30);
        NewEventView.add(eventMonth);

        NewEventView.setVisible(false);

    }
    private JFrame NewEventView;
    private Controller controller;
    private JButton BackButton;
    private JButton SaveButton;
    private JTextField eventName, eventDescription, eventDate, eventLength;
    public JComboBox<Integer> eventTime, eventDay;
    public JComboBox<String> eventMonth;

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Back")) {
            controller.BackFromNewEventView();
        }
        if (event.getActionCommand().equals("Save event"))
        {
            controller.SaveEvent();
            controller.illustrateEvents();
        }
    }
    public void setNewEventViewVisible(boolean isVisible) {
        NewEventView.setVisible(isVisible);
    }

    public void disposeNewEventView(){
        NewEventView.dispose();
    }
    public String getEventName()
    {
        return eventName.getText();
    }
    public String getEventDescription ()
    {
        return eventDescription.getText();
    }
    public int getEventTime ()
    {
        int i = eventTime.getSelectedIndex();
        return eventTime.getItemAt(i);
    }
    public int getEventDay ()
    {
        int i = eventDay.getSelectedIndex();
        return eventDay.getItemAt(i);
    }
    public String getEventMonth ()
    {
        int i = eventMonth.getSelectedIndex();
        return eventMonth.getItemAt(i);
    }
}
