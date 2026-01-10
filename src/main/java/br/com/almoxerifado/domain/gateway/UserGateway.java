package br.com.almoxerifado.domain.gateway;

import br.com.almoxerifado.domain.model.User;

public interface UserGateway {
    User findUserByEmail(String email);
}
