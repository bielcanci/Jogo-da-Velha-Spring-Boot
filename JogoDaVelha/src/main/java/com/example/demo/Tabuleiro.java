package com.example.demo;

public class Tabuleiro {
    private char[][] matriz = new char[3][3];

    public Tabuleiro() {
        // Inicializa o tabuleiro com espaços vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void fazerJogada(int linha, int coluna, char jogador) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        if (matriz[linha][coluna] != ' ') {
            throw new IllegalArgumentException("Posição já ocupada.");
        }

        matriz[linha][coluna] = jogador;
    }

    public boolean verificarVitoria(char jogador) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == jogador && matriz[i][1] == jogador && matriz[i][2] == jogador) {
                return true;
            }
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (matriz[0][j] == jogador && matriz[1][j] == jogador && matriz[2][j] == jogador) {
                return true;
            }
        }

        // Verifica diagonais
        if (matriz[0][0] == jogador && matriz[1][1] == jogador && matriz[2][2] == jogador) {
            return true;
        }
        if (matriz[0][2] == jogador && matriz[1][1] == jogador && matriz[2][0] == jogador) {
            return true;
        }

        return false;
    }

    public boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
