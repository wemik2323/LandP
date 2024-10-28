package com.example.course;

import com.example.course.model.DBModel;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainController {

    private DBModel model = new DBModel();

    @FXML
    private VBox mainVbox;

    @FXML
    protected void showPersonal() {

    }

    @FXML
    protected void showPatients() {

    }

    @FXML
    protected void makeStatement() {

    }

    public void initialize() throws Exception {
        getDoctorName(2);
        displayWelcomeMessage();
    }

    private void displayWelcomeMessage() {
        String doctorName = model.doctorName;
        String currentTime = getCurrentTime();

        Label welcomeLabel = new Label("Приветствуем вас, " + doctorName + "!\nТекущее время: " + currentTime);
        mainVbox.getChildren().add(welcomeLabel);
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    private void getDoctorName(int doctorId) throws Exception {
        String name = null;
        try (Socket socket = new Socket("localhost", 8081);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("getDoctorName:" + doctorId);
            model.doctorName = in.readLine();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Запрос не выслан!");
        }
    }
}