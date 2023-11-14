// Variável que controla o jogador atual (inicia com 'X')
let jogadorAtual = 'X';

// Função chamada ao clicar em uma célula do tabuleiro
function fazerJogada(linha, coluna) {
    // Obtém a célula clicada
    const celula = document.getElementById(`celula-${linha}-${coluna}`);

    // Verifica se a célula está vazia e o jogo não acabou
    if (celula.textContent === '' && jogadorAtual !== 'FIM') {
        // Preenche a célula com o símbolo do jogador atual
        celula.textContent = jogadorAtual;

        // Verifica se há um vencedor após a jogada
        verificarVitoria(linha, coluna);

        // Alterna para o próximo jogador
        jogadorAtual = (jogadorAtual === 'X') ? 'O' : 'X';
    }
}

// Função para verificar se há um vencedor
function verificarVitoria(linha, coluna) {
    const jogador = jogadorAtual;
    const tabuleiro = document.getElementById('tabuleiro');
    const celulas = tabuleiro.getElementsByClassName('celula');
    let vitoria = false;

    // Verifica vitória na linha
    if (celulas[linha * 3].textContent === jogador &&
        celulas[linha * 3 + 1].textContent === jogador &&
        celulas[linha * 3 + 2].textContent === jogador) {
        vitoria = true;
    }

    // Verifica vitória na coluna
    if (celulas[coluna].textContent === jogador &&
        celulas[coluna + 3].textContent === jogador &&
        celulas[coluna + 6].textContent === jogador) {
        vitoria = true;
    }

    // Verifica vitória na diagonal principal
    if (linha === coluna) {
        if (celulas[0].textContent === jogador &&
            celulas[4].textContent === jogador &&
            celulas[8].textContent === jogador) {
            vitoria = true;
        }
    }

    // Verifica vitória na diagonal secundária
    if (linha + coluna === 2) {
        if (celulas[2].textContent === jogador &&
            celulas[4].textContent === jogador &&
            celulas[6].textContent === jogador) {
            vitoria = true;
        }
    }

    // Se houver vitória, encerra o jogo e exibe uma mensagem
    if (vitoria) {
        jogadorAtual = 'FIM';
        alert(`O jogador ${jogador} venceu!`);
    } else {
        // Se não houver vitória, verifica se o jogo empatou
        let empate = true;
        for (let i = 0; i < 9; i++) {
            if (celulas[i].textContent === '') {
                empate = false;
                break;
            }
        }
        // Se houver empate, encerra o jogo e exibe uma mensagem
        if (empate) {
            jogadorAtual = 'FIM';
            alert('O jogo empatou!');
        }
    }
}

// Função para reiniciar o jogo
function reiniciarJogo() {
    jogadorAtual = 'X';
    // Obtém todas as células do tabuleiro e as limpa
    const celulas = document.querySelectorAll('.celula');
    celulas.forEach(celula => {
        celula.textContent = '';
    });
}
