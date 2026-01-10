package br.com.almoxerifado.domain.gateway;

public interface PasswordEncryptor {
    boolean matches(String password, String hash);
}
