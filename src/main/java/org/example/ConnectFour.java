package org.example;

import java.util.Scanner;

public class ConnectFour {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public ConnectFour() {
        board = new Board();
        player1 = new Player('R');
        player2 = new Player('Y');
        currentPlayer = player1; // Kezdő játékos
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            board.printBoard();
            System.out.println("Játékos " + currentPlayer.getSymbol() + ", válassz egy oszlopot (0-" + (Board.COLS - 1) + "):");
            int column = scanner.nextInt();

            if (column < 0 || column >= Board.COLS || !board.dropPiece(column, currentPlayer.getSymbol())) {
                System.out.println("Érvénytelen lépés, próbáld újra.");
                continue;
            }

            gameWon = board.checkForWin(currentPlayer.getSymbol());
            if (!gameWon) {
                currentPlayer = (currentPlayer == player1) ? player2 : player1; // Váltás a játékosok között
            }
        }

        board.printBoard();
        System.out.println("Gratulálok, játékos " + currentPlayer.getSymbol() + " nyert!");
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.play();
    }
}

