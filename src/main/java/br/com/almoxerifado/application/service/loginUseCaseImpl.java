package br.com.almoxerifado.application.service;

import br.com.almoxerifado.application.dto.LoginDTO;
import br.com.almoxerifado.application.dto.UserDTO;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import br.com.almoxerifado.domain.exception.InvalidLoginArgumentsException;
import br.com.almoxerifado.domain.exception.UserNotFountException;
import br.com.almoxerifado.domain.gateway.PasswordEncryptor;
import br.com.almoxerifado.domain.gateway.UserGateway;
import br.com.almoxerifado.domain.gateway.UserMapper;
import br.com.almoxerifado.domain.model.User;

public class loginUseCaseImpl implements LoginuseCase {

    private final UserGateway userGateway;
    private final PasswordEncryptor passwordEncryptor;
    private final UserMapper userMapper;

    public loginUseCaseImpl(UserGateway userGateway, PasswordEncryptor passwordEncryptor, UserMapper userMapper) {
        this.userGateway = userGateway;
        this.passwordEncryptor = passwordEncryptor;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO execute(LoginDTO input) {
        if(input.email().isBlank()){
            throw new InvalidLoginArgumentsException("Credenciais invalídas!");
        }
        if(input.password().isBlank()){
            throw new InvalidLoginArgumentsException("Credenciais invalídas!");
        }
        User user = userGateway.findUserByEmail(input.email());
        if(user == null){
            throw new UserNotFountException("User not found!");
        }
        if(!passwordEncryptor.matches(input.password(), user.password())){
            throw new InvalidLoginArgumentsException("Credenciais invalídas!");
        }
        return userMapper.userToUserDTO(user);
    }
}
