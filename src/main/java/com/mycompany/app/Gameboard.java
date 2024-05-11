package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;

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
    }

    public char[][] getBoard() {
        return board;
    }

    public void resetBoard() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
}