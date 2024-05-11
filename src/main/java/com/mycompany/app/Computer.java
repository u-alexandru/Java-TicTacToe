package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;

public class Computer extends PlayerEntity {

    public Computer(Board gameBoard) {
        super(gameBoard);
    }

    @Override
    public void move(char piece) {

    }

    @Override
    public boolean validMove(String inputMove) {
        return false;
    }
}