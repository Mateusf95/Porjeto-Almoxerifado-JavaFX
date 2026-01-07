package br.com.almoxerifado.application.service;

import br.com.almoxerifado.application.dto.LoginDTO;
import br.com.almoxerifado.application.dto.UserDTO;
import br.com.almoxerifado.application.usecase.LoginuseCase;
import br.com.almoxerifado.domain.exception.UserNotFountException;

public class loginUseCaseImpl implements LoginuseCase {
    @Override
    public UserDTO execute(LoginDTO input) {
        throw  new UserNotFountException("User not fount");
//        return null;
    }
}
