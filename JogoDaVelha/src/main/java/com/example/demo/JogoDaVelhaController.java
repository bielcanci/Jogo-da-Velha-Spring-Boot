// Pacote da aplicação
package com.example.demo;

// Importações necessárias do Spring para manipulação de endpoints REST
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotação indicando que esta classe é um controlador REST
@RestController
@RequestMapping("/jogodavelha")
public class JogoDaVelhaController {

    // Instância do Tabuleiro para armazenar o estado do jogo da velha
    private Tabuleiro tabuleiro = new Tabuleiro();

    // Endpoint para obter o estado atual do tabuleiro
    @GetMapping("/tabuleiro")
    public char[][] obterTabuleiro() {
        // Retorna a matriz representando o tabuleiro
        return tabuleiro.getMatriz();
    }

    // Endpoint para realizar uma jogada no jogo da velha
    @PostMapping("/jogar/{linha}/{coluna}")
    public void fazerJogada(@PathVariable int linha, @PathVariable int coluna, @RequestBody char jogador) {
        // Chama o método fazerJogada do tabuleiro para registrar a jogada
        tabuleiro.fazerJogada(linha, coluna, jogador);
    }
}
