package com.github.eorlsam.texteditorapp;

import com.github.eorlsam.texteditorapp.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/eorlsam/texteditorapp/view/main.fxml"));
        Scene scene = new Scene(loader.load());

        // Inject Stage into Controller
        MainController controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("Simple Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}