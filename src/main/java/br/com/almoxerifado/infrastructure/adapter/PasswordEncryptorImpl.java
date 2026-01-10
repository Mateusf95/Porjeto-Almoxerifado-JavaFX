package br.com.almoxerifado.infrastructure.adapter;

import br.com.almoxerifado.domain.gateway.PasswordEncryptor;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptorImpl implements PasswordEncryptor {
    @Override
    public boolean matches(String password, String hash) {
        return password.equals(hash);
    }
}
