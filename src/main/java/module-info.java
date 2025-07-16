module com.github.eorlsam.texteditorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.github.eorlsam.texteditorapp to javafx.fxml;
    exports com.github.eorlsam.texteditorapp;
}