// Pacote da aplicação
package com.example.demo;

// Classe que representa o tabuleiro do jogo da velha
public class Tabuleiro {
    // Matriz para armazenar o estado atual do tabuleiro
    private char[][] matriz = new char[3][3];

    // Construtor que inicializa o tabuleiro com espaços vazios
    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    // Método para obter a matriz do tabuleiro
    public char[][] getMatriz() {
        return matriz;
    }

    // Método para realizar uma jogada no tabuleiro
    public void fazerJogada(int linha, int coluna, char jogador) {
        // Verifica se a posição é válida
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        // Verifica se a posição está ocupada
        if (matriz[linha][coluna] != ' ') {
            throw new IllegalArgumentException("Posição já ocupada.");
        }

        // Registra a jogada no tabuleiro
        matriz[linha][coluna] = jogador;
    }

    // Método para verificar se um jogador venceu
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

        // Se não houver vitória
        return false;
    }

    // Método para verificar se o tabuleiro está completamente preenchido
    public boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Se houver uma posição vazia, o tabuleiro não está cheio
                if (matriz[i][j] == ' ') {
                    return false;
                }
            }
        }
        // Se todas as posições estiverem ocupadas, o tabuleiro está cheio
        return true;
    }
}
