module com.mycompany.tarea {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tarea to javafx.fxml;
    exports com.mycompany.tarea;
}
