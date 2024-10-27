package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
    
        if (username.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Por favor, ingrese usuario y contraseña.");
            return;
        }
    
        // Validación de usuario
        if (username.equals("admin") && password.equals("1234")) { // Ejemplo de usuario
            mostrarAlerta("Éxito", "Login exitoso!");
            
            try {
                // Cargar la vista principal
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainView.fxml"));
                Parent mainView = loader.load();
    
                // Mostrar la nueva escena
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(mainView, 400, 300));
            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta("Error", "No se pudo cargar la vista principal.");
            }
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cambiarAVistaPrincipal() throws IOException {
        // Cargar la vista principal
        URL fxmlLocation = getClass().getResource("/views/MainView.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Stage stage = (Stage) usernameField.getScene().getWindow(); // Obtener el escenario actual
        Scene scene = new Scene(loader.load()); // Cargar la nueva vista
        stage.setScene(scene); // Cambiar la escena
        stage.show(); // Mostrar la nueva escena
    }
}

