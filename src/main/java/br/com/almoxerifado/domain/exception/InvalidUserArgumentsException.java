package br.com.almoxerifado.domain.exception;

public class InvalidUserArgumentsException extends RuntimeException {
    public InvalidUserArgumentsException(String message) {
        super(message);
    }
}
