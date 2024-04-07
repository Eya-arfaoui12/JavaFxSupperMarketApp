module com.example.javafxsuppermarketapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.tunisiamarket to javafx.fxml;
    exports com.example.tunisiamarket;
}