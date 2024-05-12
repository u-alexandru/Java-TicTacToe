package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Gameboard implements Board {

    private char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};

    public void drawBoard() {
        System.out.println(
               "\n     A  |  B  |  C   \n" +
                "  ===================\n" +
                "1 |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |\n" +
                "2 |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |\n" +
                "3 |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |\n" +
                "  ===================\n"
        );

    }

    private void checkGameEnded(char[][] board) {
        if(hasWon('X', getBoard())) {
            drawBoard();
            System.out.println("X has won the game!");
            System.exit(0);
        } else if(hasWon('O', getBoard())) {
            drawBoard();
            System.out.println("O has won the game!");
            System.exit(0);
        } else if(isDraw(getBoard())) {
            drawBoard();
            System.out.println("It's a draw! No winner!");
            System.exit(0);
        }
    }

    public void placePiece(char piece, String destination) {
        int row = Character.getNumericValue(Character.toLowerCase(destination.charAt(0)));
        char column = Character.toLowerCase(destination.charAt(1));

        int colNumber = 0;
        if(column == 'b') {
            colNumber = 1;
        }else if(column == 'c') {
            colNumber = 2;
        }

        piece = Character.toUpperCase(piece);
        board[row - 1][colNumber] = piece;

        checkGameEnded(board);
    }

    public char[][] getBoard() {
        return board;
    }

    @Override
    public boolean hasWon(char piece, char[][] boardState) {
        piece = Character.toUpperCase(piece);
        boolean hasWon = false;

        for(char[] row : boardState) {
            if(row[0] == piece && row[1] == piece && row[2] == piece) {
                hasWon = true;
                break;
            }
        }

        if(!hasWon) {
            if(boardState[0][0] == piece && boardState[1][0] == piece && boardState[2][0] == piece) {
                hasWon = true;
            }
            if(boardState[0][1] == piece && boardState[1][1] == piece && boardState[2][1] == piece) {
                hasWon = true;
            }
            if(boardState[0][2] == piece && boardState[1][2] == piece && boardState[2][2] == piece) {
                hasWon = true;
            }
        }

        if(!hasWon) {
            if(boardState[0][0] == piece && boardState[1][1] == piece && boardState[2][2] == piece) {
                hasWon = true;
            }
            if(boardState[0][2] == piece && boardState[1][1] == piece && boardState[2][0] == piece) {
                hasWon = true;
            }
        }
        return hasWon;
    }

    public boolean isDraw(char[][] gameState) {
        if(!hasWon('X', gameState) && !hasWon('O', gameState)) {
            for(char[] row : gameState) {
                for(char square : row) {
                    if (square == ' ') {
                        return false;
                    }
                }
            }
        }
        return !hasWon('X', gameState) && !hasWon('O', gameState);
    }

    public ArrayList<byte[]> availableMoves(char[][] gameState) {
        ArrayList<byte[]> moves = new ArrayList<>();

        for(byte i = 0; i < gameState.length; i++) {
            for(byte j = 0; j < gameState[i].length; j++) {
                if(gameState[i][j] == ' ') {
                    moves.add(new byte[]{i, j});
                }
            }
        }

        return moves;
    }

    public void resetBoard() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
}