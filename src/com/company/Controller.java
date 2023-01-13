package com.company;

import javax.swing.table.TableColumn;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Controller implements Serializable {

    List<User> users = new ArrayList<>();

    public Controller() {

        loginView = new LoginView(this);
        createUserView = new CreateUserView(this);
        homeView = new HomeView(this);
        newEventView = new NewEventView(this);
        loginView.setLoginViewVisible(true);


    }


    private LoginView loginView;
    public CreateUserView createUserView;
    public HomeView homeView;
    public NewEventView newEventView;
    public User possibleUser;
    public User currentUser;
    public User newUser;
    public Event newEvent;
    public int[] dates;
    public int i;


    public void CreatingNewUser() {
        loginView.setLoginViewVisible(false);
        createUserView.setCreateUserViewVisible(true);
        loginView.disposeLoginView();
    }

    public void CreateNewUser() {
        LinkedList events = new LinkedList();
        newUser = new User(createUserView.getCreatedUserName(), createUserView.getCreatedPassword(), events);
        users.add(newUser);
        createUserView.setCreateUserViewVisible(false);
        loginView.setLoginViewVisible(true);
        createUserView.disposeCreateUserView();
    }

    public boolean LoginIsValid() {
        boolean isValid = false;
        String testedUsername;
        String testedPassword;
        System.out.println(loginView.getUsername());
        System.out.println(loginView.getPassword());
        for (int i = 0; i < users.size(); i++) {
            testedUsername = users.get(i).getUsername();
            testedPassword = users.get(i).getPassword();
            possibleUser = new User(loginView.getUsername(), loginView.getPassword(), users.get(i).getEvents());
            if (testedUsername.equals(possibleUser.getUsername()) && testedPassword.equals(possibleUser.getPassword())) {
                isValid = true;
            }
        }
        return isValid;
    }

    public void Login() {
        loginView.setLoginViewVisible(false);
        homeView.setHomeViewVisible(true);
        loginView.disposeLoginView();
        currentUser = possibleUser;

    }

    public void BackFromCreateUserView() {
        createUserView.setCreateUserViewVisible(false);
        loginView.setLoginViewVisible(true);
        createUserView.disposeCreateUserView();
    }

    public void NewEvent() {
        homeView.setHomeViewVisible(false);
        newEventView.setNewEventViewVisible(true);
        homeView.disposeHomeView();
    }

    public void BackFromNewEventView() {
        newEventView.setNewEventViewVisible(false);
        homeView.setHomeViewVisible(true);
        newEventView.disposeNewEventView();

    }

    public void SaveEvent() {
        int eventsTime = newEventView.getEventTime();
        int eventsDay = newEventView.getEventDay();
        String eventsMonth = newEventView.getEventMonth();
        String eventsName = newEventView.getEventName();
        String eventsDescription = newEventView.getEventDescription();
        newEvent = new Event(eventsTime, eventsDay, eventsMonth, eventsName, eventsDescription);
        if (newEvent.getMonth().equals("jan")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.jan[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("feb")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.feb[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("mar")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.mar[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("apr")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.apr[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("may")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.may[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("jun")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.jun[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("jul")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.jul[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("aug")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.aug[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("sep")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.sep[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("oct")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.oct[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("nov")) {
            int day = newEvent.getDay();
            int time = newEvent.getTime() - 7;
            currentUser.nov[time][day] = newEvent;
        }
        if (newEvent.getMonth().equals("dec")) {
            int day = newEvent.getDay() - 7;
            int time = newEvent.getTime();
            currentUser.dec[time][day] = newEvent;
        }
        newEventView.setNewEventViewVisible(false);
        homeView.setHomeViewVisible(true);
        newEventView.disposeNewEventView();

    }

    public void saveUsers() {
        try {
            FileOutputStream out = new FileOutputStream("usersData");
            ObjectOutputStream out2 = new ObjectOutputStream(out);
            out2.writeObject(users);
            out2.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void getUsers() {
        try {
            FileInputStream in = new FileInputStream("usersData");
            ObjectInputStream in2 = new ObjectInputStream(in);
            users = (ArrayList) in2.readObject();
            for (User user : users)
                System.out.println(user);

            in.close();
            in2.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public int[] dates() {
        dates = new int[365];
        for (int i = 0; i <= 30; i++) {
            dates[i] = i + 1;
        }
        for (int i = 31; i <= 58; i++) {
            dates[i] = i - 30;
        }
        for (int i = 59; i <= 89; i++) {
            dates[i] = i - 58;
        }
        for (int i = 90; i <= 119; i++) {
            dates[i] = i - 89;
        }
        for (int i = 120; i <= 150; i++) {
            dates[i] = i - 119;
        }
        for (int i = 151; i <= 180; i++) {
            dates[i] = i - 150;
        }
        for (int i = 181; i <= 211; i++) {
            dates[i] = i - 180;
        }
        for (int i = 212; i <= 242; i++) {
            dates[i] = i - 211;
        }
        for (int i = 243; i <= 272; i++) {
            dates[i] = i - 242;
        }
        for (int i = 273; i <= 303; i++) {
            dates[i] = i - 272;
        }
        for (int i = 304; i <= 333; i++) {
            dates[i] = i - 303;
        }
        for (int i = 334; i <= 364; i++) {
            dates[i] = i - 333;
        }
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }

        return dates;

    }

    public void addDates() {
        LocalDate currentDate = LocalDate.now();
        i = 0;
        homeView.datesShown1.setText(String.valueOf(dates[i]));
        homeView.datesShown2.setText(String.valueOf(dates[i + 1]));
        homeView.datesShown3.setText(String.valueOf(dates[i + 2]));
        homeView.datesShown4.setText(String.valueOf(dates[i + 3]));
        homeView.datesShown5.setText(String.valueOf(dates[i + 4]));
        homeView.datesShown6.setText(String.valueOf(dates[i + 5]));
        homeView.datesShown7.setText(String.valueOf(dates[i + 6]));
    }

    public void changeDatesForvard() {
        i = i + 7;

        homeView.datesShown1.setText(String.valueOf(dates[i]));
        homeView.datesShown2.setText(String.valueOf(dates[i + 1]));
        homeView.datesShown3.setText(String.valueOf(dates[i + 2]));
        homeView.datesShown4.setText(String.valueOf(dates[i + 3]));
        homeView.datesShown5.setText(String.valueOf(dates[i + 4]));
        homeView.datesShown6.setText(String.valueOf(dates[i + 5]));
        homeView.datesShown7.setText(String.valueOf(dates[i + 6]));
    }

    public void changeDatesBackwards() {
        i = i - 7;

        homeView.datesShown1.setText(String.valueOf(dates[i]));
        homeView.datesShown2.setText(String.valueOf(dates[i + 1]));
        homeView.datesShown3.setText(String.valueOf(dates[i + 2]));
        homeView.datesShown4.setText(String.valueOf(dates[i + 3]));
        homeView.datesShown5.setText(String.valueOf(dates[i + 4]));
        homeView.datesShown6.setText(String.valueOf(dates[i + 5]));
        homeView.datesShown7.setText(String.valueOf(dates[i + 6]));
    }

    public void createEventList() {
        LinkedList events = newUser.getEvents();


    }

    public void createJComboBoxDays() {
        for (int i = 1; i <= 31; i++) {
            newEventView.eventDay.addItem(i);
        }
    }

    public void createJComboBoxTimes() {
        for (int i = 8; i <= 16; i++) {
            newEventView.eventTime.addItem(i);
        }
    }

    public void changeTableSize() {
        TableColumn column = null;
        for (int i = 0; i <= 7; i++) {
            column = homeView.getWeekView().getColumnModel().getColumn(i);
            column.setPreferredWidth(200);
        }
    }

    public void addEventsToWeekView() {
        currentUser.getEvents();
        Event addingEvent = newEvent;
        int date;
        int time;
        String month = null;
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j <= 8; j++) {
                if (currentUser.jan[j][i] != null) {
                    addingEvent = currentUser.jan[j][i];
                    date = addingEvent.getDay();
                    time = addingEvent.getTime();
                    month = addingEvent.getMonth();
                    if (month.equals("jan")) {

                    }
                }
            }
        }
    }

    public void illustrateEvents() {
        for (int i = 0; i < currentUser.jan.length; i++) {
            for (int j = 0; j < 9; j++) {
                if (currentUser.jan[j][i] != null) {
                    int day = currentUser.jan[j][i].getDay();
                    int time = currentUser.jan[j][i].getTime();
                    String name = currentUser.jan[j][i].getName();
                    homeView.getWeekView().setValueAt(name, day, time);
                }
            }
        }
    }
}





    /*public void getTime () {
        LocalTime now = LocalTime.now();
        int hours = now.getHour(), minutes = now.getMinute(), seconds = now.getSecond();
        .setText(formatInt(hours)+ ":" + formatInt(minutes) + ":" + formatInt(seconds));

    }
    private String formatInt (int i){
        return String.format("%02d", i);*/