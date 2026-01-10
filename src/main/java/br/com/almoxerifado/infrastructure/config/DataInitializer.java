package br.com.almoxerifado.infrastructure.config;

import br.com.almoxerifado.domain.model.User;
import br.com.almoxerifado.infrastructure.adapter.UserRepository;
import br.com.almoxerifado.infrastructure.database.entitles.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco está vazio para não duplicar dados toda vez que iniciar
        if (userRepository.count()) {

            UserEntity testUser = new UserEntity();
            testUser.setName("Usuario Teste");
            testUser.setEmail("teste@email.com");
            testUser.setCpf("123456789");
            testUser.setPassword("123456");
            testUser.setRegister("REG-2026");



            userRepository.save(testUser);

            System.out.println(">>> Dados de teste inseridos com sucesso!");
        }
    }
}
