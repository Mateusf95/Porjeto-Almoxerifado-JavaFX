package br.com.almoxerifado.infrastructure.shared.mapstruct;

import br.com.almoxerifado.application.dto.UserDTO;
import br.com.almoxerifado.domain.gateway.UserMapper;
import br.com.almoxerifado.domain.model.User;
import br.com.almoxerifado.infrastructure.database.entitles.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapperStruct extends UserMapper {

    @Override
    UserDTO userToUserDTO(User user);

    @Override
    User userEntityToUser(UserEntity userEntity);
}
