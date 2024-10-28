module com.example.course {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires java.sql;

    opens com.example.course to javafx.fxml;
    exports com.example.course;
    exports com.example.course.model;
    opens com.example.course.model to javafx.fxml;
}