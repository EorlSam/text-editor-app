package com.github.eorlsam.texteditorapp.controller;

import com.github.eorlsam.texteditorapp.model.Note;
import com.github.eorlsam.texteditorapp.util.FileIO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainController {

    @FXML private TextArea textArea;
    @FXML private Label charCountLabel;

    private File currentFile;
    private Note currentNote;
    private Stage stage;

    // Called automatically when the FXML is loaded
    @FXML
    public void initialize() {
        // Update char count on each text change
        textArea.textProperty().addListener((obs, oldVal, newVal) -> updateCharCount());
    }

    public void setStage(Stage stage) {
        this.stage = stage; // Needed to show FileChooser dialogs
    }

    @FXML
    private void handleOpenFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            FileIO fileIO = new FileIO(file);
            String content = fileIO.readFile(file);

            textArea.setText(content);
            currentNote = new Note(file.getName(), content);
            currentFile = file;
            updateCharCount();
        }
    }

    @FXML
    private void handleSaveFile() {
        if (currentFile != null) {
            String content = textArea.getText();
            FileIO fileIO = new FileIO(currentFile);
            fileIO.writeFile(currentFile, content);
        } else {
            handleSaveAs();
        }
    }

    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            currentFile = file;
            String content = textArea.getText();
            FileIO fileIO = new FileIO(currentFile);
            fileIO.writeFile(currentFile, content);
        }
    }

    private void updateCharCount() {
        int count = textArea.getText().length();
        charCountLabel.setText("Characters: " + count);
    }
}