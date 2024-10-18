package org.example;

public class Board {
    private static final int ROWS = 6;
    static final int COLS = 7;
    private char[][] board;

    public Board() {
        board = new char[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = '.';
            }
        }
    }

    public boolean dropPiece(int column, char currentPlayer) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][column] == '.') {
                board[r][column] = currentPlayer;
                return true;
            }
        }
        return false; // Oszlop tele van
    }

    public void printBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkForWin(char currentPlayer) {
        return checkHorizontal(currentPlayer) || checkVertical(currentPlayer) || checkDiagonal(currentPlayer);
    }

    private boolean checkHorizontal(char currentPlayer) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                        board[r][c + 1] == currentPlayer &&
                        board[r][c + 2] == currentPlayer &&
                        board[r][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char currentPlayer) {
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS - 3; r++) {
                if (board[r][c] == currentPlayer &&
                        board[r + 1][c] == currentPlayer &&
                        board[r + 2][c] == currentPlayer &&
                        board[r + 3][c] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char currentPlayer) {
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                        board[r + 1][c + 1] == currentPlayer &&
                        board[r + 2][c + 2] == currentPlayer &&
                        board[r + 3][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (board[r][c] == currentPlayer &&
                        board[r - 1][c + 1] == currentPlayer &&
                        board[r - 2][c + 2] == currentPlayer &&
                        board[r - 3][c + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }
}
