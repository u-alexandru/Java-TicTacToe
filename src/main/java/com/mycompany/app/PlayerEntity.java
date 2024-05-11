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

    public abstract void move(char piece);
}
