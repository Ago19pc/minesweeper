package it.ago19.minesweeper;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    HelloController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 900);

        controller = fxmlLoader.getController();

        stage.setTitle("MineSweeper I guess");
        stage.setScene(scene);
        stage.show();
        Platform.runLater(() -> {controller.setUp();});
    }

    public static void main(String[] args) {
        launch();
    }
}