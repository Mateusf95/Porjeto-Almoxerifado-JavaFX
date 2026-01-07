package br.com.almoxerifado.infrastructure.config;

import br.com.almoxerifado.application.service.loginUseCaseImpl;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public LoginuseCase loginuseCase(){
        return new loginUseCaseImpl();
    }
}
