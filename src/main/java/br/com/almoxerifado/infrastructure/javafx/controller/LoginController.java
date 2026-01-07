package br.com.almoxerifado.infrastructure.javafx.controller;

import br.com.almoxerifado.application.dto.LoginDTO;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import br.com.almoxerifado.domain.exception.UserNotFountException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @FXML
    private TextFlow loginMsg;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldPassword;

    private final LoginuseCase loginuseCase;

    public LoginController(LoginuseCase loginuseCase) {
        this.loginuseCase = loginuseCase;
    }

    @FXML
    void handleForgotPassword(MouseEvent event) {

    }

    @FXML
    void handleLoginButton(ActionEvent event) {
        System.out.println("Funcionou!");
        try{
            LoginDTO loginDTO = new LoginDTO(textFieldEmail.getText(), textFieldPassword.getText());
            loginuseCase.execute(loginDTO);
        }catch(UserNotFountException e){
            System.out.println("Caiu no catch: User not fount");
            System.out.println(e.getMessage());
        }
    }

}
