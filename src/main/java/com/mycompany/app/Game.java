package com.mycompany.app;

import com.mycompany.app.Interfaces.*;

public class Game implements GameService {

    private char firstToMove = 'p';
    private boolean IsGameOver = false;

    private final DeterminePlayerOrder ChoseStartingEntity;
    private final Speaker gameSpeaker;
    private final Turn gameTurn;

    public Game(
            DeterminePlayerOrder ChoseStartingEntity,
            Speaker gameSpeaker,
            Turn gameTurn
    ) {
        this.ChoseStartingEntity = ChoseStartingEntity;
        this.gameSpeaker = gameSpeaker;
        this.gameTurn = gameTurn;
    }

    public void setFirstToMove(char firstToMove) {
        this.firstToMove = firstToMove;
    }

    @Override
    public void GameIntroduction() {
        gameSpeaker.writeText("Welcome to my game of TicTacToe!");
        if(firstToMove == 'p') {
            gameSpeaker.writeText("You have chosen to move first. Your pieces are X");
        } else {
            gameSpeaker.writeText("You have chosen to move second. Your pieces are O");
        }
        gameSpeaker.writeText("The Gameboard is divided in a 3x3 table.");
        gameSpeaker.writeText("The columns are named A, B, C");
        gameSpeaker.writeText("The rows are numbered 1, 2, 3");
        gameSpeaker.writeText("To make your move, you will have to type the column and row of the desired square");
        gameSpeaker.writeText("where you want to place your piece");
        gameSpeaker.writeText("Ex. A1, B2, C3");
        gameSpeaker.writeText("To win you must place three of your pieces in a horizontal, vertical or diagonal line.");
        gameSpeaker.writeText("____________________________________");
        gameSpeaker.writeText("Have Fun!");
    }

    private void update() {
            gameTurn.nextTurn();
            update();
    }

    @Override
    public void startGame() throws Exception {
        this.setFirstToMove(ChoseStartingEntity.choseStartingEntity());
        gameTurn.setTurnToMove(firstToMove);

        if(firstToMove == 'p') {
            gameTurn.setPlayerPiece('x');
        } else {
            gameTurn.setPlayerPiece('o');
        }

        GameIntroduction();
        update();
    }

}