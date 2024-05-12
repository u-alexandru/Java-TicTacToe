package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;

import java.util.ArrayList;

public class Computer extends PlayerEntity {

    private final Board gameBoard;

    public Computer(Board gameBoard) {
        super(gameBoard);
        this.gameBoard = gameBoard;
    }

    @Override
    public void move(char piece) {
        System.out.println(minimax(gameBoard.getBoard(), piece, true));
    }

    public byte getMoveScore(char piece, char[][] boardState) {
        char player = 'X';
        char computer = 'O';
        if(piece == 'O') {
            player = 'O';
            computer = 'X';
        }

        if(gameBoard.hasWon(player, boardState)) {
            return 10;
        } else if(gameBoard.hasWon(computer, boardState)) {
            return -10;
        } else {
            return 0;
        }
    }

    private int minimax(char[][] board, char piece, boolean isMaximizing) {
        char opponent = (piece == 'X') ? 'O' : 'X';
        if(gameBoard.hasWon(piece, board)) {
            return getMoveScore(piece, board);
        } else if(gameBoard.hasWon(opponent, board)) {
            return getMoveScore(opponent, board);
        } else if(gameBoard.isDraw(board)) {
            return 0;
        }

        ArrayList<byte[]> moves = gameBoard.availableMoves(board);

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for(byte[] move : moves) {
            char[][] newBoardState = new char[3][3];
            for (int i = 0; i < board.length; i++) {
                System.arraycopy(board[i], 0, newBoardState[i], 0, board[i].length);
            }
            newBoardState[move[0]][move[1]] = piece;

            int score = minimax(newBoardState, opponent, !isMaximizing);
            bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
        }

        return bestScore;

    }


}