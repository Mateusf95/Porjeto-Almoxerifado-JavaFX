package br.com.almoxerifado.application.dto;

import java.time.LocalDateTime;

public record UserDTO(
        Long id,
        String email,
        String password,
        String cpf,
        String register,
        LocalDateTime createdAt,
        LocalDateTime updateAt) {

}
