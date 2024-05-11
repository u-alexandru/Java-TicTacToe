package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;
import com.mycompany.app.Interfaces.Playable;

public class Player extends PlayerEntity {

    private final Board gameBoard;

    public Player(Board gameBoard) {
        super(gameBoard);
        this.gameBoard = gameBoard;
    }

    @Override
    public void move(char piece) {

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
}