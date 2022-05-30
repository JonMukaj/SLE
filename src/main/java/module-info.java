module com.example.jonsle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.jonsle to javafx.fxml;
    exports com.example.jonsle;
}