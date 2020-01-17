package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private Character[][] board = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
    private char player = '0';
    private static final int SIZE = 3;
    private char winner = '0';

    public String play(int x, int y) {
        if (winner != '0') {
            return "Game had been over, " + winner + " is the winner";
        }
        checkAxis(x, y);
        player = nextPlayer();
        setBox(x, y, player);
        if (isWin()) {
            winner = player;
            return player + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }
        return "No winner";
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        int playerTotal = player * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == playerTotal) {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] == playerTotal) {
                return true;
            }
        }
        if (board[0][0] + board[1][1] + board[2][2] == playerTotal) {
            return true;
        } else if (board[0][2] + board[1][1] + board[2][0] == playerTotal) {
            return true;
        }
        return false;
    }

    private void checkAxis(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            throw new RuntimeException("Axis is outside board");
        }
    }

    private void setBox(int x, int y, char player) {
        if (board[x - 1][y - 1] != '0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = player;
        }
    }

    public char nextPlayer() {
        if (player == 'X') {
            return 'O';
        }
        return 'X';
    }

}
