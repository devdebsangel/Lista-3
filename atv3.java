import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {
    // O tabuleiro inicial com os números de 1 a 9 representando as posições
    static char[][] tabuleiro = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    static char jogador = 'X';  // Símbolo do jogador
    static char computador = 'O';  // Símbolo do computador

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Seleção do modo de jogo
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Normal");
        System.out.println("2. Difícil");
        int modo = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        // Laço principal do jogo
        while (true) {
            mostrarTabuleiro();  // Mostra o estado atual do tabuleiro
            jogadorFazJogada(sc);  // O jogador faz a jogada

            // Verifica se o jogador venceu ou se o tabuleiro está cheio
            if (verificarVitoria(jogador)) {
                mostrarTabuleiro();
                System.out.println("Você venceu!");
                break;
            }
            if (tabuleiroCheio()) {
                mostrarTabuleiro();
                System.out.println("Empate!");
                break;
            }

            // Computador faz a jogada de acordo com o modo escolhido
            if (modo == 1) {
                computadorJogadaAleatoria();  // Modo normal: jogadas aleatórias
            } else {
                computadorJogadaDificil();  // Modo difícil: lógica avançada
            }

            // Verifica se o computador venceu ou se o tabuleiro está cheio
            if (verificarVitoria(computador)) {
                mostrarTabuleiro();
                System.out.println("O computador venceu!");
                break;
            }
            if (tabuleiroCheio()) {
                mostrarTabuleiro();
                System.out.println("Empate!");
                break;
            }
        }
        sc.close();  // Fecha o scanner após o jogo
    }

    // Função para exibir o tabuleiro
    static void mostrarTabuleiro() {
        System.out.println();
        for (char[] linha : tabuleiro) {
            for (char casa : linha) {
                System.out.print(casa + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Jogada do jogador (o usuário escolhe a posição)
    static void jogadorFazJogada(Scanner sc) {
        System.out.print("Digite o número da posição (1 a 9): ");
        int jogada = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == (char) (jogada + '0')) {
                    tabuleiro[i][j] = jogador;
                    return;
                }
            }
        }
        System.out.println("Posição inválida, tente novamente.");
        jogadorFazJogada(sc);  // Pede uma nova jogada se a posição for inválida
    }

    // Jogada aleatória do computador (modo normal)
    static void computadorJogadaAleatoria() {
        Random rnd = new Random();
        while (true) {
            int jogada = rnd.nextInt(9) + 1;  // Gera uma jogada aleatória de 1 a 9
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == (char) (jogada + '0')) {
                        tabuleiro[i][j] = computador;
                        return;
                    }
                }
            }
        }
    }

    // Jogada difícil do computador (implementar uma lógica avançada)
    static void computadorJogadaDificil() {
        // A lógica para o computador fazer jogadas inteligentes deve ser implementada.
        // Pode incluir bloqueios de jogadas do jogador ou tentar vencer.
        // Para fins de simplicidade, usamos uma jogada aleatória por enquanto.
        computadorJogadaAleatoria(); 
    }

    // Verifica se algum jogador venceu
    static boolean verificarVitoria(char jogador) {
        // Verifica as linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) return true;
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) return true;
        }
        // Verifica as diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) return true;
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) return true;
        return false;
    }

    // Verifica se o tabuleiro está cheio (empate)
    static boolean tabuleiroCheio() {
        for (char[] linha : tabuleiro) {
            for (char casa : linha) {
                if (casa != 'X' && casa != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}