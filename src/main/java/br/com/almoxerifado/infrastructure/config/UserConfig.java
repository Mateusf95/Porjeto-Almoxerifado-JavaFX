package br.com.almoxerifado.infrastructure.config;

import br.com.almoxerifado.application.service.loginUseCaseImpl;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import br.com.almoxerifado.domain.gateway.PasswordEncryptor;
import br.com.almoxerifado.domain.gateway.UserGateway;
import br.com.almoxerifado.domain.gateway.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public LoginuseCase loginuseCase(UserGateway userGateway,
                                     PasswordEncryptor passwordEncryptor,
                                     UserMapper userMapper) {
        return new loginUseCaseImpl(userGateway,  passwordEncryptor, userMapper);
    }
}
