module modelo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens modelo to javafx.fxml;
    opens Controlador to javafx.fxml;
    exports modelo;
    exports Controlador;
}
