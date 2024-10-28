package com.example.course;

import java.io.*;
import java.net.*;
import java.sql.*;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту " + port);
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            System.out.println("Новый клиент создан!");
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String response = handleRequest(inputLine);
                    out.println(response);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String handleRequest(String request) {
            System.out.println("ЗАПРОС ПОЛУЧЕН!");
            if (request.contains("getDoctorName:")) {
                int doctorId = Integer.parseInt(request.replace("getDoctorName", ""));
                return getDoctorName(doctorId);
            }
            if (request.equals("getPatients")) {
                return getPatients();
            }
            return "Неизвестный запрос";
        }
        private String getDoctorName(int doctorId) {
            String doctorName = null;
            String query = "SELECT name FROM doctors WHERE id = ?";  // Подставьте имя поля, используемого для поиска

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db", "user", "password");
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, doctorId); // Установка ID врача в запрос
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    doctorName = rs.getString("name"); // Получаем имя врача из результата
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("БД ПРОБЛЕМА!");
            }
            return doctorName;
        }

        private String getPatients() {
            StringBuilder patientsData = new StringBuilder();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db", "root", "qwer");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM patients WHERE doctor = ?")) {

                while (rs.next()) {
                    patientsData.append(rs.getInt("id")).append(", ")
                            .append(rs.getString("name")).append(", ")
                            .append(rs.getString("diagnosis")).append("\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return patientsData.toString();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(8081);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
