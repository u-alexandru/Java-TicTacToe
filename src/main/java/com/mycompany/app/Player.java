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
    public void move(char piece) {}
}