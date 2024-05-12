package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;
import com.mycompany.app.Interfaces.Movable;
import com.mycompany.app.Interfaces.Turn;

public class GameTurn implements Turn {

    private final Board gameboard;
    private final Movable move;
    private char turnToMove = 'p';
    private char playerPiece = 'x';
    private char computerPiece = 'o';

    public GameTurn(Board gameboard, Movable move) {
        this.gameboard = gameboard;
        this.move = move;
    }

    @Override
    public void setPlayerPiece(char playerPiece) {
        this.playerPiece = playerPiece;
        if(playerPiece == 'o') {
            computerPiece = 'x';
        }
    }

    public void setTurnToMove(char turnToMove) {
        this.turnToMove = turnToMove;
    }

    public void nextTurn() {
        if(turnToMove == 'p') {
            move.playerMove(playerPiece);
            turnToMove = 'c';
        } else {
            move.computerMove(computerPiece);
            turnToMove = 'p';
        }
    }
}
