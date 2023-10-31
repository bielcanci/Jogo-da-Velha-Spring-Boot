package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogodavelha")
public class JogoDaVelhaController {

    private Tabuleiro tabuleiro = new Tabuleiro();

    @GetMapping("/tabuleiro")
    public char[][] obterTabuleiro() {
        return tabuleiro.getMatriz();
    }

    @PostMapping("/jogar/{linha}/{coluna}")
    public void fazerJogada(@PathVariable int linha, @PathVariable int coluna, @RequestBody char jogador) {
        tabuleiro.fazerJogada(linha, coluna, jogador);
    }
}
