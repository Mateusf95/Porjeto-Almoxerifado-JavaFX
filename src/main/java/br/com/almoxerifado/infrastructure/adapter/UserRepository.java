package br.com.almoxerifado.infrastructure.adapter;

import br.com.almoxerifado.domain.exception.UserNotFountException;
import br.com.almoxerifado.domain.gateway.UserGateway;
import br.com.almoxerifado.domain.gateway.UserMapper;
import br.com.almoxerifado.domain.model.User;
import br.com.almoxerifado.infrastructure.database.entitles.UserEntity;
import br.com.almoxerifado.infrastructure.database.entitles.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserGateway {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = userJpaRepository.findByEmail(email).orElseThrow(()->
                new UserNotFountException("User not found"));
        return userMapper.userEntityToUser(userEntity);
    }

    public boolean count() {
        List<UserEntity> userEntityList = userJpaRepository.findAll();

        return userEntityList.isEmpty();
    }

    public void save(UserEntity user) {
        userJpaRepository.save(user);
    }
}
