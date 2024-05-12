package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;
import com.mycompany.app.Interfaces.Playable;

public abstract class PlayerEntity implements Playable {

    private final Board gameBoard;
    public PlayerEntity(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void move(char piece, String destination) {
        gameBoard.placePiece(piece, destination);
    }

    public void drawBoard() {
        gameBoard.drawBoard();
    }

    public boolean validMove(String move) {
        char[][] myBoard = gameBoard.getBoard();
        int row = Character.getNumericValue(move.charAt(0));
        char column = Character.toLowerCase(move.charAt(1));

        int colNumber = 0;
        if(column == 'b') {
            colNumber = 1;
        }else if(column == 'c') {
            colNumber = 2;
        }

        return myBoard[row - 1][colNumber] == ' ';
    }

    public abstract void move(char piece);
}
