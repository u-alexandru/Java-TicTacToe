package com.mycompany.app.Factory;

import com.mycompany.app.*;
import com.mycompany.app.Helpers.ChoseFirstMoveEntity;
import com.mycompany.app.Helpers.GameSpeaker;
import com.mycompany.app.Interfaces.*;

public class DefaultGeneralFactory implements GeneralFactory {
    private final Board gameBoard;

    public DefaultGeneralFactory() {
        this.gameBoard = new Gameboard();
    }

    @Override
    public Speaker createSpeaker() {
        return new GameSpeaker();
    }

    @Override
    public GameService createGame() {
        return new Game(createPlayOrder(), createSpeaker(), createGameTurn());
    }

    @Override
    public Movable createMove() {
        return new Move(createPlayer(), createComputer());
    }

    @Override
    public Playable createComputer() {
        return new Computer(gameBoard);
    }

    @Override
    public Playable createPlayer() {
        return new Player(gameBoard);
    }

    @Override
    public Board createGameboard() {
        return new Gameboard();
    }

    @Override
    public DeterminePlayerOrder createPlayOrder() {
        return new ChoseFirstMoveEntity(createSpeaker());
    }

    @Override
    public Turn createGameTurn() {
        return new GameTurn(createGameboard(), createMove());
    }
}
