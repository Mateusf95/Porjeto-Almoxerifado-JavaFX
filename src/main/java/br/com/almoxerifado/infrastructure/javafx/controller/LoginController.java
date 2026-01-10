package br.com.almoxerifado.infrastructure.javafx.controller;

import br.com.almoxerifado.application.dto.LoginDTO;
import br.com.almoxerifado.application.dto.UserDTO;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import br.com.almoxerifado.domain.exception.InvalidLoginArgumentsException;
import br.com.almoxerifado.domain.exception.UserNotFountException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import org.springframework.stereotype.Controller;

import javax.management.InvalidApplicationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        try{
            LoginDTO loginDTO = new LoginDTO(textFieldEmail.getText(), textFieldPassword.getText());
            UserDTO user = loginuseCase.execute(loginDTO);

            System.out.println("usuário logado: " + user.name());
        }catch(UserNotFountException | InvalidLoginArgumentsException e){
            loginMsg.setVisible(true);
            setTimeOut(() -> {
                loginMsg.setVisible(true);
            });
        }
    }
    private void setTimeOut(Runnable runnable) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.schedule(runnable, 5, TimeUnit.SECONDS);
    }

}
