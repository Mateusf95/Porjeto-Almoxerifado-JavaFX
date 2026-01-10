package br.com.almoxerifado.domain.exception;

public class InvalidLoginArgumentsException extends RuntimeException {
    public InvalidLoginArgumentsException(String message) {
        super(message);
    }
}
