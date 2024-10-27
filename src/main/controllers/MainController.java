package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController {
    
    @FXML
    private TableView<Doctor> doctorTable;
    @FXML
    private TableColumn<Doctor, String> nameColumn;
    @FXML
    private TableColumn<Doctor, String> specialtyColumn;

    // Lista de doctores simulada (puedes reemplazarla con datos de una base de datos)
    private List<Doctor> doctors = new ArrayList<>();

    @FXML
    public void initialize() {
        // Inicializar columnas de la tabla
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));

        // Cargar doctores en la tabla
        loadDoctors();
    }

    private void loadDoctors() {
        // Agregar doctores a la lista
        doctors.add(new Doctor("Dr. Juan Pérez", "Cardiología"));
        doctors.add(new Doctor("Dra. María López", "Dermatología"));
        doctors.add(new Doctor("Dr. Carlos Gómez", "Pediatría"));

        // Añadir doctores a la tabla
        doctorTable.getItems().addAll(doctors);
    }

    @FXML
    private void handleRequestAppointment() throws IOException {
        // Cargar la vista de solicitud de turno
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AppointmentView.fxml"));
        Parent appointmentView = loader.load();
        
        // Mostrar la nueva escena
        Stage stage = (Stage) doctorTable.getScene().getWindow();
        stage.setScene(new Scene(appointmentView, 400, 300));
    }

    @FXML
    private void handleLogout() throws IOException {
        // Mostrar alerta de cierre de sesión
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText(null);
        alert.setContentText("Has cerrado sesión.");
        alert.showAndWait();

        // Cargar la vista de inicio de sesión
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
        Parent loginView = loader.load();
        
        // Mostrar la nueva escena
        Stage stage = (Stage) doctorTable.getScene().getWindow();
        stage.setScene(new Scene(loginView, 300, 200)); // Ajusta el tamaño de la ventana según sea necesario
    }
}

