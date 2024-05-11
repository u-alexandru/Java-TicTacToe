package com.mycompany.app.Interfaces;

public interface Playable {

    void move(char piece, String destination);
    void move(char piece);
    void drawBoard();
    boolean validMove(String inputMove);
}
