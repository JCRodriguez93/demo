module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jh;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.help;
    opens com.example.demo.help to javafx.fxml;
}