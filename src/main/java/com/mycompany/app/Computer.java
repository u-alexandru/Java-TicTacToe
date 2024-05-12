package com.mycompany.app;

import com.mycompany.app.Helpers.MoveScore;
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
        MoveScore bestMoveScore = minimax(gameBoard.getBoard(), piece, true);
        byte[] bestMove = bestMoveScore.move;
        System.out.println(bestMove[0] + ", " + bestMove[1]);
        String column = "A";
        if(bestMove[1] == 1) {
            column = "B";
        } else if(bestMove[1] == 2) {
            column = "C";
        }
        String destination = (bestMove[0] + 1) + column;
        System.out.println(destination);
        gameBoard.placePiece(piece, destination);
        // Now you can use bestMove to make the move
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

    private MoveScore minimax(char[][] board, char piece, boolean isMaximizing) {
        char opponent = (piece == 'X') ? 'O' : 'X';
        if(gameBoard.hasWon(piece, board)) {
            return new MoveScore(null, getMoveScore(piece, board));
        } else if(gameBoard.hasWon(opponent, board)) {
            return new MoveScore(null, getMoveScore(opponent, board));
        } else if(gameBoard.isDraw(board)) {
            return new MoveScore(null, 0);
        }

        ArrayList<byte[]> moves = gameBoard.availableMoves(board);

        MoveScore bestMoveScore = new MoveScore(null, isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE);
        for(byte[] move : moves) {
            char[][] newBoardState = new char[3][3];
            for (int i = 0; i < board.length; i++) {
                System.arraycopy(board[i], 0, newBoardState[i], 0, board[i].length);
            }
            newBoardState[move[0]][move[1]] = piece;

            MoveScore currentMoveScore = minimax(newBoardState, opponent, !isMaximizing);
            if(isMaximizing) {
                if(currentMoveScore.score > bestMoveScore.score) {
                    bestMoveScore = new MoveScore(move, currentMoveScore.score);
                }
            } else {
                if(currentMoveScore.score < bestMoveScore.score) {
                    bestMoveScore = new MoveScore(move, currentMoveScore.score);
                }
            }
        }

        return bestMoveScore;
    }


}