// Pacote da aplicação
package com.example.demo;

// Importações necessárias do Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação indicando que esta é uma aplicação Spring Boot
@SpringBootApplication
public class DemoApplication {

    // Método principal, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(DemoApplication.class, args);
    }
}

