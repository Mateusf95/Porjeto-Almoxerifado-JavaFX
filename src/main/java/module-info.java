module br.com.almoxerifado {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.almoxerifado to javafx.fxml;
    exports br.com.almoxerifado;
    exports br.com.almoxerifado.infra.javafx.controller to javafx.fxml;
    opens br.com.almoxerifado.infra.javafx.controller to javafx.fxml;
}