package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Minha Aplicação");
        stage.show();
    }

    // Método estático para trocar de tela
    public static void setRoot(String fxml) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(fxml + ".fxml"));
        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch();
    }
}