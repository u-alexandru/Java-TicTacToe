package com.mycompany.app.Interfaces;

public interface Board {
    void drawBoard();
    void placePiece(char piece, String destination);
    char[][] getBoard();
}
