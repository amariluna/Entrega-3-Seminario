package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class AppointmentController {
    
    @FXML
    private ComboBox<String> doctorComboBox;
    @FXML
    private TextField datetimeField;

    // Lista para almacenar los turnos solicitados en memoria
    private List<Appointment> appointments = new ArrayList<>();

    @FXML
    public void initialize() {
        // Cargar médicos disponibles en el ComboBox
        doctorComboBox.getItems().addAll("Dr. Juan Pérez", "Dra. María López", "Dr. Carlos Gómez");
    }

    @FXML
    private void handleRequestAppointment() {
        String selectedDoctor = doctorComboBox.getValue();
        String datetime = datetimeField.getText();
        
        if (selectedDoctor != null && !datetime.isEmpty()) {
            // Crear una nueva cita y agregarla a la lista
            Appointment newAppointment = new Appointment(selectedDoctor, datetime);
            appointments.add(newAppointment);

            // Mostrar mensaje de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turno Solicitado");
            alert.setHeaderText(null);
            alert.setContentText("Turno solicitado con " + selectedDoctor + " para el " + datetime + ".");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un médico y una fecha/hora.");
            alert.showAndWait();
        }
    }

    // Clase interna para representar un turno
    private static class Appointment {
        private String doctor;
        private String datetime;

        public Appointment(String doctor, String datetime) {
            this.doctor = doctor;
            this.datetime = datetime;
        }

        public String getDoctor() {
            return doctor;
        }

        public String getDatetime() {
            return datetime;
        }
    }
}
