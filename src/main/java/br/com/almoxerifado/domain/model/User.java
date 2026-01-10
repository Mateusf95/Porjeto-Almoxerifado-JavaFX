package br.com.almoxerifado.domain.model;

import br.com.almoxerifado.domain.exception.InvalidUserArgumentsException;

import java.time.LocalDateTime;

public record User(Long id,
                   String name,
                   String email,
                   String password,
                   String register,
                   LocalDateTime createdAt,
                   LocalDateTime updateAt) {

    public User(Long id, String name, String email, String password, String register, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.register = register;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        validate();
    }

    private void validate() {
        if(name.isBlank()){
            throw new InvalidUserArgumentsException("Nome é obrigatório!");
        }
        if(email.isBlank()){
            throw new InvalidUserArgumentsException("Email é Obrigatório");
        }
        if(password.isBlank()){
            throw new InvalidUserArgumentsException("Senha é Obrigat[oria!");
        }
    }
}
