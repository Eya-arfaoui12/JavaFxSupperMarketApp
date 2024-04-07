module com.example.javafxsuppermarketapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.javafxsuppermarketapp to javafx.fxml;
    exports com.example.javafxsuppermarketapp;
}