package br.com.almoxerifado.domain.gateway;

import br.com.almoxerifado.application.dto.UserDTO;
import br.com.almoxerifado.domain.model.User;
import br.com.almoxerifado.infrastructure.database.entitles.UserEntity;

public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userEntityToUser(UserEntity userEntity);
}
