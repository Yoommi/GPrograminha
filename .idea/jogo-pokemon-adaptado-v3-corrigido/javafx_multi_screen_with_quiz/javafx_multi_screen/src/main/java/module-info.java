module com.example.gp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.gp to javafx.fxml;
    exports com.example.gp;
}


