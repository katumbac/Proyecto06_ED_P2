module com.mycompany.p_grupo06 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.p_grupo06 to javafx.fxml;
    exports com.mycompany.p_grupo06;
}
