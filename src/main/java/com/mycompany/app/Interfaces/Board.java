package com.mycompany.app.Interfaces;

import java.util.ArrayList;

public interface Board {
    void drawBoard();
    void placePiece(char piece, String destination);
    char[][] getBoard();
    boolean hasWon(char piece,  char[][] gameState);
    boolean isDraw(char[][] gameState);
    ArrayList<byte[]> availableMoves(char[][] gameState);
}
