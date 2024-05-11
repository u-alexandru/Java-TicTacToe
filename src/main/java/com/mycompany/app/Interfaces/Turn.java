package com.mycompany.app.Interfaces;

public interface Turn {
    void nextTurn();

    void setTurnToMove(char firstToMove);
    void setPlayerPiece(char piece);
}
