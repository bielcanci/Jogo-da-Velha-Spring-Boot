let jogadorAtual = 'X';

function fazerJogada(linha, coluna) {
    const celula = document.getElementById(`celula-${linha}-${coluna}`);
    if (celula.textContent === '' && jogadorAtual !== 'FIM') {
        celula.textContent = jogadorAtual;
        verificarVitoria(linha, coluna);
        jogadorAtual = (jogadorAtual === 'X') ? 'O' : 'X';
    }
}

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

    if (vitoria) {
        jogadorAtual = 'FIM';
        alert(`O jogador ${jogador} venceu!`);
    } else {
        let empate = true;
        for (let i = 0; i < 9; i++) {
            if (celulas[i].textContent === '') {
                empate = false;
                break;
            }
        }
        if (empate) {
            jogadorAtual = 'FIM';
            alert('O jogo empatou!');
        }
    }
}


function reiniciarJogo() {
    jogadorAtual = 'X';
    const celulas = document.querySelectorAll('.celula');
    celulas.forEach(celula => {
        celula.textContent = '';
    });
}
