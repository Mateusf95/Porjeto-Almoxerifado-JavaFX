package br.com.almoxerifado.application.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}
